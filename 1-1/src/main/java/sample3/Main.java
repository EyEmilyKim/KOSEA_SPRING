package sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("sample3/beans.xml");
		Human h = (Suzuki)ctx.getBean("suzuki");
		h.has();
		Human h2 = (Danaka)ctx.getBean("danaka");
		h2.has();
		Human h3 = (Gobayasi)ctx.getBean("gobayasi");
		h3.has();
	}
}
