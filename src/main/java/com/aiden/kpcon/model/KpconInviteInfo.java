package com.aiden.kpcon.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * kpcon_invite_info
 * @author 
 */
@ApiModel(value="com.aiden.kpcon.model.KpconInviteInfo")
@Data
public class KpconInviteInfo implements Serializable {
    /**
     * 邀约id
     */
    @ApiModelProperty(value="邀约id")
    private String iid;

    /**
     * 邀请开始时间
     */
    @ApiModelProperty(value="邀请开始时间")
    private Date inviteStartTime;

    /**
     * 预期结束时间
     */
    @ApiModelProperty(value="预期结束时间")
    private Date expectEndTime;

    /**
     * 实际结束时间
     */
    @ApiModelProperty(value="实际结束时间")
    private Date actualEndTime;

    /**
     * 运动项目
     */
    @ApiModelProperty(value="运动项目")
    private String sportEvent;

    /**
     * 性别偏向
     */
    @ApiModelProperty(value="性别偏向")
    private String genderBias;

    /**
     * 年龄限制
     */
    @ApiModelProperty(value="年龄限制")
    private String agedLimit;

    /**
     * 活动场所
     */
    @ApiModelProperty(value="活动场所")
    private String activityLocation;

    /**
     * 活动地址
     */
    @ApiModelProperty(value="活动地址")
    private String activityAddress;

    /**
     * 活动开始时间
     */
    @ApiModelProperty(value="活动开始时间")
    private Date activityStartTime;

    /**
     * 活动结束时间
     */
    @ApiModelProperty(value="活动结束时间")
    private Date activityEndTime;

    /**
     * 活动时长
     */
    @ApiModelProperty(value="活动时长")
    private Integer activityTimeLong;

    /**
     * 匹配标签，使用“，”分割
     */
    @ApiModelProperty(value="匹配标签，使用“，”分割")
    private String matchLabel;

    /**
     * 图片URL，使用“，”分割
     */
    @ApiModelProperty(value="图片URL，使用“，”分割")
    private String imgUrl;

    /**
     * 首图URL
     */
    @ApiModelProperty(value="首图URL")
    private String imgFirstUrl;

    /**
     * 文案
     */
    @ApiModelProperty(value="文案")
    private String copywriting;


    /**
     * 用户id
     */
    @ApiModelProperty(value="用户id")
    private String uid;

    /**
     * 邀约类型
     */
    @ApiModelProperty(value="邀约类型")
    private String inviteType;
    /**
     * 邀约状态
     */
    @ApiModelProperty(value = "邀约状态  1.进行中 2.已暂停 3.已结束 4.已删除")
    private Integer inviteStatus;
    private static final long serialVersionUID = 1L;
}