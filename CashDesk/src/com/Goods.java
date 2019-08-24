package com;


import java.util.concurrent.atomic.AtomicInteger;

/*商品类*/
public class Goods {
    /*编号*/
    private  Integer id;
    /*名称*/
    private String name;
    /*价格*/
    private Double price;

    public Goods() {
    }

    public Goods(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
