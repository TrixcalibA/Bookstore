package bookstore

import grails.converters.JSON
import bookstore.model.User
import bookstore.service.UserService
import bookstore.utils.ErrorHelper

class LoginController {
	
    def index() {
		def model = [:]
		model['error'] = flash.error
		model['warning'] = flash.warning
		model['success'] = flash.success
        return model
    }
	
	def login(){
		def username = params.username
		def password = params.password
		println username
		println password
		render true
	}
	
	def signup(){
		try{
			def userService = UserService.getInstance()
			def username = params.username
			
			def user = userService.getUserByUsername(username)
			
			if (user != null) {
				flash.error = 'User ' + username + ' already exists.'
				redirect(action: 'index', controller: 'login')
				return
			}
			
			user = new User()
			user.username = username
			user.password = params.password.encodeAsSHA1()
			user.firstName = params.firstName
			user.lastName = params.lastName
			user.gender = params.gender
			user.save(flush: true, failOnError: true)
			
			flash.success = 'An email has been sent to the address you provided with a link to verify your account.'
			redirect(action: 'index', controller: 'login')
		}
		catch(e){
			flash.error = 'Error signing up user.'
			redirect(action: 'index', controller: 'login')
		}
	}

}