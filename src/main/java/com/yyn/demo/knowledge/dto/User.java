package com.yyn.demo.knowledge.dto;

import com.yyn.demo.knowledge.annotation.ApiModelEnumProperty;
import com.yyn.demo.knowledge.enums.TypeEnum;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author Administrator
 */
@ApiModel
@Data
public class User {

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", id=" + id +
				'}';
	}

	private String name;

	@ApiModelEnumProperty(description = "类型", enumClass = TypeEnum.class)
	private TypeEnum typeEnum;

	private Long id;

	private String status;
}
