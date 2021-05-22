package com.seeing.mapper;

import com.seeing.pojo.labels;

public interface labelsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(labels record);

    int insertSelective(labels record);

    labels selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(labels record);

    int updateByPrimaryKey(labels record);
}