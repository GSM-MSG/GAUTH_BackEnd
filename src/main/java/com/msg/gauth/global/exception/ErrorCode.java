package com.msg.gauth.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR("서버 내부 에러", 500),

    BAD_REQUEST("잘못된 요청", 400),

    UNAUTHORIZED("권한 없음", 401),
    EXPIRED_TOKEN("토큰 만료", 401),
    INVALID_TOKEN("토큰 변질", 401),

    NOT_FOUND("리소스를 찾을수 없음", 404),
    USER_NOT_FOUND("해당 유저를 찾을 수 없음", 404),
    ;

    private String msg;
    private Integer code;
}
