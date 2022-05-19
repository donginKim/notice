package com.project.notice.apis.user.domain

import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Entity

@Embeddable
open class UserId : Serializable {
    @Column(name = "noti_user_no", nullable = false)
    open var notiUserNo: Int? = null

    @Column(name = "noti_class_no", nullable = false)
    open var notiClassNo: Int? = null

    override fun hashCode(): Int = Objects.hash(notiUserNo, notiClassNo)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as UserId

        return notiUserNo == other.notiUserNo &&
                notiClassNo == other.notiClassNo
    }

    companion object {
        private const val serialVersionUID = 4002497705821993561L
    }
}