package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CartDao;

@Service
public class Cart {
	@Autowired
	private CartDao cartDao;
	
	public CartItem getCartItem(String code){
		return cartDao.getCartItem(code);
	}
	
	private String id; //계정
	private String code; //상품번호
	private Integer num; //상품 개수
	
	private ArrayList<String> codeList = new ArrayList<String>();
	private ArrayList<Integer> numList = new ArrayList<Integer>();
	
	public void addCart(String code, Integer num) {
		//code를 codeList에 넣기 전에, 이미 codeList 에 있는지 검새
		//있으면, numList에서 상품갯수만 증가
		//없으면, codeList에 상품번호, numList에 상품갯수 추가.
		for(int cnt=0; cnt<codeList.size(); cnt++) {
			if(codeList.get(cnt).equals(code)) { //있으면 case.
				int number = numList.get(cnt);
				number = number + number; //갯수 증가
				numList.set(cnt, number);
				System.out.println("갯수만 증가");
				return; //메서드 종료
			}
		}	
		//없으면 case.
		codeList.add(code);
		numList.add(num);
		System.out.println("상품번호와 갯수 저장");
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public ArrayList<String> getCodeList() {
		return codeList;
	}
	public void setCodeList(int index, String code) {
		this.codeList.add(index, code);
	}
	public ArrayList<Integer> getNumList() {
		return numList;
	}
	public void setNumList(int index, Integer num) {
		this.codeList.add(index, code);
	}
	
	public void deleteItem(String code, String id) {
		for(int cnt = 0; cnt<codeList.size(); cnt++) {
			codeList.remove(cnt); //cnt번째 상품번호 삭제
			numList.remove(cnt); //cnt번째 상품갯수 삭제
			return; //메서드 종료
		} //상품번호가 일치하는 경우
	}
	
	public void modifyItem(String code, String id, Integer num) {
		for(int cnt=0; cnt<codeList.size(); cnt++) {
			if(codeList.get(cnt).equals(code)) {
				numList.set(cnt, num); //cnt번째 갯수를 num으로 변경
				return; //메서드 종료
			} //상품번호가 일치하는 경우, 갯수를 바꾼다.
		}
	}
	
	public void addCart(String code, Integer num) {
		//code를 codeList에 넣기 전에, 이미  codeList에 있는지 검사
		for(int cnt=0; cnt<codeList.size(); cnt++) {
			if(codeList.get(cnt).equals(code)) {
				int number = numList.get(cnt);
				number = number + num; //갯수 증가
				numList.set(cnt, number);
				System.out.println("갯수만 증가");
				return; //메서드 종료
			} //있으면 numList에서 갯수만 증가
		} //없으면
		
		
	}
}
