package bookstore

import grails.converters.JSON
import groovy.swing.factory.TitledBorderFactory
import sun.security.jca.GetInstance
import bookstore.model.User

import org.apache.commons.validator.routines.checkdigit.ISBN10CheckDigit
import bookstore.utils.Logger
import bookstore.model.Book
import bookstore.service.UserService
import bookstore.service.SellService

class SellBooksController {
	
    def index() {
		def userService = UserService.getInstance()
		def userId = session['userId']
        def model = [:]
		model['page'] = 'sell-books'
		if(userId){
			def login = userService.getUserById(session['userId'])
			model['userId'] = userId
			model['loginName'] = login.firstName+' '+login.lastName
		}
        return model
    }
	
	def books(){
		def ret = [:]
		
		try {
			def userId = session['userId']
			def userService = UserService.getInstance()
			def user = userService.getUserById(userId)
			def sellService = SellService.getInstance()
			def bookList = sellService.getBooksById(userId)
			ret['success'] = true
		} catch (e) {
			Logger.log(e.getMessage())
			ret['success'] = false
		}
		render ret as JSON	
	}
	
	def sell() {
		def ret = [:]
		try{
			def book = new Book()
			def userId = session['userId']
			def userService = UserService.getInstance()
			def user = userService.getUserById(userId)
			book.title = params.title
			book.isbn = params.isbn
			book.major = params.major
			book.course = params.course
			book.postedDate = new Date()
			book.postedBy = user
			book.save(flush: true, failOnError: true)
			ret['success'] = true
		}
		catch(e){
			Logger.log(e.getMessage())
			ret['success'] = false
		}
		render ret as JSON
	}
}