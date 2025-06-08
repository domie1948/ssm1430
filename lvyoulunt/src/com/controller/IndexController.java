package com.controller;

import java.io.File;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.entity.Xinwentongzhi;
import com.entity.Yonghuzhuce;
import com.entity.Gerenxiangce;import com.entity.Jingdianxinxi;import com.entity.Youjixinxi;//jixacxishxu1

import com.server.XinwentongzhiServer;
import com.server.YonghuzhuceServer;
import com.server.GerenxiangceServer;import com.server.JingdianxinxiServer;import com.server.YoujixinxiServer;//jixacxishxu2

import com.util.PageBean;

@Controller
public class IndexController {
	
	
	@Resource
	private XinwentongzhiServer xinwentongzhiService;
	@Resource
	private YonghuzhuceServer yonghuzhuceServer;
	@Resource	private GerenxiangceServer gerenxiangceServer;	@Resource	private JingdianxinxiServer jingdianxinxiServer;	@Resource	private YoujixinxiServer youjixinxiServer;	//jixacxishxu3
	
	
	
//	首页显示内容
	@RequestMapping("index.do")
	public String showIndex(ModelMap map){

		List<Xinwentongzhi> syxinwentongzhi1=xinwentongzhiService.getsyxinwentongzhi1(null);
		List<Xinwentongzhi> syxinwentongzhi2=xinwentongzhiService.getsyxinwentongzhi2(null);
		List<Xinwentongzhi> syxinwentongzhi3=xinwentongzhiService.getsyxinwentongzhi3(null);

		List<Yonghuzhuce> syyonghuzhuce1=yonghuzhuceServer.getsyyonghuzhuce1(null);
		List<Gerenxiangce> sygerenxiangce1=gerenxiangceServer.getsygerenxiangce1(null);		List<Gerenxiangce> sygerenxiangce2=gerenxiangceServer.getsygerenxiangce2(null);		List<Gerenxiangce> sygerenxiangce3=gerenxiangceServer.getsygerenxiangce3(null);		List<Jingdianxinxi> syjingdianxinxi1=jingdianxinxiServer.getsyjingdianxinxi1(null);		List<Jingdianxinxi> syjingdianxinxi2=jingdianxinxiServer.getsyjingdianxinxi2(null);		List<Jingdianxinxi> syjingdianxinxi3=jingdianxinxiServer.getsyjingdianxinxi3(null);		List<Youjixinxi> syyoujixinxi1=youjixinxiServer.getsyyoujixinxi1(null);		List<Youjixinxi> syyoujixinxi2=youjixinxiServer.getsyyoujixinxi2(null);		List<Youjixinxi> syyoujixinxi3=youjixinxiServer.getsyyoujixinxi3(null);		//jixacxishxu4
		
	    map.put("syxinwentongzhi1", syxinwentongzhi1);
	    map.put("syxinwentongzhi2", syxinwentongzhi2);
	    map.put("syxinwentongzhi3", syxinwentongzhi3);
	    map.put("syyonghuzhuce1", syyonghuzhuce1);
	    map.put("sygerenxiangce1", sygerenxiangce1);	    map.put("sygerenxiangce2", sygerenxiangce2);	    map.put("sygerenxiangce3", sygerenxiangce3);	    map.put("syjingdianxinxi1", syjingdianxinxi1);	    map.put("syjingdianxinxi2", syjingdianxinxi2);	    map.put("syjingdianxinxi3", syjingdianxinxi3);	    map.put("syyoujixinxi1", syyoujixinxi1);	    map.put("syyoujixinxi2", syyoujixinxi2);	    map.put("syyoujixinxi3", syyoujixinxi3);	    //jixacxishxu5

		return "default";
	}

	

	
}
