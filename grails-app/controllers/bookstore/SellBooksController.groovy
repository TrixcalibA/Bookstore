package bookstore

import grails.converters.JSON
import bookstore.service.UserService

class SellBooksController {
	
    def index() {
		def userService = UserService.getInstance()
		def login = userService.getUserById(session['userId'])
        def model = [:]
		model['userId'] = session['userId']
		model['page'] = 'sell-books'
		model['loginName'] = login.firstName+' '+login.lastName
        return model
    }

}