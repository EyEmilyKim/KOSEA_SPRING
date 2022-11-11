package controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ItemDAO;
import model.Item;

@Controller
public class ItemController {
	@Autowired
	private ItemDAO itemDao;
	
	//ModelAttribute생성을 따로 안하고  create()->mav.addObject(new Item()); 코드로 대체
//	@ModelAttribute
//	public Item setUp() {
//		return new Item();
//	}
	
	@RequestMapping(value="/item/delete.html")
	public ModelAndView delete(Integer itemId) {
		this.itemDao.delete(itemId); //DB에서 삭제
		return index(); //목록 출력
	}
	
	@RequestMapping(value="item/confirm.html")
	public ModelAndView confirm(Integer itemId) {
		ModelAndView mav = new ModelAndView("delete"); //뷰 설정
		Item item = this.itemDao.findById(itemId); //상품 검색
		mav.addObject("item", item);
		mav.addObject("imageName", item.getPictureUrl());
		return mav;
	}
	
	@RequestMapping(value="item/create.html")
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView("add");
		mav.addObject(new Item());
		return mav;
	}
	
	@RequestMapping(value="item/register.html")
	public ModelAndView register(Item item, HttpServletRequest request) throws Exception{
		ServletContext ctx = request.getSession().getServletContext();
		String realPath = ctx.getRealPath("/upload");
		String encType = "UTF-8";
		int maxSize = 5 * 1024 * 1024; //최대 업로드 크기 5메가
		MultipartRequest multipart = 
				new MultipartRequest(request, realPath, maxSize, encType, new DefaultFileRenamePolicy());
		String fileName = multipart.getFilesystemName("pictureUrl"); //파일이 들어 있는 파라미터
		System.out.println("업로드 위치:"+realPath);
		item.setPictureUrl(fileName); //파일 이름 설정
		Integer itemId = Integer.parseInt(multipart.getParameter("itemId"));
		item.setItemId(itemId); //상품 번호 설정
		item.setItemName(multipart.getParameter("itemName"));
		Integer price = Integer.parseInt(multipart.getParameter("price"));
		item.setPrice(price); //상품 가격 설정
		item.setDescription(multipart.getParameter("description"));
		this.itemDao.create(item); //DB에 삽입
		//return index(); //삽입 후 다시 목록 출력...하려했는데 이건 URL이 안바뀌니까
		return new ModelAndView("redirect:/item/index.html"); //이렇게 바꿔서 띄워줘야 함!
	}
	
	@RequestMapping(value="/item/update.html")
	public ModelAndView update(Item item, HttpServletRequest req) throws Exception {
		ServletContext ctx = req.getSession().getServletContext();
		String realPath = ctx.getRealPath("/upload"); //업로드 폴더 절대경로
		String encType = "UTF-8";
		int maxSize = 5 * 1024 * 1024; //최대 5메가
		MultipartRequest multipart = new MultipartRequest(req, realPath, maxSize, encType, new DefaultFileRenamePolicy());
		String fileName = multipart.getFilesystemName("pictureUrl");
		if(fileName != null) { //이미지를 바꾸는 경우
			item.setPictureUrl(fileName);
		}else { //이미지를 바꾸지 않은 경우
			item.setPictureUrl(multipart.getParameter("pictureUrl"));
		} 
		Integer itemId = Integer.parseInt(multipart.getParameter("itemId"));
		item.setItemId(itemId);
		item.setItemName(multipart.getParameter("itemName"));
		Integer price = Integer.parseInt(multipart.getParameter("price"));
		item.setPrice(price); 
		item.setDescription(multipart.getParameter("description"));
		this.itemDao.update(item); //DB에서 update 실행
		return new ModelAndView("redirect:/item/index.html");
	}
	
	@RequestMapping(value="/item/search.html")
	public ModelAndView search(String itemName) {
		if(itemName == null || itemName.equals("")) {
			return new ModelAndView("redirect:item/index.html");
		} //이름이 입력되지 않거나 파라미터가 없는 경우
		List<Item> itemList = this.itemDao.findByName(itemName);
		if(itemList == null || itemList.isEmpty()) {
			return new ModelAndView("redirect:/item/index.html");
		} //검색결과가 없는 경우
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("itemList", itemList);
		return mav;
	}
	
	@RequestMapping(value="/item/edit.html")
	public ModelAndView edit(Integer itemId) {
		ModelAndView mav = new ModelAndView("update"); //생성자를 통한 뷰이름 주입
		Item item = this.itemDao.findById(itemId);
		mav.addObject("item", item);
		return mav;
	}
	
	@RequestMapping(value="/item/index.html")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index"); //생성자를 통한 뷰이름 주입
		//mav.setViewName("index"); //setter를 통한 뷰이름 주입
		List<Item> itemList = this.itemDao.findAll();
		mav.addObject("itemList", itemList); //index.jsp로 전달
		return mav;
	}
	
	
}
