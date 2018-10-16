package me.jinkun.rds.org.dao;

import me.jinkun.rds.org.model.OrgUser;
import me.jinkun.rds.org.model.OrgUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrgUserMapper {
    int countByExample(OrgUserExample example);

    int deleteByExample(OrgUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrgUser record);

    int insertSelective(OrgUser record);

    List<OrgUser> selectByExample(OrgUserExample example);

    OrgUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrgUser record, @Param("example") OrgUserExample example);

    int updateByExample(@Param("record") OrgUser record, @Param("example") OrgUserExample example);

    int updateByPrimaryKeySelective(OrgUser record);

    int updateByPrimaryKey(OrgUser record);
}