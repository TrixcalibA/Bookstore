package bookstore

import grails.converters.JSON
import bookstore.utils.ErrorHelper

class BookController {
	
    def view() {
        def ret = [:]
		try{
			def bookId = params.id
			//retrieve book model from database
			
			ret['id'] = bookId
			ret['name'] = 'Database'
			ret['isbn'] = '123456789'
			ret['major'] = 'Computer Science'
			ret['success'] = true
		}
		catch(e){
			ret['errorCode'] = 'BOOK_VIEW_ERROR'
			ret['errorMessage'] = ErrorHelper.ERROR_MESSAGES['BOOK_VIEW_ERROR']
			ret['success'] = false
		}
		render ret as JSON
    }

}