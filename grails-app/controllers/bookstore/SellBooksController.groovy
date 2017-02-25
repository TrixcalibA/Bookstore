package bookstore

import grails.converters.JSON
import groovy.swing.factory.TitledBorderFactory
import sun.security.jca.GetInstance
import bookstore.model.User

import org.apache.commons.validator.routines.checkdigit.ISBN10CheckDigit
import bookstore.utils.Logger
import bookstore.model.Book
import bookstore.service.UserService
import bookstore.service.BookService
import bookstore.utils.ErrorHelper
import bookstore.utils.DateUtility

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
			model['isLoggedIn'] = true
		}
		else
			model['isLoggedIn'] = false
        return model
    }
	
	def books(){
		def ret = [:]
		def ownerId = session['userId']
		
		def titleSort = 'unsorted'
		def isbnSort = 'unsorted'
		def majorSort = 'unsorted'
		def courseSort = 'unsorted'
		def postedDateSort = 'unsorted'
		def statusSort = 'unsorted'
	
		def sortColNumber = Integer.parseInt(params.iSortCol_0)
		def sortDirection = params.sSortDir_0
		switch(sortColNumber){
			case 0:
				titleSort = sortDirection
				break;
			case 1:
				isbnSort = sortDirection
				break;
			case 2:
				majorSort = sortDirection
				break;
			case 3:
				courseSort = sortDirection
				break;
			case 4:
				postedDateSort = sortDirection
				break;
			case 5:
				statusSort = sortDirection
				break;
		}
		def searchStr = params.sSearch
		def bookService = BookService.getInstance()
		def results = bookService.searchBooksByOwnerId(ownerId,params.iDisplayStart,params.iDisplayLength,searchStr,titleSort,isbnSort,majorSort,courseSort,postedDateSort,statusSort)
		def bvms = []

		for(book in results["data"]){
			bvms.push([title:book.title,
					   isbn:book.isbn,
					   major:book.major,
					   course:book.course,
					   postedDate:DateUtility.getDate(book.postedDate),
					   status:book.status])
		}
		
		
		def data = [
			"iTotalDisplayRecords": results["nrows"],
			"iTotalRecords": bookService.getNumberOfBooksByOwnerId(ownerId),
			"aaData": bvms
		]
		render data as JSON
	}
	
	def sell() {
		def ret = [:]
		try{
			def book = new Book()
			def userId = session['userId']
			def userService = UserService.getInstance()
			def user = userService.getUserById(userId)
			book.title = params.title
			book.isbn = params.isbn
			book.major = params.major
			book.course = params.course
			book.postedDate = new Date()
			book.postedBy = user
			book.status = 'available'
			book.save(flush: true, failOnError: true)
			ret['success'] = true
		}
		catch(e){
			Logger.log(e.getMessage())
			ret['errorCode'] = 'SELL_BOOK_ERROR'
			ret['errorMessage'] = ErrorHelper.ERROR_MESSAGES['SELL_BOOK_ERROR']
			ret['success'] = false
		}
		render ret as JSON
	}
}