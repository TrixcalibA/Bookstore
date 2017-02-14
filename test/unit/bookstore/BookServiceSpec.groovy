package bookstore

import grails.test.mixin.Mock
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

import java.awt.Component.BaselineResizeBehavior

import org.grails.datastore.gorm.finders.FindAllByBooleanFinder
import bookstore.model.Book
import bookstore.model.User
import bookstore.service.UserService

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@Mock(Book)
class BookServiceSpec extends Specification {
	
	def setup() {
		def user = new User()
		user.username = "fhpham"
		user.firstName = "Frank"
		user.lastName = "Pham"
		user.gender = "male"
		def book = new Book()
		book.title = "test book"
		book.isbn = "1234567891"
		book.major = "Computer Science"
		book.course = "CS 530"
		book.postedDate = new Date()
		book.postedBy = user
		book.save(flush: true, failOnError: true)
	}
	
	def cleanup() {
	}
	
	void 'test book creation successfully' () {
		def books = Book.createCriteria().list() {
			eq('title', "test book")
			eq('isbn', "1234567891")
			eq('major', "Computer Science")
			eq('course', "CS 530")
		}
		expect:
			assert books.size() == 1
	}
}

