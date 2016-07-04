package com.sea.swallow.common;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @ClassName: StringUtils
 * @Description: 字符串工具类
 * @author hy
 * @date 2016年6月30日 下午20:15:58
 */
public class StringUtils {

	private static final String DEFAULT_CHARSET = "UTF-8";

	/**
	 * @Description: 转换为字节数组
	 * @param str
	 * @return
	 */
	public static byte[] getBytes(String str) {
		return getBytes(str, DEFAULT_CHARSET);
	}

	/**
	 * @Description: 转换为字节数组
	 * @param str
	 * @param charset
	 *            字符集
	 * @return
	 */
	public static byte[] getBytes(String str, String charset) {
		try {
			return str.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
		}
		return null;
	}

	/**
	 * @Description: 转换为字节数组
	 * @param bytes
	 * @return
	 */
	public static String toString(byte[] bytes) {
		return toString(bytes, DEFAULT_CHARSET);
	}

	/**
	 * @Description: 转换为字节数组
	 * @param bytes
	 * @param charset
	 *            字符集
	 * @return
	 */
	public static String toString(byte[] bytes, String charset) {
		try {
			return new String(bytes, charset);
		} catch (UnsupportedEncodingException e) {
		}
		return null;
	}

	/**
	 * @Description: 是否是数字
	 * @param value
	 *            字符串
	 * @return
	 */
	public static boolean isNumber(String value) {
		if (value == null || value.length() == 0) {
			return false;
		}
		;
		return value.matches("^[-]?\\d+$");

	}

	/**
	 * @Description: 是否是小数
	 * @param str
	 * @return
	 */
	public static boolean isDouble(String str) {
		if (str != null && str.length() > 0) {
			return str.toString().matches("^[-]?\\d+(\\.[\\d]+)?$");
		}
		return false;
	}

	/**
	 * @Description: 是否是邮箱
	 * @param value
	 * @return
	 */
	public static boolean isEmail(String value) {
		if (value == null || value.length() == 0) {
			return false;
		}
		;
		String regEx = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(value.toLowerCase());
		return m.find();
	}

	/**
	 * @Description: 转换为double类型
	 * @param value
	 *            待转换的字符串
	 * @param defaultVal
	 *            转换失败后的默认返回值
	 * @return
	 */
	public static double parseDouble(String value, double defaultVal) {
		try {
			return Double.parseDouble(value);
		} catch (NumberFormatException e) {
			return defaultVal;
		}
	}

	/**
	 * @Description: 转换为float类型
	 * @param value
	 *            待转换的字符串
	 * @param defaultVal
	 *            转换失败后的默认返回值
	 * @return
	 */
	public static float parseFloat(String value, float defaultVal) {
		try {
			return Float.parseFloat(value);
		} catch (NumberFormatException e) {
			return defaultVal;
		}
	}

	/**
	 * @Description: 转换为long类型
	 * @param value
	 *            待转换的字符串
	 * @param defaultVal
	 *            转换失败后的默认返回值
	 * @return
	 */
	public static long parseLong(String value, long defaultVal) {
		try {
			return Long.parseLong(value);
		} catch (NumberFormatException e) {
			return defaultVal;
		}
	}

	/**
	 * @Description: 转换为int类型
	 * @param value
	 *            待转换的字符串
	 * @param defaultVal
	 *            转换失败后的默认返回值
	 * @return
	 */
	public static int parseInteger(String value, int defaultVal) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return defaultVal;
		}
	}

	/**
	 * @Description: 是否空值
	 * @param src
	 * @return
	 */
	public static boolean isEmpty(String src) {
		return src == null || src.length() == 0 || src.trim().length() == 0;
	}

	/**
	 * @Description: 拼接字符串
	 * @param array
	 * @param split
	 * @return
	 */
	public static String join(String[] array, char split) {
		if (array==null||array.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (i > 0) {
				sb.append(split);
			}
			sb.append(array[i]);
		}
		return sb.toString();
	}
	/**
	 * @Description: 判断对象中的值是否为空
	 * @param object
	 * @return
	 */
	public static boolean isClassEmpty(Object object)  throws Exception{
		Field[] field = object.getClass().getDeclaredFields(); 
		for (int j = 0; j < field.length; j++) {  
            // 获取属性的名字  
            String name = field[j].getName();  
            // 将属性的首字符大写，方便构造get，set方法  
            name = name.substring(0, 1).toUpperCase() + name.substring(1);  
            // 如果type是类类型，则前面包含"class "，后面跟类名   
            Method m = object.getClass().getMethod("get" + name);  
            // 调用getter方法获取属性值  
            String value = (String) m.invoke(object);  
            if (isEmpty(value)) {  
            	return false;
            } 
        }  
		  return true;
	}

	/**
	 * @Description: String数组去重
	 * @param old
	 * @return String[] string数组
	 */
	public static String[] arrayRepeat(String[] old) {
		Set<String> set = new TreeSet<String>();
		set.addAll(Arrays.asList(old));
		return set.toArray(new String[0]);
	}

	/**
	 * 判断是否包含中文汉字
	 * 
	 * @param strName
	 * @return
	 */
	public static boolean isChineseHave(String strName) {
		char[] ch = strName.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (isChinese(c)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 根据Unicode编码完美的判断中文汉字和符号
	 * 
	 * @param c
	 * @return boolean
	 */
	private static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
			return true;
		}
		return false;
	}
	
	 
}
