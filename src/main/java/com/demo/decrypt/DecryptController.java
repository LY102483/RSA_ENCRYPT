package com.demo.decrypt;

import com.demo.util.FileEDUtil;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.kit.PathKit;
import com.jfinal.upload.UploadFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by wushange on 2022/4/1.
 */
@Path("/decrypt")
public class DecryptController extends Controller {

    public void index() {
        render("decrypt.html");
    }

    public void upload() {
        // 保存文件
        List<UploadFile> files = getFiles();
        String key = getPara("key");
        String type = getPara("etype");
        File uploadFile = files.get(0).getFile();
        System.out.print("key" + key + "  type" + type);
        switch (type) {
            case "RSA":
                System.out.print("执行RSA解密");
                try {
                    InputStream in = new FileInputStream(uploadFile);
                    File destFile = new File(PathKit.getWebRootPath() + "/upload/" + "decrypt_" + uploadFile.getName());
                    FileEDUtil.decryptRsa(in, destFile, key);
                    renderFile(destFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "DES":
                System.out.print("执行DES解密");
                try {
                    InputStream in = new FileInputStream(uploadFile);
                    File destFile = new File(PathKit.getWebRootPath() + "/upload/" + "decrypt_" + uploadFile.getName());
                    FileEDUtil.decryptDes(in, destFile, key);
                    renderFile(destFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "AES":
                System.out.print("执行AES解密");
                try {
                    InputStream in = new FileInputStream(uploadFile);
                    File destFile = new File(PathKit.getWebRootPath() + "/upload/" + "decrypt_" + uploadFile.getName());
                    FileEDUtil.decryptAes(in, destFile, key);
                    renderFile(destFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }

    }
}
