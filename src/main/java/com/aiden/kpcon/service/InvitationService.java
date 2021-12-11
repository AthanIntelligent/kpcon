package com.aiden.kpcon.service;

import com.aiden.kpcon.model.KpconInviteInfo;

import java.util.List;

public interface InvitationService {
    int insertSelective(KpconInviteInfo kpconInviteInfo);
    //根据项目名称查询出所有未删除未结束的邀请项
    List<KpconInviteInfo> selectAllBySportEvent(String sportEvent);

    KpconInviteInfo selectByIdAndSportEvent(String iid, String sportEvent);

    List<KpconInviteInfo> queryInvitationInfo(KpconInviteInfo inviteInfo);

    List<KpconInviteInfo> getIndiInvitationInfo(String uid);
}
