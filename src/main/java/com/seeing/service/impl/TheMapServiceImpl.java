package com.seeing.service.impl;

import com.seeing.common.ServerResponse;
import com.seeing.mapper.theMapMapper;
import com.seeing.pojo.theMap;
import com.seeing.service.ITheMapService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TheMapServiceImpl implements ITheMapService {

    @Resource
    theMapMapper theMapMapper;


    @Override
    public ServerResponse insertTheMap(double longitude, double latitude, int userId, String message) {
        theMap theMap = new theMap(longitude , latitude , userId , message);
        if( theMapMapper.insert(theMap) > 0 ){
            List<theMap> list = selectAllData();
            if(list == null){
                return ServerResponse.createBySuccessMsg("添加数据成功,查询失败");
            }
            return ServerResponse.createBySuccess("添加成功",list);
        }else {
            return ServerResponse.createByErrorMsg("添加失败");
        }
    }

    @Override
    public ServerResponse deleteTheMap(double longitude , double latitude) {
        return  selectByPoint(longitude, latitude);
    }

    @Override
    public ServerResponse selectByPoint(double longitude, double latitude) {

        List<Integer> lists = theMapMapper.selectByPoint(longitude , latitude , 100);
        for ( Integer i: lists
             ) {
            if( !deleteById( i ).isSuccess() ){
                return ServerResponse.createByErrorMsg("删除失败");
            }
        }

        List<theMap> list = selectAllData();
        if(list == null){
            return ServerResponse.createByErrorMsg("删除成功，查询失败");
        }
        if(lists.size() > 0){
            return ServerResponse.createBySuccess("删除成功",list);
        }else {
            return ServerResponse.createBySuccess("未删除数据",list);
        }
    }

    public ServerResponse deleteById(int id) {

            if ( theMapMapper.deleteByPrimaryKey(id) > 0 ){
                return ServerResponse.createBySuccess();
            }else {
                return ServerResponse.createByError();
            }
    }

    @Override
    public ServerResponse selectAll() {

        try {
            List<theMap> list = theMapMapper.selectAll();
            return ServerResponse.createBySuccess("查询成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMsg("查询失败");
        }
    }

    public List<theMap> selectAllData() {

        try {
            List<theMap> list = theMapMapper.selectAll();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
