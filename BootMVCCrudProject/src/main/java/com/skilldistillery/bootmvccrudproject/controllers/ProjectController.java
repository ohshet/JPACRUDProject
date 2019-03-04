package com.skilldistillery.bootmvccrudproject.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.jpacruddata.dao.RedMeatDAO;
import com.skilldistillery.jpacruddata.dao.RedMeatDAOImpl;
import com.skilldistillery.jpacruddata.entities.RedMeat;

@Controller
public class ProjectController {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index() {
		return "WEB-INF/index.jsp";
	}

//	@RequestMapping(path = "search.do", method = RequestMethod.GET)
//	public ModelAndView getMeat(@RequestParam("search_by") String searchBy,
//								@RequestParam("search_string") String searchString) {
	
//	@RequestMapping(path = "search.do", method = RequestMethod.GET)
//	public ModelAndView getMeat(String searchby, String searchstring) {
//		RedMeatDAO dao = new RedMeatDAOImpl();
//		ModelAndView mv = new ModelAndView();
//		RedMeat foundMeat = dao.searchId(searchstring);
//		mv.addObject("meat", foundMeat);
//		mv.setViewName("index.jsp");
//		return mv;
//	}
	
	@RequestMapping(path = "search.do", method = RequestMethod.GET)
	public ModelAndView getMeat(String searchby, String searchstring) {
		RedMeatDAO dao = new RedMeatDAOImpl();
		ModelAndView mv = new ModelAndView();
		List<RedMeat> meatList = null;
		if(searchby.equals("ID")) {
			int parsedInt = Integer.parseInt(searchstring);
			meatList = dao.searchId(parsedInt);
		}
		else if(searchby.equals("Title")) {
			meatList = dao.searchTitle(searchstring);
		}
		else if(searchby.equals("Character")) {
			meatList = dao.searchCharacter(searchstring);
			}
		else if(searchby.equals("Text")) {
			meatList = dao.searchText(searchstring);
		}
		mv.addObject("meatlist", meatList);
		mv.setViewName("WEB-INF/index.jsp");
		return mv;
	}
	
	@RequestMapping(path = "geturl.do", method = RequestMethod.GET)
	public ModelAndView getImg(String searchresults) {
		System.err.print(searchresults);
		RedMeatDAO dao = new RedMeatDAOImpl();
		ModelAndView mv = new ModelAndView();
		List<RedMeat> meatList = null;
		meatList = dao.searchTitle(searchresults);
		String imgUrl = meatList.get(0).getImgUrl();
		System.err.print(imgUrl);
		mv.addObject("imgurl", imgUrl);
		mv.setViewName("WEB-INF/index.jsp");
		return mv;
	
	}
}
