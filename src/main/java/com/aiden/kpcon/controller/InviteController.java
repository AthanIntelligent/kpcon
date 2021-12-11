package com.aiden.kpcon.controller;

import com.aiden.kpcon.common.constant.Result;
import com.aiden.kpcon.common.constant.ResultCode;
import com.aiden.kpcon.model.KpconInviteInfo;
import com.aiden.kpcon.service.InvitationService;
import com.aiden.kpcon.utils.UUIDUtil;
import io.swagger.annotations.ApiModel;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
@ApiModel(value = "发布邀请接口")
@Log4j
public class InviteController {

    static final Logger logger = Logger.getLogger(InviteController.class);

    @Autowired
    InvitationService invitationService;

    @PostMapping("/publishInvitationInfo")
    public Result publishInvitationInfo(@RequestBody KpconInviteInfo inviteInfo){
        logger.info("发布邀请信息");
        Subject subject = SecurityUtils.getSubject();
        inviteInfo.setIid(UUIDUtil.getUUID());
        invitationService.insertSelective(inviteInfo);
        return new Result(null, ResultCode.SUCCESS.getCode());
    }

    @GetMapping("/listInvitationInfo")
    public Result listInvitationInfo(String sportEvent){
        logger.info("查询所有邀约信息");
        List<KpconInviteInfo> infoList = invitationService.selectAllBySportEvent(sportEvent);
        return new Result(null,ResultCode.SUCCESS.getCode(),infoList);
    }

    @PostMapping("/getInvitationInfo")
    public Result getInvitationInfo(@RequestBody KpconInviteInfo inviteInfo){
        logger.info("获取邀约详情信息");
        KpconInviteInfo info = invitationService.selectByIdAndSportEvent(inviteInfo.getIid(),inviteInfo.getSportEvent());
        return new Result(null,ResultCode.SUCCESS.getCode(),info);
    }

    @PostMapping("/queryInvitationInfo")
    public Result queryInvitationInfo(@RequestBody KpconInviteInfo inviteInfo){
        logger.info("根据不同的条件进行查询，获取更多");
        List<KpconInviteInfo> inviteInfos = invitationService.queryInvitationInfo(inviteInfo);
        return new Result(null,ResultCode.SUCCESS.getCode(),inviteInfos);
    }

    @GetMapping("/getIndiInvitationInfo/{uid}")
    public Result getIndiInvitationInfo(@PathVariable("uid") String uid){
        List<KpconInviteInfo> inviteInfos = invitationService.getIndiInvitationInfo(uid);
        return new Result(null,ResultCode.SUCCESS.getCode(),inviteInfos);
    }



}
