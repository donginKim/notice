package com.project.notice.apis.group.domain

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@Entity
@Table(name = "NOTICE_CLASS")
@DynamicUpdate
data class Group (
    @Id
    @Column(name = "noti_class_no", nullable = false)
    open var notiClassNo: Int? = null,

    @Column(name = "noti_class_name")
    open var notiClassName: String? = null,

    @Column(name = "noti_class_manager")
    open var notiClassManager: Int? = null

)