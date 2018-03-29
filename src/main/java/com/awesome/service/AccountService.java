package com.awesome.service;

import com.awesome.mapper.*;
import com.awesome.model.ShiroUser;
import com.awesome.model.SysAccount;
import com.awesome.model.SysAccountExample;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountService {
	@Autowired
	private SysAccountMapper		sysAccountMapper;
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



	public ShiroUser login(String username, String password) {
        SysAccountExample exp = new SysAccountExample();
        exp.createCriteria().andLoginNameEqualTo(username);
        List<SysAccount> accounts= sysAccountMapper.selectByExample(exp);
        if (accounts.size() > 0) {
            SysAccount account = accounts.get(0);
        } else {
            throw new UnknownAccountException("username not correct")
        }
		return null;
	}



	public void setShiroUserExtraInfo(ShiroUser shiroUser) {

	}



	public Map<String, Object> getUser() {
		return null;
	}
}
