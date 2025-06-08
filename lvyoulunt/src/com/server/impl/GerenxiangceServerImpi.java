package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.GerenxiangceMapper;
import com.entity.Gerenxiangce;
import com.server.GerenxiangceServer;
@Service
public class GerenxiangceServerImpi implements GerenxiangceServer {
   @Resource
   private GerenxiangceMapper gdao;
	@Override
	public int add(Gerenxiangce po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Gerenxiangce po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Gerenxiangce> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Gerenxiangce> getsygerenxiangce1(Map<String, Object> map) {
		return gdao.getsygerenxiangce1(map);
	}
	public List<Gerenxiangce> getsygerenxiangce2(Map<String, Object> map) {
		return gdao.getsygerenxiangce2(map);
	}
	public List<Gerenxiangce> getsygerenxiangce3(Map<String, Object> map) {
		return gdao.getsygerenxiangce3(map);
	}
	
	@Override
	public Gerenxiangce quchongGerenxiangce(Map<String, Object> account) {
		return gdao.quchongGerenxiangce(account);
	}

	@Override
	public List<Gerenxiangce> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Gerenxiangce> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Gerenxiangce getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

