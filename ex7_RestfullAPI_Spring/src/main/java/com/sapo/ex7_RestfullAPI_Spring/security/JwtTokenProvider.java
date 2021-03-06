package com.sapo.ex7_RestfullAPI_Spring.security;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtTokenProvider {
	 private Logger log = org.slf4j.LoggerFactory.getLogger(JwtTokenProvider.class);
	// Chuỗi bí mật chỉ phía server biết
    private final String JWT_SECRET = "lobsterrr";

    // Thời gian hiệu lực chuỗi
    private final Long JWT_EXPIRATION = 604800000L;

    // Tạo ra jwt từ thông tin user
    public String generateToken(CustomUserDetails userDetails){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        // Tạo chuỗi json web token từ id của user.
        return Jwts.builder()
                .setSubject(Integer.toString(userDetails.getUser().getId()))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512,JWT_SECRET)
                .compact();
    }

    // Lấy thông tin user từ jwt
    public Integer getUserIdFromJWT(String token){
        Claims claims = Jwts.parser()
                            .setSigningKey(JWT_SECRET)
                            .parseClaimsJws(token)
                            .getBody();
        return Integer.parseInt(claims.getSubject());
    }

    // Kiểm tra tính hợp lệ của token
    public boolean validateToken(String authToken){
        try{
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        }catch (MalformedJwtException e){
            log.error("Invalid JWT token"); // Chuỗi không hợp lệ
        }catch (ExpiredJwtException e){
            log.error("Expired JWT token"); // Chuỗi quá hạn
        }catch (UnsupportedJwtException e){
            log.error("Unsupported JWT token"); // Chuỗi không hỗ trợ
        }catch (IllegalArgumentException e){
            log.error("JWT claims string is empty"); // Chuỗi rỗng
        }
        return false;
    }
}
