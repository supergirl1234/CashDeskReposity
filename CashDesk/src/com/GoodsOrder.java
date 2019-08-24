package com;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
/*订单*/
public class GoodsOrder {


    /*商品编号，商品数量*/

    public  Integer GoodsId;

    public  Integer GoodsCount;
    public  Integer OrderId;//订单编号

    public GoodsOrder(Integer orderId) {
        OrderId = orderId;
    }

    public Integer getOrderId() {
        return OrderId;
    }

    public void setOrderId(Integer orderId) {
        OrderId = orderId;
    }

    public Integer getGoodsId() {
        return GoodsId;
    }

    public void setGoodsId(Integer goodsId) {
        GoodsId = goodsId;
    }

    public Integer getGoodsCount() {
        return GoodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        GoodsCount = goodsCount;
    }

    @Override
    public String toString() {
        return "GoodsOrder{" +
                "GoodsId=" + GoodsId +
                ", GoodsCount=" + GoodsCount +
                '}';
    }
}
