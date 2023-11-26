package com.functional.java;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerSection1 {

	public static void main(String[] args) {
		
		Consumer<String> myStringConsumer = str -> System.out.println(str);
		myStringConsumer.accept("hello");
		myStringConsumer.accept("world");
		
		List<Integer> integerInputs = Arrays.asList(4,3,2,1);
		Consumer<Integer> myIntegerProcessor = x -> System.out.println("myIntegerProcessor : " +x);
		process(integerInputs,myIntegerProcessor);
		
		Consumer<Integer> myDifferentIntegerProcessor = x -> System.out.println("myDifferentIntegerProcessor : " + (x + x));
		process(integerInputs,myDifferentIntegerProcessor);
		
		List<Double> doubleInputs = Arrays.asList(4.4,3.3,2.2,1.1);
		Consumer<Double> myDoubleProcessor = x -> System.out.println("myDoubleProcessor : " + (x));
		process(doubleInputs,myDoubleProcessor);

	}
	
	private static <T> void process(List<T> inputs, Consumer<T> processor) {
		
		for(T input : inputs) {
			processor.accept(input);
		}
		
	}

}
