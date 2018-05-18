package com.example.demo.mapper;

import org.apache.ibatis.annotations.Param;


import com.example.demo.bean.Flower;

public interface FlowerMapper {
	
	int addFlower(@Param("flowername")String flowername,@Param("description") String description);
	
	int deleteFlower(@Param("flowername")String flowername);
	
	int modifyFlower(@Param("flowername") String flowername,@Param("description") String description);
	
	Flower inquireFlower(@Param("flowername")String flowername);
	
	int upLoadFlowerImg(@Param("flowername")String floername,@Param("pic") String pic);
}
