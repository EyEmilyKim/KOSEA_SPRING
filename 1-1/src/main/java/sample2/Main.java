package sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("sample2/beans.xml");
		MyMessage mmK = (MyMessage)ctx.getBean("MyMessageKr");
		mmK.sayHello("My.스프링");
		MyMessage mmE = (MyMessage)ctx.getBean("MyMessageEn");
		mmE.sayHello("My.스프링");
	}
}
