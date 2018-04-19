package com.upms.rpc.api;

import com.upms.dao.model.SysAccount;

import java.util.List;

/**
 * SysAccountService interface
 */
public interface SysAccountService {
	/**
     * select accounts
	 * @param username
	 * @return
	 */
	public List<SysAccount> selectAccountsByUsername(String username);
}
