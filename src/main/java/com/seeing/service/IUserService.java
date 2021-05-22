package com.seeing.service;

import com.seeing.common.ServerResponse;
import com.seeing.pojo.User;
import org.springframework.web.multipart.MultipartFile;

public interface IUserService {



    ServerResponse getInfoById(Integer id);

    ServerResponse register(String name , String phone , String password , Integer type);

    ServerResponse login(String phone , String password);

    ServerResponse update(Integer id ,String mame ,  String phone,String address , Integer gender , String msg , String email);

    ServerResponse addHelp(Integer volunteer , Integer blind );

    ServerResponse updatePwdById(Integer id , String password , String newPassword);

    ServerResponse SmsVerification(String phone);

    ServerResponse verify(String phone,String code);

    ServerResponse updatePwdByPhone(String phone , String newPassword);

    ServerResponse upload(Integer id,String url);

    ServerResponse volunteer();



 }
