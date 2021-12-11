package com.aiden.kpcon.mapper;

import com.aiden.kpcon.model.KpconInviteInfo;

import java.util.List;

public interface KpconInviteInfoDao {
    int deleteByPrimaryKey(String iid);

    int insert(KpconInviteInfo record);

    int insertSelective(KpconInviteInfo record);

    KpconInviteInfo selectByPrimaryKey(String iid,String sportEvent);

    int updateByPrimaryKeySelective(KpconInviteInfo record);

    int updateByPrimaryKey(KpconInviteInfo record);

    List<KpconInviteInfo> selectAllBySportEvent(String sportEvent);

    List<KpconInviteInfo> queryInvitationInfo(KpconInviteInfo inviteInfo);

    List<KpconInviteInfo> getIndiInvitationInfo(String uid);
}