package com.awesome.mapper;

import com.awesome.model.SysAccountRoleExample;
import com.awesome.model.SysAccountRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAccountRoleMapper {
    long countByExample(SysAccountRoleExample example);

    int deleteByExample(SysAccountRoleExample example);

    int deleteByPrimaryKey(SysAccountRoleKey key);

    int insert(SysAccountRoleKey record);

    int insertSelective(SysAccountRoleKey record);

    List<SysAccountRoleKey> selectByExample(SysAccountRoleExample example);

    int updateByExampleSelective(@Param("record") SysAccountRoleKey record, @Param("example") SysAccountRoleExample example);

    int updateByExample(@Param("record") SysAccountRoleKey record, @Param("example") SysAccountRoleExample example);
}