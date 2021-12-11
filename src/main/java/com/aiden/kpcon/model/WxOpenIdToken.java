package com.aiden.kpcon.model;

import com.aiden.kpcon.model.vo.WxLoginVo;
import org.apache.shiro.authc.UsernamePasswordToken;

import java.io.Serializable;

//MyOpenIdToken
public class WxOpenIdToken extends UsernamePasswordToken implements Serializable {
    private WxLoginVo loginVo;
    /**
     *
     */
    private static final long serialVersionUID = 4812793519945855483L;
    @Override
    public WxLoginVo getPrincipal() {
        return getWxUser();
    }

    private WxLoginVo getWxUser() {
        return this.loginVo;
    }

    @Override
    public String getCredentials() {
        return "ok";
    }
    public WxOpenIdToken(WxLoginVo wxLoginVo){
        this.loginVo=wxLoginVo;
    }
}
