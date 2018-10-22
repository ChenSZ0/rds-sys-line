package me.jy.rds.overtime.dao;


import me.jy.rds.overtime.model.Overtime;
import me.jy.rds.overtime.model.OvertimeExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OvertimeMapper {
    int countByExample(OvertimeExample example);

    int deleteByExample(OvertimeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Overtime record);

    int insertSelective(Overtime record);

    List<Overtime> selectByExample(OvertimeExample example);

    Overtime selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Overtime record, @Param("example") OvertimeExample example);

    int updateByExample(@Param("record") Overtime record, @Param("example") OvertimeExample example);

    int updateByPrimaryKeySelective(Overtime record);

    int updateByPrimaryKey(Overtime record);

    List<Overtime> getMissPrintData(@Param("startDate") Date startDate,@Param("endDate") Date endDate);

    List<Overtime> getTrialPrintData(@Param("startDate")Date startDate,@Param("endDate") Date endDate);
}