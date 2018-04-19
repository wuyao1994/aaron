package com.upms.rpc.service.impl;

import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.upms.dao.mapper.SysAccountMapper;
import com.upms.dao.model.SysAccount;
import com.upms.dao.model.SysAccountExample;
import com.upms.rpc.api.SysAccountService;


@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class SysAccountServiceImpl implements SysAccountService {
	@Autowired
	private SysAccountMapper sysAccountMapper;



	@Override
	public List<SysAccount> selectAccountsByUsername(String username) {
		SysAccountExample exp = new SysAccountExample();
		exp.createCriteria().andLoginNameEqualTo(username);
		List<SysAccount> accounts = sysAccountMapper.selectByExample(exp);
		return accounts;
	}
}
