package bookstore



class BookstoreDailyCronJob {
    static triggers = {
		cron name: 'bookstoreDailyCronJob', cronExpression: "0 0 0 * * ?"
    }

    def execute() {
        // execute job
    }
}
