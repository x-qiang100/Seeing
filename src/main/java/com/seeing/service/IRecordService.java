package com.seeing.service;

import com.seeing.common.ServerResponse;

import java.util.Date;

public interface IRecordService {

    ServerResponse addHelp(Integer volunteer  , Integer blind  , String msg , Date date);


    ServerResponse getHelps(Integer volunteer );

}
