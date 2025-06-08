package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ZhanneisixinMapper;
import com.entity.Zhanneisixin;
import com.server.ZhanneisixinServer;
@Service
public class ZhanneisixinServerImpi implements ZhanneisixinServer {
   @Resource
   private ZhanneisixinMapper gdao;
	@Override
	public int add(Zhanneisixin po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Zhanneisixin po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Zhanneisixin> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Zhanneisixin> getsyzhanneisixin1(Map<String, Object> map) {
		return gdao.getsyzhanneisixin1(map);
	}
	public List<Zhanneisixin> getsyzhanneisixin2(Map<String, Object> map) {
		return gdao.getsyzhanneisixin2(map);
	}
	public List<Zhanneisixin> getsyzhanneisixin3(Map<String, Object> map) {
		return gdao.getsyzhanneisixin3(map);
	}
	
	@Override
	public Zhanneisixin quchongZhanneisixin(Map<String, Object> account) {
		return gdao.quchongZhanneisixin(account);
	}

	@Override
	public List<Zhanneisixin> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Zhanneisixin> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Zhanneisixin getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

