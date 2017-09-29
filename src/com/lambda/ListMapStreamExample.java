package com.lambda;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListMapStreamExample {
	public static void main(String[] args) {
		
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(678, "Ann", "Lee", LocalDate.of(2007, Month.APRIL, 12), new BigDecimal(2000)));
        persons.add(new Person(123, "Jack", "Johnson", LocalDate.now(), new BigDecimal(3000)));
        persons.add(new Person(345, "Cindy", "Node", LocalDate.of(2011, Month.DECEMBER, 15), new BigDecimal(3000)));
        persons.add(new Person(567, "Perry", "Node", LocalDate.of(2005, Month.JUNE, 07), new BigDecimal(2000)));
        persons.add(new Person(467, "Pam", "Krauss", LocalDate.of(2005, Month.JUNE, 07), new BigDecimal(2500)));
        persons.add(new Person(435, "Fred", "Shak", LocalDate.of(1988, Month.APRIL, 17), new BigDecimal(5000)));
		
        //****** Sort
        persons.stream()
        		.sorted((e1, e2) -> Integer.compare(e1.getNumber(),e2.getNumber()))
        		.forEach(e -> System.out.println(e));

		System.out.println("*******--------------*********");
		
        //****** Person Name List
        persons.stream().map(Person::getFirstName).collect(Collectors.toList())
        				.forEach(e -> System.out.println(e));

		System.out.println("*******--------------*********");
		
        //****** Person Id List
        persons.stream().map(Person::getNumber).collect(Collectors.toList())
        				.forEach(e -> System.out.println(e));

		System.out.println("*******--------------*********");
		
        //****** Person Id Map create
        List<Person> lastNameNodes =persons.stream().filter(e -> "Node".equals(e.getLastName())).collect(Collectors.toList());//LastName = "Node"
        Map<Integer, List<Person>> map = lastNameNodes.stream().collect(Collectors.groupingBy(Person::getNumber));//map create
        
        map.forEach((k,v) -> System.out.println("key: "+k+" value: "+v));//Map out with lambda

		System.out.println("*******--------------*********");
        
		Map<Integer, List<Person>> personMap = persons.stream().collect(Collectors.groupingBy(Person::getNumber));
		personMap.forEach((k,v) -> System.out.println("key: "+k+" value: "+v));//Map out with lambda
		
		System.out.println("*******--------------*********");
		
		List<Person> orDefault = personMap.getOrDefault(678, new ArrayList<Person>());
        orDefault.forEach(System.out::println);//678 in personMap
        
		System.out.println("*******--------------*********");
		
		Map<BigDecimal, List<Person>> salarysPersonGroping = persons.stream().collect(Collectors.groupingBy(Person::getSalary));
		salarysPersonGroping.forEach((k,v) -> System.out.println("key: "+k+" value: "+v));
        
		System.out.println("*******--------------*********");

		Map<BigDecimal, Person> salaryOneToOnePersonMap = persons.stream().collect(Collectors.toMap(Person::getSalary, p -> p));
		salaryOneToOnePersonMap.forEach((k,v) -> System.out.println("key: "+k+" value: "+v));
		
		System.out.println("*******--------------*********");
		
		String phrase = persons
			    .stream()
			    .filter(p -> p.getNumber() > 450)
			    .map(p -> p.getFirstName())
			    .collect(Collectors.joining(" and ", "Persons ", " are of legal number."));
		System.out.println(phrase);
		
		System.out.println("*******--------------*********");
		
		Comparator<Person> byBirthdate = (p1, p2) -> p1.getDate().compareTo(p2.getDate());
		List<Person> sortedList = persons.stream().sorted(byBirthdate).collect(Collectors.toList());
		sortedList.forEach(System.out::println);//sorted list by Birthdate
		
		System.out.println("*******--------------*********");
		
		
		
	}
}
