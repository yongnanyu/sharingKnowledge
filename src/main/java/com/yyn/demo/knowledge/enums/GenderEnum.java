package com.yyn.demo.knowledge.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum GenderEnum {
	MALE("M", "", "1"),

	FEMALE("F", "", "2")
	;

	private final String code;

	private final String desc;

	private final String outerBizCode;

	public static String transferOuterBizCode(String outerBizCode) {
		GenderEnum gender = Arrays.stream(GenderEnum.values()).filter(t -> StringUtils.equals(t.getOuterBizCode(), outerBizCode)).findFirst().orElse(null);
		return gender == null ? null : gender.getCode();
	}
}
