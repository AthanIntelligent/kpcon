package com.aiden.kpcon.controller;


import com.aiden.kpcon.model.WxOpenIdToken;
import com.aiden.kpcon.model.vo.WxLoginVo;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Api("微信用户登录")
@RequestMapping("/login")
@RestController
public class LoginController {

    @PostMapping("/mini_app")
    public Object WxLogin(@RequestBody WxLoginVo loginVo) {
        Model model = new ConcurrentModel();
        //当前用户
        Subject subject = SecurityUtils.getSubject();
        WxOpenIdToken wxOpenIdToken=new WxOpenIdToken(loginVo);
        try{
            subject.login(wxOpenIdToken);
        }catch (UnknownAccountException e){
            model.addAttribute("msg","code为空");
            return "error";
        }

        return "ok";
    }
}
