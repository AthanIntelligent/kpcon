package com.aiden.kpcon.service;

public interface WxChatService {
    public String codeToGetOpenId(String code);
    public String openidToGetUnionId(String openid);
}
