package com.upms.rpc.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.upms.dao.mapper.*;
import com.upms.dao.model.*;
import com.upms.rpc.api.UpmsApiService;

@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class UpmsApiServiceImpl implements UpmsApiService {

	@Autowired
	private SysAccountRoleMapper	sysAccountRoleMapper;
	@Autowired
	private SysMenuMapper			sysMenuMapper;
	@Autowired
	private SysPermissionMapper		sysPermissionMapper;
	@Autowired
	private SysRoleMapper			sysRoleMapper;
	@Autowired
	private SysRolePermissionMapper	sysRolePermissionMapper;



	@Override
	public List<SysRole> selectRolesByAccountId(String accountId) {
		List<SysRole> roles;
		SysAccountRoleExample sysAccountRoleExample = new SysAccountRoleExample();
		sysAccountRoleExample.createCriteria().andAccountIdEqualTo(accountId);
		List<SysAccountRoleKey> sysAccountRoleKeys = sysAccountRoleMapper.selectByExample(sysAccountRoleExample);
		SysRoleExample roleExample = new SysRoleExample();
		List<String> roleIds = sysAccountRoleKeys.stream().map(SysAccountRoleKey::getRoleId)
				.collect(Collectors.toList());
		roleExample.createCriteria().andIdIn(roleIds);
		if (roleIds.size() == 0) {
			throw new AuthenticationException("role permission deny");
		}
		roles = sysRoleMapper.selectByExample(roleExample);
		return roles;
	}



	@Override
	public List<SysPermission> selectPermissionByRoleIds(List<String> roleIds) {
		List<SysPermission> permissions;
		SysRolePermissionExample rolePermissionExample = new SysRolePermissionExample();
		rolePermissionExample.createCriteria().andRoleIdIn(roleIds);
		List<SysRolePermissionKey> sysRolePermissionKeys = sysRolePermissionMapper
				.selectByExample(rolePermissionExample);
		List<String> permissionsIds = sysRolePermissionKeys.stream().map(SysRolePermissionKey::getPermissionId)
				.collect(Collectors.toList());
		SysPermissionExample sysPermissionExample = new SysPermissionExample();
		sysPermissionExample.createCriteria().andIdIn(permissionsIds);
		permissions = sysPermissionMapper.selectByExample(sysPermissionExample);
		return permissions;
	}



	@Override
	public List<SysMenu> selectMenuByRoleIds(List<String> roleIds) {
		List<SysMenu> menus;
		SysRolePermissionExample rolePermissionExample = new SysRolePermissionExample();
		rolePermissionExample.createCriteria().andRoleIdIn(roleIds);
		List<SysRolePermissionKey> sysRolePermissionKeys = sysRolePermissionMapper
				.selectByExample(rolePermissionExample);
		List<String> permissionsIds = sysRolePermissionKeys.stream().map(SysRolePermissionKey::getPermissionId)
				.collect(Collectors.toList());
		SysMenuExample menuExample = new SysMenuExample();
		menuExample.setOrderByClause("MENU_LEVEL, SEQUENCE asc");
		menuExample.createCriteria().andPermissionIn(permissionsIds);
		menus = sysMenuMapper.selectByExample(menuExample);
		return menus;
	}
}
