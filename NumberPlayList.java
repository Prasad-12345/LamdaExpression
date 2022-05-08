package com.bridgelabz.lamdaexpression;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
 *Author: Prasad
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
            System.out.println("Mth4: forEach lambda impl value" + n);
        };
        numberList.forEach(myListAction);

        //Meththod 5:Implicit lamda function
        numberList.forEach(n->{
            System.out.println("Mth5: forEach lambda impl value: " + n);
        });

        //Method 6: Implicit lamda function to print double value
        Function<Integer, Double> function = Integer::doubleValue;
        numberList.forEach( n-> {
            System.out.println("Mth6: forEach lambda double value: " + function.apply(n));
        });

        //Method7: Implicit lamda function to chech even
        Predicate<Integer> isEven = n -> (n % 2 == 0);
        numberList.forEach(n ->{
         //   System.out.println("Mth7: forEach lambda even number: " + isEven.test(n));
            if(isEven.test(n)){
                System.out.println("Mth7: forEach lambda even number: " + n);
            }
        });

        //Method8: Processing the stream
        numberList.stream().forEach(n -> {
            System.out.println("Mth8: Stream forEachValue: " + n);
        });

        //Method9: Process the stream apply operation on the stream and store the result
        List<Double> streamList = numberList.stream().filter(isEven).map(function).collect(Collectors.toList());
        System.out.println("Mth9: Printing double list: " + streamList);

        //Method10: To peek first even number
        Integer firstEvenNumber = numberList.stream().filter(isEven).peek(n -> System.out.println("Peek even number: " + n)).findFirst().orElse(null);
        System.out.println("Mth10: First even: " + firstEvenNumber);

        //Method11: Minimun even number
        Integer min = numberList.stream().filter(isEven).min(Integer::compare).orElse(null);
        System.out.println("Mth11:  Min even: " + min);

        //Method12: Maximum even number
        Integer max = numberList.stream().filter(isEven).max(Comparator.comparing(Integer::intValue)).orElse(null);
        System.out.println("Mth12: Max Even: " + max);

        //Method13: Sum, Count and Average of numbers
        Integer sum = numberList.stream().reduce(0, Integer::sum);
        Long count = numberList.stream().count();
        System.out.println("Mth13: Avg of " + sum +"/"+count+"="+sum/count);
    }
}
