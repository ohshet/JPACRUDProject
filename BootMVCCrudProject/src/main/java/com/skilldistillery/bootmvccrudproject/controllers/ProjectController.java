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

	@RequestMapping(path = "search.do", method = RequestMethod.GET)
	public ModelAndView getMeat(String searchby, String searchstring) {
		RedMeatDAO dao = new RedMeatDAOImpl();
		ModelAndView mv = new ModelAndView();
		List<RedMeat> meatList = null;
		String searchStatus = null;
		if (searchby.equals("ID")) {
			try {
				int parsedInt = Integer.parseInt(searchstring);
				meatList = dao.searchId(parsedInt);
			} catch (Exception e) {
				meatList = null;
			}
		} else if (searchby.equals("Title")) {
			meatList = dao.searchTitle(searchstring);
		} else if (searchby.equals("Character")) {
			meatList = dao.searchCharacter(searchstring);
		} else if (searchby.equals("Text")) {
			meatList = dao.searchText(searchstring);
		}
		if (meatList == null || meatList.size() == 0) {
			searchStatus = "No records found!";
		}
		mv.addObject("searchstatus", searchStatus);
		mv.addObject("meatlist", meatList);

		mv.setViewName("WEB-INF/index.jsp");
		return mv;
	}

	@RequestMapping(path = "geturl.do", method = RequestMethod.GET)
	public ModelAndView getUrl(String searchresults) {
		RedMeatDAO dao = new RedMeatDAOImpl();
		ModelAndView mv = new ModelAndView();
		List<RedMeat> meatList = null;
		meatList = dao.searchTitle(searchresults);
		System.err.print(searchresults);
		int id = meatList.get(0).getId();
		String title = meatList.get(0).getTitle();
		String characters = meatList.get(0).getCharacters();
		String text = meatList.get(0).getText();
		String imgUrl = meatList.get(0).getImgUrl();
		mv.addObject("id", id);
		mv.addObject("title", title);
		mv.addObject("characters", characters);
		mv.addObject("text", text);
		mv.addObject("imgurl", imgUrl);
		mv.setViewName("WEB-INF/index.jsp");
		return mv;

	}

	@RequestMapping(path = "crud.do", method = RequestMethod.POST)
	public ModelAndView crud(String crud, String id, String title, String characters, String text, String imgurl) {
		RedMeatDAO dao = new RedMeatDAOImpl();
		ModelAndView mv = new ModelAndView();
		RedMeat meatInput = new RedMeat(0, title, characters, text, imgurl);
		RedMeat resultMeat = null;
		String status = null;
		if (crud.equals("add")) {
			resultMeat = dao.create(meatInput);
			if (resultMeat != null) {
				status = "Record added successfully!";
			} else {
				status = "Error while adding record!";
			}
		} else if (crud.equals("modify")) {
			resultMeat = dao.update(Integer.parseInt(id), meatInput);
			if (resultMeat != null) {
				status = "Record updated successfully!";
			} else {
				status = "Error while updating record!";
			}
		} else if (crud.equals("delete")) {
			boolean result = dao.destroy(Integer.parseInt(id));
			if (result) {
				status = "Record deleted successfully!";
				resultMeat = null;
			} else {
				status = "Error deleting record!";
				resultMeat = dao.searchId(Integer.parseInt(id)).get(0);
			}
		}
		mv.addObject("status", status);
		if (resultMeat != null) {
			mv.addObject("id", resultMeat.getId());
			mv.addObject("title", resultMeat.getTitle());
			mv.addObject("characters", resultMeat.getCharacters());
			mv.addObject("text", resultMeat.getText());
			mv.addObject("imgurl", resultMeat.getImgUrl());
		}
		mv.setViewName("WEB-INF/index.jsp");
		return mv;

	}
}
