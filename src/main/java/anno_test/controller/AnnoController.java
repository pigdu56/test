package anno_test.controller;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import anno_test.maps.TestMappable;

@Controller
@RequestMapping("/")
public class AnnoController {
	@Autowired
	Connection con;

	@Autowired
	TestMappable testMappable;

	@Autowired
	SqlSessionFactory sqlsession;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String homePage(ModelMap m) {
		System.out.println("getListXml START!");
		m.addAttribute("message", String.format("%s, %s", testMappable.getClass(), testMappable.selectTest()));
		return "home";
	}

	@RequestMapping(value = { "/home1" }, method = RequestMethod.GET)
	public String homePage1(ModelMap m) {
		System.out.println("getListXml START!");
		m.addAttribute("message", String.format("%s, %s", testMappable.getClass(), testMappable.selectTest()));
		return "home1";
	}

	@RequestMapping(value = { "/products" }, method = RequestMethod.GET)
	public String productsPage(ModelMap m) {
		m.addAttribute("message", testMappable.getListWhere(2));
		return "products";
	}
	@RequestMapping(value = { "/test" }, method = RequestMethod.GET)
	public String testPage(ModelMap m) {
		m.addAttribute("message", testMappable.getListWhere(2));
		return "test";
	}

	@RequestMapping(value = { "/contactus" }, method = RequestMethod.GET)
	public String contactUsPage(ModelMap m) {
		m.addAttribute("message", testMappable.getListWhere(2));
		return "contactus";
	}

	
	/* 맵퍼 애노테이션 ############################################################### */
	// 1. select
	@RequestMapping(value = { "/get_list_where" }, method = RequestMethod.GET)
	public String getListWhere(Model m) {
		m.addAttribute("message", testMappable.getListWhere(2));
		return "get_list_where";
	}

	
}