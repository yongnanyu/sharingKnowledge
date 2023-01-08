
package com.yyn.demo.knowledge.annotation;

import com.yyn.demo.knowledge.enums.DefaultEnum;
import com.yyn.demo.knowledge.enums.NameValueEnum;

import java.lang.annotation.*;

/**
 * @author Administrator
 */
@Target(value = {ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface ApiModelEnumProperty {
	String value() default "";

	String[] values() default {};

	Class<? extends Enum<? extends NameValueEnum<?, ?>>> enumClass() default DefaultEnum.class;

	boolean required() default false;

	String description() default "";
}
