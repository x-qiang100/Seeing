package com.seeing.controller;


import com.seeing.common.ServerResponse;
import com.seeing.service.ILabelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@RequestMapping("/labels")
@Controller
public class LabelsController {

    @Autowired
    ILabelsService iLabelsService;


    /***
     * 物品识别
     * 通过label码返回信息
     * 暂未使用
     *
     * @param label
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public ServerResponse select(int label){
        long l = (long)label;
        return iLabelsService.selectByLabel(l);
    }


}
