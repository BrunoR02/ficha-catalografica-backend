package com.ficha.catalografica.projeto.common.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Service
public class JwtTokenService {

  private static final String SECRET_KEY = "/c&#Hkv7Byn)&(N";

  private static final String ISSUER = "ficha_catalografica";

  public static final Long EXPIRATION_TIME_IN_SECONDS = ChronoUnit.HOURS.getDuration().toSeconds() * 3;

  public String generateToken(String subject) {
    if (subject == null)
      throw new IllegalArgumentException("Subject cannot be null");

    return JWT.create()
        .withSubject(subject)
        .withIssuer(ISSUER)
        .withIssuedAt(Instant.now())
        .withExpiresAt(getDefaultExpirationDate())
        .sign(getAlgorithm());
  }

  public String generateToken(String subject, Instant expiresAt) {
    if (subject == null)
      throw new IllegalArgumentException("Subject cannot be null");

    return JWT.create()
        .withSubject(subject)
        .withIssuer(ISSUER)
        .withIssuedAt(Instant.now())
        .withExpiresAt(expiresAt)
        .sign(getAlgorithm());
  }

  public Algorithm getAlgorithm() {
    return Algorithm.HMAC256(SECRET_KEY);
  }

  public String getTokenSubject(String token) throws JWTVerificationException {

    return verify(token).getSubject();
  }

  public DecodedJWT verify(String token) throws JWTVerificationException {
    if (token == null || token.isEmpty())
      throw new JWTVerificationException("Token is null or empty");

    return JWT.require(getAlgorithm())
        .withIssuer(ISSUER)
        .build()
        .verify(token);
  }

  public Boolean isValid(String token) throws JWTVerificationException {
    try {
      verify(token);
      return true;
    } catch (JWTVerificationException exception) {
      return false;
    }
  }

  public Instant getDefaultExpirationDate() {
    return Instant.now().plus(EXPIRATION_TIME_IN_SECONDS, ChronoUnit.SECONDS);
  }

}
