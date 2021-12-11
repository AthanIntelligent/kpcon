package com.aiden.kpcon.service.Impl;

import com.aiden.kpcon.mapper.KpconInviteInfoDao;
import com.aiden.kpcon.model.KpconInviteInfo;
import com.aiden.kpcon.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvitationServiceImpl implements InvitationService {
    @Autowired
    KpconInviteInfoDao inviteInfoDao;

    @Override
    public int insertSelective(KpconInviteInfo kpconInviteInfo) {
        return inviteInfoDao.insertSelective(kpconInviteInfo);
    }

    @Override
    public List<KpconInviteInfo> selectAllBySportEvent(String sportEvent) {
        List<KpconInviteInfo> inviteInfoList = inviteInfoDao.selectAllBySportEvent(sportEvent);
        return null;
    }

    @Override
    public KpconInviteInfo selectByIdAndSportEvent(String iid, String sportEvent) {
        KpconInviteInfo info = inviteInfoDao.selectByPrimaryKey(iid, sportEvent);
        return info;
    }

    @Override
    public List<KpconInviteInfo> queryInvitationInfo(KpconInviteInfo inviteInfo) {
        List<KpconInviteInfo> inviteInfos = inviteInfoDao.queryInvitationInfo(inviteInfo);
        return inviteInfos;
    }

    @Override
    public List<KpconInviteInfo> getIndiInvitationInfo(String uid) {
        List<KpconInviteInfo> inviteInfos = inviteInfoDao.getIndiInvitationInfo(uid);
        return inviteInfos;
    }
}
