package com.project.mall.entity;

import javax.persistence.*;

@Entity
@Table(name = "good")
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int goodid;
    @Column(name = "goodname")
    String goodname;
    @Column(name="goodpicture")
    String goodpicture;
    @Column(name="originprice")
    Double originprice;
    @Column(name = "realprice")
    Double realprice;
    @Column(name="discount")
    Double discount;
    @Column(name = "shopid")
   Integer shopid;



    @Column(name = "discription")

    String discription;

    public int getGoodid() {
        return goodid;
    }

    public void setGoodid(int goodid) {
        this.goodid = goodid;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public String getGoodpicture() {
        return goodpicture;
    }

    public void setGoodpicture(String goodpicture) {
        this.goodpicture = goodpicture;
    }

    public Double getOriginprice() {
        return originprice;
    }

    public void setOriginprice(Double originprice) {
        this.originprice = originprice;
    }

    public Double getRealprice() {
        return realprice;
    }

    public void setRealprice(Double realprice) {
        this.realprice = realprice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Good(String goodname, String goodpicture, Double originprice) {
        this.goodname = goodname;
        this.goodpicture = goodpicture;
        this.originprice = originprice;
        this.discount=0.0;
        this.discription="";
        this.realprice=0.0;

    }
    public Good(int goodid,String goodname, String goodpicture, Double originprice) {
        this.goodid=goodid;
        this.goodname = goodname;
        this.goodpicture = goodpicture;
        this.originprice = originprice;
        this.discount=0.0;
        this.discription="";
        this.realprice=0.0;

    }

    public Good(String goodname, String goodpicture, Double originprice, Double realprice, Double discount, int shopid, String discription) {
        this.goodname = goodname;
        this.goodpicture = goodpicture;
        this.originprice = originprice;
        this.realprice = realprice;
        this.discount = discount;
        this.shopid = shopid;
        this.discription = discription;
    }
    public Good() {
        this.goodname = goodname;
        this.goodpicture = goodpicture;
        this.originprice = originprice;
        this.realprice = realprice;
        this.discount = discount;
        this.shopid = shopid;
        this.discription = discription;
    }
}
