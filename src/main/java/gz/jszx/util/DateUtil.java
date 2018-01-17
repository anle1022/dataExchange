package gz.jszx.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class DateUtil {
	

	public static Date date = null;

	public static DateFormat dateFormat = null;

	public static Calendar calendar = null;

	/**
	 * ������������ʽ������
	 * 
	 * @param dateStr
	 *            String �ַ�������
	 * @param format
	 *            String ��ʽ
	 * @return Date ����
	 */
	public static Date parseDate(String dateStr, String format) {
		try {
			dateFormat = new SimpleDateFormat(format);
			String dt = dateStr.replaceAll("-", "/");
			if ((!dt.equals("")) && (dt.length() < format.length())) {
				dt += format.substring(dt.length()).replaceAll("[YyMmDdHhSs]",
						"0");
			}
			date = (Date) dateFormat.parse(dt);
		} catch (Exception e) {
		}
		return date;
	}

	/**
	 * ������������ʽ������
	 * 
	 * @param dateStr
	 *            String �ַ������ڣ�YYYY-MM-DD ��ʽ
	 * @return Date
	 */
	public static Date parseDate(String dateStr) {
		return parseDate(dateStr, "yyyy/MM/dd");
	}

	/**
	 * ������������ʽ���������
	 * 
	 * @param date
	 *            Date ����
	 * @param format
	 *            String ��ʽ
	 * @return �����ַ�������
	 */
	public static String format(Date date, String format) {
		String result = "";
		try {
			if (date != null) {
				dateFormat = new SimpleDateFormat(format);
				result = dateFormat.format(date);
			}
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * ����������
	 * 
	 * @param date
	 *            Date ����
	 * @return
	 */
	public static String format(Date date) {
		return format(date, "yyyy/MM/dd");
	}

	/**
	 * �����������������
	 * 
	 * @param date
	 *            Date ����
	 * @return �������
	 */
	public static int getYear(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * ���������������·�
	 * 
	 * @param date
	 *            Date ����
	 * @return �����·�
	 */
	public static int getMonth(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * ���������������շ�
	 * 
	 * @param date
	 *            Date ����
	 * @return �����շ�
	 */
	public static int getDay(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * ��������������Сʱ
	 * 
	 * @param date
	 *            ����
	 * @return ����Сʱ
	 */
	public static int getHour(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * �������������ط���
	 * 
	 * @param date
	 *            ����
	 * @return ���ط���
	 */
	public static int getMinute(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * ��������
	 * 
	 * @param date
	 *            Date ����
	 * @return ��������
	 */
	public static int getSecond(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.SECOND);
	}

	/**
	 * �������������غ���
	 * 
	 * @param date
	 *            ����
	 * @return ���غ���
	 */
	public static long getMillis(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}

	/**
	 * ���������������ַ�������
	 * 
	 * @param date
	 *            ����
	 * @return �����ַ������� yyyy/MM/dd ��ʽ
	 */
	public static String getDate(Date date) {
		return format(date, "yyyy/MM/dd");
	}

	/**
	 * ���������������ַ���ʱ��
	 * 
	 * @param date
	 *            Date ����
	 * @return �����ַ���ʱ�� HH:mm:ss ��ʽ
	 */
	public static String getTime(Date date) {
		return format(date, "HH:mm:ss");
	}

	/**
	 * ���������������ַ�������ʱ��
	 * 
	 * @param date
	 *            Date ����
	 * @return �����ַ�������ʱ�� yyyy/MM/dd HH:mm:ss ��ʽ
	 */
	public static String getDateTime(Date date) {
		return format(date, "yyyy/MM/dd HH:mm:ss");
	}

	/**
	 * �����������������
	 * 
	 * @param date
	 *            Date ����
	 * @param day
	 *            int ����
	 * @return ������Ӻ������
	 */
	public static Date addDate(Date date, int day) {
		calendar = Calendar.getInstance();
		long millis = getMillis(date) + ((long) day) * 24 * 3600 * 1000;
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

	/**
	 * �����������������
	 * 
	 * @param date
	 *            Date ����
	 * @param date1
	 *            Date ����
	 * @return ��������������
	 */
	public static int diffDate(Date date, Date date1) {
		return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
	}

	/**
	 * ����������ȡ��ָ���·ݵĵ�һ��
	 * 
	 * @param strdate
	 *            String �ַ�������
	 * @return String yyyy-MM-dd ��ʽ
	 */
	public static String getMonthBegin(String strdate) {
		date = parseDate(strdate);
		return format(date, "yyyy-MM") + "-01";
	}

	/**
	 * ����������ȡ�ñ��µĵ�һ��
	 * @return String yyyy-MM-01 ��ʽ
	 */
	public static String getNowMonthBegin() {
		Date date = new Date();
		return format(date, "yyyy-MM") + "-01";
	}

	/**
	 * ����������ȡ��ָ���·ݵ����һ��
	 * 
	 * @param strdate
	 *            String �ַ�������
	 * @return String �����ַ� yyyy-MM-dd��ʽ
	 */
	public static String getMonthEnd(String strdate) {
		date = parseDate(getMonthBegin(strdate));
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		return formatDate(calendar.getTime());
	}

	/**
	 * �������������õĸ�ʽ������
	 * 
	 * @param date
	 *            Date ����
	 * @return String �����ַ� yyyy-MM-dd��ʽ
	 */
	public static String formatDate(Date date) {
		return formatDateByFormat(date, "yyyy-MM-dd");
	}

	/**
	 * ������������ָ���ĸ�ʽ����ʽ������
	 * 
	 * @param date
	 *            Date ����
	 * @param format
	 *            String ��ʽ
	 * @return String �����ַ�
	 */
	public static String formatDateByFormat(Date date, String format) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				result = sdf.format(date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}


	/**
	 * ��������:�ַ�ת��Ϊʱ�� 
	 * @param sdate  ��Ҫת�����ַ� �ַ��ʽ:yyyyddmm HH:MM
	 * @return ʱ�� 
	 */
	public static Date convetDate(String sdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyddmm HH:MM");
		Date date = null;
		try {
			date = sdf.parse(sdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * ��������:��ʱ��ת��(��1970-01-01ʱ���)������
	 * @param sdate ��ʽ:(yyyy-MM-dd HH:mm:ss")
	 * @return
	 */
	public static long getSeconds(String sdate) {
		
		SimpleDateFormat sdf = null;

		if(sdate.length()>12)
		{
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}else
		{
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		}
		
		Date date1 = null;
		try {
			date1 = sdf.parse(sdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar1 = Calendar.getInstance(Locale.CHINA);
		calendar1.setTime(date1);

		Date date2 =  stringToDate("1970-01-01", "yyyy-MM-dd");
		Calendar calendar2 = Calendar.getInstance( Locale.CHINA );
		calendar2.setTime(date2);
		
		return   calendar1.getTimeInMillis()/1000L - calendar2.getTimeInMillis()/1000L  ;
	}
	
	
	/**
	 * ��������:��(��1970-01-01ʱ���)������ת��Ϊʱ��
	 * @param seconds  ����
	 * @return ��ʽ:(yyyy-MM-dd HH:mm:ss)
	 */
	public static String getDates(long seconds) {
		
		Date date1 = stringToDate("1970-01-01", "yyyy-MM-dd");
		Calendar calendar1 = Calendar.getInstance( Locale.CHINA );
		calendar1.setTime(date1);
		
		Calendar calendar3 = Calendar.getInstance( Locale.CHINA);
		calendar3.setTimeInMillis( seconds*1000L +   calendar1.getTimeInMillis()  );
	
		return   dateToString(calendar3.getTime(), "yyyy-MM-dd HH:mm:ss")  ;
	}

	/**
	 * ��������:ʱ��ת��Ϊ�ַ� 
	 * @param date  ʱ��
	 * @return ʱ���ַ� �ַ��ʽ:yyyy-MM-dd 
	 */
	public static String DateToString(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if(date == null)
		{
			date = new Date();
		}
		String dateString = formatter.format(date);
		return dateString;
	}

	/**
	 * ��������:ʱ��ת��Ϊ�ַ�
	 * @param date
	 * @return ʱ���ַ�  �ַ��ʽ:yyyy-MM-dd HH:mm:ss
	 */
	public static String DateToString2(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = "";
		try
		{
			 dateString = formatter.format(date);	
		}catch(Exception e)
		{
			return dateString;
		}
		
		return dateString;
	}

	/**
	 * ��������:ϵͳ��ǰ��ʱ��
	 * @return ʱ��
	 */
	public static Date getServerTime() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}

	/**
	 * ��������:��ʱ��ת��Ϊָ���ĸ�ʽ��
	 * 
	 * @param date  ת����ʱ��
	 * @param str   ��ʽ ע��:(24Сʱ�Ƹ�ʽ:yyyy-MM-dd HH:mm:ss)
	 * @return ʱ���ַ� 
	 */
	public static String dateToString(Date date, String str)  {
		String dates ="1900-00-00";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(str);
			dates = sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dates;
	}

	/**
	 * ��������:��ָ����ʽ���ַ�ת��Ϊdate����
	 * @param str   �ַ�
	 * @param df  ��ʽ :(24Сʱ�Ƹ�ʽ:yyyy-MM-dd HH:mm:ss)
	 * @return ʱ��
	 */
	public static Date stringToDate(String str, String df) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(df);
		try {
			calendar.setTime(sdf.parse(str));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return calendar.getTime();
	}

	/**
	 * ��������������֮���ʱ������
	 * 
	 * @param date1
	 *            ʱ��1
	 * @param date2
	 *            ʱ��1
	 * @return ����
	 */
	public static int getDateNum(Date date1, Date date2) {
		return Math
				.abs((int) ((date1.getTime() - date2.getTime()) / 1000 / 60 / 60 / 24));
	}

	/**
	 * �����ַ��ʽ����֮�������
	 * 
	 * @param sd1
	 *            ʱ��1
	 * @param sd2
	 *            ʱ��1
	 * @param df
	 *            ��ʽ
	 * @return ����
	 */
	public static int getDateNum(String sd1, String sd2, String df) {
		Date date1 = stringToDate(sd1, df);
		Date date2 = stringToDate(sd2, df);
		return getDateNum(date1, date2);
	}

	/**
	 * �����ַ��ʽ����֮���ÿ����ַ�ֵ
	 * 
	 * @param sd1
	 *            ʱ��1
	 * @param sd2
	 *            ʱ��2
	 * @param df
	 *            ��ʽ
	 * @param df2
	 *            ��ʽ
	 * @return �ַ�����
	 */
	public static String[] getDateNumStr(String sd1, String sd2, String df,
			String df2) throws Exception {
		Date date1 = stringToDate(sd1, df);
		Date date2 = stringToDate(sd2, df);
		int num = getDateNum(date1, date2) + 1;
		String[] dateStr = new String[num];
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date1);
		for (int i = 0; i < num; i++) {
			dateStr[i] = dateToString(calendar.getTime(), df2);
			calendar.add(Calendar.DAY_OF_YEAR, +1);
		}
		return dateStr;
	}
	
	
	/**
	 * �����ַ��ʽ����֮���ÿ������ڶ���
	 * @param date1 ʱ��1
	 * @param date2 ʱ��2
	 * @return ʱ��������
	 */
	public static List<?> getBetweenDate(Date date1 ,Date date2) {
		List<Date> list = new ArrayList<Date>();
		int num = getDateNum(date1, date2) + 1;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date1);
		for (int i = 0; i < num; i++) {
			list.add(calendar.getTime());
			calendar.add(Calendar.DAY_OF_YEAR, +1);
		}
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<String> getBetweenDate(String startTime,String endTime){
		Date d1 = parseDate(startTime);
		Date d2 = parseDate(endTime);
		List list = getBetweenDate(d1,d2);
		List<String> timeList = new ArrayList();
		for(int i=0;i<list.size();i++){
			Date d = (Date) list.get(i);
			String time = formatDate(d);
			System.out.println( time );
			timeList.add(  time );
			
		}
		return timeList;
	}
	
	/**
	 * ����ʣ������
	 * 
	 * @param date
	 *            ʱ��
	 * @return ����
	 */
	public static int getRsYearNum(Date date) throws Exception {
		String year = dateToString(date, "yyyy");
		Date dateLast = stringToDate(year + "-12-31", "yyyy-MM-dd");
		return getDateNum(date, dateLast);
	}

	/**
	 * ��������
	 * 
	 * @param date
	 *            ʱ��
	 * @return ����
	 */
	public static int getMonthNum(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, +1);
		Date date2 = calendar.getTime();
		return getDateNum(date, date2);
	}

	/**
	 * ����ʣ������
	 * 
	 * @param date
	 * @return
	 */
	public static int getRsMonthNum(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, +1);
		Date date2 = calendar.getTime();
		return getDateNum(date, date2) - calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * ����ʣ������
	 * 
	 * @param date
	 * @return
	 */
	public static int getRsWeekNum(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return 7 - calendar.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * �õ�ָ������n��������
	 * 
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date getAfterDate(Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, n);
		return calendar.getTime();
	}
	

	/**
	 * �õ�ָ������n�º������
	 * 
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date getAfterMonth(Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, n);
		return calendar.getTime();
	}

	/**
	 * �������ת�� 0.0 -> #0.00
	 * 
	 * @param f
	 * @return
	 */
	public static String getTwoDecimal(float f) {
		java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
		String new_DCJD = df.format(f);
		return new_DCJD;
	}
	
	
	/**
	 * �������ת�� 0.0 -> #0.000
	 * 
	 * @param f
	 * @return
	 */
	public static String getThreeDecimal(float f) {
		java.text.DecimalFormat df = new java.text.DecimalFormat("#0.000");
		String new_DCJD = df.format(f);
		return new_DCJD;
	}
	

	/**
	 * ��ȡ�������
	 * 
	 * @return �ַ����
	 */
	public static String getYear() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		String year;
		year = dateString.substring(0, 4);
		return year;
	}

	/**
	 * ��ȡ�����·�
	 * 
	 * @return �ַ��·�
	 */
	public static String getNowMonth() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		String month;
		month = dateString.substring(5, 7);
		return month;
	}

	/**
	 * ��ȡ��������
	 * @return �ַ�����
	 */
	public static String getNowDay() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		String day;
		day = dateString.substring(8, 10);
		return day;
	}
	
	
	/**
	 * ��ȡ��������
	 * 
	 * @return �ַ�����
	 */
	public static String getNowYearMonth() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	
	/**
	 * ��ȡ��������
	 * ��ʽ:(yyyy-MM-dd HH:mm:ss)
	 * @return �ַ�������
	 */
	public static String getNowDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	
	
	/**
	 * �������������ʱ���Ƿ��� ��ʼʱ���Ƿ���ڽ���ʱ�� ��Χ��
	 * @param kssj ��ʼʱ��
	 * @param jssj ����ʱ��
	 * @param time
	 * @return
	 */
	public static boolean getTimeInOrOutTime(String kssj,String jssj,String time)
	{
		boolean check = true;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Calendar calBegin = java.util.Calendar.getInstance();
		java.util.Calendar calEnd = java.util.Calendar.getInstance();
		java.util.Calendar calNow = java.util.Calendar.getInstance();
		Date beginDate = null;
		Date endDate = null;
		Date nowDate = null;
		try {
			beginDate = sdf.parse(kssj);
			endDate = sdf.parse(jssj);
			nowDate = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		calBegin.setTime(beginDate);
		calEnd.setTime(endDate);
		calNow.setTime(nowDate);
		if(calBegin.after(calNow)){
			//����ʱ����
            check = false;
		}
		if(calEnd.before(calNow)){
			//����ʱ����
			check = false;
		}
		
		return check;
	}
	
	
	/**
	 * ������������ʼʱ���Ƿ���ڽ���ʱ��
	 * @param kssj ��ʼʱ��
	 * @param jssj ����ʱ��
	 * @param time
	 * @return
	 */
	public static boolean getTime(String kssj,String jssj,String date_sdf)
	{
		boolean check = false;
		
		SimpleDateFormat sdf = new SimpleDateFormat(date_sdf);
		java.util.Calendar calBegin = java.util.Calendar.getInstance();
		java.util.Calendar calEnd = java.util.Calendar.getInstance();
		Date beginDate = null;
		Date endDate = null;
		try {
			beginDate = sdf.parse(kssj);
			endDate = sdf.parse(jssj);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		calBegin.setTime(beginDate);
		calEnd.setTime(endDate);
		
		if(calEnd.getTimeInMillis()>calBegin.getTimeInMillis())
		{
			check  = true;
		}
		
		return check;
	}
	public static void main(String[] args) {
		//Date d = new Date();
		// System.out.println(d.toString());
//		System.out.println(formatDate(d).toString());
		// System.out.println(getMonthBegin(formatDate(d).toString()));
		// System.out.println(getMonthBegin("2008/07/19"));
		// System.out.println(getMonthEnd("2008/07/19"));
		//System.out.println(addDate(d,15).toString());
		System.out.println(getAfterDate(new Date(), -1));
		//getBetweenDate("2016-11-22","2016-12-02");
	}

}
