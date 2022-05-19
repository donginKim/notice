package com.project.notice.apis.user.domain

import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "NOTICE_USER")
data class User(
    @EmbeddedId
    open var id: UserId? = null,

    @Column(name = "noti_user_name", nullable = false)
    open var notiUserName: String? = null,

    @Column(name = "noti_user_number")
    open var notiUserNumber: String? = null,

    @Column(name = "noti_user_profile")
    open var notiUserProfile: String? = null,

    @Column(name = "noti_user_clf_cd", nullable = false)
    open var notiUserClfCd: Int? = null,

    @Column(name = "create_date")
    open var createDate: Instant? = null,

    @Column(name = "update_date")
    open var updateDate: Instant? = null
)