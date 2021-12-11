package com.ysj.algo.test

import javax.persistence.*

@Entity
@Table(name="Template_model") // table name
data class TemplateModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    val id: Int,
    @Column(name="template_name")
    val templateName: String,
    @Column(name="asd")
    val qwe: String,
    @Column(name="content")
    val content: String)