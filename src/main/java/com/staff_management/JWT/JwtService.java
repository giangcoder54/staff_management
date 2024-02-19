package com.staff_management.JWT;

import com.staff_management.Entity.Security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;

@Component
public class JwtService {
    @Value("${intrust.app.jwtExpirationMs}")
    private long jwtExpiratonMs;

    @Value("${intrust.app.jwtRefreshSecret}")
    private String jwtRefreshSecret;

    @Value("${intrust.app.jwtRefreshExpirationMs}")
    private Long refreshTokenDurationMs;

    private String generateToken(UserDetailsImpl userPrinciple){

        return null;
    }
    private String createAndSignJWT(UserDetailsImpl userPrinciple){
        return null;
    }
    private RSAPrivateKey getPrivateKey(String fileName) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        String rootPath = System.getProperty("user.dir"); // lay thu muc hien tai cua java application
        String filePath = rootPath +"/"+ fileName;
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file); // đọc file
        DataInputStream dis = new DataInputStream(fis); // đọc binay data từ file

        byte[] keyBytes = new byte[(int) file.length()];
        System.out.println(keyBytes.length);
        dis.readFully(keyBytes);// đọc toàn bộ nội dung trong file và truyền vào keyBytes
        // keyBytes giờ contain binary representation private key
        System.out.println(rootPath);
        KeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");//A KeyFactory is created for RSA keys.assigned KeyFactory algorithm
        //The generatePrivate method of the KeyFactory is called with the PKCS8EncodedKeySpec to create an RSAPrivateKey.
        // This RSAPrivateKey represents your private key.
        RSAPrivateKey privateKey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        return  privateKey;
    }

}
