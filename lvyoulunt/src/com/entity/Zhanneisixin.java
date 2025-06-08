package com.entity;

public class Zhanneisixin {
    private Integer id;
	private String shoujianren;	private String biaoti;	private String neirong;	private String fajianren;	private String quanxian;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getShoujianren() {
        return shoujianren;
    }
    public void setShoujianren(String shoujianren) {
        this.shoujianren = shoujianren == null ? null : shoujianren.trim();
    }	public String getBiaoti() {
        return biaoti;
    }
    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti == null ? null : biaoti.trim();
    }	public String getNeirong() {
        return neirong;
    }
    public void setNeirong(String neirong) {
        this.neirong = neirong == null ? null : neirong.trim();
    }	public String getFajianren() {
        return fajianren;
    }
    public void setFajianren(String fajianren) {
        this.fajianren = fajianren == null ? null : fajianren.trim();
    }	public String getQuanxian() {
        return quanxian;
    }
    public void setQuanxian(String quanxian) {
        this.quanxian = quanxian == null ? null : quanxian.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
