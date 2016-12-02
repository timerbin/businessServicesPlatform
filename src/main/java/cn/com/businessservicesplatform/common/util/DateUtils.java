package cn.com.businessservicesplatform.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static DateUtils instance = null;
	public static final String DEF_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DEF_DATE_NO_TIME_FORMAT = "yyyy-MM-dd";

    public static synchronized DateUtils getInstance() {
        if (instance == null) {
            instance = new DateUtils();
        }
        return instance;
    }

    /**
     * 这是一个构造函数
     *  
     */
    public DateUtils() {
    }
 
    /**
    *
    * 按指定格式转换日期字符串为日期对象,如果解析失败,返回null
    * @param date:日期字符串
    * @param pattern:指定的日期格式
    * @return:Date 日期
    *
    */
   public static Date parseDate(String date, String pattern) {
		if (date == null)
			return null;

		try {
			DateFormat parser = new SimpleDateFormat(pattern);
			return parser.parse(date);
		} catch (ParseException ex) {
		}

		return null;
	}
   public static String getString(Date d, String pattern) {
		String ret;
		try {
			ret = new SimpleDateFormat(pattern).format(d);
		} catch (Exception e) {
			ret = null;
		}
		return ret;
	}
     
 

   
     

    
	 
}
