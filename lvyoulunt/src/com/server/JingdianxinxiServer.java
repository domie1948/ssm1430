package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Jingdianxinxi;

public interface JingdianxinxiServer {

  public int add(Jingdianxinxi po);

  public int update(Jingdianxinxi po);
  
  
  
  public int delete(int id);

  public List<Jingdianxinxi> getAll(Map<String,Object> map);
  public List<Jingdianxinxi> getsyjingdianxinxi1(Map<String,Object> map);
  public List<Jingdianxinxi> getsyjingdianxinxi2(Map<String,Object> map);
  public List<Jingdianxinxi> getsyjingdianxinxi3(Map<String,Object> map);
  public Jingdianxinxi quchongJingdianxinxi(Map<String, Object> acount);

  public Jingdianxinxi getById( int id);

  public List<Jingdianxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Jingdianxinxi> select(Map<String, Object> map);
}
//	所有List
