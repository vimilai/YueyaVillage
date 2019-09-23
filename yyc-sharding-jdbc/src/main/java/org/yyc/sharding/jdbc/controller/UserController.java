package org.yyc.sharding.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yyc.sharding.jdbc.entity.TUser;
import org.yyc.sharding.jdbc.entity.User;
import org.yyc.sharding.jdbc.service.TUserService;
import org.yyc.sharding.jdbc.service.UserService;

/**
 * @Auther: Tinko
 * @Date: 2018/12/19 16:36
 * @Description:
 */
@Service
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TUserService tUserService;
    

    //测试
    @RequestMapping(value="update1")
    public String updateTransactional(@RequestParam(value = "id") Long id,
                                      @RequestParam(value = "user_id") Long user_id,
                                      @RequestParam(value = "order_id") Long order_id,
                                      @RequestParam(value = "nickName") String nickName,
                                      @RequestParam(value = "passWord") String passWord,
                                      @RequestParam(value = "userName") String userName
    ) {
        User user2 = new User();
        user2.setId(id);
        user2.setUser_id(user_id);
        user2.setOrder_id(order_id);
        user2.setNickName(nickName);
        user2.setPassWord(passWord);
        user2.setUserName(userName);
        userService.insert(user2);
      
        return "success";
    }
    @RequestMapping(value="select")
    public List<User> slect(){
    	return userService.selectList();
    }
    
}