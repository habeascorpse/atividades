<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'atividade.label', default: 'Atividade')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <header>
          <span>Criar Tarefa</span>

      </header>
      <section class="nav" role="navigation">
          <ul>
              <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
              <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
          </ul>
      </section>
      <main id="taskPage">
        <section id="taskCreation"  role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.atividade}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.atividade}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form action="save">
                <fieldset class="form">
                    <f:with bean="atividade">
                      <f:field property="nome"  />
                      <f:field property="categoria" input-optionValue="descricao" />
                      <f:field property="deadLine" type="Date" />
                  </f:with>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </section>
      </main>
    </body>
</html>
