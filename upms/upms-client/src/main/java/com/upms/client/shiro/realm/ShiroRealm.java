package com.upms.client.shiro.realm;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.common.util.PasswordUtils;
import com.upms.dao.model.*;
import com.upms.rpc.api.SysAccountService;
import com.upms.rpc.api.UpmsApiService;

public class ShiroRealm extends AuthorizingRealm {
	@Autowired
	private SysAccountService	mSysAccountService;
	@Autowired
	private UpmsApiService		mUpmsApiService;



	/**
	 * 授权：验证是调用
	 * 
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		ShiroUser shiroUser = (ShiroUser) principalCollection.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(shiroUser.getPermissions());
		info.addRoles(shiroUser.getRoles());
		return null;
	}



	/**
	 * 认证：登录时调用
	 * 
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
		String username = usernamePasswordToken.getUsername();
		String password = new String(usernamePasswordToken.getPassword());
		List<SysAccount> accounts = mSysAccountService.selectAccountsByUsername(username);
		if (accounts.size() > 0) {
			SysAccount account = accounts.get(0);
			String currPassword = PasswordUtils.getEncodePassWord(password, PasswordUtils.decodeHex(account.getSalt()));
			if (!account.getPassword().equals(currPassword)) {
				throw new AuthenticationException("password is  not correct");
			}
		} else {
			throw new UnknownAccountException("username is not correct");
		}
		SysAccount account = accounts.get(0);
		ShiroUser shiroUser = new ShiroUser();
		shiroUser.setAccountId(account.getId());
		shiroUser.setAdmin(account.getIsAdmin() == 1);
		shiroUser.setLoginName(account.getLoginName());
		shiroUser.setName(account.getName());
		List<SysRole> roles = mUpmsApiService.selectRolesByAccountId(account.getId());
		List<String> roleIds = roles.stream().map(SysRole::getId).collect(Collectors.toList());
		List<SysPermission> permissions = mUpmsApiService.selectPermissionByRoleIds(roleIds);
		List<SysMenu> menus = mUpmsApiService.selectMenuByRoleIds(roleIds);

		List<String> roleStr = roles.stream().map(SysRole::getName).collect(Collectors.toList());
		List<String> permissionsStr = permissions.stream().map(SysPermission::getCode).collect(Collectors.toList());

		shiroUser.setRoles(roleStr);
		shiroUser.setPermissions(permissionsStr);
		shiroUser.setMenus(menus.stream().map(menu -> {
			Menu newMenu = new Menu();
			BeanUtils.copyProperties(menu, newMenu);
			return newMenu;
		}).collect(Collectors.toList()));
		return new SimpleAuthenticationInfo(shiroUser, usernamePasswordToken.getPassword(), getName());
	}
}
