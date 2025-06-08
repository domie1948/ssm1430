package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Youjixinxi;

public interface YoujixinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Youjixinxi record);

    int insertSelective(Youjixinxi record);

    Youjixinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Youjixinxi record);
	
    int updateByPrimaryKey(Youjixinxi record);
	public Youjixinxi quchongYoujixinxi(Map<String, Object> faburen);
	public List<Youjixinxi> getAll(Map<String, Object> map);
	public List<Youjixinxi> getsyyoujixinxi1(Map<String, Object> map);
	public List<Youjixinxi> getsyyoujixinxi3(Map<String, Object> map);
	public List<Youjixinxi> getsyyoujixinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Youjixinxi> getByPage(Map<String, Object> map);
	public List<Youjixinxi> select(Map<String, Object> map);
//	所有List
}

