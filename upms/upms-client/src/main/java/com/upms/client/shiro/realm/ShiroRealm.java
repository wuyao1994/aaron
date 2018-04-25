package com.upms.client.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

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

		return new SimpleAuthenticationInfo(mUpmsApiService.login(username, password), usernamePasswordToken.getPassword(), getName());
	}
}
