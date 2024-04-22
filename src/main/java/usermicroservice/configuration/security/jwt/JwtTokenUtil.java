package usermicroservice.configuration.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.security.Key;
import java.security.SignatureException;
import java.util.*;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {
    public final long JWT_TOKEN_VALIDITY = 10 * 60 * 60 * 1000;

    private String secret = ("7c5063e525246a38094310f875f0a2bbbebecb1c016b5989c7269cc1afd69cf9");

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());
        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ JWT_TOKEN_VALIDITY))
                .signWith(getKey())
                .compact();
    }

    private Key getKey() {
        byte[] keyBytes = secret.getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public Claims getAllClaimsFromToken(String token){
        return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    public List<String> getRolesFromToken(String token){
        return getClaimFromToken(token, claim -> {
            List<?> rolesObject = claim.get("roles", List.class);
            if (rolesObject != null){
                return rolesObject.stream()
                        .filter(String.class::isInstance)
                        .map(String::valueOf)
                        .toList();
            }
            return Collections.emptyList();
        });
    }

    public String getUsernameFromToken(String token) {return getClaimFromToken(token, Claims::getSubject);}

    public Date getExpirationDateFromToken(String token) {return getClaimFromToken(token, Claims::getExpiration);}

    private boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public boolean validateToken(String token, String userFromHeader) throws SignatureException {
        final String username = getUsernameFromToken(token);
        final Key key = getKey();

       if(username.equalsIgnoreCase(userFromHeader) && !isTokenExpired(token)){
           try {
               Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
               return true;
           } catch (Exception e) {
               throw new SignatureException();
           }
       }
       return false;
    }

    public String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer")) {
            return authHeader.substring(7).trim();
        }
        return null;
    }
}
