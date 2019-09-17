package com.example.retrofitdemo;

/**
 * @author Menglingshuai
 * @date 2019-09-17.
 * email：mlsnatalie@163.com
 * description：根据 金山词霸API 的数据格式，创建 接收服务器返回数据 的类：
 */
public class Translation {

    private int status;

    private content content;
    private static class content {
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errNo;
    }

    //定义 输出返回数据 的方法
    public void show() {
        System.out.println(status);

        System.out.println(content.from);
        System.out.println(content.to);
        System.out.println(content.vendor);
        System.out.println(content.out);
        System.out.println(content.errNo);
    }
}
