package com.msg.gauth.domain.oauth.exception

import com.msg.gauth.global.exception.ErrorCode
import com.msg.gauth.global.exception.exceptions.BasicException

class OAuthSignInBanException : BasicException(
    ErrorCode.OAUTH_SIGN_IN_BAN
)