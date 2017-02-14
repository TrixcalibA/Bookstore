package bookstore

import grails.converters.JSON
import bookstore.service.UserService

class BooksController {
	
    def index() {
		def userService = UserService.getInstance()
		def userId = session['userId']
        def model = [:]
		model['page'] = 'our-books'
		if(userId){
			def login = userService.getUserById(session['userId'])
			model['userId'] = userId
			model['loginName'] = login.firstName+' '+login.lastName
		}
        return model
    }

}