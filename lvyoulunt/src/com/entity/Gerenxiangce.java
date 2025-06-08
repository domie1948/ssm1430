package com.entity;

public class Gerenxiangce {
    private Integer id;
	private String bianhao;	private String mingcheng;	private String fengmian;	private String zhuti;	private String xiangpian;	private String yonghuming;	private String issh;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getBianhao() {
        return bianhao;
    }
    public void setBianhao(String bianhao) {
        this.bianhao = bianhao == null ? null : bianhao.trim();
    }	public String getMingcheng() {
        return mingcheng;
    }
    public void setMingcheng(String mingcheng) {
        this.mingcheng = mingcheng == null ? null : mingcheng.trim();
    }	public String getFengmian() {
        return fengmian;
    }
    public void setFengmian(String fengmian) {
        this.fengmian = fengmian == null ? null : fengmian.trim();
    }	public String getZhuti() {
        return zhuti;
    }
    public void setZhuti(String zhuti) {
        this.zhuti = zhuti == null ? null : zhuti.trim();
    }	public String getXiangpian() {
        return xiangpian;
    }
    public void setXiangpian(String xiangpian) {
        this.xiangpian = xiangpian == null ? null : xiangpian.trim();
    }	public String getYonghuming() {
        return yonghuming;
    }
    public void setYonghuming(String yonghuming) {
        this.yonghuming = yonghuming == null ? null : yonghuming.trim();
    }	public String getIssh() {
        return issh;
    }
    public void setIssh(String issh) {
        this.issh = issh == null ? null : issh.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
