package com.bridgelabz.lamdaexpression;
/*
 *Author: Prasad
 * Ability to show the results of Math Operation of Addition,Subtraction and Division
 */

//Function interface 
@FunctionalInterface
interface IMathFunction {
    int calculate(int a, int b);
    static void printResult(int a, int b, String function, IMathFunction obj){
        System.out.println("The result of" + " " + function + " " + "is" + " " + obj.calculate(a, b));
    }
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

        //calling static function 
        IMathFunction.printResult(10, 5, "Addition", add);
        IMathFunction.printResult(10, 5, "Substraction", substract);
        IMathFunction.printResult(10, 5, "Division", division);
        IMathFunction.printResult(10, 5, "Multipication", multiply);
    }
}
