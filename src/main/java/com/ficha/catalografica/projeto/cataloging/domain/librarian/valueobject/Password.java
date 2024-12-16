package com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject;

import java.util.regex.Pattern;

import org.springframework.security.crypto.bcrypt.BCrypt;

import io.micrometer.common.util.StringUtils;
import lombok.Getter;

@Getter
public class Password {

  private final String hashedValue;

  private static final Pattern ANY_UPPERCASE_PATTERN = Pattern.compile(".*[A-Z].*");
  private static final Pattern ANY_LOWERCASE_PATTERN = Pattern.compile(".*[a-z].*");
  private static final Pattern ANY_NUMBER_PATTERN = Pattern.compile(".*\\d.*");

  public Password(String password) {
    this.hashedValue = password;
  }

  public static Password fromRaw(String rawPassword) throws IllegalArgumentException {
    if (!isPasswordValid(rawPassword))
      throw new IllegalArgumentException("Password does not meet the criteria");

    return new Password(hashPassword(rawPassword));
  }

  private static String hashPassword(String rawPassword) {
    return BCrypt.hashpw(rawPassword, BCrypt.gensalt());
  }

  public static boolean isPasswordValid(String password) {
    if (StringUtils.isBlank(password))
      return false;

    return password.length() >= 8 && ANY_UPPERCASE_PATTERN.matcher(password).matches() // At least one uppercase
        && ANY_LOWERCASE_PATTERN.matcher(password).matches() // At least one lowercase
        && ANY_NUMBER_PATTERN.matcher(password).matches(); // At least one digit
  }

  public boolean matches(String rawPassword) {
    return BCrypt.checkpw(rawPassword, this.hashedValue);
  }
}
