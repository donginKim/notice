package com.project.notice.apis.user

import com.project.notice.apis.user.domain.User
import com.project.notice.apis.user.repository.UserRepository
import io.swagger.annotations.Api
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
@Api(value = "/user", description = "사용자 정보", tags = ["사용자"])
@ApiResponses(value = [
    ApiResponse(code = 400, message = "Wrong Parameter Type"),
    ApiResponse(code = 404, message = "Shopping Contents not found"),
    ApiResponse(code = 500, message = "Server Error")
])
class UserController(
    val userRepository: UserRepository
) {
    @GetMapping()
    fun getUser(): ResponseEntity<*> {
        return ResponseEntity.ok(userRepository.findAll())
    }

    @PostMapping("/save")
    fun addUser(@RequestBody user: User): ResponseEntity<*> {
        return ResponseEntity.ok(userRepository.save(user));
    }

}