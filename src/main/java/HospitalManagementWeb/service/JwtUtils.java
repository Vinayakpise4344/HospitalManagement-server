package HospitalManagementWeb.service;

import HospitalManagementWeb.entity.ManagementEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Component
public class JwtUtils {
    private SecretKey key;

    private static final long EXPIRATION_TIME = 86400000;

    public  JwtUtils(){
        String secreteString = "843567893696976453275974432697R7878876R7384747TR678T5R6834R8763T478385475896SS5387456738657836785487345687R3";
        byte[] keyBytes = Base64.getDecoder().decode(secreteString.getBytes(StandardCharsets.UTF_8));
        this.key = new SecretKeySpec(keyBytes,"HmacSHA256");

    }
    public String generateToken(ManagementEntity managementEntity){
        return Jwts.builder()
                .subject(managementEntity.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    public String refreshToken(HashMap<String,Object> claims , ManagementEntity managementEntity){
        return Jwts.builder()
                .subject(managementEntity.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }
    public String extractUsername(String token){
        return extractClaims(token, Claims::getSubject);
    }
    private <T> T extractClaims(String token , Function<Claims,T> claimsTFunction){
        return  claimsTFunction.apply(Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload());
    }
    public  boolean isTokenValid(String token, UserDetails userDetails){
        final  String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()));
    }
    public boolean isTokenExpired(String token, ManagementEntity managementEntity){
        return  extractClaims(token,Claims::getExpiration).before(new Date());
    }


}

