package com.seeing;

import com.aliyuncs.exceptions.ClientException;
import com.seeing.mapper.RecordMapper;
import com.seeing.mapper.UserMapper;
import com.seeing.mapper.theMapMapper;
import com.seeing.pojo.User;
import com.seeing.utils.PhoneCodeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    UserMapper userMapper;

    @Resource
    RecordMapper recordMapper;

    @Resource
    theMapMapper theMapMapper;


//    @Resource
//    ContactMapper contactMapper;


/*
    @Test
    void TestDatetime(){
        Record record = new Record();
        record.setBlind(1);
        record.setVolunteer(2);
        record.setEvaluate("你好你好");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date date = simpleDateFormat.parse("2020-11-24 22:00:00");
            record.setTime(date);
        }catch (Exception e){
            e.getMessage();
        }
        int i = recordMapper.insertSelective(record);
        System.out.println("i = " + i);
    }

    @Test
    void selectRecord(){
        System.out.println();
        System.out.println();
        System.out.println();
            Record record = recordMapper.selectByPrimaryKey(4);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("record = " + record.getId());
        System.out.println("simpleDateFormat.format(record.getTime()) = " + simpleDateFormat.format(record.getTime()));
        System.out.println("record.getEvaluate() = " + record.getEvaluate());
        System.out.println("record.getBlind() = " + record.getBlind());
        System.out.println("record.getVolunteer() = " + record.getVolunteer());
    }
*/

//    @Test
   void TestUsers(){
        List<User> list = userMapper.selectAll();
        for (User u: list
             ) {
            System.out.println("u.getId() ) = " + u.getId() );
            System.out.println("u.getName() = " + u.getName());
            System.out.println("u.getPhone() = " + u.getPhone());
            System.out.println("u.getPassword() = " + u.getPassword());

            System.out.println("u.getType() = " + u.getType());
            System.out.println("u.getGender() = " + u.getGender());

            System.out.println("u.getMsg() = " + u.getMsg());
            System.out.println("u.getPicture() = " + u.getPicture());
            System.out.println("u.getNumber() = " + u.getNumber());
            System.out.println("u.getEmail() = " + u.getEmail());
            System.out.println("u.getAddress() = " + u.getAddress());

            System.out.println("-------------\n\n\n");
        }
    }

//    @Test
    void TestGenerateMapper(){
        User user = new User();
        user.setId(1);
        user.setPassword("123");
        int i = userMapper.updateByPrimaryKeySelective(user);
        System.out.println("i = " + i);
    }

//    @Test
    void Token(){

        String token = UUID.randomUUID()+"";
        System.out.println("token = " + token);
    }

//    @Test
//    void TestContact(){
//        List<Contact> list = contactMapper.selectByBlind(2);
//        for (Contact c:list
//             ) {
//            System.out.println("c.getName() = " + c.getName());
//        }
//
//
//   }



    @Test
    void TestFile(){

//       String s = this.getClass().getClassLoader().getResource("/").getPath();

        System.out.println("TEST");

    }
    @Test
    void TestTheMap(){

    List<Integer> list = theMapMapper.selectByPoint(123.1234567,23.1234567,100);

        System.out.println("-------------- Test Start --------------");
        for (int i:list
             ) {
            System.out.print(i+" ");
        }
        System.out.println("-------------- Test End --------------");

    }

    @Test
    void phone() throws ClientException {
        PhoneCodeUtil.sendSms("");
    }


}
