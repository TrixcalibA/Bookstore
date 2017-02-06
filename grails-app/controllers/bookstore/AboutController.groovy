package bookstore

import grails.converters.JSON
import bookstore.service.UserService

class AboutController {
	
    def index() {
		def userService = UserService.getInstance()
		def login = userService.getUserById(session['userId'])
        def model = [:]
		model['userId'] = session['userId']
		model['page'] = 'about'
		model['loginName'] = login.firstName+' '+login.lastName
        return model
    }

}