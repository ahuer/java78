package com.points.java7

import static org.junit.Assert.*
import org.junit.Test

import com.points.java7.Java7Additions

class Java7AdditionsTest {
	private String filepath = "src/test/groovy/com/points/java7/test.txt"
	
	@Test
	public void testTryWithResourcesClosesFile() {
		assertEquals(true, Java7Additions.tryWithResources(filepath))
	}
	
	@Test
	public void testCatchingMultipleExceptions() {
		assertEquals(false, Java7Additions.catchingMultipleExceptions("doesntExist.txt"))
	}
	
	@Test
	public void testSwitchStrings() {
		assertEquals(1, Java7Additions.switchStrings("first"))
		assertEquals(2, Java7Additions.switchStrings("second"))
		assertEquals(0, Java7Additions.switchStrings("banana"))
	}
	
	
}
