package bookstore

import grails.converters.JSON

class SellBooksController {
	
    def index() {
        def model = [:]
		model['page'] = 'sell-books'
        return model
    }

}