package com.seeing.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.seeing.common.ServerResponse;
import com.seeing.utils.PhoneCodeUtil;
import com.seeing.mapper.UserMapper;
import com.seeing.pojo.User;
import com.seeing.service.IUserService;
import com.seeing.utils.PhoneCodeUtil;
import com.seeing.utils.RedisUtil;
import com.seeing.utils.TokenUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public ServerResponse login(String phone, String password) {
        if( !checkPhone(phone) ){
            return ServerResponse.createByErrorMsg("电话号码不存在");
        }

        User user ;
        try {
             user = userMapper.selectLogin(phone , password);
        }catch (Exception e){
            e.getMessage();
            return ServerResponse.createByErrorMsg("登录失败");
        }

        if(user == null){
            return ServerResponse.createByErrorMsg("密码错误");
        }else {
            return ServerResponse.createBySuccess( addToken( user.getId(),user.getPhone()) , user);
        }
    }


    @Override
    public ServerResponse register(String name, String phone, String password,Integer type) {
        if( checkPhone(phone) ){
            return ServerResponse.createByErrorMsg("电话号码已存在");
        }

        if( !checkIsEmpty(name, phone, password) ){
            return ServerResponse.createByErrorMsg("信息不完善");
        }
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setPassword(password);
        user.setType(type);
        int i = userMapper.insertSelective(user);
        if( i>0  ){
            return ServerResponse.createBySuccessMsg("注册成功");
        }else {
            return ServerResponse.createByErrorMsg("注册失败");
        }
    }


    @Override
    public  ServerResponse SmsVerification(String phone){
        if(!checkPhone(phone)){
           return ServerResponse.createByErrorMsg("手机号码不存在");
        }
        try {
            PhoneCodeUtil.sendSms(phone);
            return ServerResponse.createBySuccessMsg("短信验证发送成功");
        }catch (ClientException e){
            return ServerResponse.createByErrorMsg("短信验证码发送失败");
        }
    }


    @Override
    public ServerResponse verify(String phone, String code) {
        //待验证
        String msgCode = RedisUtil.getCode(phone);

        if(code.equals(msgCode) ){
            return ServerResponse.createBySuccessMsg("验证成功");
        }
        else {
            return ServerResponse.createByErrorMsg("验证失败");
        }
    }


    @Override
    public ServerResponse getInfoById(Integer id) {
        return null;
    }



    @Override
    public ServerResponse update(Integer id ,String name , String phone , String address, Integer gender, String msg, String email) {
        if( checkPhone(phone) ){

            User user = userMapper.selectByPrimaryKey(id);
            if(!user.getPhone().equals(phone)) {
                return ServerResponse.createByErrorMsg("电话号码已存在");
            }

        }

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);
        user.setAddress(address);
        user.setGender(gender);
        user.setMsg(msg);
        user.setEmail(email);

        int i = userMapper.updateByPrimaryKeySelective(user);
        if( i>0 ){
            User user2 = userMapper.selectByPrimaryKey(id);
            return ServerResponse.createBySuccess("修改成功",user2);
        }else {
            return ServerResponse.createByErrorMsg("修改失败");
        }
    }

    @Override
    public ServerResponse updatePwdByPhone(String phone, String newPassword) {
        if( userMapper.updatePwdByPhone(phone, newPassword) > 0 ){
            return ServerResponse.createBySuccessMsg("修改成功");
        }else {
            return ServerResponse.createByErrorMsg("修改失败");
        }
    }

    @Override
    public  ServerResponse addHelp(Integer blind , Integer volunteer ){

        int i = userMapper.updateNumber(blind);
        int j = userMapper.updateNumber(volunteer);
        if(i>1 && j>1) {
            return ServerResponse.createBySuccessMsg("添加成功");
        }else {
            return ServerResponse.createByErrorMsg("添加失败");
        }
    }

    @Override
    public ServerResponse updatePwdById(Integer id, String password, String newPassword) {
        int i = userMapper.selectByIdPassword(id,password);
        if( i== 0 ){
            return ServerResponse.createByErrorMsg("密码错误");
        }

        User user = new User();
        user.setId(id);
        user.setPassword(newPassword);
        i = userMapper.updateByPrimaryKeySelective(user);
        if(i > 0){
            return ServerResponse.createBySuccessMsg("修改成功");
        }else {
            return ServerResponse.createByErrorMsg("修改失败");
        }
    }



    @Override
    public ServerResponse upload(Integer id, String url) {
        User newUser = new User();
        newUser.setPicture( url  );
        newUser.setId(id);
        int i = userMapper.updateByPrimaryKeySelective(newUser);
        if(i > 0){
            return ServerResponse.createBySuccess(url);
        }else {
            return ServerResponse.createByErrorMsg("保存失败");
        }
    }




    public ServerResponse volunteer(){
        List<User> list = new ArrayList<>();
        list = userMapper.selectVolunteer();
        List<String> stringList = new ArrayList<>();

        for (User u :list
                ) {
            if (u.getPhone().length() == 11) {
                stringList.add(u.getPhone());
            }
        }


        Random random = new Random();
        int x = random.nextInt(list.size());
        String phone = stringList.get(x);

        return ServerResponse.createBySuccess(phone);
    }


    //存在返回true,不存在返回false
    private Boolean checkPhone(String phone){
        int count = userMapper.selectByPhone(phone);
        return count > 0;
    }


    private Boolean checkIsEmpty(String name , String phone , String password ){
        if(name.equals("") || phone.equals("") || password.equals("") ){
            return false;
        }else {
            return true;
        }
    }

    private String addToken(Integer id , String phone){
        return TokenUtil.sign(id, phone);
    }


}
