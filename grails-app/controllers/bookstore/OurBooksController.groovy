package bookstore

import grails.converters.JSON
import bookstore.service.UserService
import bookstore.service.BookService
import bookstore.utils.DateUtility
import java.text.NumberFormat

class OurBooksController {
	
    def index() {
		def userService = UserService.getInstance()
		def userId = session['userId']
        def model = [:]
		model['page'] = 'our-books'
		if(userId){
			def login = userService.getUserById(session['userId'])
			model['loginId'] = userId
			model['loginName'] = login.firstName+' '+login.lastName
			model['isLoggedIn'] = true
		}
		else
			model['isLoggedIn'] = false
        return model
    }

	def books(){
		def ret = [:]
				
		def titleSort = 'unsorted'
		def isbnSort = 'unsorted'
		def majorSort = 'unsorted'
		def courseSort = 'unsorted'
		def postedDateSort = 'unsorted'
		def postedBySort = 'unsorted'
		def statusSort = 'unsorted'
		def priceSort = 'unsorted'
	
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
			case 5:
				postedDateSort = sortDirection
				break;
			case 6:
				postedBySort = sortDirection
				break;
			case 7:
				statusSort = sortDirection
				break;
			case 4:
				priceSort = sortDirection
				break;
		}
		def searchStr = params.sSearch
		def bookService = BookService.getInstance()
		def results = bookService.searchBooks(params.iDisplayStart,params.iDisplayLength,searchStr,titleSort,isbnSort,majorSort,courseSort,postedDateSort,postedBySort,statusSort,priceSort)
		def bvms = []

		for(book in results["data"]){
			bvms.push([title:book.title,
					   isbn:book.isbn,
					   major:book.major,
					   course:book.course,
					   price:NumberFormat.getCurrencyInstance().format(book.price),
					   postedDate:DateUtility.getDate(book.postedDate),
					   postedBy: book.firstName + ' ' +book.lastName,
					   postedById: book.postedById,
					   status:book.status])
		}
		
		
		def data = [
			"iTotalDisplayRecords": results["nrows"],
			"iTotalRecords": bookService.getNumberOfBooks(),
			"aaData": bvms
		]
		render data as JSON
	}
}