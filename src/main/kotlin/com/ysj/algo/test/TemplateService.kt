package com.ysj.algo.test

import org.springframework.stereotype.Service

@Service
interface TemplateService {

    fun getAllTemplates(): List<TemplateModel>?

    fun getTemplate(id: Int): TemplateModel?

    fun saveTemplate(templateModel: TemplateModel): TemplateModel

    fun getTemplateByName(name: String): TemplateModel?
}