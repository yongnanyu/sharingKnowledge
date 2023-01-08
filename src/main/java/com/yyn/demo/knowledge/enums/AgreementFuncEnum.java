package com.yyn.demo.knowledge.enums;

import com.yyn.demo.knowledge.dto.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum AgreementFuncEnum {
	TAX("1", "含税", user -> user.setStatus("1")),

	NO_TAX("2", "不含税", user -> user.setStatus("2"))
	;

	private final String code;

	private final String desc;

	private final AgreementFunction function;

	public static void updateUserStatus(String code, User user) {
		AgreementFuncEnum funcEnum = Arrays.stream(AgreementFuncEnum.values()).filter(t -> StringUtils.equals(t.getCode(), code)).findFirst().orElse(null);
		if (funcEnum != null) {
			funcEnum.getFunction().process(user);
		}
	}

	@FunctionalInterface
	public interface AgreementFunction {
		void process(User user);
	}
}
