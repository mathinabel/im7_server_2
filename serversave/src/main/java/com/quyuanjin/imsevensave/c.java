package com.quyuanjin.imsevensave;

import java.util.Arrays;
public class c {
    public static void main(String[] args) {
        int[] a ={1, 5, 3, 8, 7, 9, 4};
        Arrays.sort(a);   //核心语句

        for (int i=0;i<a.length;i++){ //打印全部
            System.out.print(a[i]+" ");
        }

    }
}
