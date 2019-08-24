package com;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
public class GoodsShelf {
    /*存放货物Goods*/
    private static List<Goods> GoodsShelfList=new ArrayList<>();


    /*添加Goods*/
    public static void AddGoods(Goods goods){
        GoodsShelfList.add(goods);
    }
    /*删除Goods*/
    public static void DeleteGoods(Integer goodsId){
        Iterator<Goods> iterator=GoodsShelfList.iterator();
      /*  for (Goods  entry:GoodsShelfList) {
           if(entry.getId()==goodsId){
               GoodsShelfList.remove(entry);
           }
       }*/
      while(iterator.hasNext()){
          Goods goods=iterator.next();
          if( goods.getId()==goodsId){
              iterator.remove();
              break;
          }

      }
    }
    /*获取Goods信息*/
    public static Goods GetGoods(Integer goodsId){
        for (Goods  entry:GoodsShelfList) {
            if (entry.getId() == goodsId) {

                return entry;
            }
        }
        return  null;

    }

    /*根据商品编号更新商品*/
    public static void UpdateGoods(Goods goods){
        for (Goods  entry:GoodsShelfList) {
            if (entry.getId() == goods.getId()) {
                  entry.setName(goods.getName());
                  entry.setPrice(goods.getPrice());
            }
        }
    }

    /*列出所有商品信息*/
    public static void list(){

        System.out.println("********************商品信息********************");
        System.out.println("\t" + "商品编号" + "\t" + "商品名称" + "\t\t" + "商品单价");
        for (Goods  entry:GoodsShelfList) {
            System.out.println("\t      " +entry.getId()+"\t      " +entry.getName()+"\t     " +entry.getPrice());
        }
        System.out.println("***********************************************");

    }

    /*货架上是否存在该商品*/
    public  static  boolean isCunGoods(Integer goodsId){

        for (Goods  entry:GoodsShelfList) {
            if(entry.getId()==goodsId){
                return  true;
            }
        }
        return false;
    }

}
