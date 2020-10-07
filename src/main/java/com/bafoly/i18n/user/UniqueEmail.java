package com.bafoly.i18n.user;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = UniqueEmailValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueEmail {

  String message() default "{com.bafoly.constraints.UniqueEmail.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
  
}
