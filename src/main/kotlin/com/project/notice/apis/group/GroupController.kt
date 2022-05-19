package com.project.notice.apis.group

import com.project.notice.apis.group.domain.Group
import com.project.notice.apis.group.repository.GroupRepository
import io.swagger.annotations.Api
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException

@RestController
@RequestMapping("/class")
@Api(value = "/class", description = "그룹 정보", tags = ["그룹"])
@ApiResponses(value = [
    ApiResponse(code = 400, message = "Wrong Parameter Type"),
    ApiResponse(code = 404, message = "Shopping Contents not found"),
    ApiResponse(code = 500, message = "Server Error")
])
class GroupController(
    val groupRepository: GroupRepository
) {
    @GetMapping()
    fun getClass(): ResponseEntity<*> {
        return ResponseEntity.ok(groupRepository.findAll())
    }

    @PostMapping("/save")
    fun addClass(@RequestBody group: Group): ResponseEntity<*> {
        return ResponseEntity.ok(groupRepository.save(group))
    }

    @PutMapping("/update/{classNo}")
    fun updateClass(@PathVariable classNo: Int,
                    @RequestParam(value = "manager", required = false) manager: Long? = null,
                    @RequestParam(value = "name", required = false) name: String? = null): ResponseEntity<*> {

        val group = groupRepository.findByNotiClassNo(classNo) ?: throw EntityNotFoundException()

        if(manager != null) { group.notiClassManager = manager.toInt() }
        if(name != null) { group.notiClassName = name }

        return ResponseEntity.ok(groupRepository.flush())
    }
}