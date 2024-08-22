package com.orders_management.domain.util;

import java.security.SecureRandom;

public class AuthenticationCodeUtil {
    private static final String caracters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final SecureRandom random = new SecureRandom();
    public static String getToken(int length) {
        StringBuilder token = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            token.append(caracters.charAt(random.nextInt(caracters.length())));
        }
        return token.toString();
    }
}
