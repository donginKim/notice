package com.project.notice.apis.group.repository

import com.project.notice.apis.group.domain.Group
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GroupRepository : JpaRepository<Group, String?>{
    fun findByNotiClassNo(id: Int) : Group?
}