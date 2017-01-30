package bookstore

import grails.converters.JSON

class SearchBooksController {
	
    def index() {
        def model = [:]
		model['page'] = 'our-books'		
        return model
    }

}