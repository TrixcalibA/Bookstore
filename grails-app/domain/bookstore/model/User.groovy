package bookstore.model

class User {

	String username
	
	String password
	
	String firstName
	
	String lastName
	
	String gender
	
	String major
	
	String degree
	
	Integer yearOfGraduation
	
	static constraints = {
		major nullable : true
		degree nullable : true
		yearOfGraduation nullable : true
	}
}