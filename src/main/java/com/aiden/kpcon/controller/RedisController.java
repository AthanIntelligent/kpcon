package com.aiden.kpcon.controller;

import com.aiden.kpcon.model.User;
import com.aiden.kpcon.service.UserService;
import com.aiden.kpcon.utils.RedisUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName：TestController
 * @Description：Redis控制器
 * @Author：chenyb
 * @Date：2020/8/17 12:07 上午
 * @Versiion：1.0
 */
@RestController
public class RedisController {
    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private UserService kpUserService=null;

    @RequestMapping("setAndGet")
    public String test(String k,String v){
        redisUtils.set(k,v);
        return (String) redisUtils.get(k);
    }

//    @RequestMapping("test")
//    public Object test(){
//        //step1 先从redis中取
//        String strJson=(String) redisUtils.get("listUser");
//        if (strJson==null){
//            System.out.println("从db取值");
//            // step2如果拿不到则从DB取值
//            List<User> listUser=kpUserService.listUser();
//            // step3 DB非空情况刷新redis值
//            if (listUser!=null){
//                redisUtils.set("listUser", JSON.toJSONString(listUser));
//                return listUser;
//            }
//            return null;
//        }else
//        {
//            System.out.println("从redis缓存取值");
//            return JSONObject.parseArray(strJson,User.class);
//        }
//    }
}
