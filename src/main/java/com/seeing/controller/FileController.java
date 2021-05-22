package com.seeing.controller;

import com.seeing.common.ServerResponse;
import com.seeing.utils.HttpFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 停用
 */
@RequestMapping("/file")
@Controller
public class FileController {


    /***
     * 文件传输，接受大文件
     *
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/file")
    public ServerResponse getURL(@RequestParam(value = "image_file", required = false) MultipartFile file ,int id) {
        HttpFile httpFile = new HttpFile();
        return ServerResponse.createBySuccess( httpFile.downloadFile( file) );
    }


    /***
     * 接受大文件
     *
     * @param imageName
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/download/{imageName}")
    public void getPic(@PathVariable String imageName , HttpServletResponse response) {
        HttpFile httpFileDownload = new HttpFile();
        httpFileDownload.getFile(response , imageName);
    }

}
