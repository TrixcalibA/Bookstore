package bookstore

import org.apache.commons.lang.StringEscapeUtils
import grails.converters.JSON
import bookstore.service.UserService
import bookstore.utils.Logger
import bookstore.utils.ErrorHelper

class ProfileController {
	
    def index() {
		def ret = [:]
		try{
			def userService = UserService.getInstance()
			def userId = Long.parseLong(params.userId)
			def u = userService.getUserById(userId)
			if(u==null){
				response.sendError(404)
				return
			}

			def logginId = session['userId']
			def model = [:]
			model['userId'] = userId
			if(logginId){
				def login = userService.getUserById(logginId)
				model['loginId'] = login.id
				model['loginName'] = login.firstName+' '+login.lastName
				model['isLoggedIn'] = true
			}
			else
				model['isLoggedIn'] = false
			
			return model
		}
		catch(e){
			Logger.log(e.getMessage())
			response.sendError(404)
		}
    }
	
	def getProfileSummary(){
		def ret = [:]
		try{
			def userId = Long.parseLong(params.userId)
			def userService = UserService.getInstance()
			def u = userService.getUserById(userId)
			ret['username'] = u.username
			ret['firstName'] = u.firstName
			ret['lastName'] = u.lastName
			ret['major'] = u.major
			ret['degree'] = u.degree
			ret['yearOfGraduation'] = u.yearOfGraduation
			ret['success'] = true
		}
		catch(e){
			Logger.log(e.getMessage())
			ret['errorCode'] = 'PROFILE_RETRIEVAL_ERROR'
			ret['errorMessage'] = ErrorHelper.ERROR_MESSAGES['PROFILE_RETRIEVAL_ERROR']
			ret['success'] = false
		}
		render ret as JSON
	}
	
	def updateProfile(){
		def ret = [:]
		try{
			def firstName = params.firstName
			def lastName = params.lastName
			def major = params.major
			def degree = params.degree
			def yearOfGraduation = Integer.parseInt(params.yearOfGraduation)
			def userId = session["userId"]
			def userService = UserService.getInstance()
			def u = userService.getUserById(userId)
			u.firstName = firstName
			u.lastName = lastName
			u.firstName = firstName
			u.major = major
			u.degree = degree
			u.yearOfGraduation = yearOfGraduation
			u.save(flush: true, failOnError: true)
			ret['success'] = true
		}
		catch(e){
			Logger.log(e.getMessage())
			ret['errorCode'] = 'UPDATE_PROFILE_ERROR'
			ret['errorMessage'] = ErrorHelper.ERROR_MESSAGES['UPDATE_PROFILE_ERROR']
			ret['success'] = false
		}
		render ret as JSON
	}
}