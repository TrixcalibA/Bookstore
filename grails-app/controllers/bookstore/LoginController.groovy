package bookstore

import grails.converters.JSON
import bookstore.model.AccountActivationToken
import bookstore.model.User
import bookstore.service.UserService
import bookstore.service.MailService
import bookstore.utils.ErrorHelper
import grails.util.Holders

class LoginController {
	
    def index() {
		def model = [:]
		model['error'] = flash.error
		model['warning'] = flash.warning
		model['success'] = flash.success
        return model
    }
	
	def login(){
		def username = params.username
		def password = params.password
		def userService  = UserService.getInstance()
		def user = userService.getUserByUsername(username)
		
		if (user == null){
			flash.error = 'Username not found'
			redirect(action: 'index', controller: 'login')
			return
		}
		
		if(!user.active){
			AccountActivationToken.executeUpdate("delete from AccountActivationToken as aat where aat.user=?", [user])			
			def accountActivationToken = new AccountActivationToken()
			def aat = UUID.randomUUID().toString()
			accountActivationToken.id = aat
			accountActivationToken.user = user
			accountActivationToken.save(flush: true, failOnError: true)
			
			def mailService = MailService.getInstance()
			def address = user.username
			def title = "Verify your Bookstore account"
			def model = [firstName: user.firstName, serverURL: Holders.config.grails.serverURL, aat: aat]
			def body = mailService.generateHTML("data/verify_account_email.gsp",model)
			mailService.sendMail(address,title,body)
			
			flash.error = 'Your account was not activated yet. A verification email has been sent to activate your account.'
			redirect(action: 'index', controller: 'login')
			return
		}
		
		if (user.password != password.encodeAsSHA1()) {
			flash.error = 'Invalid password'
			redirect(action: 'index', controller: 'login')
			return
		}

		session["userId"] = user.id
		redirect(action: 'index', controller: 'books')
	}
	
	def signup(){
		try{
			def userService = UserService.getInstance()
			def username = params.username
			
			def user = userService.getUserByUsername(username)
			
			if (user != null) {
				flash.error = 'User ' + username + ' already exists.'
				redirect(action: 'index', controller: 'login')
				return
			}
			
			user = new User()
			user.username = username
			user.password = params.password.encodeAsSHA1()
			user.firstName = params.firstName
			user.lastName = params.lastName
			user.gender = params.gender
			user.major = params.major
			user.degree = params.degree
			user.yearOfGraduation = Integer.parseInt(params.yearOfGraduation)
			user.active = false
			user.save(flush: true, failOnError: true)
			
			def accountActivationToken = new AccountActivationToken()
			def aat = UUID.randomUUID().toString()
			accountActivationToken.id = aat
			accountActivationToken.user = user
			accountActivationToken.save(flush: true, failOnError: true)
			
			def mailService = MailService.getInstance()
			def address = params.username
			def title = "Thank you for signing up with our Bookstore"
			def model = [firstName: params.firstName, serverURL: Holders.config.grails.serverURL, aat: aat]
			def body = mailService.generateHTML("data/signup_thankyou_email.gsp",model)
			mailService.sendMail(address,title,body)
			
			flash.success = 'An email has been sent to the address you provided with a link to verify your account.'
			redirect(action: 'index', controller: 'login')
		}
		catch(e){
			println e
			flash.error = 'Error signing up user.'
			redirect(action: 'index', controller: 'login')
		}
	}

}