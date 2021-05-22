package com.seeing.mapper;

import com.seeing.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int selectByPhone(String phone);

    User selectLogin(@Param("phone")String phone , @Param("password")String password );

    int updateNumber(Integer id);

    int selectByIdPassword(@Param("id")Integer id , @Param("password")String password);

    List<User> selectAll();

    int updatePwdByPhone(@Param("phone")String phone , @Param("newPassword")String newPassword);

    List<User> selectVolunteer();


}