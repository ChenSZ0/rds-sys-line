package me.jinkun.rds.overtime.service;

import me.jinkun.rds.common.base.BaseResult;

/**
 * @author Cshuzhuo
 * @date 2018/10/16 17:06
 */
public interface OverTimeServie {

    BaseResult getOverTime(Long userId);
}
