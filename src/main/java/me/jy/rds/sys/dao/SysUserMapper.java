package me.jy.rds.sys.dao;

import java.util.List;

import me.jy.rds.sys.domain.SysUser;
import me.jy.rds.sys.domain.SysUserExample;
import org.apache.ibatis.annotations.Param;


/**
 * @Description: 用户,数据库表为： sys_user<br/>
 * @Autor: Created by JinKun on 2016-12-30.
 */
public interface SysUserMapper {
    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    List<SysUser> selectPageByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}