package sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("sample2/beans.xml");
		MyMessage mm = (MyMessage)ctx.getBean("MyMessageEn");
		mm.sayHello("My.스프링");
	}
}
