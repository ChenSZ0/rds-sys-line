package me.jinkun.rds.overtime.service.impl;

import me.jinkun.rds.common.base.BaseResult;
import me.jinkun.rds.org.dao.OrgUserMapper;
import me.jinkun.rds.outtime.dao.OuttimeMapper;
import me.jinkun.rds.outtime.model.Outtime;
import me.jinkun.rds.outtime.model.OuttimeExample;
import me.jinkun.rds.overtime.dao.OvertimeMapper;
import me.jinkun.rds.overtime.dto.OverTimeDTO;
import me.jinkun.rds.overtime.model.Overtime;
import me.jinkun.rds.overtime.model.OvertimeExample;
import me.jinkun.rds.overtime.service.OverTimeServie;
import me.jinkun.rds.vacationtime.model.Vacationtime;
import me.jinkun.rds.vacationtime.model.VacationtimeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Cshuzhuo
 * @Date 2018/10/16 17:07
 */
@Service
public class OverTimeImpl implements OverTimeServie {

    @Autowired
    private OvertimeMapper overtimeMapper;
    @Autowired
    private OrgUserMapper orgUserMapper;
    @Autowired
    private OuttimeMapper outtimeMapper;
    @Autowired
    private me.jinkun.rds.vacationtime.dao.VacationtimeMapper vacationtimeMapper;

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

    @Override
    @Transactional
    public BaseResult saveData(OverTimeDTO dto) {

        String linkStr="";
        //---------出差

        OuttimeExample outtimeExample = new OuttimeExample();
        OuttimeExample.Criteria criteria = outtimeExample.createCriteria();
        criteria.andUserIdEqualTo(dto.getId());
        int result = outtimeMapper.countByExample(outtimeExample);
        if(result>0)
        outtimeMapper.deleteByExample(outtimeExample);

        Outtime outtime = new Outtime();
        outtime.setCreateTime(new Date());
        outtime.setUserId(dto.getId());
        List<String> outTime = dto.getOutTime();
        for (int i = 0; i < outTime.size(); i++) {
            outtime.setDate(StringToDate(outTime.get(i)));
            linkStr=linkStr+outtime.getDate().getDay()+",";
            outtimeMapper.insert(outtime);
        }
//---------休假
        VacationtimeExample vacationtimeExample = new VacationtimeExample();
        VacationtimeExample.Criteria criteria1 = vacationtimeExample.createCriteria();
        criteria1.andUserIdEqualTo(dto.getId());
        result = vacationtimeMapper.countByExample(vacationtimeExample);
        if(result>0)
            vacationtimeMapper.deleteByExample(vacationtimeExample);

        List<String> vacationTime = dto.getVacationTime();
        Vacationtime vacationtime = new Vacationtime();
        vacationtime.setCreateTime(new Date());
        vacationtime.setUserId(dto.getId());
        for (int i = 0; i < vacationTime.size(); i++) {
            vacationtime.setDate(StringToDate(vacationTime.get(i)));
            linkStr=linkStr+vacationtime.getDate().getDay()+",";
            vacationtimeMapper.insert(vacationtime);
        }

//       加班日期
        OvertimeExample overtimeExample = new OvertimeExample();
        OvertimeExample.Criteria overtimeExampleCriteria = overtimeExample.createCriteria();
        overtimeExampleCriteria.andUserIdEqualTo(dto.getId());
        int count = overtimeMapper.countByExample(overtimeExample);
        if(count>0)
            overtimeMapper.deleteByExample(overtimeExample);

                Overtime overtime = new Overtime();
                overtime.setUserId(dto.getId());
//          随机分配加班日期
                Calendar c = Calendar.getInstance();
                c.setTime(new Date());
                c.add(Calendar.MONTH, 0);
                int maxDate = c.getActualMaximum(Calendar.DATE);
        Random rand = new Random();
        int index;
        Set<Integer> hashSet = new HashSet<>();
        while (true){
            index=rand.nextInt(maxDate)+1;
            if(!linkStr.contains(String.valueOf(index)))
                hashSet.add(index);

            if(hashSet.size()==dto.getCount()){
                break;
            }
        }


                for (Integer value : hashSet) {
                    c.set(Calendar.DAY_OF_MONTH,value);
                    overtime.setDate(c.getTime());
                    if (value%2==0){
                        overtime.setFlag(true);
                    }else{
                        overtime.setFlag(false);
                    }
                    overtimeMapper.insert(overtime);
                }

//            }

//        }

        return BaseResult.ok("保存成功");
    }

    private Date StringToDate(String str){
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) {
//        Calendar c = Calendar.getInstance();
//        c.setTime(new Date());
//        c.add(Calendar.MONTH, 0);
//        int   maxDate   =   c.getActualMaximum(Calendar.DATE);
//        for (int i = 1; i <= maxDate; i++) {
//            c.set(Calendar.DAY_OF_MONTH,i);//设置为1号,当前日期既为本月第一天
//            String first = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
//            System.out.println("===============first:"+first);
//        }
//
//    }
}
