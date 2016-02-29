package com.points.java8;

import java.util.ArrayList;
import java.util.Collections;

public class Java8Additions {
	
	/*
	 * Lambda expressions (otherwise known as closures or anonymous methods)
	 * Lambda expressions can be used where a single-abstract-method interface or class is expected, 
	 * enabling forward compatibility of existing libraries. 
	 */
	public static ArrayList<String> addToListAndLambdaSort(ArrayList<String> list, String newElement) {
			
		if (newElement == null || newElement.isEmpty()) {
			return list;
		}		
		
		list.add(newElement);
		
		Collections.sort(list, (s1, s2) -> { return s1.compareTo(s2); } );
		
		return list;
	}	
	
	
	/* 
	 * Default Interface Methods
	 * The semantics of interfaces in the Java Language have been extended to support virtual extension methods, 
	 * whereby an interface can nominate a static default method to stand in for the implementation of an 
	 * interface method in the event that an implementation class does not provide an implementation of the 
	 * extension method. This enables interfaces to be augmented with new methods "after the fact" without 
	 * breaking existing implementation classes.
	 * 
	 * The lambda form makes use of a new method on the Collection interface called forEach, 
	 * which takes a lambda expression and evaluates it for all the contained elements. 
	 */
	public static ArrayList<Integer> alterListElementsUsingDefaultForEachMethod(ArrayList<Integer> list, int number) {
		if (number < 0 ) {
			return list;
		}
		
		list.forEach(num -> { if (num > number) list.set(list.indexOf(num), 1); else list.set(list.indexOf(num), 0); });
		return list;
	}
	
	
	/*
	 * Streams
	 * Classes in the new java.util.stream package provide a Stream API to support functional-style operations
	 * on streams of elements. The Stream API is integrated into the Collections API, which enables bulk operations 
	 * on collections, such as sequential or parallel map-reduce transformations.
	 */
	public static int streamListStringLengthSum(ArrayList<String> list, char letter) {
		return list.stream()
				.filter(s -> s.charAt(0) == letter)
				.mapToInt(s -> s.length())
				.sum();
	}	
	
}
