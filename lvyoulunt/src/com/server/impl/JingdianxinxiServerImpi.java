package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JingdianxinxiMapper;
import com.entity.Jingdianxinxi;
import com.server.JingdianxinxiServer;
@Service
public class JingdianxinxiServerImpi implements JingdianxinxiServer {
   @Resource
   private JingdianxinxiMapper gdao;
	@Override
	public int add(Jingdianxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Jingdianxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Jingdianxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Jingdianxinxi> getsyjingdianxinxi1(Map<String, Object> map) {
		return gdao.getsyjingdianxinxi1(map);
	}
	public List<Jingdianxinxi> getsyjingdianxinxi2(Map<String, Object> map) {
		return gdao.getsyjingdianxinxi2(map);
	}
	public List<Jingdianxinxi> getsyjingdianxinxi3(Map<String, Object> map) {
		return gdao.getsyjingdianxinxi3(map);
	}
	
	@Override
	public Jingdianxinxi quchongJingdianxinxi(Map<String, Object> account) {
		return gdao.quchongJingdianxinxi(account);
	}

	@Override
	public List<Jingdianxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Jingdianxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Jingdianxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

