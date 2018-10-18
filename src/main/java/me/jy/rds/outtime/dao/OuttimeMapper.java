package me.jy.rds.outtime.dao;

import java.util.List;
import me.jy.rds.outtime.model.Outtime;
import me.jy.rds.outtime.model.OuttimeExample;
import org.apache.ibatis.annotations.Param;

public interface OuttimeMapper {
    int countByExample(OuttimeExample example);

    int deleteByExample(OuttimeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Outtime record);

    int insertSelective(Outtime record);

    List<Outtime> selectByExample(OuttimeExample example);

    Outtime selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Outtime record, @Param("example") OuttimeExample example);

    int updateByExample(@Param("record") Outtime record, @Param("example") OuttimeExample example);

    int updateByPrimaryKeySelective(Outtime record);

    int updateByPrimaryKey(Outtime record);
}