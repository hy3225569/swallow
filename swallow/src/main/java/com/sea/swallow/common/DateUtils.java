
package com.sea.swallow.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * @ClassName: DateUtils
 * @Description: 日期工具类
 */
public class DateUtils {

	private static String[] parsePatterns = { "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm","yyyy-MM-dd HH","yyyy-MM-dd", "yyyy-MM",
			 "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm","yyyy/MM/dd HH", "yyyy/MM/dd","yyyy/MM", "yyyy.MM.dd HH:mm:ss",
			 "yyyy.MM.dd HH:mm","yyyy.MM.dd HH","yyyy.MM.dd", "yyyy.MM" };

	private static SimpleDateFormat sdf = new SimpleDateFormat();

	/**
	 * @Description: 日期转换成字符串
	 * @param date   日期
	 * @param pattern 格式
	 * @return  日期字符串
	 */
	public static String format(Date date, String pattern) {
		sdf.applyPattern(pattern);
		return sdf.format(date);
	}
	
    /**
     * @Description: 日期转换成字符串
     * @param date   日期
     * @param pattern 模版
     * @return 日期字符串
     */
	public static String formatDate(Date date, String pattern) {
		String formatDate = null;
		if (pattern != null ) {
			formatDate = format(date, pattern);
		} else {
			formatDate = format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}
	
    /**
     * @Description: 将字符串转换成时间日期
     * @param date  日期
     * @return  时间日期字符串
     */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * @Description: 将字符串转换成日期
	 * @param str    日期字符串
	 * @param pattern 模版
	 * @return   日期
	 */
	public static Date parseDate(String str, String pattern) {
		sdf.applyPattern(pattern);
		try {
			return sdf.parse(str);
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * @Description: 使用默认模版将字符串转换成日期
	 * @param str   
	 * @return
	 */
	public static Date parseDate(String str) {
		Date data=null;
		for(String pattern :parsePatterns){
			if(pattern.length()==str.length()){
				data=parseDate(str,pattern);
				if(data!=null){
					return data;
				}
			}
		}
		return data;
	}
	
	/**
	 * @Description: 获取当前日期
	 * @return 日期字符串
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}
	
    /**
     * @Description:  获取当前日期
     * @param pattern 模版
     * @return 日期字符串
     */
	public static String getDate(String pattern) {
		return format(new Date(), pattern);
	}
	
    /**
     * @Description:  获取当前时间
     * @return 时间字符串
     */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * @Description:  获取当前时间日期
	 * @return 时间日期字符串
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}
	
    /**
     * @Description: 获取当前年份
     * @return  年份字符串
     */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
     * @Description: 获取当前月份
     * @return  月份字符串
     */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}
    /**
     * @Description: 获取当前日
     * @return  日字符串
     */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}
	
    /**
     * @Description: 获取当前周
     * @return 周字符串
     */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}

	/**
	 * @Description: 获取昨天
	 * @return
	 */
	public static Date getYesterday(){
		return getYesterday(new Date());
	}
	
	/**
	 * @Description: 获取昨天
	 * @param date
	 * @return
	 */
	public static Date getYesterday(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		return calendar.getTime();
	}
	
	/**
	 * @Description: 获取明天
	 * @return
	 */
	public static Date getTomorrow(){
		return getTomorrow(new Date());
	}
	
	/**
	 * @Description: 获取明天
	 * @return
	 */
	public static Date getTomorrow(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}
	
	/**
	 * @Description: 获取过去的时间
	 * @param date   
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (24 * 60 * 60 * 1000);
	}

	/**
	 * @Description: 获取过去的小时
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 60 * 1000);
	}

	/**
	 * @Description: 获取过去的分钟
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 1000);
	}

	/**
	 * @Description: 转换为时间（天,时:分:秒.毫秒）
	 * @param timeMillis
	 * @return
	 */
	public static String formatDateTime(long timeMillis) {
		long day = timeMillis / (24 * 60 * 60 * 1000);
		long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
		long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
		return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
	}

	/**
	 * @Description:  获取两个日期之间的天数
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}

	 
 
}
