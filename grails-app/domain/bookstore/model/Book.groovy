package bookstore.model

class Book {

	String title
	
	String isbn
	
	String major
	
	String course
	
	User postedBy

	Date postedDate
	
	static constraints = {
		major nullable : true
		course nullable : true
	}
}
