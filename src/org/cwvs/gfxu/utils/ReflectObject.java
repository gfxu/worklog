package org.cwvs.gfxu.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

public class ReflectObject {

	static Logger log = Logger.getLogger(ReflectObject.class);

	/**
	 * 将一个 Map 对象转化为一个 JavaBean
	 * 
	 * @param type
	 *            要转化的类型
	 * @param map
	 *            包含属性值的 map
	 * @return 转化出来的 JavaBean 对象
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InstantiationException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 * @throws ParseException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object convertMap(Class type, Map map)
			throws IntrospectionException, IllegalAccessException,
			InstantiationException, InvocationTargetException, ParseException {
		if (map == null) {
			return null;
		}
		BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
		Object obj = type.newInstance(); // 创建 JavaBean 对象
		Map param = filterMap(map);// 过滤表名

		// 给 JavaBean 对象的属性赋值
		PropertyDescriptor[] propertyDescriptors = beanInfo
				.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			String fieldType = descriptor.getPropertyType().getSimpleName();
			if (map.containsKey("ID")) {
				map.put("id", map.get("ID"));
			}
			if (map.containsKey("INSERT_USER")) {
				map.put("insert_user", map.get("INSERT_USER"));
			}
			if (map.containsKey("INSERT_TIME")) {
				map.put("insert_time", map.get("INSERT_TIME"));
			}
			if (map.containsKey("UPDATE_USER")) {
				map.put("update_user", map.get("UPDATE_USER"));
			}
			if (map.containsKey("UPDATE_TIME")) {
				map.put("update_time", map.get("UPDATE_TIME"));
			}

			if (param.containsKey(propertyName)) {
				// 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
				try {

					Object value = param.get(propertyName);

					Object[] args = new Object[1];

					if (fieldType.equals("Long")) {
						if (value != null) {
							value = Long.parseLong(value.toString());
						}

					} else if (fieldType.equals("Integer")) {
						if (value != null) {
							value = Integer.valueOf(value.toString());
						}
					} else if (fieldType.equals("Date")) {
						if (value != null) {
							value = DateUtil.parse(value.toString(),
									"yyyy-MM-dd HH:mm:ss.SSS");
						}
					} else if (fieldType.equals("BigDecimal")) {
						if (value != null) {
							value = new BigDecimal(value.toString());
						}
					} else if (fieldType.equals("Short")) {
						if (value != null) {
							value = Short.parseShort(value.toString());
						}
					} else if (fieldType.equals("Boolean")) {
						if (value != null) {
							value = Boolean.parseBoolean(value.toString());
						}
					}
					args[0] = value;
					descriptor.getWriteMethod().invoke(obj, args);
				} catch (Exception e) {
					// log.error(e);
				}
			}
		}
		return obj;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map filterMap(Map map) {
		Map m = new HashMap();
		if (map != null) {
			Set set = map.entrySet();
			Iterator it = set.iterator();
			while (it.hasNext()) {
				Entry entry = (Entry) it.next();
				Object key = entry.getKey();
				Object value = entry.getValue();
				if (key != null) {
					String str = key.toString();
					str = str.toLowerCase();

					if (str.indexOf(".") != -1) {
						str = str.substring(str.indexOf(".") + 1);
					}
					m.put(str, value);
				}
			}
		}

		return m;
	}

	public static Map<String, Object> convertBean(Object bean) throws Exception {
		return convertBean(bean, true);

	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, Object> convertBean(Object bean,
			boolean filterNull) throws Exception {
		
		Map<String, Object> map = PropertyUtils.describe(bean);
		Map<String, Object> newMap = new HashMap<String, Object>();
		if (map.containsKey("id")) {
			map.put("ID", map.get("id"));
		}
		Object id = map.get("ID");
		if (id == null) {
			map.remove("ID");
		}

		if (map.containsKey("id")) {
			map.put("ID", map.get("id"));
		}
		if (map.containsKey("insert_user")) {
			map.put("INSERT_USER", map.get("insert_user"));
		}
		if (map.containsKey("insert_time")) {
			map.put("INSERT_TIME", map.get("insert_time"));
		}
		if (map.containsKey("update_user")) {
			map.put("UPDATE_USER", map.get("update_user"));
		}
		if (map.containsKey("update_time")) {
			map.put("UPDATE_TIME", map.get("update_time"));
		}

		if (filterNull) {
			Iterator it = map.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				Object key = entry.getKey();
				Object value = entry.getValue();
				if (value != null) {

					newMap.put(key.toString(), value);
				}
			}

			return newMap;
		}
		return map;

	}
}
