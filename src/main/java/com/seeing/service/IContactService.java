package com.seeing.service;

import com.seeing.common.ServerResponse;

public interface IContactService {

    ServerResponse selectByBlind(Integer blind);

    ServerResponse insertContact(Integer user , String name , String phone , String relation);

}


