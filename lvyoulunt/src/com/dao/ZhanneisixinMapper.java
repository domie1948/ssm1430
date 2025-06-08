package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Zhanneisixin;

public interface ZhanneisixinMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zhanneisixin record);

    int insertSelective(Zhanneisixin record);

    Zhanneisixin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zhanneisixin record);
	
    int updateByPrimaryKey(Zhanneisixin record);
	public Zhanneisixin quchongZhanneisixin(Map<String, Object> fajianren);
	public List<Zhanneisixin> getAll(Map<String, Object> map);
	public List<Zhanneisixin> getsyzhanneisixin1(Map<String, Object> map);
	public List<Zhanneisixin> getsyzhanneisixin3(Map<String, Object> map);
	public List<Zhanneisixin> getsyzhanneisixin2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Zhanneisixin> getByPage(Map<String, Object> map);
	public List<Zhanneisixin> select(Map<String, Object> map);
//	所有List
}

