package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Admin;
import com.example.demo.mapper.AdminMapper;

@Controller

public class AdminCotroller {
	@Autowired
	private AdminMapper adminMapper;
	@RequestMapping(value="adminLogin.html")
	public String adminhtml() {
		return "adminLogin.html";
	}
	
	@RequestMapping(value="/adminLoginSubmit",method=RequestMethod.POST)
	public String adminLoginSubmit(
			@RequestParam("adminname") String adminname,
			@RequestParam("adminpw") String adminpw,
			HttpSession session,
			Model model) {
		Admin admin = adminMapper.isExist(adminname, adminpw);
		if(admin!=null) {
			session.setAttribute("admin", admin);
			return "flower.html";
		}
		model.addAttribute("warning", "该用户未注册");
		return "adminLogin.html";
		
	}
}
