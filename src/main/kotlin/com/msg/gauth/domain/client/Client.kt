package com.msg.gauth.domain.client

import com.msg.gauth.domain.client.enums.ServiceScope
import com.msg.gauth.domain.client.presentation.dto.request.ClientUpdateReqDto
import com.msg.gauth.domain.user.User
import com.msg.gauth.global.entity.BaseIdEntity
import javax.persistence.*

@Entity
class Client(

    override val id: Long = 0,

    val clientId: String,

    val clientSecret: String,

    val redirectUri: String,

    val serviceName: String,

    val serviceUri: String,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val createdBy: User,

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'PUBLIC'")
    val serviceScope: ServiceScope

): BaseIdEntity(id)