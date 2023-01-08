package com.yyn.demo.knowledge.controller;

import com.yyn.demo.knowledge.dto.User;
import com.yyn.demo.knowledge.enums.AgreementFactoryEnum;
import com.yyn.demo.knowledge.enums.AgreementFuncEnum;
import com.yyn.demo.knowledge.enums.GenderEnum;
import com.yyn.demo.knowledge.enums.StatusEnum;
import com.yyn.demo.knowledge.service.IAgreementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("1")
//@RestController
@RequestMapping("/testy")
public class TestController {

	@ApiOperation("user")
	@GetMapping("/user")
	public void test(@RequestBody User user) {

	}

	/**
	 *
	 * 业务编码枚举
	 * 通过不同的业务含义，制定不同的编码
	 *
	 */
	@GetMapping("/test1")
	public void test1() {
		User user = new User();
		user.setStatus(StatusEnum.INVALID.getCode());
	}

	/**
	 * 属性枚举
	 * 用于和三方的属性值进行映射
	 */
	@GetMapping("/test2")
	public void test2(String outerBizCode) {
		String genderCode = GenderEnum.transferOuterBizCode(outerBizCode);
	}

	/**
	 * 业务枚举
	 * 根据不同的枚举走不同的代码分支
	 * 渠道类型
	 * 1. 为190，则获取190下的
	 */
	@GetMapping("/test3")
	public void test3() {

	}

	/**
	 * 枚举工厂
	 * 通过枚举来实现工厂模式
	 */
	@GetMapping("/test4")
	public void test4(String typeCode) {
		IAgreementService agreementService = AgreementFactoryEnum.getService(typeCode);
		if (agreementService != null) {
			agreementService.calc();
		}
	}

	/**
	 * 枚举回调
	 * 枚举中实现函数，functionInterface
	 */
	@GetMapping("/test5")
	public void test5(String code) {
		User user = new User();
		AgreementFuncEnum.updateUserStatus(code, user);
	}

	/**
	 * 策略枚举
	 */
	@GetMapping("/test6")
	public void test6() {

	}
}
