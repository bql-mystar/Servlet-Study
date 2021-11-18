package com.xie.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        // 创建真是对象
        Lemovo lemovo = new Lemovo();
        // 动态代理增强对象
        /**
         * 1、类加载器：真实对象.getClass().getClassLoader()
         * 2、接口数组：真实对象.getClass()..getInterfaces()
         * 3、处理器：new InvocationHandler()
         */
        SaleComputer proxyLemovo = (SaleComputer) Proxy.newProxyInstance(lemovo.getClass().getClassLoader(), lemovo.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 代理逻辑编写的方法：代理对象调用的所有方法都会触发该方法执行
             * @param proxy 代理对象
             * @param method 代理对象调用的方法，被封装为的对象
             * @param args 代理对象调用方法时，传递的实际参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("执行了代理对象");
//                System.out.println(method);
//                System.out.println(args[0]);

                // 增强参数
                if (method.getName().equals("sale")){
                    // 1、参数增强
                    double money = (double) args[0];
                    money = money * 0.85;
                    // 使用真是对象调用方法
                    String obj = (String) method.invoke(lemovo, money);
                    // 3、返回值增强
                    return obj + "_鼠标垫";
                }else {
                    Object obj = method.invoke(lemovo, args);
                    return obj;
                }


            }
        });

        String sale = proxyLemovo.sale(8000);
        System.out.println(sale);
//        proxyLemovo.show();

    }
}
