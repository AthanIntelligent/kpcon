package com.aiden.kpcon.shiro;

import com.aiden.kpcon.model.User;
import com.aiden.kpcon.model.WxOpenIdToken;
import com.aiden.kpcon.model.vo.WxLoginVo;
import com.aiden.kpcon.service.UserService;
import com.aiden.kpcon.service.WxChatService;
import com.aiden.kpcon.utils.DateUtils;
import com.aiden.kpcon.utils.UUIDUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private WxChatService wxChatService;
    @Autowired
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权");
        return null;
    }
    //认证

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行认证");
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
        WxOpenIdToken wxOpenIdToken = (WxOpenIdToken) token;
        if(StringUtils.isEmpty(wxOpenIdToken.getPrincipal().getCode())){
            return null;
        }
        System.out.println("code:"+wxOpenIdToken.getPrincipal());
        String os = wxChatService.codeToGetOpenId(wxOpenIdToken.getPrincipal().getCode());
        JSONObject obj= JSON.parseObject(os);
        String openid = (String) obj.get("openid");
        String sessionKey = (String) obj.get("session_key");
        User user = userService.selectOneByOpenId(openid);
        if(user == null){
            User us = new User();
            us.setId(UUIDUtil.getCharAndNumr(12));
            us.setWxOpenId(openid);
            String currDate = DateUtils.getCurrDate("yyyy-MM-dd HH:mm:ss");
            us.setCreateTime(DateUtils.stringtoDate(currDate,"yyyy-MM-dd HH:mm:ss"));
            us.setWxUnionId(null);
            WxLoginVo.WxUserInfo userInfo =wxOpenIdToken.getPrincipal().getUserInfo();
            us.setWxNickname(userInfo.getNickName());
            us.setWxCity(userInfo.getCity());
            us.setWxCountry(userInfo.getCountry());
            us.setWxProvince(userInfo.getProvince());
            us.setWxHeadimgUrl(userInfo.getAvatarUrl());
            us.setWxGender(userInfo.getGender());
            us.setWxLanguage(userInfo.getLanguage());
            userService.insert(us);
        }else {
            user.setUpdateTime(DateUtils.stringtoDate(DateUtils.getCurrDate("yyyy-MM-dd HH:mm:ss"),"yyyy-MM-dd HH:mm:ss"));
            userService.update(user);
        }
        return null;
    }
}
