package hu.hittanacs.login.util;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class EncryptUtil {

    public static final String getEncryptedString(String str){
        return Hashing.sha256()
                .hashString(str, StandardCharsets.UTF_8)
                .toString();
    }
}
