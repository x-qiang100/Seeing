package com.seeing.utils;

import com.seeing.common.ServerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

public class HttpFile {

    private static  final Logger logger = LoggerFactory.getLogger(HttpFile.class);
    /**
     * windows
     */
//    String filePath = System.getProperty("user.dir")+"\\picture\\";
    /**
     * linux
     *
     */
//    String filePath = System.getProperty("user.dir")+"/picture/";


    public String GetFilePath(){

        if( System.getProperties().getProperty("os.name").equals("Linux") ){
            return System.getProperty("user.dir")+"/picture/";
        }else {
            return System.getProperty("user.dir")+"\\picture\\"   ;
        }

    }

    public String downloadFile(MultipartFile file) {

        String fileName = file.getOriginalFilename();
        String filePath = GetFilePath();

        //取随机值命名，防止重复
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;

        System.out.println("fileExtensionName = " + fileExtensionName);
        System.out.println("uploadFileName = " + uploadFileName);


        InputStream in = null;
        FileOutputStream out = null;

        String SavePath = filePath+uploadFileName;
        try {


            in = file.getInputStream();
            out = new FileOutputStream(SavePath);

            int len = 0;
            byte[] buffer = new byte[1024];
            while ( (len = in.read(buffer)) != -1) {
                out.write(buffer,0,len);
            }
            return "106.14.32.152:8082/user/download/" +uploadFileName;

        }catch (Exception e){
            logger.error("下载文件异常!", e);
            return "";
        }finally {
            try {
                if( in != null ) in.close();

                if( out != null ) {
                    out.flush();
                    out.close();
                }
            }catch (Exception e){
                logger.error("流关闭异常!");
            }
        }
    }


    //客户端下载文件
    public boolean getFile(HttpServletResponse response , String fileName  ) {

        String filePath = GetFilePath();

        FileInputStream in = null;
        ServletOutputStream out = null;

        String file = filePath+fileName;
        try {
            response.setHeader("Content-Disposition", "attachment;filename="+fileName);
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);

            in = new FileInputStream(file);

            out = response.getOutputStream();

            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer,0,len);
            }

            return true;
        }catch (Exception e){
            logger.error("下载文件异常!", e);
            return false;
        }finally {
            try {
                if( in != null ) in.close();
                if( out != null ) {
                    out.flush();
                    out.close();
                }
            }catch (Exception e){
                logger.error("流关闭异常!");
            }
        }
    }

}


