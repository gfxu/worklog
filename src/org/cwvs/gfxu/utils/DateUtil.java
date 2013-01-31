package org.cwvs.gfxu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author fei.jin
 * 
 */
public final class DateUtil extends org.apache.commons.lang.time.DateUtils {

	/**
	 * 默认的日期格式化样式
	 */
	public static final String DAY_PATTERN = "yyyy-MM-dd";
	/**
	 * 默认的时间格式化样式
	 */
	public static final String TIME_PATTERN = "HH:mm:ss";

	/**
	 * 默认的格式化工具
	 */
	private static SimpleDateFormat formatTool = new SimpleDateFormat();

	/**
	 * 将Date格式化成符合默认格式的字符串
	 * 
	 * @param date
	 * @return 返回样例:2012-03-29 14:32:23
	 */
	public static String format(Date date) {
		formatTool.applyPattern(DAY_PATTERN + " " + TIME_PATTERN);
		return formatTool.format(date);
	}

	/**
	 * 将Date格式化成符合默认日期格式的字符串
	 * 
	 * @param date
	 * @return 返回样例:2012-03-29
	 */
	public static String formatDate(Date date) {
		formatTool.applyPattern(DAY_PATTERN);
		return formatTool.format(date);
	}

	/**
	 * 将Date格式化成符合默认时间格式的字符串
	 * 
	 * @param date
	 * @return 返回样例:14:32:23
	 */
	public static String formatTime(Date date) {
		formatTool.applyPattern(TIME_PATTERN);
		return formatTool.format(date);
	}

	/**
	 * 按照pattern格式格式化Date
	 * 
	 * @param date
	 * @param pattern
	 *            样例: yyyy/MM/dd
	 * @return 返回样例:2012/03/29
	 */
	public static String format(Date date, String pattern) {
		formatTool.applyPattern(pattern);
		return formatTool.format(date);
	}

	/**
	 * 将符合默认格式的字符串转换成Date
	 * 
	 * @param dateValue
	 *            样例:2012-03-29 14:32:23
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String dateValue) throws ParseException {
		formatTool.applyPattern(DAY_PATTERN + " " + TIME_PATTERN);
		return formatTool.parse(dateValue);
	}

	/**
	 * 将符合默认格式的日期字符串转换成Date
	 * 
	 * @param dateValue
	 *            样例:2012-03-29
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String dateValue) throws ParseException {
		formatTool.applyPattern(DAY_PATTERN);
		return formatTool.parse(dateValue);
	}

	/**
	 * 将符合pattern格式的dateValue转换成Date
	 * 
	 * @param dateValue
	 *            样例:2012/03/29
	 * @param pattern
	 *            样例:yyyy/MM/dd
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String dateValue, String pattern)
			throws ParseException {
		formatTool.applyPattern(pattern);
		return formatTool.parse(dateValue);
	}

	public static void main(String[] args) throws ParseException {

		// Date d = parse("2012-03-29 14:32:23");
		//
		// System.out.println(d);
		//
		// d = parse("2012-03-2", DAY_PATTERN);
		// System.out.println(d);
		//
		// d =parseDate("2012-03-29");
		// System.out.println(d);
		//
		// d=new Date();
		//
		// System.out.println(format(d));
		//
		// System.out.println(formatDate(d));
		//
		// System.out.println(formatTime(d));;
		//
		// System.out.println(format(d, "yyyy哈哈MM乐乐dd"));

	}
}
