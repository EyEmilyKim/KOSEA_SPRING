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
		return null;
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
