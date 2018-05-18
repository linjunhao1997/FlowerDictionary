package com.example.demo.controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.bean.Flower;
import com.example.demo.mapper.FlowerMapper;

@RestController
public class FlowerController {
	@Autowired
	private FlowerMapper flowerMapper;
	
	@RequestMapping(value="/addFlower",method=RequestMethod.POST)
	public String addFlower(
			@RequestParam("flowername")String flowername,
			@RequestParam("description")String description) {
		if(flowerMapper.addFlower(flowername, description)>0) {
			return "添加成功";
		}
		else {
			return "添加失败";
		}
	}
	
	@RequestMapping(value="/deleteFlower")
	public String deleteFlower(@RequestParam("flowername")String flowername) {
		if(flowerMapper.deleteFlower(flowername)>0) {
			return "删除成功";
		}else {
			return "删除失败";
		}
	}
	
	@RequestMapping(value="/modifyFlower")
	public String modifyFlower(
			@RequestParam("flowername") String flowername,
			@RequestParam("description") String description) {
		 if(flowerMapper.modifyFlower(flowername,description)>0) {
			 return "修改成功";
		 }else {
			 return "修改失败";
		 }
	}
	
	@RequestMapping(value="/inquireFlower")
	public Flower inquierFlower(@RequestParam("flowername")String flowername) {
		Flower flower = flowerMapper.inquireFlower(flowername);
		if(flower!=null) {
			return flower;
		}
		else {
			return null;
		}
	}
	
	@PostMapping("/upLoadImg")
	public String singleFileUpload(@RequestParam("flowername")String flowername,
			@RequestParam("file") MultipartFile file) {
		if(file.isEmpty()) {
			return "请选择文件";
		}
		try {
			byte[] bytes = file.getBytes();
			String filePath = "target/classes/static/img/"+file.getOriginalFilename();
			Path path = Paths.get(filePath);
			Files.write(path,bytes);
			flowerMapper.upLoadFlowerImg(flowername, file.getOriginalFilename());
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		return "文件上传成功";
	}
}
