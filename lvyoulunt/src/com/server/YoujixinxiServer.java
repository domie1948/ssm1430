package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Youjixinxi;

public interface YoujixinxiServer {

  public int add(Youjixinxi po);

  public int update(Youjixinxi po);
  
  
  
  public int delete(int id);

  public List<Youjixinxi> getAll(Map<String,Object> map);
  public List<Youjixinxi> getsyyoujixinxi1(Map<String,Object> map);
  public List<Youjixinxi> getsyyoujixinxi2(Map<String,Object> map);
  public List<Youjixinxi> getsyyoujixinxi3(Map<String,Object> map);
  public Youjixinxi quchongYoujixinxi(Map<String, Object> acount);

  public Youjixinxi getById( int id);

  public List<Youjixinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Youjixinxi> select(Map<String, Object> map);
}
//	所有List
