package bookstore

import grails.converters.JSON

class AboutController {
	
    def index() {
        def model = [:]
		model['userId'] = session['userId']
		model['page'] = 'about'
        return model
    }

}