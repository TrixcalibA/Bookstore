package bookstore

import grails.converters.JSON;


class MailController {
	
    def view() {
		
		try {
			sendMail {
				to "${params.id}"
				subject "Bookstore"
				body "Hello World"
			}
			render "email sent!"
		}
        catch (e) {
			println e
			render "could not send email"
		}
    }

}