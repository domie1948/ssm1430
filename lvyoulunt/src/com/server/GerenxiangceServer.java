package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Gerenxiangce;

public interface GerenxiangceServer {

  public int add(Gerenxiangce po);

  public int update(Gerenxiangce po);
  
  
  
  public int delete(int id);

  public List<Gerenxiangce> getAll(Map<String,Object> map);
  public List<Gerenxiangce> getsygerenxiangce1(Map<String,Object> map);
  public List<Gerenxiangce> getsygerenxiangce2(Map<String,Object> map);
  public List<Gerenxiangce> getsygerenxiangce3(Map<String,Object> map);
  public Gerenxiangce quchongGerenxiangce(Map<String, Object> acount);

  public Gerenxiangce getById( int id);

  public List<Gerenxiangce> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Gerenxiangce> select(Map<String, Object> map);
}
//	所有List
