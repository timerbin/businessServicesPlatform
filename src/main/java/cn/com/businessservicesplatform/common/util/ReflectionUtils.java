package cn.com.businessservicesplatform.common.util;


import org.apache.log4j.Logger;

import java.lang.reflect.*;

 
public class ReflectionUtils {
	/** 日志记录对象 **/
	private static final Logger log = Logger.getLogger(ReflectionUtils.class);

	private static Object operate(Object obj, String fieldName,Object fieldVal, String type) {
		Object ret = null;
		try {
			// 获得对象类型
			Class<? extends Object> classType = obj.getClass();
			// 获得对象的所有属性
			Field fields[] = classType.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				if (field.getName().equals(fieldName)) {
					// 获得和属性对应的getXXX()方法的名字
					String firstLetter = fieldName.substring(0, 1).toUpperCase(); 
					if ("set".equals(type)) {
						// 获得和属性对应的getXXX()方法
						String setMethodName = "set" + firstLetter + fieldName.substring(1); 
						// 调用原对象的getXXX()方法
						Method setMethod = classType.getMethod(setMethodName,new Class[] { field.getType() }); 
						ret = setMethod.invoke(obj, new Object[] { fieldVal });
					}
					if ("get".equals(type)) {
						// 获得和属性对应的setXXX()方法的名字
						String getMethodName = "get" + firstLetter + fieldName.substring(1); 
						Method getMethod = classType.getMethod(getMethodName,new Class[] {});
						ret = getMethod.invoke(obj, new Object[] {});
					}
					return ret;
				}
			}
		} catch (Exception e) {
			log.error("Reflect Error:" + fieldName, e);
		}
		return ret;
	}

	public static Object getVal(Object obj, String fieldName) {
		return operate(obj, fieldName, null, "get");
	}

	public static void setVal(Object obj, String fieldName, Object fieldVal) {
		operate(obj, fieldName, fieldVal, "set");
	}

	private static Method getDeclaredMethod(Object object, String methodName,Class<?>[] parameterTypes) {
		for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				// superClass.getMethod(methodName, parameterTypes);
				return superClass.getDeclaredMethod(methodName, parameterTypes);
			} catch (NoSuchMethodException e) {
				// Method 不在当前类定义, 继续向上转型
			}
		}

		return null;
	}

	private static void makeAccessible(Field field) {
		if (!Modifier.isPublic(field.getModifiers())) {
			field.setAccessible(true);
		}
	}
	private static Field getDeclaredField(Object object, String filedName) {
		for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				return superClass.getDeclaredField(filedName);
			} catch (NoSuchFieldException e) {
				// Field 不在当前类定义, 继续向上转型
			}
		}
		return null;
	}

	public static Object invokeMethod(Object object, String methodName,Class<?>[] parameterTypes, Object[] parameters) {
		Method method = getDeclaredMethod(object, methodName, parameterTypes);

		if (method == null) {
			throw new IllegalArgumentException("Could not find method ["+ methodName + "] on target [" + object + "]");
		}

		method.setAccessible(true);

		try {
			return method.invoke(object, parameters);
		} catch (Exception ex) {
			handleReflectionException(ex);
		}
		throw new IllegalStateException("Should never get here");
	}

	public static void setFieldValue(Object object, String fieldName,Object value) {
		Field field = getDeclaredField(object, fieldName);

		if (field == null)
			throw new IllegalArgumentException("Could not find field ["
					+ fieldName + "] on target [" + object + "]");

		makeAccessible(field);

		try {
			field.set(object, value);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	public static Object getFieldValue(Object object, String fieldName) {
		Field field = getDeclaredField(object, fieldName);
		if (field == null)
			throw new IllegalArgumentException("Could not find field ["
					+ fieldName + "] on target [" + object + "]");

		makeAccessible(field);

		Object result = null;
		try {
			result = field.get(object);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return result;
	}
	public static void handleReflectionException(Exception ex) {
		if (ex instanceof NoSuchMethodException) {
			throw new IllegalStateException("Method not found: " + ex.getMessage());
		}
		if (ex instanceof IllegalAccessException) {
			throw new IllegalStateException("Could not access method: " + ex.getMessage());
		}
		if (ex instanceof InvocationTargetException) {
			handleInvocationTargetException((InvocationTargetException) ex);
		}
		if (ex instanceof RuntimeException) {
			throw (RuntimeException) ex;
		}
		throw new UndeclaredThrowableException(ex);
	}
	
	public static void handleInvocationTargetException(InvocationTargetException ex) {
		rethrowRuntimeException(ex.getTargetException());
	}
	public static void rethrowRuntimeException(Throwable ex) {
		if (ex instanceof RuntimeException) {
			throw (RuntimeException) ex;
		}
		if (ex instanceof Error) {
			throw (Error) ex;
		}
		throw new UndeclaredThrowableException(ex);
	}

}
