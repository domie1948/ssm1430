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

import com.entity.Jingdianxinxi;
import com.server.JingdianxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class JingdianxinxiController {
	@Resource
	private JingdianxinxiServer jingdianxinxiService;


   
	@RequestMapping("addJingdianxinxi.do")
	public String addJingdianxinxi(HttpServletRequest request,Jingdianxinxi jingdianxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		jingdianxinxi.setAddtime(time.toString().substring(0, 19));
		jingdianxinxiService.add(jingdianxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "jingdianxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:jingdianxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateJingdianxinxi.do")
	public String doUpdateJingdianxinxi(int id,ModelMap map,Jingdianxinxi jingdianxinxi){
		jingdianxinxi=jingdianxinxiService.getById(id);
		map.put("jingdianxinxi", jingdianxinxi);
		return "jingdianxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("jingdianxinxiDetail.do")
	public String jingdianxinxiDetail(int id,ModelMap map,Jingdianxinxi jingdianxinxi){
		jingdianxinxi=jingdianxinxiService.getById(id);
		map.put("jingdianxinxi", jingdianxinxi);
		return "jingdianxinxi_detail";
	}
//	前台详细
	@RequestMapping("jdxxDetail.do")
	public String jdxxDetail(int id,ModelMap map,Jingdianxinxi jingdianxinxi){
		jingdianxinxi=jingdianxinxiService.getById(id);
		map.put("jingdianxinxi", jingdianxinxi);
		return "jingdianxinxidetail";
	}
//	
	@RequestMapping("updateJingdianxinxi.do")
	public String updateJingdianxinxi(int id,ModelMap map,Jingdianxinxi jingdianxinxi,HttpServletRequest request,HttpSession session){
		jingdianxinxiService.update(jingdianxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:jingdianxinxiList.do";
	}

//	分页查询
	@RequestMapping("jingdianxinxiList.do")
	public String jingdianxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jingdianxinxi jingdianxinxi, String jingdianbianhao, String jingdianmingcheng, String jingdiandengji, String menpiaojiage1,String menpiaojiage2, String jiaotongzhuangkuang, String diliweizhi, String jingdianzhutu, String xiangqingjieshao, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(jingdianbianhao==null||jingdianbianhao.equals("")){pmap.put("jingdianbianhao", null);}else{pmap.put("jingdianbianhao", jingdianbianhao);}
		if(jingdianmingcheng==null||jingdianmingcheng.equals("")){pmap.put("jingdianmingcheng", null);}else{pmap.put("jingdianmingcheng", jingdianmingcheng);}
		if(jingdiandengji==null||jingdiandengji.equals("")){pmap.put("jingdiandengji", null);}else{pmap.put("jingdiandengji", jingdiandengji);}
		if(menpiaojiage1==null||menpiaojiage1.equals("")){pmap.put("menpiaojiage1", null);}else{pmap.put("menpiaojiage1", menpiaojiage1);}
		if(menpiaojiage2==null||menpiaojiage2.equals("")){pmap.put("menpiaojiage2", null);}else{pmap.put("menpiaojiage2", menpiaojiage2);}
		if(jiaotongzhuangkuang==null||jiaotongzhuangkuang.equals("")){pmap.put("jiaotongzhuangkuang", null);}else{pmap.put("jiaotongzhuangkuang", jiaotongzhuangkuang);}
		if(diliweizhi==null||diliweizhi.equals("")){pmap.put("diliweizhi", null);}else{pmap.put("diliweizhi", diliweizhi);}
		if(jingdianzhutu==null||jingdianzhutu.equals("")){pmap.put("jingdianzhutu", null);}else{pmap.put("jingdianzhutu", jingdianzhutu);}
		if(xiangqingjieshao==null||xiangqingjieshao.equals("")){pmap.put("xiangqingjieshao", null);}else{pmap.put("xiangqingjieshao", xiangqingjieshao);}
		
		int total=jingdianxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jingdianxinxi> list=jingdianxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jingdianxinxi_list";
	}
	
	
	
	@RequestMapping("jdxxList.do")
	public String jdxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jingdianxinxi jingdianxinxi, String jingdianbianhao, String jingdianmingcheng, String jingdiandengji, String menpiaojiage1,String menpiaojiage2, String jiaotongzhuangkuang, String diliweizhi, String jingdianzhutu, String xiangqingjieshao, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(jingdianbianhao==null||jingdianbianhao.equals("")){pmap.put("jingdianbianhao", null);}else{pmap.put("jingdianbianhao", jingdianbianhao);}
		if(jingdianmingcheng==null||jingdianmingcheng.equals("")){pmap.put("jingdianmingcheng", null);}else{pmap.put("jingdianmingcheng", jingdianmingcheng);}
		if(jingdiandengji==null||jingdiandengji.equals("")){pmap.put("jingdiandengji", null);}else{pmap.put("jingdiandengji", jingdiandengji);}
		if(menpiaojiage1==null||menpiaojiage1.equals("")){pmap.put("menpiaojiage1", null);}else{pmap.put("menpiaojiage1", menpiaojiage1);}
		if(menpiaojiage2==null||menpiaojiage2.equals("")){pmap.put("menpiaojiage2", null);}else{pmap.put("menpiaojiage2", menpiaojiage2);}
		if(jiaotongzhuangkuang==null||jiaotongzhuangkuang.equals("")){pmap.put("jiaotongzhuangkuang", null);}else{pmap.put("jiaotongzhuangkuang", jiaotongzhuangkuang);}
		if(diliweizhi==null||diliweizhi.equals("")){pmap.put("diliweizhi", null);}else{pmap.put("diliweizhi", diliweizhi);}
		if(jingdianzhutu==null||jingdianzhutu.equals("")){pmap.put("jingdianzhutu", null);}else{pmap.put("jingdianzhutu", jingdianzhutu);}
		if(xiangqingjieshao==null||xiangqingjieshao.equals("")){pmap.put("xiangqingjieshao", null);}else{pmap.put("xiangqingjieshao", xiangqingjieshao);}
		
		int total=jingdianxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jingdianxinxi> list=jingdianxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jingdianxinxilisttp";
	}
	
	@RequestMapping("deleteJingdianxinxi.do")
	public String deleteJingdianxinxi(int id,HttpServletRequest request){
		jingdianxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:jingdianxinxiList.do";
	}
	
	
}
