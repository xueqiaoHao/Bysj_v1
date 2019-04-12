package com.hao.employment.common.util;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/*@author haoxueqiao
  @date 2019/3/19 11:43*/
public class DateUtil {

    /*此方法实现将字符串型转为date日期型
    * 满足的场景为在页面中传入的应该为日期类型的字符串封装为日期类型的对象
    * */
    public static Date convertStringToDate(String dateStr) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=sdf.parse(dateStr);

//        java.sql.Date sqlDate=new java.sql.Date(date.getTime());

        return date;
    }
        /*获取当前时间并转化为字符串形式*/
        public static String getCurrentTimeByString(){
            Date t = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return df.format(t);
        }
    public static void main(String[] args) throws ParseException {
//        Date date1=new Date();
//        String dateStr=date1.toString();
//        Date date=convertStringToDate(dateStr);
//        System.out.println(date);
//        Date t = new Date();
//
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(getCurrentTimeByString());

    }
}
