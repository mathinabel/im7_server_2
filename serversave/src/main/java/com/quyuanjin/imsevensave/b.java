package com.quyuanjin.imsevensave;

import java.util.Random;

public class b {
    public static void main(String[] args) {
        Random r = new Random(1);
        int ran1 = r.nextInt(100);//100是生成的随机数的范围
        System.out.println(ran1);
    }
}
