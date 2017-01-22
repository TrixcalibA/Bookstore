package bookstore

import grails.converters.JSON

class AboutController {
	
    def index() {
        def model = [:]
		model['page'] = 'about'
        return model
    }

}