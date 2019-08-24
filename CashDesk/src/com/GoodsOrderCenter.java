package com;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class GoodsOrderCenter {


    /*订单：订单编号，商品编号，商品数量*/
    public static Map<Integer, GoodsOrder> OrderCenterMap = new HashMap<>();


    /*添加商品订单*/

    public void addOrder(GoodsOrder goodsOrder) {

        OrderCenterMap.put(goodsOrder.getOrderId(), goodsOrder);

    }


  /*  *//*删除商品订单*//*
    public void deleteOrder(GoodsOrder goodsOrder) {

        Set<Map.Entry<Integer,GoodsOrder>> OrderCenterMapSet=OrderCenterMap.entrySet();
        Iterator<Map.Entry<Integer,GoodsOrder>> iterator=OrderCenterMapSet.iterator();
        while (iterator.hasNext()) {
            GoodsOrder order=iterator.next().getValue();
            if(order.getGoodsId()==goodsOrder.getGoodsId()){

                iterator.remove();
                break;
            }

        }

    }*/

    /*根据订单编号删除商品订单*/

    public void deleteOrder(Integer orderId) {

        Set<Map.Entry<Integer,GoodsOrder>> OrderCenterMapSet=OrderCenterMap.entrySet();
        Iterator<Map.Entry<Integer,GoodsOrder>> iterator=OrderCenterMapSet.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().getKey()==orderId){
                iterator.remove();
                break;
            }

        }

    }
    /*根据商品编号删除商品订单*/
    public void deleteOrderByGoodsId(Integer goodsId) {

        Set<Map.Entry<Integer,GoodsOrder>> OrderCenterMapSet=OrderCenterMap.entrySet();
        Iterator<Map.Entry<Integer,GoodsOrder>> iterator=OrderCenterMapSet.iterator();
        while (iterator.hasNext()) {
            GoodsOrder order=iterator.next().getValue();
            if(order.getGoodsId()==goodsId){

                iterator.remove();
                break;
            }

        }

    }

    /*添加订单中商品数量*/
    public void addGoods(Integer ordersId, Integer goodsCount) {

        for (Map.Entry<Integer, GoodsOrder> entry : OrderCenterMap.entrySet()) {
            if (entry.getKey() == ordersId) {
                entry.getValue().setGoodsCount(entry.getValue().getGoodsCount() + goodsCount);
                OrderCenterMap.put(entry.getKey(), entry.getValue());


            }
        }



    }

    /*减少订单中商品数量*/
    public void deleteGoods(Integer orderId, Integer goodsCount) {
        for (Map.Entry<Integer, GoodsOrder> entry : OrderCenterMap.entrySet()) {
            if (entry.getKey() == orderId) {
                entry.getValue().setGoodsCount(entry.getValue().getGoodsCount() - goodsCount);
                if(entry.getValue().getGoodsCount()==0){

                    deleteOrderByGoodsId(orderId);
                }else {
                    OrderCenterMap.put(entry.getKey(), entry.getValue());
                }


            }
        }


    }

    /*查看全部订单*/
    public void ListOrder() {
        System.out.println(" 订单编号       商品编号       商品数量      ");
        for (Map.Entry<Integer, GoodsOrder> entry : OrderCenterMap.entrySet()) {

            System.out.println("     "+entry.getKey() + "          " + entry.getValue().getGoodsId() + "           " + entry.getValue().getGoodsCount());
        }
        System.out.println("***********************************************");
    }

    /*根据订单编号获取信息*/
    public void ListOrderByOrderId(Integer orderId) {

        for (Map.Entry<Integer, GoodsOrder> entry : OrderCenterMap.entrySet()) {
            if(entry.getKey()==orderId){

                System.out.println(entry.getKey()+entry.getValue().getGoodsId()+entry.getValue().getGoodsCount());
            }
        }
    }

    /*根据订单编号判断订单是否存在*/
    public boolean IsCunOrder(Integer orderId) {

            if(OrderCenterMap.containsKey(orderId)){

                return true;
            }
            return false;

    }

}
