package bookstore.service
import grails.util.Holders
import bookstore.utils.Logger
import org.springframework.context.ApplicationContext

class MailService {

	private static MailService instance = null
	
	def static synchronized getInstance(){
		if(instance==null){
			instance = new MailService()
			return instance
		}
		return instance
	}
	
	def generateHTML(path,model){
		ApplicationContext ctx = Holders.grailsApplication.mainContext
		def groovyPagesTemplateEngine = ctx.getBean("groovyPagesTemplateEngine")
		
		String content = ''
		def is = ctx.getClassLoader().getResourceAsStream(path)
		int i;
		while((i = is.read())>-1)
			content += (char)i;

		def template = groovyPagesTemplateEngine.createTemplate(content, "html")
		def htmlWriteable = template.make(model)
		def wr = new StringWriter()
		htmlWriteable.writeTo(wr)
		return wr.toString()
	}
	
	def sendMail(address,title,body){
		ApplicationContext ctx = Holders.grailsApplication.mainContext
		def mailService = ctx.getBean("mailService")
		
		try{
			mailService.sendMail {
				to address
				subject title
				html body
			}
		}
		catch(Exception e){
			Logger.log(e.getMessage());
		}
	}
}
