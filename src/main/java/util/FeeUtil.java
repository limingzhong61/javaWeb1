package util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import pojo.Fee;

public class FeeUtil {

	@SuppressWarnings("unchecked")
	public static Fee getFeeFromRequest(Map<String, String[]> map) {
//		 通过Class.forName方式
		@SuppressWarnings("rawtypes")
		Class feeClass = null;
		try {
			feeClass = Class.forName("pojo.Fee");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
//	            feeClass
		}
		Fee fee = new Fee();
		Field[] fields = feeClass.getDeclaredFields();
		for (Field field : fields) {
			String fieldName = field.getName();
			String[] parameter = map.get(fieldName);
			if (parameter == null) {
				continue;
			}
			String upperChar = fieldName.substring(0, 1).toUpperCase();
			String anotherStr = fieldName.substring(1);
			String methodName = "set" + upperChar + anotherStr;
			Method method;
			try {
				method = feeClass.getMethod(methodName, field.getType());
				method.setAccessible(true);
				Object resultValue = method.invoke(fee, parameter);
				// 这里可以编写你的业务代码
				System.out.println(fieldName + ": " + resultValue);
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;
	}

	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Class feeClass = null;
		try {
			feeClass = Class.forName("pojo.Fee");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
//	            feeClass
		}
//		Fee fee = new Fee();
		Field[] fields = feeClass.getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			Class<?> type = field.getType();
			System.out.println(name);
			System.out.println(type);
		}
	}

}
