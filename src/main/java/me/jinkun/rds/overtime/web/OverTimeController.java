package me.jinkun.rds.overtime.web;

import me.jinkun.rds.overtime.dto.OverTimeDTO;
import me.jinkun.rds.overtime.service.OverTimeServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/getOverTime/{userId}",method = RequestMethod.GET)
    @ResponseBody
    public Object getOverTime(@PathVariable Long userId){
        return overTimeServie.getOverTime(userId);
    }

    @RequestMapping(value = "/saveData",method = RequestMethod.POST)
    @ResponseBody
    public Object saveData(OverTimeDTO dto){
        System.out.println(dto);
        return overTimeServie.saveData(dto);

    }
}
