package me.jy.rds.canteentime.service;

import me.jy.rds.canteentime.dto.CanteentimeDto;
import me.jy.rds.common.base.BaseResult;


import java.util.List;

/**
 * @author Cshuzhuo
 * @date 2018/10/22 17:54
 */

public interface CanteentimeService {

    BaseResult saveList(List<CanteentimeDto> list);

}
