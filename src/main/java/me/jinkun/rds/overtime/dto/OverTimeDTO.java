package me.jinkun.rds.overtime.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author Cshuzhuo
 * @date 2018/10/17 12:23
 */
public class OverTimeDTO implements Serializable {

    private static final long serialVersionUID = 1651844981197763374L;
    private Long id;
    private Long count;
    private List<String> outTime;
    private List<String> vacationTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<String> getOutTime() {
        return outTime;
    }

    public void setOutTime(List<String> outTime) {
        this.outTime = outTime;
    }

    public List<String> getVacationTime() {
        return vacationTime;
    }

    public void setVacationTime(List<String> vacationTime) {
        this.vacationTime = vacationTime;
    }

    @Override
    public String toString() {
        return "OverTimeDTO{" +
                "id=" + id +
                ", count=" + count +
                ", outTime=" + outTime +
                ", vacationTime=" + vacationTime +
                '}';
    }
}
