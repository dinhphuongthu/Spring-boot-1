package com.sapo.ex7_RestfullAPI_Spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapo.ex7_RestfullAPI_Spring.security.CustomUserDetails;
import com.sapo.ex7_RestfullAPI_Spring.security.JwtTokenProvider;
import com.sapo.ex7_RestfullAPI_Spring.security.LoginRequest;
import com.sapo.ex7_RestfullAPI_Spring.security.LoginResponse;

@RestController
@RequestMapping("/admin")
public class LoginAPI {
	@Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider tokenProvider;
    @PostMapping("/login")
    public LoginResponse authenticateUser(@RequestBody LoginRequest request){
        // Xác thực username và password
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        // Nếu không xảy ra exeption là thông tin hợp lệ
        // Trả về jwt cho người dùng
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }
}
