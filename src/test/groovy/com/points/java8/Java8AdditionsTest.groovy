package com.points.java8

import static org.junit.Assert.*
import org.junit.Test

import com.points.java8.Java8Additions

class Java8AdditionsTest {

	@Test
	public void testAddToListAndLambdaSort() {
		def list = ["cat", "banana"]
		def expectedResult = ["apple", "banana", "cat"]
		assertEquals(expectedResult, Java8Additions.addToListAndLambdaSort(list, "apple"))
	}
	
	@Test
	public void testAlterListElementsUsingDefaultForEachMethod() {
		def list = [1, 2, 3, 4, 5, 6, 7, 8]
		def expectedResult = [0, 0, 0, 1, 1, 1, 1, 1]
		assertEquals(expectedResult, Java8Additions.alterListElementsUsingDefaultForEachMethod(list, 3))
	}
	
	@Test
	public void testStreamListStringLengthSum() {
		def list = ["apple", "aardvark"]
		def expectedResult = 13
		assertEquals(expectedResult, Java8Additions.streamListStringLengthSum(list, 'a' as char))
	}
	
	@Test
	public void testStreamNoWordsFound() {
		def list = ["bapple", "baardvark"]
		def expectedResult = 0
		assertEquals(expectedResult, Java8Additions.streamListStringLengthSum(list, 'a' as char))
	}
}
