package com.seeing.service.impl;

import com.seeing.common.ServerResponse;
import com.seeing.mapper.labelsMapper;
import com.seeing.pojo.labels;
import com.seeing.service.ILabelsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class LabelsServiceImpl implements ILabelsService {

    @Resource
    labelsMapper labelsMapper;

    @Override
    public ServerResponse selectByLabel(Long label) {

        labels labels;
        labels  = labelsMapper.selectByPrimaryKey(label);
        if (labels == null){
            return ServerResponse.createByErrorMsg("查询失败");
        }
        Map map = new HashMap<String , String>();
        map.put("english",labels.getEnglish() );
        map.put("chinese",labels.getChinese() );

        return ServerResponse.createBySuccess("查询成功",map);

    }


}
