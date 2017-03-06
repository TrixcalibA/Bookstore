package bookstore.service
import bookstore.model.Book
 
class BookService {
	private static BookService instance = null
	
	def static synchronized getInstance(){
		if(instance==null){
			instance = new BookService()
			return instance
		}
		return instance
	}
	
	def searchBooksByOwnerId(ownerId,offset,displayLen,searchStr,titleSort,isbnSort,majorSort,courseSort,postedDateSort,statusSort,priceSort){
		def count_select = """SELECT count(*) FROM Book b
				  		   """
		
		def select = """SELECT new map(b.id as id, b.title as title, b.isbn as isbn, b.major as major,
									b.course as course, b.price as price, b.postedDate as postedDate, b.status as status) FROM Book b
					 """ 
		
		def where = """ WHERE (lower(b.title) like lower(:searchStrLike) OR
							  lower(b.isbn) like lower(:searchStrLike) OR
							  lower(b.major) like lower(:searchStrLike) OR
							  lower(b.course) like lower(:searchStrLike)) AND postedBy.id = :ownerId
				  	"""
		
		def order = '';
		
		if(titleSort == 'asc')
			order = ' order by b.title asc'
		if(titleSort == 'desc')
			order = ' order by b.title desc'
		
		if(isbnSort == 'asc')
			order = ' order by b.isbn asc'
		if(isbnSort == 'desc')
			order = ' order by b.isbn desc'
		
		if(majorSort == 'asc')
			order = ' order by b.major asc'
		if(majorSort == 'desc')
			order = ' order by b.major desc'
			
		if(courseSort == 'asc')
			order = ' order by b.course asc'
		if(courseSort == 'desc')
			order = ' order by b.course desc'
			
		if(priceSort == 'asc')
			order = ' order by b.price asc'
		if(priceSort == 'desc')
			order = ' order by b.price desc'
		
		if(postedDateSort == 'asc')
			order = ' order by b.postedDate asc'
		if(postedDateSort == 'desc')
			order = ' order by b.postedDate desc'
			
		if(statusSort == 'asc')
			order = ' order by b.status asc'
		if(statusSort == 'desc')
			order = ' order by b.status desc'
			
		def searchStrExact = searchStr.trim();
		def searchStrLike = searchStrExact.replace('\\', '\\\\').replace('%', /\%/).replace('_', /\_/)

		def parameters = [ownerId: ownerId, searchStrLike: "%${searchStrLike}%"]

		def paginOpt = [max: displayLen, offset: offset]
		
		def nrows = Book.executeQuery(count_select+where,parameters)
		
		def books = Book.executeQuery(select+where+order,parameters,paginOpt)
		
		return [data: books, nrows: nrows[0]]
	}
	
	def getNumberOfBooksByOwnerId(ownerId){
		def sql = "SELECT count(b.id) FROM Book b WHERE b.postedBy.id = :ownerId"
		def ret = Book.executeQuery(sql,[ownerId: ownerId])
		return ret[0]
	}
	
	def searchBooks(offset,displayLen,searchStr,titleSort,isbnSort,majorSort,courseSort,postedDateSort,postedBySort,statusSort,priceSort){
		def count_select = """SELECT count(*) FROM Book b
				  		   """
		
		def select = """SELECT new map(b.id as id, b.title as title, b.isbn as isbn, b.major as major,
									b.course as course, b.price as price, b.postedDate as postedDate, b.postedBy.id as postedById, b.postedBy.firstName as firstName, b.postedBy.lastName as lastName, b.status as status) FROM Book b
					 """ 
		
		def where = """ WHERE (lower(b.title) like lower(:searchStrLike) OR
							  lower(b.isbn) like lower(:searchStrLike) OR
							  lower(b.major) like lower(:searchStrLike) OR
							  lower(b.course) like lower(:searchStrLike) OR
							  lower(b.postedBy.firstName) like lower(:searchStrLike) OR
							  lower(b.postedBy.lastName) like lower(:searchStrLike))
				  	"""
		
		def order = '';
		
		if(titleSort == 'asc')
			order = ' order by b.title asc'
		if(titleSort == 'desc')
			order = ' order by b.title desc'
		
		if(isbnSort == 'asc')
			order = ' order by b.isbn asc'
		if(isbnSort == 'desc')
			order = ' order by b.isbn desc'
		
		if(majorSort == 'asc')
			order = ' order by b.major asc'
		if(majorSort == 'desc')
			order = ' order by b.major desc'
			
		if(courseSort == 'asc')
			order = ' order by b.course asc'
		if(courseSort == 'desc')
			order = ' order by b.course desc'
			
		if(priceSort == 'asc')
			order = ' order by b.price asc'
		if(priceSort == 'desc')
			order = ' order by b.price desc'
		
		if(postedDateSort == 'asc')
			order = ' order by b.postedDate asc'
		if(postedDateSort == 'desc')
			order = ' order by b.postedDate desc'
		
		if(postedBySort == 'asc')
			order = ' order by b.postedBy.firstName asc, b.postedBy.lastName asc'
		if(postedBySort == 'desc')
			order = ' order by b.postedBy.firstName desc, b.postedBy.lastName desc'
		
		if(statusSort == 'asc')
			order = ' order by b.status asc'
		if(statusSort == 'desc')
			order = ' order by b.status desc'
			
		
			
		def searchStrExact = searchStr.trim();
		def searchStrLike = searchStrExact.replace('\\', '\\\\').replace('%', /\%/).replace('_', /\_/)

		def parameters = [searchStrLike: "%${searchStrLike}%"]

		def paginOpt = [max: displayLen, offset: offset]
		
		def nrows = Book.executeQuery(count_select+where,parameters)
		
		def books = Book.executeQuery(select+where+order,parameters,paginOpt)
		
		return [data: books, nrows: nrows[0]]
	}
	
	def getNumberOfBooks(){
		def sql = "SELECT count(b.id) FROM Book b"
		def ret = Book.executeQuery(sql)
		return ret[0]
	}
}
