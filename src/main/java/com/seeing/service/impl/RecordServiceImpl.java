package com.seeing.service.impl;

import com.seeing.common.ServerResponse;
import com.seeing.mapper.RecordMapper;
import com.seeing.pojo.Record;
import com.seeing.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class RecordServiceImpl implements IRecordService {

    @Resource
    private RecordMapper recordMapper;

    @Override
    public ServerResponse addHelp(Integer volunteer, Integer blind, String msg , Date date) {
        Record record = new Record();
        record.setVolunteer(volunteer);
        record.setBlind(blind);
        record.setEvaluate(msg);
        record.setTime(date);
        int i = recordMapper.insertSelective( record );
        if( i > 0 ){
            return ServerResponse.createBySuccessMsg("添加成功");
        }else {
            return ServerResponse.createByErrorMsg("添加失败");
        }
    }


    @Override
    public ServerResponse getHelps(Integer volunteer) {
        try {
            List<Record> records = recordMapper.selectByVolunteer(volunteer);
            return ServerResponse.createBySuccess("查询成功", records);
        }catch (Exception e){
            e.printStackTrace();
            return ServerResponse.createByErrorMsg("查询失败");
        }
    }
}
