package bookstore.model

class Book {

	String title
	
	String isbn
	
	String major
	
	String course
	
	User postedBy
	
	String status
	
	Date postedDate
	
	Double price
	
	static constraints = {
		major nullable : true
		course nullable : true
	}
}
