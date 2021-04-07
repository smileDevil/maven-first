package com.jyb.jdbc.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/***
 * 理解函数式编程
 * Predicate函数式接口使用方法
 */
public class PredicateSample {
    public static void main(String[] args) {
        Predicate<Integer> predicate = n -> n>4;
        boolean result = predicate.test(5);
        //System.out.println( result);
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        filter(list,n->n%2 == 0);
    }
    public static void filter(List<Integer>list , Predicate<Integer> predicate){
        for(Integer num : list){
            if(predicate.test(num)){
                System.out.println(num+" ");
            }
        }
    }
}
