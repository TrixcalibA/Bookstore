package bookstore.model

class AccountActivationToken {
	String id
	
    User user

    static mapping = {
		id generator:'assigned'
		autoTimestamp false
    }
}
