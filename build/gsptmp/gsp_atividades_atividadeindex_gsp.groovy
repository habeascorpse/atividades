import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_atividades_atividadeindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/atividade/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('set','g',4,['var':("entityName"),'value':(message(code: 'atividade.label', default: 'Atividade'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',5,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(1)
invokeTag('stylesheet','asset',6,['src':("02-tasks.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',7,['src':("application.css")],-1)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
if(true && (flash.message)) {
printHtmlPart(4)
expressionOut.print(flash.message)
printHtmlPart(5)
}
printHtmlPart(6)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(7)
invokeTag('message','g',22,['code':("default.home.label")],-1)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',23,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',23,['class':("list"),'action':("index")],2)
printHtmlPart(9)
loop:{
int i = 0
for( atividade in (atividadeList) ) {
printHtmlPart(10)
invokeTag('set','g',46,['var':("dif"),'value':(((atividade.deadLine.time - new Date().time) / 1000 / 60 / 60 / 24).intValue())],-1)
printHtmlPart(11)
expressionOut.print((dif < 0) ? 'tarefa_atrasada' : (dif > 5? 'none' : 'tarefa_prazo'))
printHtmlPart(12)
expressionOut.print(atividade.completo ? 'completo' : 'none')
printHtmlPart(13)
expressionOut.print(fieldValue(bean: atividade, field: "nome"))
printHtmlPart(14)
expressionOut.print(atividade.completo ? 'completo' : 'none')
printHtmlPart(13)
invokeTag('formatDate','g',51,['format':("dd/MM/yyyy"),'date':(atividade.deadLine)],-1)
printHtmlPart(15)
expressionOut.print(atividade.completo ? 'completo' : 'none')
printHtmlPart(7)
expressionOut.print(fieldValue(bean: atividade, field: "categoria.descricao"))
printHtmlPart(16)
createTagBody(3, {->
printHtmlPart(17)
expressionOut.print(message(code: 'default.button.delete.label', default: 'Delete'))
printHtmlPart(18)
})
invokeTag('form','g',58,['resource':(atividade),'method':("DELETE")],3)
printHtmlPart(19)
if(true && (atividade.completo == false)) {
printHtmlPart(20)
createClosureForHtmlPart(21, 4)
invokeTag('link','g',61,['action':("edit"),'id':(atividade.id)],4)
printHtmlPart(22)
createClosureForHtmlPart(23, 4)
invokeTag('link','g',64,['class':("editRow"),'action':("completar"),'id':(atividade.id)],4)
printHtmlPart(24)
}
printHtmlPart(25)
i++
}
}
printHtmlPart(26)
createTagBody(2, {->
invokeTag('message','g',76,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',76,['id':("btnAddTask"),'class':("create"),'action':("create")],2)
printHtmlPart(27)
expressionOut.print(atividadeCount)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',84,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1439068467000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
