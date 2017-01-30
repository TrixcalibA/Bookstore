package bookstore

import grails.converters.JSON

class SellBooksController {
	
    def index() {
        def model = [:]
		model['userId'] = session['userId']
		model['page'] = 'sell-books'
        return model
    }

}