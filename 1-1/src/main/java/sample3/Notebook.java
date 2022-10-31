package sample3;

public class Notebook implements Item {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void showName() {
		System.out.println(name+" 입니다.");
	}
}
