package com.yyn.demo.knowledge.enums;

public class EnumUtils {

	public static <T extends ValueEnum<V>, V> T getEnumByValue(T[] enums, V value) {
		for(T valueEnum : enums) {
			if (valueEnum.getValue().equals(value)) {
				return valueEnum;
			}
		}
		return null;
	}

	/**
	 * 根据枚举value获取枚举name
	 * @param enums  枚举values集合
	 * @param value  枚举value属性
	 * @return  枚举name
	 * @param <T> 枚举类型
	 * @param <V> value类型
	 * @param <P> name类型
	 */
	public static <T extends ValueEnum<V> & NameEnum<P>, V, P> P getNameByValue(T[] enums, V value) {
		if (value == null) {
			return null;
		}

		for (T valueEnum : enums) {
		    if (valueEnum.getValue().equals(value)) {
				return valueEnum.getName();
		    }
		}
		return null;
	}

	public static <T> NameEnum<T> getEnumByName(NameEnum<T>[] enums, T name) {
		for(NameEnum<T> nameEnum : enums) {
			if (nameEnum.getName().equals(name)) {
				return nameEnum;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		String value = EnumUtils.getNameByValue(UserEnum.values(),"1");
		System.out.println(value);

		UserEnum enumeration = EnumUtils.getEnumByValue(UserEnum.values(), "1");
		System.out.println(enumeration);
	}
}
