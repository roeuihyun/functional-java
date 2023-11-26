package com.functional.java;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerSection1 {

	public static void main(String[] args) {
		
		List<Double> doubleInputs = Arrays.asList(1.1,2.2,3.3,4.4);
		BiConsumer<Integer,Double> myBiConsumer = 
				(index,input)->System.out.println("myBiConsumer processing index : " + index + " , input : " + input);
		process(doubleInputs,myBiConsumer);

	}
	
	private static <T> void process(List<T> inputs, BiConsumer<Integer, T> processor) {
		
		for(int i = 0 ; i< inputs.size(); i ++) {
			processor.accept(i,inputs.get(i));
		}
		
	}

}
