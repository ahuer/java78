package com.points.java7

import static org.junit.Assert.*
import org.junit.Test

import com.points.java7.Java7Additions

class Java7AdditionsTest {
	private String filepath = "src/test/groovy/com/points/java7/test.txt"
	@Test
	public void testTryWithResourcesClosesFile() {
		def java7 = new Java7Additions()
		assertEquals(5, java7.tryWithResources(filepath))
	}
}
