package com;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    /*订单中心*/
    public static GoodsOrderCenter goodsOrderCenter = new GoodsOrderCenter();
    public static AtomicInteger atomicInteger=new AtomicInteger(0);

    public static void start() {

        System.out.println("                 请选择功能：                  ");
        System.out.println("        [U] 使用 [S]设置 [A]关于 [Q]退出       ");
        System.out.println("            输入:U S A Q 进入操作              ");
        System.out.println("***********************************************");
    }

    public static void use() {
        System.out.println("                    买单功能                   ");
        System.out.println("     [A] 添加订单 [D] 取消订单 [L] 浏览商品     ");
        System.out.println(" [T]订单中添加商品数量   [Q] 订单中取消商品数量  ");
        System.out.println("          [S] 查看订单   [R] 返回上级           ");
        System.out.println("           输入:  A D L T Q S R 进入操作        ");
        System.out.println("***********************************************");
    }

    public static void useFunction() {
        use();
        while (true) {

            String message = scanner.nextLine();
            switch (message.toUpperCase()) {
                case "A": {
                    /*添加订单*/
                    System.out.println("请按 [商品编号 数量]的格式下单：");
                    String line = scanner.nextLine();
                    Integer goodsId = Integer.parseInt(line.split(" ")[0]);//商品编号
                    Integer goodsCount = Integer.parseInt(line.split(" ")[1]);//商品数量
                    Goods goods = GoodsShelf.GetGoods(goodsId);//根据商品编号获取商品
                    GoodsOrder order = new GoodsOrder(atomicInteger.getAndAdd(1));
                    order.setGoodsId(goodsId);//订单
                    order.setGoodsCount(goodsCount);
                    if (goods != null) {//判断商品是否存在
                        /*将该订单添加到订单中心*/
                        goodsOrderCenter.addOrder(order);

                    }else{
                        System.out.println("该商品不存在，请选择正确的商品编号");
                    }

                    use();
                    break;
                }
                case "D": {
                    /*取消订单*/
                    //先展示所有的订单
                    goodsOrderCenter.ListOrder();
                    //再输入要取消的订单号
                    System.out.println("请按 [订单编号]的格式取消订单：");
                    String line = scanner.nextLine();
                    Integer OrderId = Integer.parseInt(line);
                    if(goodsOrderCenter.IsCunOrder(OrderId)) {
                        goodsOrderCenter.deleteOrder(OrderId);
                    }else {
                        System.out.println("请输入正确的订单号");
                    }

                    use();
                    break;

                }
                case "L": {
                    //浏览商品
                    GoodsShelf.list();

                    use();
                    break;
                }

                case "T": {
                    /*添加订单商品数量*/
                    //先展示所有的订单
                    goodsOrderCenter.ListOrder();
                    //再输入信息
                    System.out.println("请按 [订单编号 数量]的格式添加订单中商品数量：");
                    String line = scanner.nextLine();
                    Integer OrderId = Integer.parseInt(line.split(" ")[0]);
                    Integer goodsCount = Integer.parseInt(line.split(" ")[1]);
                    if(goodsOrderCenter.IsCunOrder(OrderId)) {
                        goodsOrderCenter.addGoods(OrderId, goodsCount);
                    }else {
                        System.out.println("该订单编号不存在，请输入正确的订单编号");
                    }
                    use();
                    break;
                }
                case "Q": {
                    /*取消订单商品数量*/

                    //先查看一下订单
                    goodsOrderCenter.ListOrder();
                    //再操作
                    System.out.println("请按 [订单编号 数量]的格式取消订单中商品数量：");
                    String line = scanner.nextLine();
                    Integer orderId = Integer.parseInt(line.split(" ")[0]);
                    Integer goodsCount = Integer.parseInt(line.split(" ")[1]);

                    /*取消订单商品数量*/
                    goodsOrderCenter.deleteGoods(orderId, goodsCount);

                    use();
                    break;
                }
                case "S": {
                    //查看订单
                    goodsOrderCenter.ListOrder();
                    use();
                    break;

                }
                case "R": {
                    //返回上级
                    return;
                }
            }

        }
    }

    public static void set() {

        System.out.println("                 设置功能                      ");
        System.out.println("    [A] 商品上架 [D] 商品下架 [U] 商品修改      ");
        System.out.println("    [S] 查看商品 [L] 浏览订单 [R] 返回上级      ");
        System.out.println("          输入:  A D U S L R 进入操作          ");
        System.out.println("***********************************************");

    }

    public static void setFunction() {
        set();
        while (true) {
            String message = scanner.nextLine();
            switch (message.toUpperCase()) {

                case "A": {
                    /*商品上架*/
                    //先展示一下在货架上的商品
                    GoodsShelf.list();
                    //再进行操作
                    System.out.println("请输入上架的商品编号、名字、价钱");
                    String value = scanner.nextLine();
                    String[] mess = value.split(" ");

                    Integer goodsId = Integer.parseInt(mess[0]);
                    String goodsName = mess[1];
                    Double goodsPrice = Double.parseDouble(mess[2]);
                    if (GoodsShelf.isCunGoods(goodsId)) {
                        System.out.println("上架商品已存在");
                        break;

                    } else {
                        Goods goods = new Goods(goodsId, goodsName, goodsPrice);
                        GoodsShelf.AddGoods(goods);

                    }
                    set();
                    break;
                }
                case "D": {
                    /*商品下架*/
                   //先展示一下在货架上的商品
                    GoodsShelf.list();
                    //再进行操作
                    System.out.println("请输入要下架的商品编号");
                    String value = scanner.nextLine();
                    Integer goodsId = Integer.parseInt(value);
                    /*判断是否存在该商品编号*/
                    if(GoodsShelf.isCunGoods(goodsId)) {
                        GoodsShelf.DeleteGoods(goodsId);
                    }else{
                        System.out.println("该商品编号不存在，请输入正确的商品编号");
                    }
                    set();
                    break;
                }

                case "U": {
                    /*商品修改*/
                    //先展示一下在货架上的商品
                    GoodsShelf.list();
                    //再操作
                    System.out.println("请输入修改的商品信息：[商品编号  商品名字 商品价格]");
                    String value = scanner.nextLine();
                    String[] mess = value.split(" ");
                    Integer goodsId = Integer.parseInt(mess[0]);
                    String goodsName = mess[1];
                    Double goodsPrice = Double.parseDouble(mess[2]);
                    Goods goods = new Goods(goodsId, goodsName, goodsPrice);
                    if(GoodsShelf.isCunGoods(goodsId)) {
                        GoodsShelf.UpdateGoods(goods);
                    }else{
                        System.out.println("该商品编号不存在，请输入正确的商品编号");
                    }
                    set();
                    break;
                }
                case "S": {
                    /*查看商品*/
                    GoodsShelf.list();
                    set();
                    break;
                }
                case "L": {
                    /*浏览订单*/
                    goodsOrderCenter.ListOrder();
                    set();
                    break;
                }
                case "R": {
                    /*返回上级*/

                    return;
                }
            }

        }
    }

    public static void about() {

        System.out.println("                 关于设置                    ");
        System.out.println("             名称：简易版收银台                ");
        System.out.println("             意见反馈：f23456@163.com          ");
        System.out.println("***********************************************");
    }

    public static void quit() {

        System.out.println("                 欢迎使用，再见！              ");
        System.out.println("***********************************************");
        System.exit(0);
    }

    public static void main(String[] args) {
        System.out.println("            欢迎进入收银台系统            ");
        start();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.nextLine();
            switch (message.toUpperCase()) {
                case "U":
                    useFunction();
                    start();
                    break;

                case "S":
                    setFunction();
                    start();
                    break;
                case "A":
                    about();
                    start();
                    break;
                case "Q":
                    quit();
                    start();
                    break;
                default:
                    start();
            }

        }


    }
}
