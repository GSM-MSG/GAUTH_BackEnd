package com.msg.gauth.domain.oauth.presentation

import com.msg.gauth.domain.oauth.presentation.dto.request.OauthCodeRequestDto
import com.msg.gauth.domain.oauth.presentation.dto.request.UserTokenRequestDto
import com.msg.gauth.domain.oauth.presentation.dto.response.OauthCodeResponseDto
import com.msg.gauth.domain.oauth.presentation.dto.response.ServiceNameResponseDto
import com.msg.gauth.domain.oauth.presentation.dto.response.UserTokenResponseDto
import com.msg.gauth.domain.oauth.services.GetServiceNameService
import com.msg.gauth.domain.oauth.services.GenerateOauthCodeService
import com.msg.gauth.domain.oauth.services.RefreshOauthTokenService
import com.msg.gauth.domain.oauth.services.GenerateOauthTokenService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/oauth")
class OauthController(
    private val generateOauthCodeService: GenerateOauthCodeService,
    private val generateOauthTokenService: GenerateOauthTokenService,
    private val refreshOauthTokenService: RefreshOauthTokenService,
    private val getServiceNameService: GetServiceNameService,
) {
    @PostMapping("/code")
    fun generateOauthCode(@Valid @RequestBody oauthCodeRequestDto : OauthCodeRequestDto): ResponseEntity<OauthCodeResponseDto> {
        val result = generateOauthCodeService.execute(oauthCodeRequestDto)
        return ResponseEntity.ok(result)
    }

    @PostMapping("/code/access")
    fun generateOauthCode(): ResponseEntity<OauthCodeResponseDto>{
        val result = generateOauthCodeService.execute()
        return ResponseEntity.ok(result)
    }

    @PostMapping("/token")
    fun generateOauthToken(@Valid @RequestBody userTokenRequestDto: UserTokenRequestDto): ResponseEntity<UserTokenResponseDto> {
        val result = generateOauthTokenService.execute(userTokenRequestDto)
        return ResponseEntity.ok(result)
    }

    @PatchMapping("/token")
    fun refreshOauthToken(@RequestHeader refreshToken: String): ResponseEntity<UserTokenResponseDto> {
        val result = refreshOauthTokenService.execute(refreshToken)
        return ResponseEntity.ok(result)
    }

    @GetMapping("/{clientId}")
    fun getServiceName(@PathVariable clientId: String): ResponseEntity<ServiceNameResponseDto> {
        val result = getServiceNameService.execute(clientId)
        return ResponseEntity.ok(result)
    }
}