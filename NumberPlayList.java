package com.bridgelabz.lamdaexpression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
/*
 *Author: Prasad
 *Create a Number Play List and Iterate and print each element
 */
public class NumberPlayList<i> {
    public static void main(String[] args) {
        //creating array list and adding elements in list
        List<Integer> numberList = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            numberList.add(i);
        }

        //Method1: Traversing using iterator
        Iterator<Integer> iterator = numberList.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + ",");
        }

        //Method 2: Traversing with explicit consumer interface implementation
        class MyConsumer implements Consumer<Integer>{
            public void accept(Integer t){
                System.out.println("Mth2: consumer implement value: " + t);
            }
        }
        MyConsumer action = new MyConsumer();
        numberList.forEach(action);

        //Method 3: Traversing with anonymous consumer interface implementation
        numberList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("Mth3: forEach anonymous class value" + integer);
            }
        });

        //Method 4: Explicit lamda function
        Consumer<Integer> myListAction = n->{
            System.out.println("Mth4: forEach lamda impl value" + n);
        };
        numberList.forEach(myListAction);

        //Meththod 5:Implicit lamda function
        numberList.forEach(n->{
            System.out.println("Mth5: forEach lamda impl value: " + n);
        });
    }
}
