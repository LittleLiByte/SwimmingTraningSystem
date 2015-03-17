package com.scnu.swimmingtrainingsystem.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.scnu.swimmingtrainingsystem.R;

/**
 * ����������
 * 
 * @author Littleyte
 * 
 */
public class XUtils {

	public static String HOSTURL = "";

	/**
	 * �Ƿ��һ������
	 * 
	 * @param context
	 * @param isFirst
	 */
	@SuppressWarnings("static-access")
	public static void SaveLoginInfo(Context context, boolean isFirst) {
		SharedPreferences sp = context.getSharedPreferences(
				Constants.LOGININFO, context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putBoolean("isFirst", isFirst);
		editor.commit();
	}

	/**
	 * �����¼��Ϣ��SharedPreferences
	 * 
	 * @param context
	 * @param username
	 * @param password
	 */
	public static void SaveLoginInfo(Context context, String username,
			String password) {
		SharedPreferences sp = context.getSharedPreferences(
				Constants.LOGININFO, context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString("username", username);
		editor.putString("password", password);
		editor.commit();
	}

	public static void SaveLoginInfo(Context context, String host, String ip,
			String port) {
		SharedPreferences sp = context.getSharedPreferences(
				Constants.LOGININFO, context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString("hostInfo", host);
		editor.putString("ip", ip);
		editor.putString("port", port);
		editor.commit();
	}

	public static void saveIsThisUserFirstLogin(Context context, boolean first) {
		SharedPreferences sp = context.getSharedPreferences(
				Constants.LOGININFO, context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putBoolean(Constants.IS_THIS_USER_FIRST_LOGIN, first);
		editor.commit();
	}

	/**
	 * ��¼�Ƿ��һ�δ�Ӧ�õ��˶�ԱActivity
	 * 
	 * @param context
	 * @param isFirst
	 */
	public static void initAthletes(Context context, boolean isFirst) {
		SharedPreferences sp = context.getSharedPreferences(
				Constants.LOGININFO, context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putBoolean(Constants.FISRTOPENATHLETE, isFirst);
		editor.commit();
	}

	/**
	 * ��¼�Ƿ��һ�δ�Ӧ�õ��˶�ԱActivity
	 * 
	 * @param context
	 * @param isFirst
	 */
	public static void initPlans(Context context, boolean isFirst) {
		SharedPreferences sp = context.getSharedPreferences(
				Constants.LOGININFO, context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putBoolean(Constants.FISRTOPENPLAN, isFirst);
		editor.commit();
	}

	/**
	 * ��һ���˶�Ա�Ķ�γɼ��ۺ�ͳ��
	 * 
	 * @param list
	 * @return
	 */
	public static String scoreSum(List<String> list) {
		int minute = 0;
		int second = 0;
		int millisecond = 0;
		for (String s : list) {
			int msc = Integer.parseInt(s.substring(6));
			millisecond += msc;

			int sec = Integer.parseInt(s.substring(3, 5));
			second += sec;

			int min = Integer.parseInt(s.substring(0, 2));
			minute += min;
		}

		second += millisecond / 1000;
		millisecond = millisecond % 1000;
		minute += second / 60;
		second = second % 60;
		if (minute > 59) {
			return "����ͳ�Ƴ������㷶Χ������";
		}

		return String.format("%1$02d��%2$02d��%3$03d", minute, second,
				millisecond);
	}

	/**
	 * �Զ�����ʾToast
	 * 
	 * @param context
	 * @param mToast
	 * @param text
	 */
	public static void showToast(Context context, Toast mToast, String text) {
		if (mToast == null) {
			mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
			mToast.setGravity(Gravity.CENTER, 0, 0);
			View view = mToast.getView();
			view.setBackgroundResource(R.drawable.bg_toast);
			mToast.setView(view);
		} else {
			mToast.setText(text);
			mToast.setDuration(Toast.LENGTH_SHORT);
		}
		mToast.show();
	}

	private static long lastClickTime;

	/**
	 * ��ֹ���ٵ��ظ��������
	 * 
	 * @return
	 */
	public static boolean isFastDoubleClick() {
		long time = System.currentTimeMillis();
		long timeD = time - lastClickTime;
		if (0 < timeD && timeD < 800) {
			return true;
		}
		lastClickTime = time;
		return false;
	}

	public static String getCurrentTime(String format) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
		String currentTime = sdf.format(date);
		return currentTime;
	}

	public static String getCurrentTime() {
		return getCurrentTime("yyyy-MM-dd  HH:mm:ss");
	}
	
//	public static String toTimeString(String serviceTime) {
//		Float.parseFloat(string)
//		int totalTime=Integer.parseInt(serviceTime);
//		totalTime/
//		return null;
//		
//	}
}