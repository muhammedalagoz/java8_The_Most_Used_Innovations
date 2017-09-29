package com.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SimpleStreamAPI {
	public static void main(String[] args) {

		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 1, 1, 1);

		// **** forEach
		integers.forEach(System.out::println);

		System.out.println("*******--------------*********");

		// **** filter
		List<Integer> ones = integers.stream().filter(i -> i.equals(1)).collect(Collectors.toList());
		ones.forEach(System.out::println);

		System.out.println("*******--------------*********");

		Stream<Integer> stream = integers.stream();
		int sum = stream.mapToInt(i -> i).sum();
		double avarage = stream.mapToInt(i -> i).average().getAsDouble();
		int max = stream.max(Integer::compare).get();
		int min = stream.min(Integer::compare).get();

		System.out.println("toplam: "+sum);
		System.out.println("ort: "+avarage);
		System.out.println("max: "+max);
		System.out.println("min: "+min);

		System.out.println("*******--------------*********");
		
		// **** distinct
		List<Integer> distincts = stream.distinct().collect(Collectors.toList());
		distincts.forEach(System.out::println);

		System.out.println("*******--------------*********");
		
		// ***** count
		long count = integers.stream().filter(i -> i.equals(1)).count();
		System.out.println("Birlerin Sayısı: " + count);

		System.out.println("*******--------------*********");
		
		List<Integer> squareDstinct = stream.map(i -> i*i).distinct().collect(Collectors.toList());
		squareDstinct.forEach(System.out::println);

		System.out.println("*******--------------*********");
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return true;
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		
//		filter:  d2
//		forEach: d2
//		filter:  a2
//		forEach: a2	
//		filter:  b1
//		forEach: b1
//		filter:  b3
//		forEach: b3
//		filter:  c
//		forEach: c

		System.out.println("*******--------------*********");
		
		Stream.of("d2", "a2", "b1", "b3", "c").map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).filter(s -> {
			System.out.println("filter: " + s);
			return s.startsWith("A");
		}).forEach(s -> System.out.println("forEach: " + s));

	// map:     d2
	// filter:  D2
	// map:     a2
	// filter:  A2
	// forEach: A2
	// map:     b1
	// filter:  B1
	// map:     b3
	// filter:  B3
	// map:     c
	// filter:  C

		System.out.println("*******--------------*********");
		
		int result = IntStream.of(1, 2, 3, 4, 5).reduce(0, (prev, next) -> {
					System.out.format("%d - %d %n", prev, next);
					return prev + next;
				});

		System.out.println("*******--------------*********");
		
	}
}
