package bookstore

import grails.converters.JSON
import bookstore.service.UserService

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

}