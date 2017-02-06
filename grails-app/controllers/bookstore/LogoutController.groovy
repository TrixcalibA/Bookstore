package bookstore

class LogoutController {

    def index() {
		session.invalidate()
		redirect(action: 'index', controller: 'login')
    }
}
