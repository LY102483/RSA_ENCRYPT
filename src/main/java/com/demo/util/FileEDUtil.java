package com.demo.util;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by wushange on 2022/4/1.
 */
public class FileEDUtil {

    /**
     * 进行加密并保存目标文件destFile中
     */
    public static void encryptRsa(InputStream is, File destFile, String strKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        byte[] decoded = getPublicKey(strKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        OutputStream out = new FileOutputStream(destFile);
        CipherInputStream cis = new CipherInputStream(is, cipher);
        byte[] buffer = new byte[1024];
        int r;
        while ((r = cis.read(buffer)) > 0) {
            out.write(buffer, 0, r);
        }
        cis.close();
        out.close();
    }

    /**
     * 采用DES算法解密
     */
    public static void decryptRsa(InputStream is, File dest, String strKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        byte[] decoded = getPrivateKey(strKey);
        RSAPrivateKey pubKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        cipher.init(Cipher.DECRYPT_MODE, pubKey);
        OutputStream out = new FileOutputStream(dest);
        CipherOutputStream cos = new CipherOutputStream(out, cipher);
        byte[] buffer = new byte[1024];
        int r;
        while ((r = is.read(buffer)) >= 0) {
            cos.write(buffer, 0, r);
        }
        cos.close();
        out.close();

    }
        /**
         * 进行加密并保存目标文件destFile中
         */
    public static void encryptAes(InputStream is, File destFile, String strKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, getAesKey(strKey));

        OutputStream out = new FileOutputStream(destFile);
        CipherInputStream cis = new CipherInputStream(is, cipher);
        byte[] buffer = new byte[1024];
        int r;
        while ((r = cis.read(buffer)) > 0) {
            out.write(buffer, 0, r);
        }
        cis.close();
        out.close();
    }
    /**
     * 采用AES算法解密
     */
    public static void decryptAes(InputStream is, File dest, String strKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, getAesKey(strKey));

        OutputStream out = new FileOutputStream(dest);
        CipherOutputStream cos = new CipherOutputStream(out, cipher);
        byte[] buffer = new byte[1024];
        int r;
        while ((r = is.read(buffer)) >= 0) {
            cos.write(buffer, 0, r);
        }
        cos.close();
        out.close();

    }

    /**
     * 进行加密并保存目标文件destFile中
     */
    public static void encryptDes(InputStream is, File destFile, String strKey) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, getDesKey(strKey));

        OutputStream out = new FileOutputStream(destFile);
        CipherInputStream cis = new CipherInputStream(is, cipher);
        byte[] buffer = new byte[1024];
        int r;
        while ((r = cis.read(buffer)) > 0) {
            out.write(buffer, 0, r);
        }
        cis.close();
        out.close();
    }

    /**
     * 采用DES算法解密
     */
    public static void decryptDes(InputStream is, File dest, String strKey) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, getDesKey(strKey));

        OutputStream out = new FileOutputStream(dest);
        CipherOutputStream cos = new CipherOutputStream(out, cipher);
        byte[] buffer = new byte[1024];
        int r;
        while ((r = is.read(buffer)) >= 0) {
            cos.write(buffer, 0, r);
        }
        cos.close();
        out.close();

    }

    /**
     * 根据参数生成KEY
     */

    private static Key getDesKey(String strKey) {
        try {
            KeyGenerator generator = KeyGenerator.getInstance("DES");
            generator.init(new SecureRandom(strKey.getBytes()));
            Key key = generator.generateKey();
            generator = null;
            return key;
        } catch (Exception e) {
            throw new RuntimeException("Error initializing SqlMap class. Cause: " + e);
        }
    }

    private static Key getAesKey(String strKey) {
        try {
            KeyGenerator generator = KeyGenerator.getInstance("AES");
            generator.init(new SecureRandom(strKey.getBytes()));
            Key key = generator.generateKey();
            generator = null;
            return key;
        } catch (Exception e) {
            throw new RuntimeException("Error initializing SqlMap class. Cause: " + e);
        }
    }
    /**
     * 根据slatKey获取公匙，传入的slatKey作为SecureRandom的随机种子
     * 若使用new SecureRandom()创建公匙，则需要记录下私匙，解密时使用
     */
    private static byte[] getPublicKey(String slatKey) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(slatKey.getBytes());
        keyPairGenerator.initialize(1024, random);//or 2048
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return keyPair.getPublic().getEncoded();
    }

    /**
     * 根据slatKey获取私匙，传入的slatKey作为SecureRandom的随机种子
     */
    private static byte[] getPrivateKey(String slatKey) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(slatKey.getBytes());
        keyPairGenerator.initialize(1024, random);// or 2048
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return keyPair.getPrivate().getEncoded();
    }
}
