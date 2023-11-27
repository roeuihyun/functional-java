package com.functional.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import com.functional.java.model.Car;
import com.functional.java.model.Sedan;
import com.functional.java.model.Suv;
import com.functional.java.model.OldUser;
import com.functional.java.model.Van;

public class MethodReferenceSection3 {

	public static void main(String[] args) {
		// 1. ClassName::staticMethodName
		// 클래스의 static method를 지정할 때
		// 2. objectName::instanceMethodName
		// 선언된 객체의 instance method를 지정할 때
		// 3. ClassName::instanceMethodName
		// 객체의 instance method를 지정할 때
		// 4. ClassName::new
		// 클래스의 constructor를 지정할 때
		OldUser OldUser1 = new OldUser(1,"Alice");
		System.out.println(OldUser1);
		BiFunction<Integer,String,OldUser> OldUserCreator = OldUser::new;
		OldUser OldUser3 = OldUserCreator.apply(3, "Bob");
		System.out.println(OldUser3);
		
		String[][] inputs = new String[][] {
			{"Sedan","Sonata","Hyundai"}
			,{"Sedan","Model S","Tesla"}
			,{"Suv","Sorento","KIA"}
			,{"Van","Sienna","Toyota"}
		};
		
		Map<String,BiFunction<String,String,Car>> carTypeToConstructorMap = new HashMap<String,BiFunction<String,String,Car>>();
		carTypeToConstructorMap.put("Sedan", Sedan::new);
		carTypeToConstructorMap.put("Suv", Suv::new);
		carTypeToConstructorMap.put("Van", Van::new);
		
		List<Car> cars = new ArrayList<Car>();
		for(int i = 0; i < inputs.length; i ++) {
			String[] input = inputs[i];
			String carType = input[0];
			String carName = input[1];
			String carBrand = input[2];
			cars.add(carTypeToConstructorMap.get(carType).apply(carName, carBrand));
		}
		
		System.out.println("List<Car> : " + cars);
		
		for(Car car : cars) {
			System.out.println("List<Car> Loop For : " + car);
		}

	}
	
}
