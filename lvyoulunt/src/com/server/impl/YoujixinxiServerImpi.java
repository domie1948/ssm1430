package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.YoujixinxiMapper;
import com.entity.Youjixinxi;
import com.server.YoujixinxiServer;
@Service
public class YoujixinxiServerImpi implements YoujixinxiServer {
   @Resource
   private YoujixinxiMapper gdao;
	@Override
	public int add(Youjixinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Youjixinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Youjixinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Youjixinxi> getsyyoujixinxi1(Map<String, Object> map) {
		return gdao.getsyyoujixinxi1(map);
	}
	public List<Youjixinxi> getsyyoujixinxi2(Map<String, Object> map) {
		return gdao.getsyyoujixinxi2(map);
	}
	public List<Youjixinxi> getsyyoujixinxi3(Map<String, Object> map) {
		return gdao.getsyyoujixinxi3(map);
	}
	
	@Override
	public Youjixinxi quchongYoujixinxi(Map<String, Object> account) {
		return gdao.quchongYoujixinxi(account);
	}

	@Override
	public List<Youjixinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Youjixinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Youjixinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

