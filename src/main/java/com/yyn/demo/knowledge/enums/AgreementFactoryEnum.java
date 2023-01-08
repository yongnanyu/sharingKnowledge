package com.yyn.demo.knowledge.enums;

import com.yyn.demo.knowledge.service.IAgreementService;
import com.yyn.demo.knowledge.service.impl.AgreementNoTaxService;
import com.yyn.demo.knowledge.service.impl.AgreementTaxService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum AgreementFactoryEnum {
	TAX("1", "含税", new AgreementTaxService()),

	NO_TAX("2", "不含税", new AgreementNoTaxService())
	;

	private final String code;

	private final String desc;

	private final IAgreementService serviceImpl;


	public static IAgreementService getService(String code)  {
		AgreementFactoryEnum factoryEnum = Arrays.stream(AgreementFactoryEnum.values()).filter(t -> StringUtils.equals(t.getCode(), code)).findFirst().orElse(null);
		// 或者通过SpringContextUtils.getBean()获取
		return factoryEnum == null ? null : factoryEnum.getServiceImpl();
	}
}
