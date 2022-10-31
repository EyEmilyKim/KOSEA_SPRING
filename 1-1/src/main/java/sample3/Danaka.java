package sample3;

public class Danaka implements Human {
	private Item item;
	private String name;
	
	public void setItem(Item item) {
		this.item = item;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void has() {
		System.out.println("나는 "+name+" 입니다. 다음 상품을 가지고 있습니다.");
		item.showName();
	}
}
