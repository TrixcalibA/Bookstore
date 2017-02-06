package bookstore

import grails.converters.JSON
import bookstore.model.AccountActivationToken
import bookstore.model.User
import bookstore.service.UserService
import bookstore.service.MailService
import bookstore.utils.ErrorHelper
import grails.util.Holders

class AccountActivateController {
	
    def index() {
		try{
			def aat = params.id
		
			def accountActivationToken = AccountActivationToken.find('from AccountActivationToken aat where aat.id=?',[aat])
			if(accountActivationToken==null){
				flash.warning = 'Invalid activation token.'
				redirect(action: 'index', controller: 'login')
				return
			}
			def user = accountActivationToken.user
			user.active = true
			user.save(flush: true, failOnError: true)
			AccountActivationToken.executeUpdate("DELETE FROM AccountActivationToken aat where aat.id = ?",[aat])
		}
		catch(e){
			flash.warning = 'Your account was not activated successfully.'
			redirect(action: 'index', controller: 'login')
			return
		}
		flash.success = 'Your account was activated successfully. You can now login as authenticated user.'
		redirect(action: 'index', controller: 'login')
    }

}