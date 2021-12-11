package com.aiden.kpcon.wxChatService;

import com.aiden.kpcon.model.AccessToken;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class GetToken {

    private Logger logger = LoggerFactory.getLogger(GetToken.class);

    public AccessToken getToken(String appid,String secret) {

        AccessToken token = null;

        String url ="https://api.weixin.qq.com/cgi-bin/token"+"?grant_type=client_credential&appid=" + appid
                + "&secret=" + secret;
        String result = HttpRequest.get(url).body();
        JSONObject jsonObject = JSON.parseObject(result);
        if (jsonObject != null) {

            try {
                token = new AccessToken();
                token.setAccess_token((String) jsonObject.get("access_token"));
                if(null != jsonObject.get("expires_in")){
                    token.setExpires_in(Long.parseLong(jsonObject.get("expires_in").toString()));
                }
            } catch (Exception e) {
                token = null;
                e.printStackTrace();
                logger.error("系统出错了！");
            }
        } else {
            token = null;
            // 获取token失败
            logger.error("jsonObject为空，获取token失败");
        }
        return token;

    }

}
