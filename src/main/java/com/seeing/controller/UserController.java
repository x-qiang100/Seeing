package com.seeing.controller;

import com.google.common.collect.Maps;
import com.seeing.common.ServerResponse;
import com.seeing.service.IFileService;
import com.seeing.service.IUserService;
import com.seeing.utils.HttpFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@RequestMapping("/user")
@Controller
public class UserController {

    IUserService iUserService;

    @Autowired
    IFileService iFileService;

    @Autowired
    public void setiUserService(IUserService iUserService) {
        this.iUserService = iUserService;
    }


    /***
     * 登录
     *
     * @param phone
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public ServerResponse Login(String phone , String password  ){
        return  iUserService.login(phone, password);
    }


    /***
     * 注册
     *
     * @param name
     * @param phone
     * @param password
     * @param type
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public ServerResponse Register(String name , String phone , String password ,int type ){
        ServerResponse serverResponse;
        try {
            serverResponse = iUserService.register(name, phone, password,type);
        }catch (Exception e){
            System.out.println("-----");
            e.printStackTrace();
            e.getMessage();
            return ServerResponse.createByErrorMsg("注册失败");
        }
        return serverResponse;
    }


    /***
     * 更新个人信息
     *
     * @param id
     * @param name
     * @param address
     * @param gender
     * @param phone
     * @param msg
     * @param email
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateInf" ,method = RequestMethod.POST)
    public ServerResponse updateInf(Integer id ,
                @RequestParam(required = false)String name,     @RequestParam(required = false)String address,
                @RequestParam(required = false)Integer gender,  @RequestParam(required = false)String phone,
                @RequestParam(required = false)String msg,      @RequestParam(required = false)String email
    ){
        return iUserService.update(id, name,phone, address, gender, msg, email);
    }


    /***
     * 更新密码
     *
     * @param id
     * @param password
     * @param newPassword
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updatePwd" , method = RequestMethod.POST)
    public ServerResponse UpdPwd(Integer id , String password ,String newPassword ){
        return iUserService.updatePwdById(id,password,newPassword);
    }


    /**
     * 发送短信验证码
     *
     * @param phone
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/forget" , method = RequestMethod.POST)
    public ServerResponse codePwd( String phone ){
        return iUserService.SmsVerification(phone);
    }


    /***
     * 验证短信验证码
     *
     * @param phone
     * @param code
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/verify" , method = RequestMethod.POST)
    public ServerResponse verify( String phone ,String code){
        return iUserService.verify(phone,code);
    }


    /***
     * 重置密码
     *
     * @param phone
     * @param newPassword
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/reset_password",method = RequestMethod.POST)
    public ServerResponse pwd(String phone , String newPassword){
        return iUserService.updatePwdByPhone(phone,newPassword);
    }


    /*
    已停用
     */
    /**
     * 头像传输
     *  暂时不用
     * @param file
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/invalidation/ftp", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse InvaUpload(@RequestParam(value = "image_file", required = false) MultipartFile file,
                                 Integer id, HttpServletRequest request) {
        if( true ){
            return ServerResponse.createByErrorMsg("已失效");
        }

        System.out.println("ftp文件传输  已停用" );
        String path = request.getSession().getServletContext().getRealPath("upload");
        System.out.println("path = " + path);
        String targetFileName = iFileService.upload(file, path);
        String url = "ftp://***"
                + targetFileName;
        if (targetFileName != null) {
            iUserService.upload(id,url);
        }
        Map fileMap = Maps.newHashMap();
        fileMap.put("uri", targetFileName);
        fileMap.put("url", url);
        return ServerResponse.createBySuccess(fileMap);
    }


    @RequestMapping(value = "/image",method = RequestMethod.POST)
    @ResponseBody
    public  ServerResponse upload(@RequestParam(value = "image_file", required = false)MultipartFile file,
                                  Integer id){
        HttpFile httpFile = new HttpFile();
        String url = httpFile.downloadFile(file);
        if(url.equals("") ){
            return ServerResponse.createByErrorMsg("存储错误");
        }
        return iUserService.upload(id,url);
    }

    /**
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




    /**
     * 登录过期
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/tokenExpire" , method = RequestMethod.POST)
    public ServerResponse Interceptor(HttpServletRequest request) {
        return  ServerResponse.createByErrorMsg("登录失效，请重新登录");
    }


    /***
     * 返回新闻
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/news" , method = RequestMethod.POST)
    public ServerResponse News(HttpServletRequest request) {

        return ServerResponse.createBySuccess("返回成功",
                "https://news-at.zhihu.com/api/4/news/latest");
    }



    /***
     * 测试
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/phone" , method = RequestMethod.POST)
    public ServerResponse phone(HttpServletRequest request) {

        return  iUserService.volunteer();

    }


    /***
     * 测试
     *
     * @param request
     * GET
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/hello" , method = RequestMethod.GET)
    public String HelloGet(HttpServletRequest request) {

        return  "<h1>hello world get<h1>";
    }
    /***
     * 测试
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/hello" , method = RequestMethod.POST)
    public String HelloPost(HttpServletRequest request) {

        return  "<h1>hello world post<h1>";
    }



}
