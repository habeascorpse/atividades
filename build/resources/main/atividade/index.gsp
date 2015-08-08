<!DOCTYPE html>
<html>
    <head>
        <g:set var="entityName" value="${message(code: 'atividade.label', default: 'Atividade')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
        <asset:stylesheet src="02-tasks.css"/>
        <asset:stylesheet src="application.css"/>
    </head>
    <body>


      <header>
            <span>Lista de Tarefas</span>


            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
        </header>
        <section id="nav">
          <ul>
              <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
              <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
          </ul>
        </section>
        <main id="taskPage">
            <section>

                <table id="tblTasks">
                    <colgroup>
                        <col width="40%">
                        <col width="15%">
                        <col width="15%">
                        <col width="30%">
                    </colgroup>
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Deadline</th>
                            <th>Categoria</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                      <g:each in="${atividadeList}" status="i" var="atividade">
                        <g:set var="dif" value="${((atividade.deadLine.time - new Date().time) / 1000 / 60 / 60 / 24).intValue()}"/>
                        <tr class="${(dif < 0) ? 'tarefa_atrasada' : (dif > 5? 'none' : 'tarefa_prazo') }">

                          <td class="${atividade.completo ? 'completo' : 'none'}" >${fieldValue(bean: atividade, field: "nome")}</td>

                          <td class="${atividade.completo ? 'completo' : 'none'}" ><g:formatDate format="dd/MM/yyyy" date="${atividade.deadLine}" />
                            </td>

                          <td class="${atividade.completo ? 'completo' : 'none'}">${fieldValue(bean: atividade, field: "categoria.descricao")}</td>
                          <td>
                            <g:form resource="${atividade}" method="DELETE">
                                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" />
                            </g:form>
                            <g:if test="${atividade.completo == false}">
                            <button>
                              <g:link action="edit" id="${atividade.id}">editar</g:link>
                            </button>
                            <button>
                              <g:link class="editRow" action="completar" id="${atividade.id}"  >completar</g:link>

                            </button>
                            </g:if>

                          </td>

                        </tr>
                      </g:each>
                    </tbody>
                </table>
                <nav>
                    <g:link id="btnAddTask" class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link>
                </nav>
            </section>
        </main>
        <footer>
          você tem ${atividadeCount} tarefas
        </footer>

    </body>
</html>
