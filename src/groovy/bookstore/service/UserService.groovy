package bookstore.service
import bookstore.model.User
 
class UserService {
	private static UserService instance = null
	
	def static synchronized getInstance(){
		if(instance==null){
			instance = new UserService()
			return instance
		}
		return instance
	}
	
	def getUserById(userId){
		return User.find("from User as u where u.id=:userId",[userId:userId])
	}
	
	def getUserByUsername(username){
		return User.find("from User as u where u.username=:username",[username:username])
	}
	
	
}
