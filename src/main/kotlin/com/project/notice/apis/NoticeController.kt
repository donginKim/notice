package com.project.notice.apis

import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class NoticeController {

    @GetMapping()
    fun index() : ResponseEntity<String>{
        return ResponseEntity.ok("Hello World")
    }
}