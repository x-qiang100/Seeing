package com.seeing.service.impl;

import com.seeing.common.ServerResponse;
import com.seeing.mapper.ContactMapper;
import com.seeing.pojo.Contact;
import com.seeing.service.IContactService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContactServiceImpl implements IContactService {

    @Resource
    private  ContactMapper contactMapper;

    @Override
    public ServerResponse selectByBlind(Integer blind) {
        try {
            List<Contact> list = contactMapper.selectByBlind(blind);
            return ServerResponse.createBySuccess("查询成功",list);
        }catch (Exception e){
            e.printStackTrace();
            return ServerResponse.createByErrorMsg("查询失败");
        }
    }

    @Override
    public ServerResponse insertContact(Integer user , String name , String phone,String relation) {
        Contact contact = new Contact();
        contact.setUser(user);
        contact.setName(name);
        contact.setPhone(phone);
        contact.setRelation(relation);
        if(  contactMapper.insertSelective(contact) > 0 ) {
            return ServerResponse.createBySuccessMsg("添加成功");
        }else {
            return ServerResponse.createByErrorMsg("添加失败");
        }
    }
}
