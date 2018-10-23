package me.jy.rds.overtime.service.impl;

import me.jy.rds.canteentime.dao.CanteentimeMapper;
import me.jy.rds.canteentime.model.Canteentime;
import me.jy.rds.canteentime.model.CanteentimeExample;
import me.jy.rds.common.base.BaseResult;
import me.jy.rds.org.dao.OrgUserMapper;
import me.jy.rds.otherTime.dao.OtherTimeMapper;
import me.jy.rds.otherTime.model.OtherTime;
import me.jy.rds.otherTime.model.OtherTimeExample;
import me.jy.rds.outtime.dao.OuttimeMapper;
import me.jy.rds.outtime.model.Outtime;
import me.jy.rds.outtime.model.OuttimeExample;
import me.jy.rds.overtime.dao.OvertimeMapper;
import me.jy.rds.overtime.dto.OverTimeDTO;
import me.jy.rds.overtime.model.Overtime;
import me.jy.rds.overtime.model.OvertimeExample;
import me.jy.rds.overtime.service.OverTimeServie;
import me.jy.rds.vacationtime.model.Vacationtime;
import me.jy.rds.vacationtime.model.VacationtimeExample;
import me.jy.rds.vacationtime.dao.VacationtimeMapper;
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
    private VacationtimeMapper vacationtimeMapper;
    @Autowired
    private me.jy.rds.otherTime.dao.OtherTimeMapper otherTimeMapper;
    @Autowired
    private CanteentimeMapper canteentimeMapper;

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

        //---------其他
        OtherTimeExample otherTimeExample = new OtherTimeExample();
        OtherTimeExample.Criteria criteria2 = otherTimeExample.createCriteria();
        criteria2.andUserIdEqualTo(dto.getId());
        result = otherTimeMapper.countByExample(otherTimeExample);
        if(result>0)
            otherTimeMapper.deleteByExample(otherTimeExample);

        List<String> otherTimeList = dto.getOtherTime();
        OtherTime otherTime = new OtherTime();
        otherTime.setUserId(dto.getId());
        for (int i = 0; i < otherTimeList.size(); i++) {
            otherTime.setDate(StringToDate(otherTimeList.get(i)));
            linkStr=linkStr+otherTime.getDate().getDay()+",";
            otherTimeMapper.insert(otherTime);
        }


//       加班日期
        CanteentimeExample canteentimeExample = new CanteentimeExample();
        CanteentimeExample.Criteria criteria3 = canteentimeExample.createCriteria();
        criteria3.andUserIdEqualTo(dto.getId());
        criteria3.andDateBetween(getFirstday(),getLastday());
        List<Canteentime> canteentimes = canteentimeMapper.selectByExample(canteentimeExample);
        for (int i = 0; i < canteentimes.size(); i++) {
            linkStr=linkStr+canteentimes.get(i).getDate().getDay()+",";
        }

        OvertimeExample overtimeExample = new OvertimeExample();
        OvertimeExample.Criteria overtimeExampleCriteria = overtimeExample.createCriteria();
        overtimeExampleCriteria.andUserIdEqualTo(dto.getId());
        int count = overtimeMapper.countByExample(overtimeExample);
        if(count>0)
            overtimeMapper.deleteByExample(overtimeExample);

                Overtime overtime = new Overtime();
                overtime.setUserId(dto.getId());

//              随机分配加班日期
                Calendar c = Calendar.getInstance();
                c.setTime(new Date());
                c.add(Calendar.MONTH, 0);
                int maxDate = c.getActualMaximum(Calendar.DATE);
        Random rand = new Random();
        int index;
        Set<Integer> hashSet = new HashSet<>();
        System.out.println("不能在的日期"+linkStr);
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
                    overtime.setReason("办案加班");
                    overtimeMapper.insert(overtime);
                }

//            }

//        }

        return BaseResult.ok("保存成功");
    }

    @Override
    public BaseResult getMissPrintData(Date startDate, Date endDate) {
        List<Overtime> missPrintData = overtimeMapper.getMissPrintData(startDate, endDate);
        return BaseResult.ok("获取数据成功",missPrintData);
    }

    @Override
    public BaseResult getTrialPrintData(Date startDate, Date endDate) {
        List<Overtime> trialPrintData = overtimeMapper.getTrialPrintData(startDate, endDate);
        return BaseResult.ok("获取数据成功",trialPrintData);
    }


    private Date StringToDate(String str){
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取本月第一天
     * @return
     */
    public static  Date getFirstday(){
        Calendar cale = Calendar.getInstance();
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        return cale.getTime();
    }

    /**
     * 获取本月最后一天
     * @return
     */
    public static Date getLastday(){
        Calendar cale = Calendar.getInstance();
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        return cale.getTime();
    }

   /* public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String firstday = format.format(getFirstday());
        String lastday = format.format(getLastday());
        *//*Calendar cale = null;
        cale = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String firstday, lastday;
        // 获取前月的第一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        Date ddt=cale.getTime();
        System.out.println(ddt);
        firstday = format.format(cale.getTime());
        // 获取前月的最后一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        lastday = format.format(cale.getTime());*//*
        System.out.println("本月第一天和最后一天分别是 ： " + firstday + " and " + lastday);

    }*/

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
