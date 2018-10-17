package me.jinkun.rds.overtime.service;

import me.jinkun.rds.common.base.BaseResult;
import me.jinkun.rds.overtime.dto.OverTimeDTO;

/**
 * @author Cshuzhuo
 * @date 2018/10/16 17:06
 */
public interface OverTimeServie {

    BaseResult getOverTime(Long userId);

    BaseResult saveData(OverTimeDTO dto);
}
