package me.jy.rds.config;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Cshuzhuo
 * @date 2018/10/22 12:21
 */
public class JsonDateValueProcessor implements JsonValueProcessor {
    private String format="yyyy-MM-dd";
    /*public JsonDateValueProcessor(String format){
        this.format=format;
    }
    public JsonDateValueProcessor(){
        this.format="yyyy-MM-dd";
    }*/
    @Override
    public Object processArrayValue(Object value, JsonConfig jsonConfig) {
        return  process(value);
    }

    @Override
    public Object processObjectValue(String s, Object value, JsonConfig jsonConfig) {
        return process(value);
    }

    private Object process(Object value){
        if(value instanceof Date){
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
            return sdf.format(value);
        }
        return value == null ? "" : value.toString();
    }
}

