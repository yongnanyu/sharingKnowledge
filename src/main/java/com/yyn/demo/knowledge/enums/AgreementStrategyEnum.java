package com.yyn.demo.knowledge.enums;

import com.yyn.demo.knowledge.dto.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AgreementStrategyEnum {
	TAX("1", "含税") {
		@Override
		void updateUserStatus2(User user) {
			user.setStatus("1");
		}

		@Override
		void updateUserStatus(User user) {
			super.updateUserStatus(user);
		}
	},

	NO_TAX("2", "不含税") {
		@Override
		void updateUserStatus2(User user) {
			user.setStatus("2");
		}
	};

	private final String code;

	private final String desc;

	/**
	 * 默认策略
	 * 可以选择是否
	 */
	void updateUserStatus(User user) {
		user.setStatus("0");
	}

	/**
	 * 抽象方法，避免漏实现
	 */
	abstract void  updateUserStatus2(User user);
}
