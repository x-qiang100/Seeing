package com.seeing.controller;

import com.seeing.common.ServerResponse;
import com.seeing.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/contact")
@Controller
public class ContactController {

    @Autowired
//    @Resource
    IContactService iContactService;


    /***
     * 返回视障者所有联系人
     *
     * @param blind
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/lists",method = RequestMethod.POST)
    public ServerResponse getLists(Integer blind){
        return iContactService.selectByBlind(blind);
    }


    /***
     * 视障者添加紧急联系人
     *
     * @param user
     * @param name
     * @param phone
     * @param relation
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ServerResponse add(Integer user , String name , String phone , String relation){
        return iContactService.insertContact(user,name,phone,relation);
    }



}
