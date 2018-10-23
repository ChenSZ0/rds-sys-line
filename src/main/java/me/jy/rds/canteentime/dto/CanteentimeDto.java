package me.jy.rds.canteentime.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Cshuzhuo
 * @date 2018/10/23 9:10
 */

public class CanteentimeDto implements Serializable{

    private static final long serialVersionUID = -8403167277655588143L;

    @Excel(name = "员工号",orderNum = "1" ,isImportField = "true")
    private String userNum;

    @Excel(name = "姓名",orderNum = "2" ,isImportField = "true")
    private String userName;

    @Excel(name = "用餐日期",orderNum = "3" ,isImportField = "true",format = "yyyy/MM/dd")
    private Date date;

    @Excel(name = "上下午",orderNum = "4" ,isImportField = "true",replace = {"上午_0","下午_1"})
    private int flag;

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
