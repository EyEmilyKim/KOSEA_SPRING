package ui;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DAO.ItemDAO;
import model.Item;

public class MenuUI {
	private ItemDAO itemDao;
	public void setItemDao(ItemDAO itemDao) {
		this.itemDao = itemDao;
	}
	
	public void showMenu() {
		System.out.println("########################");
		System.out.println("상품관리 시스템 ver1.0");
		System.out.println("\t1.상품 목록 보기");
		System.out.println("\t2.종료");
		System.out.println();
		System.out.println("원하는 번호를 입력하고 Enter를 누르세요.");
	}
	
	private int getMaxMenuNum() { //가장 큰 메뉴번호 리턴
		return 2;
	}
	private int getMinMenuNum() { //가장 작은 메뉴번호 리턴
		return 1;
	}
	private void show() { //매뉴를 보여준다.
		showMenu();
		String input = getInputMenu(); //화면으로부터 입력을 받는다.
		if(isValidMenu(input)) { //입력한 번호가 유효한 경우, execute 메서드 호출
			execute(Integer.parseInt(input));
		}
	}
	private String getInputMenu() {
		Scanner input = new Scanner(System.in);
		return input.nextLine(); //입력한 데이터를 리턴
	}
	private boolean isValidMenu(String input) {
		if(input == null) return false;
		int num = Integer.parseInt(input);
		if(num  >= getMinMenuNum() && num <= getMaxMenuNum()) return true;
		return false;
	}
	private void execute(int menu) {
		switch(menu) {
		case 1:
			showItemList(this.itemDao.getItemList());
			System.out.println("\nEnter를 누르세요.");
			this.getInputMenu();
			break;
		case 2: 
			System.out.println("종료되었습니다. Bye~");
			System.exit(0);
			break;
		}
	}
	private void showItemList(List<Item> itemList) {
		System.out.println("==================");
		System.out.println("번호  /  이름   /  가격   /  등록일");
		for(Item item : itemList) {
//			System.out.println(item.getCode()+", "+item.getName()+", "
//								+item.getPrice()+", "+item.getReg_date());
			System.out.printf("%s, %s, %s, %s\n",
				item.getCode(),item.getName(),item.getPrice(),item.getReg_date());
		}
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans2-1.xml");
		MenuUI menu = (MenuUI)ctx.getBean("menuUi");
		while(true) {
			menu.show();
		}
	}
}
