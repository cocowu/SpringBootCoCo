package com.coco.spring.ioc;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary   // @Primary （Animal）存在多个子类时，本子类优先注入
public class Cat implements Animal {

	@Override
	public void use() {
		System.out.println("猫【" + Cat.class.getSimpleName()+"】是抓老鼠。");
	}

}
