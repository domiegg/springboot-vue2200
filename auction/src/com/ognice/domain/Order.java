package com.ognice.domain;

import java.util.Date;
/**
*
* 订单管理 实体类
*
**/
public class Order {
    private Integer id;

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer productid;

	public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    private String productname;

	public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    private Integer status;

	public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    private String address;

	public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String tel;

	public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    private Integer preuserid;

	public Integer getPreuserid() {
        return preuserid;
    }

    public void setPreuserid(Integer preuserid) {
        this.preuserid = preuserid;
    }

    private String preusername;

	public String getPreusername() {
        return preusername;
    }

    public void setPreusername(String preusername) {
        this.preusername = preusername;
    }

}