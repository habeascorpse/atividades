package atividades

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AtividadeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {

        params.max = Math.min(max ?: 10, 100)
        int qntAtividades = 0

        for (Atividade it: Atividade.getAll()) {
          if (!it.completo)
            qntAtividades++
        }

        respond Atividade.list(params), model:[atividadeCount: qntAtividades]
    }

    def show(Atividade atividade) {
        respond atividade
    }

    def create() {
        respond new Atividade(params)
    }

    @Transactional
    def save(Atividade atividade) {
        if (atividade == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }
        atividade.completo = false

        if (atividade.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond atividade.errors, view:'create'
            return
        }

        atividade.save flush:true
        redirect(action: "index")

    }

    def edit(Atividade atividade) {
        respond atividade
    }

    @Transactional
    def update(Atividade atividade) {
        if (atividade == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (atividade.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond atividade.errors, view:'edit'
            return
        }

        atividade.save flush:true

        redirect(action: "index")
    }

    @Transactional
    def completar(Atividade atividade) {
      if (atividade == null) {
          transactionStatus.setRollbackOnly()
          notFound()
          return
      }

      atividade.completo = true
      atividade.save flush:true

      redirect(action: "index")

    }

    @Transactional
    def delete(Atividade atividade) {

        if (atividade == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        atividade.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'atividade.label', default: 'Atividade'), atividade.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'atividade.label', default: 'Atividade'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
