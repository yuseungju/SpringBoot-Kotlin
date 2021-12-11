package com.ysj.algo.test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController // @Controller + @ResponseBody
@RequestMapping//("/template")
class TemplateController {

    @Autowired
    private lateinit var templateService: TemplateService

    @GetMapping("/templates")
    private fun getTemplates(): ResponseEntity<Any> {
        return ResponseEntity
            .ok()
            .body(templateService.getAllTemplates())
    }

    @GetMapping("/template/{id}")
    private fun getTemplateById(@PathVariable id: Int): ResponseEntity<Any> {
        return ResponseEntity
            .ok()
            .body(templateService.getTemplate(id))
    }

    @GetMapping("/template")
    private fun getTemplateByName(@RequestParam(value = "name") name: String): ResponseEntity<Any?> {
        return ResponseEntity
            .ok()
            .body(templateService.getTemplateByName(name))
    }

    @PostMapping("/template")
    private fun postTemplate(@RequestBody templateModel: TemplateModel): ResponseEntity<Any> {
        templateService.saveTemplate(templateModel)
        return ResponseEntity
            .ok()
            .body(true)
    }
}