package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Zhanneisixin;
import com.server.ZhanneisixinServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ZhanneisixinController {
	@Resource
	private ZhanneisixinServer zhanneisixinService;


   
	@RequestMapping("addZhanneisixin.do")
	public String addZhanneisixin(HttpServletRequest request,Zhanneisixin zhanneisixin,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		zhanneisixin.setAddtime(time.toString().substring(0, 19));
		zhanneisixinService.add(zhanneisixin);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "zhanneisixinList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:zhanneisixinList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateZhanneisixin.do")
	public String doUpdateZhanneisixin(int id,ModelMap map,Zhanneisixin zhanneisixin){
		zhanneisixin=zhanneisixinService.getById(id);
		map.put("zhanneisixin", zhanneisixin);
		return "zhanneisixin_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("zhanneisixinDetail.do")
	public String zhanneisixinDetail(int id,ModelMap map,Zhanneisixin zhanneisixin){
		zhanneisixin=zhanneisixinService.getById(id);
		map.put("zhanneisixin", zhanneisixin);
		return "zhanneisixin_detail";
	}
//	前台详细
	@RequestMapping("znsxDetail.do")
	public String znsxDetail(int id,ModelMap map,Zhanneisixin zhanneisixin){
		zhanneisixin=zhanneisixinService.getById(id);
		map.put("zhanneisixin", zhanneisixin);
		return "zhanneisixindetail";
	}
//	
	@RequestMapping("updateZhanneisixin.do")
	public String updateZhanneisixin(int id,ModelMap map,Zhanneisixin zhanneisixin,HttpServletRequest request,HttpSession session){
		zhanneisixinService.update(zhanneisixin);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:zhanneisixinList.do";
	}

//	分页查询
	@RequestMapping("zhanneisixinList.do")
	public String zhanneisixinList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhanneisixin zhanneisixin, String shoujianren, String biaoti, String neirong, String fajianren, String quanxian){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		if(fajianren==null||fajianren.equals("")){pmap.put("fajianren", null);}else{pmap.put("fajianren", fajianren);}		if(quanxian==null||quanxian.equals("")){pmap.put("quanxian", null);}else{pmap.put("quanxian", quanxian);}		
		int total=zhanneisixinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhanneisixin> list=zhanneisixinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhanneisixin_list";
	}
	
	@RequestMapping("zhanneisixinList3.do")
	public String zhanneisixinList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhanneisixin zhanneisixin, String shoujianren, String biaoti, String neirong, String fajianren, String quanxian,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("shoujianren", (String)request.getSession().getAttribute("username"));
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		if(quanxian==null||quanxian.equals("")){pmap.put("quanxian", null);}else{pmap.put("quanxian", quanxian);}		
		
		int total=zhanneisixinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhanneisixin> list=zhanneisixinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhanneisixin_list3";
	}	@RequestMapping("zhanneisixinList2.do")
	public String zhanneisixinList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhanneisixin zhanneisixin, String shoujianren, String biaoti, String neirong, String fajianren, String quanxian,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("fajianren", (String)request.getSession().getAttribute("username"));
		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		if(quanxian==null||quanxian.equals("")){pmap.put("quanxian", null);}else{pmap.put("quanxian", quanxian);}		
		
		int total=zhanneisixinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhanneisixin> list=zhanneisixinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhanneisixin_list2";
	}	
	
	@RequestMapping("znsxList.do")
	public String znsxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhanneisixin zhanneisixin, String shoujianren, String biaoti, String neirong, String fajianren, String quanxian){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shoujianren==null||shoujianren.equals("")){pmap.put("shoujianren", null);}else{pmap.put("shoujianren", shoujianren);}		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}		if(fajianren==null||fajianren.equals("")){pmap.put("fajianren", null);}else{pmap.put("fajianren", fajianren);}		if(quanxian==null||quanxian.equals("")){pmap.put("quanxian", null);}else{pmap.put("quanxian", quanxian);}		
		int total=zhanneisixinService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhanneisixin> list=zhanneisixinService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhanneisixinlist";
	}
	
	@RequestMapping("deleteZhanneisixin.do")
	public String deleteZhanneisixin(int id,HttpServletRequest request){
		zhanneisixinService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:zhanneisixinList.do";
	}
	
	
}
