package com.msg.gauth.domain.auth.presentation;

import com.msg.gauth.domain.auth.presentation.dto.request.SigninRequestDto;
import com.msg.gauth.domain.auth.presentation.dto.response.RefreshResponseDto;
import com.msg.gauth.domain.auth.presentation.dto.response.SigninResponseDto;
import com.msg.gauth.domain.auth.services.LogoutService;
import com.msg.gauth.domain.auth.services.RefreshService;
import com.msg.gauth.domain.auth.services.SigninService;
import com.msg.gauth.domain.user.presentation.dto.request.SignUpDto;
import com.msg.gauth.domain.auth.services.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final RefreshService refreshService;
    private final LogoutService logoutService;

    private final SigninService signinService;
    
    private final SignUpService signUpService;

    @PatchMapping
    public ResponseEntity<RefreshResponseDto> refresh(@RequestHeader String refreshToken){
        return ResponseEntity.ok(refreshService.execute(refreshToken));
    }

    @DeleteMapping
    public ResponseEntity<Void> logout(){
        logoutService.execute();
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<SigninResponseDto> signin(@RequestBody @Valid SigninRequestDto signinRequestDto){
        return ResponseEntity.ok(signinService.execute(signinRequestDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signUpMember(@RequestBody @Valid SignUpDto signUpDto) throws URISyntaxException {
        signUpService.execute(signUpDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
