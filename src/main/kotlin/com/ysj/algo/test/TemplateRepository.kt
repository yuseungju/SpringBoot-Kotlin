package com.ysj.algo.test

import org.springframework.data.repository.CrudRepository

interface TemplateRepository: CrudRepository<TemplateModel,Int> {

    fun findByTemplateName(templateName: String): TemplateModel?

    fun findAllBy(): List<TemplateModel>?

}