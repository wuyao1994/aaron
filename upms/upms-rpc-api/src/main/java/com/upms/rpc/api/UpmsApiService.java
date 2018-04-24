package com.upms.rpc.api;

import java.util.List;

import com.upms.dao.model.SysMenu;
import com.upms.dao.model.SysPermission;
import com.upms.dao.model.SysRole;

public interface UpmsApiService {
	public List<SysRole> selectRolesByAccountId(String accountId);



	public List<SysPermission> selectPermissionByRoleIds(List<String> roleIds);



	public List<SysMenu> selectMenuByRoleIds(List<String> roleIds);
}
