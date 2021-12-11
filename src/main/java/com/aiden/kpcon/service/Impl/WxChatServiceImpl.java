package com.aiden.kpcon.service.Impl;

import com.aiden.kpcon.model.AccessToken;
import com.aiden.kpcon.service.WxChatService;
import com.aiden.kpcon.wxChatService.AccessTokenTask;
import com.aiden.kpcon.wxChatService.WeixinToken;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class WxChatServiceImpl implements WxChatService {
    @Value("${wx.appid}")
    private String appid;
    @Value("${wx.secret}")
    private String secret;
    @Override
    public String codeToGetOpenId(String code) {
        Map<String,String> data = new HashMap<>();
        data.put("appid",appid);
        data.put("secret",secret);
        data.put("js_code",code);
        data.put("grant_type","authorization_code");

        String response = HttpRequest.get("https://api.weixin.qq.com/sns/jscode2session").form(data).body();
        return response;
    }

    /**
     * 小程序的公众号接口
     * @param openid
     * @return
     */
    @Override
    public String openidToGetUnionId(String openid) {
        Map<String,String> uni = new HashMap<>();
        AccessToken accessToken = new AccessToken();
        System.out.println("token="+accessToken.getAccess_token());
        if(null != WeixinToken.token){
            uni.put("access_token",WeixinToken.token);
        }else {
            new AccessTokenTask().getAccessToken();
            uni.put("access_token", WeixinToken.token);
        }
        uni.put("openid",openid);
        uni.put("lang","zh_CN");
        String response = HttpRequest.get("https://api.weixin.qq.com/cgi-bin/user/info").form(uni).body();
        return response;
    }
}
