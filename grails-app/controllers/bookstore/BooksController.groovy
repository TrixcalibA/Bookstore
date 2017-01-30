package bookstore

import grails.converters.JSON

class BooksController {
	
    def index() {
        def model = [:]
		model['userId'] = session['userId']
		model['page'] = 'our-books'		
        return model
    }

}