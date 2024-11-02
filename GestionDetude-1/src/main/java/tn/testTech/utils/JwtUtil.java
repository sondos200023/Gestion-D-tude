package tn.testTech.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
//classe pour la creation et la validation des Jeton JWT
@Component
public class JwtUtil {
	//clé pour signé et validé les tokens 
	  public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A713474375367566B59703373367639792F423F4528482B4D6251655468576D5A713474375367566B59703373367639792F423F4528482B4D6251655468576D5A713474375367566B59703373367639792F423F4528482B4D6251655468576D5A713474375367566B59703373367639792F423F4528482B4D6251655468576D5A713474375367566B59703373367639792F423F4528482B4D6251655468576D5A713474375367566B59703373367639792F423F4528482B4D6251655468576D5A713474375367566B59703373367639792F423F4528482B4D6251655468576D5A713474375367566B59703373367639792F423F4528482B4D6251655468576D5A713474375367566B59703373367639792F423F4528482B4D6251655468576D5A713474375367566B59703373367639792F423F4528482B4D6251655468576D5A713474375367566B59703373367639792F423F4528482B4D6251655468576D5A713474375367566B59703373367639792F423F4528482B4D6251655468576D5A713474375367566B59703373367639792F423F4528482B4D6251655468576D5A713474375367566B59703373367639792F423F4528482B4D6251655468576D5A713474375367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

	    public String extractUsername(String token) {
	        return extractClaim(token, Claims::getSubject);//recuperer nom d'utilisateur (sujet) a partir de JWT
	    }

	    public Date extractExpiration(String token) {
	        return extractClaim(token, Claims::getExpiration);//dare d'expiration de JWT
	    }

	    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {//claim contient subjet ,expiration,iat(indicate when token is used)
	        final Claims claims = extractAllClaims(token);
	        return claimsResolver.apply(claims);	
	    }

	    private Claims extractAllClaims(String token) {
	        return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
	    }

	    private Boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }
       //comparant le nom d'utilisateur extrait du token avec celui fourni par userDetails et en vérifiant qu'il n'est pas expiré.
	    public Boolean validateToken(String token, UserDetails userDetails) {
	        final String username = extractUsername(token);
	        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	    }
        //generer un token pour un user 
	    public String generateToken(String username) {
	        Map<String, Object> claims = new HashMap<>();
	        return createToken(claims, username);
	    }
        //construire un token
	    private String createToken(Map<String, Object> claims, String userName) {
	        return Jwts
	                .builder()
	                .setClaims(claims)
	                .setSubject(userName)
	                .setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
	                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
	    }
//Décode la clé secrète codée en base64 et la convertit en un objet Key utilisé pour signer ou vérifier les JWT.
	    private Key getSignKey() {
	        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
	        return Keys.hmacShaKeyFor(keyBytes);
	    }

	}


