import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_atividades_atividadecreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/atividade/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'atividade.label', default: 'Atividade'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.create.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("default.home.label")],-1)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("list"),'action':("index")],2)
printHtmlPart(6)
invokeTag('message','g',21,['code':("default.create.label"),'args':([entityName])],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(12)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(13)
expressionOut.print(error.field)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('message','g',28,['error':(error)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',29,['bean':(this.atividade),'var':("error")],3)
printHtmlPart(17)
})
invokeTag('hasErrors','g',31,['bean':(this.atividade)],2)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(18)
createTagBody(3, {->
printHtmlPart(19)
invokeTag('field','f',35,['property':("nome")],-1)
printHtmlPart(19)
invokeTag('field','f',36,['property':("categoria"),'input-optionValue':("descricao")],-1)
printHtmlPart(19)
invokeTag('field','f',37,['property':("deadLine"),'type':("Date")],-1)
printHtmlPart(20)
})
invokeTag('with','f',38,['bean':("atividade")],3)
printHtmlPart(21)
invokeTag('submitButton','g',41,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(22)
})
invokeTag('form','g',43,['action':("save")],2)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',46,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1439065500000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
