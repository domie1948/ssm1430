package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Jingdianxinxi;

public interface JingdianxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jingdianxinxi record);

    int insertSelective(Jingdianxinxi record);

    Jingdianxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jingdianxinxi record);
	
    int updateByPrimaryKey(Jingdianxinxi record);
	public Jingdianxinxi quchongJingdianxinxi(Map<String, Object> jingdianmingcheng);
	public List<Jingdianxinxi> getAll(Map<String, Object> map);
	public List<Jingdianxinxi> getsyjingdianxinxi1(Map<String, Object> map);
	public List<Jingdianxinxi> getsyjingdianxinxi3(Map<String, Object> map);
	public List<Jingdianxinxi> getsyjingdianxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Jingdianxinxi> getByPage(Map<String, Object> map);
	public List<Jingdianxinxi> select(Map<String, Object> map);
//	所有List
}

