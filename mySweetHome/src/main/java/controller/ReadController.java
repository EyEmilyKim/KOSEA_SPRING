package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.BbsDao;
import model.BBS;

@Controller
public class ReadController {
	@Autowired
	private BbsDao bbsDao;
	
	@RequestMapping(value="/read/detail.html")
	public ModelAndView detail(Integer NO) {
		BBS detail = bbsDao.getBBSDetail(NO);
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("BBS", detail);
		mav.addObject("BODY", "bbsDetail.jsp");
		return mav;
	}
	
	@RequestMapping(value="/read/read.html")
	public ModelAndView read(Integer pageNo) {
		int currentPage = 0;
		if(pageNo == null) currentPage = 1;
		else currentPage = pageNo;
		List<BBS> bbsList = bbsDao.readBBS(currentPage);
		Integer totalCount = bbsDao.getBBSCount();
		int pageCount = totalCount / 5;
		if(totalCount % 5 > 0) pageCount++;
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("bbsList", bbsList);
		mav.addObject("pageCount", pageCount);
		mav.addObject("BODY", "bbsList.jsp");
		return mav;
	}
}
