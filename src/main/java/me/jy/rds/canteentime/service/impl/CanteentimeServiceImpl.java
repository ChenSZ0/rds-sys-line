package me.jy.rds.canteentime.service.impl;

import me.jy.rds.canteentime.dao.CanteentimeMapper;
import me.jy.rds.canteentime.dto.CanteentimeDto;
import me.jy.rds.canteentime.model.Canteentime;
import me.jy.rds.canteentime.model.CanteentimeExample;
import me.jy.rds.canteentime.service.CanteentimeService;
import me.jy.rds.common.base.BaseResult;
import me.jy.rds.org.dao.OrgUserMapper;
import me.jy.rds.org.model.OrgUser;
import me.jy.rds.org.model.OrgUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cshuzhuo
 * @date 2018/10/22 17:54
 */
@Service
public class CanteentimeServiceImpl implements CanteentimeService {

    @Autowired
    private CanteentimeMapper canteentimeMapper;
    @Autowired
    private OrgUserMapper orgUserMapper;


    @Override
    @Transactional
    public BaseResult saveList(List<CanteentimeDto> list) {
        Canteentime canteentime;
        OrgUserExample orgUserExample;
        OrgUserExample.Criteria criteria;
        List<OrgUser> orgUsers;
        CanteentimeDto canteentimeDto;
        String userNum;
        CanteentimeExample canteentimeExample;
        CanteentimeExample.Criteria criteria1;
        List<String> result=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            orgUserExample = new OrgUserExample();
            criteria = orgUserExample.createCriteria();
            canteentime =new Canteentime();
            canteentimeDto = list.get(i);
            userNum=canteentimeDto.getUserNum();
            criteria.andUserNumEqualTo(userNum);
            orgUsers = orgUserMapper.selectByExample(orgUserExample);
            if(orgUsers==null || orgUsers.size()==0){
                result.add("员工号："+userNum+"不存在");
                continue;
            }
            canteentimeExample = new CanteentimeExample();
            criteria1 = canteentimeExample.createCriteria();
            criteria1.andUserIdEqualTo(orgUsers.get(0).getId());
            criteria1.andDateEqualTo(canteentimeDto.getDate());
            criteria1.andFlagEqualTo(canteentimeDto.getFlag());
            int count = canteentimeMapper.countByExample(canteentimeExample);
            if (count>0){
                continue;
            }
            canteentime.setDate(canteentimeDto.getDate());
            canteentime.setUserId(orgUsers.get(0).getId());
            canteentime.setFlag(canteentimeDto.getFlag());
            canteentime.setUserName(canteentimeDto.getUserName());
            canteentimeMapper.insert(canteentime);

        }
        return BaseResult.ok("保存成功，其中失败数据",result);
    }
}
