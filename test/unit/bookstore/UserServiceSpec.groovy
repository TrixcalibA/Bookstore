package bookstore

import grails.test.mixin.Mock
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

import org.grails.datastore.gorm.finders.FindAllByBooleanFinder

import bookstore.model.User

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@Mock(User)
class UserServiceSpec extends Specification {
	
    def setup() {
		def user = new User()
		user.username = 'test@abc.com'
		user.password = '123'
		user.firstName = 'Test'
		user.lastName = 'Account'
		user.gender = 'male'
		user.active = false
		user.save(flush: true, failOnError: true)
    }

    def cleanup() {
    }

	void "test user created successfully"() {
		def users = User.createCriteria().list(){
			eq('username', 'test@abc.com')
		}
		expect:
			assert users.size() > 0
	}
	
	void test2() {
		expect:
			2 == 2
	}
}
