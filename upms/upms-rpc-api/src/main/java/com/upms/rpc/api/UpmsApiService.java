package com.upms.rpc.api;

import java.util.List;
import java.util.Map;

import com.upms.dao.model.ShiroUser;
import com.upms.dao.model.SysMenu;
import com.upms.dao.model.SysPermission;
import com.upms.dao.model.SysRole;

public interface UpmsApiService {

	public ShiroUser login(String username, String password);



	public void setShiroUserExtraInfo(ShiroUser shiroUser);
}
