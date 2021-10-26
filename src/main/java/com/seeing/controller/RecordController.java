package com.seeing.controller;


import com.seeing.common.ServerResponse;
import com.seeing.service.IRecordService;
import com.seeing.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/record")
public class RecordController {

    @Autowired
    IRecordService iRecordService;

    @Autowired
    IUserService  userService;


    /**
     *添加帮助记录
     *
     * @param volunteer
     * @param blind
     * @param msg
     * @param date
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public ServerResponse addHelp( Integer volunteer , Integer blind ,
        @RequestParam(required = false)String msg , @RequestParam(required = false)String date){

        Date temDate = new Date();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            temDate = simpleDateFormat.parse(date);
        }catch (Exception e){
            e.getMessage();
        }

        ServerResponse serverResponseRecord  = iRecordService.addHelp(volunteer, blind, msg, temDate);
        ServerResponse serverResponseUser= userService.addHelp(volunteer,blind);

        if(serverResponseRecord.isSuccess() && serverResponseUser.isSuccess()){
            return ServerResponse.createBySuccessMsg("添加成功");
        }else {
            return ServerResponse.createByErrorMsg("添加失败");
        }
    }


    /**
     * 返回记录列表
     *
     * @Author xq
     * @param volunteer
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/lists",method = RequestMethod.POST)
    public ServerResponse getLists(Integer volunteer){
        return iRecordService.getHelps(volunteer);
    }

}
