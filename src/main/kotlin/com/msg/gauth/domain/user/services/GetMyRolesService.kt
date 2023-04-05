package com.msg.gauth.domain.user.services

import com.msg.gauth.domain.user.presentation.dto.response.GetMyRolesResDto
import com.msg.gauth.domain.user.utils.UserUtil
import com.msg.gauth.global.annotation.service.ReadOnlyService

@ReadOnlyService
class GetMyRolesService(
    private val userUtil: UserUtil
) {
    fun execute(): GetMyRolesResDto =
        GetMyRolesResDto(userUtil.fetchCurrentUser().roles)
}