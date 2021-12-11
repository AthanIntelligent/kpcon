package com.aiden.kpcon.model;

import java.io.Serializable;
import lombok.Data;

/**
 * role
 * @author 
 */
@Data
public class RoleAuth implements Serializable {
    private String roleId;

    /**
     * 角色是否生效
     */
    private Byte roleAva;

    /**
     * 角色描述
     */
    private String roleDes;

    /**
     * 角色名
     */
    private String roleName;

    private static final long serialVersionUID = 1L;
}