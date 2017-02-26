package bookstore

import grails.converters.JSON
import bookstore.service.UserService
import bookstore.service.BookService
import bookstore.utils.DateUtility

class OurBooksController {
	
    def index() {
		def userService = UserService.getInstance()
		def userId = session['userId']
        def model = [:]
		model['page'] = 'our-books'
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
				
		def titleSort = 'unsorted'
		def isbnSort = 'unsorted'
		def majorSort = 'unsorted'
		def courseSort = 'unsorted'
		def postedDateSort = 'unsorted'
		def postedBySort = 'unsorted'
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
				postedBySort = sortDirection
				break;
			case 6:
				statusSort = sortDirection
				break;
		}
		def searchStr = params.sSearch
		def bookService = BookService.getInstance()
		def results = bookService.searchBooks(params.iDisplayStart,params.iDisplayLength,searchStr,titleSort,isbnSort,majorSort,courseSort,postedDateSort,postedBySort,statusSort)
		def bvms = []

		for(book in results["data"]){
			bvms.push([title:book.title,
					   isbn:book.isbn,
					   major:book.major,
					   course:book.course,
					   postedDate:DateUtility.getDate(book.postedDate),
					   postedBy: book.firstName + ' ' +book.lastName,
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