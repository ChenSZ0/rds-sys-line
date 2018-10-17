package me.jinkun.rds.overtime.service.impl;

import me.jinkun.rds.common.base.BaseResult;
import me.jinkun.rds.org.dao.OrgUserMapper;
import me.jinkun.rds.overtime.dao.OvertimeMapper;
import me.jinkun.rds.overtime.model.OvertimeExample;
import me.jinkun.rds.overtime.service.OverTimeServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cshuzhuo
 * @date 2018/10/16 17:07
 */
@Service
public class OverTimeimpl implements OverTimeServie {

    @Autowired
    private OvertimeMapper overtimeMapper;
    @Autowired
    private OrgUserMapper orgUserMapper;

    @Override
    public BaseResult getOverTime(Long userId) {
        OvertimeExample overtimeExample = new OvertimeExample();
        OvertimeExample.Criteria criteria = overtimeExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        int count = overtimeMapper.countByExample(overtimeExample);
        Map<String, Object> map = new HashMap<>();
        map.put("id",userId);
        map.put("count",count);
        map.put("name",orgUserMapper.selectByPrimaryKey(userId).getName());
        return BaseResult.ok("获取成功",map);
    }
}
