package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Zhanneisixin;

public interface ZhanneisixinServer {

  public int add(Zhanneisixin po);

  public int update(Zhanneisixin po);
  
  
  
  public int delete(int id);

  public List<Zhanneisixin> getAll(Map<String,Object> map);
  public List<Zhanneisixin> getsyzhanneisixin1(Map<String,Object> map);
  public List<Zhanneisixin> getsyzhanneisixin2(Map<String,Object> map);
  public List<Zhanneisixin> getsyzhanneisixin3(Map<String,Object> map);
  public Zhanneisixin quchongZhanneisixin(Map<String, Object> acount);

  public Zhanneisixin getById( int id);

  public List<Zhanneisixin> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Zhanneisixin> select(Map<String, Object> map);
}
//	所有List
