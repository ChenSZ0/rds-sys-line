package me.jy.rds.overtime.web;

import me.jy.rds.common.base.BaseResult;
import me.jy.rds.config.JsonDateValueProcessor;
import me.jy.rds.overtime.dto.OverTimeDTO;
import me.jy.rds.overtime.model.Overtime;
import me.jy.rds.overtime.service.OverTimeServie;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Timestamp;
import java.util.Date;

/**
 * @author Cshuzhuo
 * @date 2018/10/16 17:03
 */
@Controller
@RequestMapping("/overtime")
public class OverTimeController {

    @Autowired
    private OverTimeServie overTimeServie;

    @RequestMapping(value = "to/{ui}", method = RequestMethod.GET)
    public String ui(@PathVariable("ui") String ui) {
        return "overtime/overtime-" + ui;
    }

    @RequestMapping(value = "/toMonth/{flag}", method = RequestMethod.GET)
    public String toMonth(@PathVariable("flag") String flag,Model model) {
        model.addAttribute("flag",flag);
        return "overtime/overtime-month";

    }

    @RequestMapping(value = "/getOverTime/{userId}",method = RequestMethod.GET)
    @ResponseBody
    public Object getOverTime(@PathVariable Long userId){
        return overTimeServie.getOverTime(userId);
    }

    @RequestMapping(value = "/saveData",method = RequestMethod.POST)
    @ResponseBody
    public Object saveData(OverTimeDTO dto){
        return overTimeServie.saveData(dto);
    }

    @RequestMapping(value = "/printPage",method = RequestMethod.GET)
    public String saveData(int flag, Date startDate,Date endDate,Model model){
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        model.addAttribute("startDate",startDate);
        model.addAttribute("endDate",endDate);
        if (flag==1){
          //误餐补助
          BaseResult missPrintData = overTimeServie.getMissPrintData(startDate, endDate);
          String[] dateFormats = new String[] {"yyyy-MM-dd HH:mm:ss"};
          JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
          model.addAttribute("data", JSONArray.fromObject(missPrintData.getData(),jsonConfig).toString());
          return "overtime/overtime-missPrint";
      }else if(flag==2){
          //审批
          BaseResult trialPrintData = overTimeServie.getTrialPrintData(startDate, endDate);
          model.addAttribute("data",JSONArray .fromObject(trialPrintData.getData(),jsonConfig).toString());
          return "overtime/overtime-trialPrint";
      }
        return "";
    }

/*    public static void main(String[] args) {
        *//*String[] dateFormats = new String[] {"yyyy-MM-dd HH:mm:ss"};
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));*//*
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        Overtime overtime = new Overtime();
        overtime.setDate(new Date());
        System.out.println(JSONArray.fromObject(overtime,jsonConfig).toString());
    }*/
}
