package com.demo.encrypt;

import com.demo.interceptor.MyInterceptor;
import com.demo.util.FileEDUtil;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.kit.PathKit;
import com.jfinal.upload.UploadFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;


/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: https://jfinal.com/club
 * <p>
 * EncryptController
 */
//拦截器start
@Before(MyInterceptor.class)
//拦截器end
@Path(value = "/", viewPath = "/encrypt")
public class EncryptController extends Controller {
    public void index() {
        render("rsa.html");
    }

    public void des() {
        render("des.html");
    }

    public void aes() {
        render("aes.html");
    }

    public void enrsa() {
        // 保存文件
        List<UploadFile> files = getFiles();
        String key = getPara("key");
        for (UploadFile file : files) {
            File uploadFile = file.getFile();
            System.out.print("执行RSA加密");
            try {
                InputStream in = new FileInputStream(uploadFile);
                File destFile = new File(PathKit.getWebRootPath() + "/upload/" + "encrypt_" + uploadFile.getName());
                FileEDUtil.encryptRsa(in, destFile, key);
                renderFile(destFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void endes() {
        // 保存文件
        List<UploadFile> files = getFiles();
        String key = getPara("key");
        for (UploadFile file : files) {
            File uploadFile = file.getFile();
            try {
                InputStream in = new FileInputStream(uploadFile);
                File destFile = new File(PathKit.getWebRootPath() + "/upload/" + "encrypt_" + uploadFile.getName());
                FileEDUtil.encryptDes(in, destFile, key);
                renderFile(destFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void enaes() {
        // 保存文件
        List<UploadFile> files = getFiles();
        String key = getPara("key");
        for (UploadFile file : files) {
            File uploadFile = file.getFile();
            try {
                InputStream in = new FileInputStream(uploadFile);
                File destFile = new File(PathKit.getWebRootPath() + "/upload/" + "encrypt_" + uploadFile.getName());
                FileEDUtil.encryptAes(in, destFile, key);
                renderFile(destFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }




}



