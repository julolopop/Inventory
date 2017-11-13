package com.example.usuario.inventoryMVP.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by usuario on 13/11/17.
 */

public final class CommonUtils {

    /**
     * Método que comprueba los sigientes requisitos
     * contiene al menos un digito 0-9
     * contiene al menos un carácter Mayuscula
     * contiene al menos un carácter Minuscula
     * contiene al menos 6 carácteres
     * @param password
     * @return
     */
    public static boolean isPasswordvalid(String password){
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN ="^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])(?=\\w*[0-9])\\S{6,}";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher=pattern.matcher(password);

        return matcher.matches();
    }

}
