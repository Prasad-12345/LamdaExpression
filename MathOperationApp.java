package com.bridgelabz.lamdaexpression;
/*
 *Author: Prasad
 * Develop Math Operation App to perform Math Functions– Addition,Subtraction and Division
 */

//Function interface 
@FunctionalInterface
interface IMathFunction {
    int calculate(int a, int b);
}
public class MathOperationApp {
    public static void main(String[] args) {
        //Addition
        IMathFunction add = Integer::sum;
        //substraction
        IMathFunction substract = (a, b)->(a -b);
        //Divison
        IMathFunction division = (a, b)->(a/b);
        //Multipication
        IMathFunction multiply = (a, b)->(a * b);

        //Invoking lamda expression with functional interface and printing return values
        System.out.println("Additon: " + add.calculate(10,5));
        System.out.println("Substraction: " + substract.calculate(10,5));
        System.out.println("Division: " + division.calculate(10,5));
        System.out.println("Multipication: " + multiply.calculate(10,5));
    }
}
