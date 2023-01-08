package com.yyn.demo.knowledge.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 业务枚举
 */
@AllArgsConstructor
@Getter
public enum StatusEnum {
	VALID("1", "生效"),
	INVALID("2", "失效")
	;

	private final String code;

	private final String desc;
}
