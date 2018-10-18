package me.jy.rds.vacationtime.dao;

import java.util.List;
import me.jy.rds.vacationtime.model.Vacationtime;
import me.jy.rds.vacationtime.model.VacationtimeExample;
import org.apache.ibatis.annotations.Param;

public interface VacationtimeMapper {
    int countByExample(VacationtimeExample example);

    int deleteByExample(VacationtimeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Vacationtime record);

    int insertSelective(Vacationtime record);

    List<Vacationtime> selectByExample(VacationtimeExample example);

    Vacationtime selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Vacationtime record, @Param("example") VacationtimeExample example);

    int updateByExample(@Param("record") Vacationtime record, @Param("example") VacationtimeExample example);

    int updateByPrimaryKeySelective(Vacationtime record);

    int updateByPrimaryKey(Vacationtime record);
}