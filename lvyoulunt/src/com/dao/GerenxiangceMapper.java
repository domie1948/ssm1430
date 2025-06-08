package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Gerenxiangce;

public interface GerenxiangceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gerenxiangce record);

    int insertSelective(Gerenxiangce record);

    Gerenxiangce selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gerenxiangce record);
	
    int updateByPrimaryKey(Gerenxiangce record);
	public Gerenxiangce quchongGerenxiangce(Map<String, Object> yonghuming);
	public List<Gerenxiangce> getAll(Map<String, Object> map);
	public List<Gerenxiangce> getsygerenxiangce1(Map<String, Object> map);
	public List<Gerenxiangce> getsygerenxiangce3(Map<String, Object> map);
	public List<Gerenxiangce> getsygerenxiangce2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Gerenxiangce> getByPage(Map<String, Object> map);
	public List<Gerenxiangce> select(Map<String, Object> map);
//	所有List
}

