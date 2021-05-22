package com.seeing.controller;

import com.seeing.common.ServerResponse;
import com.seeing.service.ITheMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/map")
public class TheMapController {

    @Autowired
    ITheMapService iTheMapService;

    @ResponseBody
    @RequestMapping(value = "/insert" , method = RequestMethod.POST)
    public  ServerResponse insert (double longitude , double latitude , int userId , String message){
        return iTheMapService.insertTheMap(longitude, latitude, userId, message);
    }

    @ResponseBody
    @RequestMapping(value = "/delete" , method = RequestMethod.POST)
    public ServerResponse delete(double longitude , double latitude){
        return iTheMapService.deleteTheMap(longitude, latitude);
    }

    @ResponseBody
    @RequestMapping(value = "/selectAll" , method = RequestMethod.POST)
    public ServerResponse selectAll(){
        return iTheMapService.selectAll();
    }




}
