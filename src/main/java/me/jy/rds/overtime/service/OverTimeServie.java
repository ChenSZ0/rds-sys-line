package me.jy.rds.overtime.service;

import me.jy.rds.common.base.BaseResult;
import me.jy.rds.overtime.dto.OverTimeDTO;

import java.util.Date;

/**
 * @author Cshuzhuo
 * @date 2018/10/16 17:06
 */
public interface OverTimeServie {

    BaseResult getOverTime(Long userId);

    BaseResult saveData(OverTimeDTO dto);

    BaseResult getMissPrintData(Date startDate,Date endDate);

    BaseResult getTrialPrintData(Date startDate,Date endDate);
}
