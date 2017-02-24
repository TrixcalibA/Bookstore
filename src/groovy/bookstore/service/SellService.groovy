package bookstore.service
import bookstore.model.User
 
class SellService {
	private static SellService instance = null
	
	def static synchronized getInstance(){
		if(instance==null){
			instance = new SellService()
			return instance
		}
		return instance
	}
	
	def getBooksById(userId){
		return User.findAll("from Book as b where b.id=:userId",[userId:userId])
	}
	
	
}
