package bookstore.service

class UserService {
	private static UserService instance = null
	
	def static synchronized getInstance(){
		if(instance==null){
			instance = new UserService()
			return instance
		}
		return instance
	}
	
	def createUser(accountCode,accountInfo){
		
	}
	
	def getUserByUsername(username){
		
	}
	
	
}
