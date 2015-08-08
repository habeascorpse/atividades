package atividades

import org.grails.databinding.BindingFormat

class Atividade {
  String nome
  @BindingFormat('ddMMyyyy')
  Date deadLine
  boolean completo
  Categoria categoria

    static constraints = {

    }

    static mapping = {
      completo defaultValue: false
    }
}
