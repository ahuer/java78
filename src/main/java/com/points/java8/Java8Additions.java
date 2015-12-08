package com.points.java8;

import java.util.ArrayList;

public class Java8Additions {
	
	/*
	 * Lambda expressions (otherwise known as closures or anonymous methods)
	 * Lambda expressions can be used where a single-abstract-method interface or class is expected, 
	 * enabling forward compatibility of existing libraries. 
	 */
	public ArrayList<String> addToListAndLambdaSort(ArrayList<String> list, String newElement) {
		list.add(newElement);
		list.sortBy({String s -> s.length()})
	}
	
	
	
	/* 
	 * Default Interface Methods
	 * The semantics of interfaces in the Java Language have been extended to support virtual extension methods, 
	 * whereby an interface can nominate a static default method to stand in for the implementation of an 
	 * interface method in the event that an implementation class does not provide an implementation of the 
	 * extension method. This enables interfaces to be augmented with new methods "after the fact" without 
	 * breaking existing implementation classes.
	 */
}
