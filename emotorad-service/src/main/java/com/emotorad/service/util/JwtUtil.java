package com.emotorad.service.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Date;

public class JwtUtil {

    PrivateKey privateKey = getPrivateKey();
    private final String keystorePath = "/jks/ebook.jks";
    private final String keystorePassword = "password";
    private final String keyAlias = "ebook";
    public static final long EXPIRATION_TIME = 300000; // 5 mins

    public String generateToken(String username) {
        PrivateKey privateKey = getPrivateKey();
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(privateKey, SignatureAlgorithm.RS256)
                .compact();
    }

    public  Claims parseJwtToken(String jwtToken) {
        PublicKey publicKey = getPublicKeyFromJKS();
        return Jwts.parser()
                .setSigningKey(publicKey)
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    private  PublicKey getPublicKeyFromJKS() {
        try {
            KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            keystore.load(getClass().getResourceAsStream(keystorePath), keystorePassword.toCharArray());
            // Retrieve the certificate from the keystore
            Certificate certificate = keystore.getCertificate(keyAlias);
            // Extract the public key from the certificate
            return certificate.getPublicKey();
        } catch (Exception e) {
            throw new RuntimeException("Error loading public key from keystore", e);
        }
    }

    public  boolean validateToken(String token, UserDetails userDetails) {
        String username = userDetails.getUsername();
        Claims claims = parseJwtToken(token);
        return claims != null && username.equals(claims.getSubject()) && !isTokenExpired(claims);
    }

    private static boolean isTokenExpired(Claims claims) {
        Date expiration = claims.getExpiration();
        return expiration != null && expiration.before(new Date());
    }

    private PrivateKey getPrivateKey() {
        try {
            KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            keystore.load(getClass().getResourceAsStream(keystorePath), keystorePassword.toCharArray());
            return (PrivateKey) keystore.getKey(keyAlias, keystorePassword.toCharArray());
        } catch (Exception e) {
            throw new RuntimeException("Error loading private key from keystore", e);
        }
    }
}
