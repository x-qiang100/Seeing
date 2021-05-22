package com.seeing.mapper;

import com.seeing.pojo.theMap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface theMapMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(theMap record);

    int insertSelective(theMap record);

    theMap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(theMap record);

    int updateByPrimaryKey(theMap record);

    List<theMap> selectAll();

    //查询距离distance范围所有数据
    List<Integer> selectByPoint(@Param("longitude") double longitude , @Param("latitude") double latitude , @Param("distance") int distance );

}