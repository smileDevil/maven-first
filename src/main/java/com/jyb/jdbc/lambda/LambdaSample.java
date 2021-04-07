package com.jyb.jdbc.lambda;

public class LambdaSample {
    public static void main(String[] args) {
        //标准lambda、
        //lambda 表达式只能实现有且只有一个抽象方法的接口， java称之为 函数式接口
        MathOperation addition = (Integer a, Integer b) -> {
          return  a + b + 0f;
        };
        System.out.println( addition.operate(5,4));

        //lambda2允许忽略参数
        MathOperation substraction = (a,b)->{
            return  a - b + 0f;
        };
        System.out.println( substraction.operate(5,4));

        // 对于单行实现代码可以省略 {} 和 return
        MathOperation multiplication = (a,b)->a*b+0f;
        System.out.println(multiplication.operate(5,4));

//        Addition additon2 = new Addition();
//        System.out.println( additon2.operate(5,4));
    }
}

class Addition implements  MathOperation {
    @Override
    public Float operate(Integer a, Integer b) {
        return a + b + 0f;
    }
}