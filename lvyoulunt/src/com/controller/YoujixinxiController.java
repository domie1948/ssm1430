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

import com.entity.Youjixinxi;
import com.server.YoujixinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class YoujixinxiController {
	@Resource
	private YoujixinxiServer youjixinxiService;


   
	@RequestMapping("addYoujixinxi.do")
	public String addYoujixinxi(HttpServletRequest request,Youjixinxi youjixinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		youjixinxi.setAddtime(time.toString().substring(0, 19));
		youjixinxiService.add(youjixinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "youjixinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:youjixinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateYoujixinxi.do")
	public String doUpdateYoujixinxi(int id,ModelMap map,Youjixinxi youjixinxi){
		youjixinxi=youjixinxiService.getById(id);
		map.put("youjixinxi", youjixinxi);
		return "youjixinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("youjixinxiDetail.do")
	public String youjixinxiDetail(int id,ModelMap map,Youjixinxi youjixinxi){
		youjixinxi=youjixinxiService.getById(id);
		map.put("youjixinxi", youjixinxi);
		return "youjixinxi_detail";
	}
//	前台详细
	@RequestMapping("yjxxDetail.do")
	public String yjxxDetail(int id,ModelMap map,Youjixinxi youjixinxi){
		youjixinxi=youjixinxiService.getById(id);
		map.put("youjixinxi", youjixinxi);
		return "youjixinxidetail";
	}
//	
	@RequestMapping("updateYoujixinxi.do")
	public String updateYoujixinxi(int id,ModelMap map,Youjixinxi youjixinxi,HttpServletRequest request,HttpSession session){
		youjixinxiService.update(youjixinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:youjixinxiList.do";
	}

//	分页查询
	@RequestMapping("youjixinxiList.do")
	public String youjixinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Youjixinxi youjixinxi, String youjibianhao, String youjibiaoti, String fengmiantupian, String xingchengshijian1,String xingchengshijian2, String zhuyaojingdian, String xingchengluxian, String neirongxiangqing, String faburen, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(youjibianhao==null||youjibianhao.equals("")){pmap.put("youjibianhao", null);}else{pmap.put("youjibianhao", youjibianhao);}
		if(youjibiaoti==null||youjibiaoti.equals("")){pmap.put("youjibiaoti", null);}else{pmap.put("youjibiaoti", youjibiaoti);}
		if(fengmiantupian==null||fengmiantupian.equals("")){pmap.put("fengmiantupian", null);}else{pmap.put("fengmiantupian", fengmiantupian);}
		if(xingchengshijian1==null||xingchengshijian1.equals("")){pmap.put("xingchengshijian1", null);}else{pmap.put("xingchengshijian1", xingchengshijian1);}
		if(xingchengshijian2==null||xingchengshijian2.equals("")){pmap.put("xingchengshijian2", null);}else{pmap.put("xingchengshijian2", xingchengshijian2);}
		if(zhuyaojingdian==null||zhuyaojingdian.equals("")){pmap.put("zhuyaojingdian", null);}else{pmap.put("zhuyaojingdian", zhuyaojingdian);}
		if(xingchengluxian==null||xingchengluxian.equals("")){pmap.put("xingchengluxian", null);}else{pmap.put("xingchengluxian", xingchengluxian);}
		if(neirongxiangqing==null||neirongxiangqing.equals("")){pmap.put("neirongxiangqing", null);}else{pmap.put("neirongxiangqing", neirongxiangqing);}
		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}
		
		int total=youjixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Youjixinxi> list=youjixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "youjixinxi_list";
	}
	
	@RequestMapping("youjixinxiList2.do")
	public String youjixinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Youjixinxi youjixinxi, String youjibianhao, String youjibiaoti, String fengmiantupian, String xingchengshijian1,String xingchengshijian2, String zhuyaojingdian, String xingchengluxian, String neirongxiangqing, String faburen, String issh,HttpServletRequest request){
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
		
		pmap.put("faburen", (String)request.getSession().getAttribute("username"));
		if(youjibianhao==null||youjibianhao.equals("")){pmap.put("youjibianhao", null);}else{pmap.put("youjibianhao", youjibianhao);}
		if(youjibiaoti==null||youjibiaoti.equals("")){pmap.put("youjibiaoti", null);}else{pmap.put("youjibiaoti", youjibiaoti);}
		if(fengmiantupian==null||fengmiantupian.equals("")){pmap.put("fengmiantupian", null);}else{pmap.put("fengmiantupian", fengmiantupian);}
		if(xingchengshijian1==null||xingchengshijian1.equals("")){pmap.put("xingchengshijian1", null);}else{pmap.put("xingchengshijian1", xingchengshijian1);}
		if(xingchengshijian2==null||xingchengshijian2.equals("")){pmap.put("xingchengshijian2", null);}else{pmap.put("xingchengshijian2", xingchengshijian2);}
		if(zhuyaojingdian==null||zhuyaojingdian.equals("")){pmap.put("zhuyaojingdian", null);}else{pmap.put("zhuyaojingdian", zhuyaojingdian);}
		if(xingchengluxian==null||xingchengluxian.equals("")){pmap.put("xingchengluxian", null);}else{pmap.put("xingchengluxian", xingchengluxian);}
		if(neirongxiangqing==null||neirongxiangqing.equals("")){pmap.put("neirongxiangqing", null);}else{pmap.put("neirongxiangqing", neirongxiangqing);}
		
		
		int total=youjixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Youjixinxi> list=youjixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "youjixinxi_list2";
	}
	
	
	@RequestMapping("yjxxList.do")
	public String yjxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Youjixinxi youjixinxi, String youjibianhao, String youjibiaoti, String fengmiantupian, String xingchengshijian1,String xingchengshijian2, String zhuyaojingdian, String xingchengluxian, String neirongxiangqing, String faburen, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(youjibianhao==null||youjibianhao.equals("")){pmap.put("youjibianhao", null);}else{pmap.put("youjibianhao", youjibianhao);}
		if(youjibiaoti==null||youjibiaoti.equals("")){pmap.put("youjibiaoti", null);}else{pmap.put("youjibiaoti", youjibiaoti);}
		if(fengmiantupian==null||fengmiantupian.equals("")){pmap.put("fengmiantupian", null);}else{pmap.put("fengmiantupian", fengmiantupian);}
		if(xingchengshijian1==null||xingchengshijian1.equals("")){pmap.put("xingchengshijian1", null);}else{pmap.put("xingchengshijian1", xingchengshijian1);}
		if(xingchengshijian2==null||xingchengshijian2.equals("")){pmap.put("xingchengshijian2", null);}else{pmap.put("xingchengshijian2", xingchengshijian2);}
		if(zhuyaojingdian==null||zhuyaojingdian.equals("")){pmap.put("zhuyaojingdian", null);}else{pmap.put("zhuyaojingdian", zhuyaojingdian);}
		if(xingchengluxian==null||xingchengluxian.equals("")){pmap.put("xingchengluxian", null);}else{pmap.put("xingchengluxian", xingchengluxian);}
		if(neirongxiangqing==null||neirongxiangqing.equals("")){pmap.put("neirongxiangqing", null);}else{pmap.put("neirongxiangqing", neirongxiangqing);}
		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}
		
		int total=youjixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Youjixinxi> list=youjixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "youjixinxilisttp";
	}
	
	@RequestMapping("deleteYoujixinxi.do")
	public String deleteYoujixinxi(int id,HttpServletRequest request){
		youjixinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:youjixinxiList.do";
	}
	
	
}
