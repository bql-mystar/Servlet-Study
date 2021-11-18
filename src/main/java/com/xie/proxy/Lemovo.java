package com.xie.proxy;

public class Lemovo implements SaleComputer{
    @Override
    public String sale(double money) {
        System.out.println("sale computer " + money);
        return "lemovo";
    }

    @Override
    public void show() {
        System.out.println("show......");
    }
}
