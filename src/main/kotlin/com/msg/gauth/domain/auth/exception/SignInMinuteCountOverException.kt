package com.msg.gauth.domain.auth.exception

import com.msg.gauth.global.exception.ErrorCode
import com.msg.gauth.global.exception.exceptions.BasicException

class SignInMinuteCountOverException : BasicException(ErrorCode.MANY_REQUEST_SIGN_IN_MINUTE) {
}