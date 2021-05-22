package com.seeing.service;

import com.seeing.common.ServerResponse;
import com.seeing.pojo.theMap;

public interface ITheMapService {

    ServerResponse insertTheMap(double longitude , double latitude , int userId , String message);

    ServerResponse deleteTheMap(double longitude , double latitude);

    ServerResponse selectByPoint(double longitude , double latitude);

    ServerResponse selectAll();



}
