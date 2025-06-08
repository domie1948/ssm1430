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

import com.entity.Gerenxiangce;
import com.server.GerenxiangceServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class GerenxiangceController {
	@Resource
	private GerenxiangceServer gerenxiangceService;


   
	@RequestMapping("addGerenxiangce.do")
	public String addGerenxiangce(HttpServletRequest request,Gerenxiangce gerenxiangce,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		gerenxiangce.setAddtime(time.toString().substring(0, 19));
		gerenxiangceService.add(gerenxiangce);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "gerenxiangceList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:gerenxiangceList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateGerenxiangce.do")
	public String doUpdateGerenxiangce(int id,ModelMap map,Gerenxiangce gerenxiangce){
		gerenxiangce=gerenxiangceService.getById(id);
		map.put("gerenxiangce", gerenxiangce);
		return "gerenxiangce_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("gerenxiangceDetail.do")
	public String gerenxiangceDetail(int id,ModelMap map,Gerenxiangce gerenxiangce){
		gerenxiangce=gerenxiangceService.getById(id);
		map.put("gerenxiangce", gerenxiangce);
		return "gerenxiangce_detail";
	}
//	前台详细
	@RequestMapping("grxcDetail.do")
	public String grxcDetail(int id,ModelMap map,Gerenxiangce gerenxiangce){
		gerenxiangce=gerenxiangceService.getById(id);
		map.put("gerenxiangce", gerenxiangce);
		return "gerenxiangcedetail";
	}
//	
	@RequestMapping("updateGerenxiangce.do")
	public String updateGerenxiangce(int id,ModelMap map,Gerenxiangce gerenxiangce,HttpServletRequest request,HttpSession session){
		gerenxiangceService.update(gerenxiangce);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:gerenxiangceList.do";
	}

//	分页查询
	@RequestMapping("gerenxiangceList.do")
	public String gerenxiangceList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gerenxiangce gerenxiangce, String bianhao, String mingcheng, String fengmian, String zhuti, String xiangpian, String yonghuming, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(fengmian==null||fengmian.equals("")){pmap.put("fengmian", null);}else{pmap.put("fengmian", fengmian);}
		if(zhuti==null||zhuti.equals("")){pmap.put("zhuti", null);}else{pmap.put("zhuti", zhuti);}
		if(xiangpian==null||xiangpian.equals("")){pmap.put("xiangpian", null);}else{pmap.put("xiangpian", xiangpian);}
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		
		int total=gerenxiangceService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gerenxiangce> list=gerenxiangceService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gerenxiangce_list";
	}
	
	@RequestMapping("gerenxiangceList2.do")
	public String gerenxiangceList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gerenxiangce gerenxiangce, String bianhao, String mingcheng, String fengmian, String zhuti, String xiangpian, String yonghuming, String issh,HttpServletRequest request){
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
		
		pmap.put("yonghuming", (String)request.getSession().getAttribute("username"));
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(fengmian==null||fengmian.equals("")){pmap.put("fengmian", null);}else{pmap.put("fengmian", fengmian);}
		if(zhuti==null||zhuti.equals("")){pmap.put("zhuti", null);}else{pmap.put("zhuti", zhuti);}
		if(xiangpian==null||xiangpian.equals("")){pmap.put("xiangpian", null);}else{pmap.put("xiangpian", xiangpian);}
		
		
		int total=gerenxiangceService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gerenxiangce> list=gerenxiangceService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gerenxiangce_list2";
	}
	
	
	@RequestMapping("grxcList.do")
	public String grxcList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Gerenxiangce gerenxiangce, String bianhao, String mingcheng, String fengmian, String zhuti, String xiangpian, String yonghuming, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}
		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}
		if(fengmian==null||fengmian.equals("")){pmap.put("fengmian", null);}else{pmap.put("fengmian", fengmian);}
		if(zhuti==null||zhuti.equals("")){pmap.put("zhuti", null);}else{pmap.put("zhuti", zhuti);}
		if(xiangpian==null||xiangpian.equals("")){pmap.put("xiangpian", null);}else{pmap.put("xiangpian", xiangpian);}
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		
		int total=gerenxiangceService.getCount(pmap);
		pageBean.setTotal(total);
		List<Gerenxiangce> list=gerenxiangceService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "gerenxiangcelisttp";
	}
	
	@RequestMapping("deleteGerenxiangce.do")
	public String deleteGerenxiangce(int id,HttpServletRequest request){
		gerenxiangceService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:gerenxiangceList.do";
	}
	
	
}
