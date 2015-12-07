package com.points.java7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Java7Additions {

	/*
	 * Garbage-First Collector (G1) Whole-heap operations, such as global
	 * marking, are performed concurrently with the application threads. This
	 * prevents interruptions proportional to heap or live-data size.
	 * Applications running today with either the CMS or the Parallel-Old
	 * garbage collector would benefit switching to G1 if the application has
	 * one or more of the following traits:
	 * 
	 * - More than 50% of the Java heap is occupied with live data. - The rate
	 * of object allocation rate or promotion varies significantly. - Undesired
	 * long garbage collection or compaction pauses (longer than 0.5 to 1
	 * second)
	 */
	public void newGarbageCollection() {
		// can't really show it working
	}

	/*
	 * Auto-closing Files with Try/Catch The try-with-resources statement
	 * ensures that each resource is closed at the end of the statement. Any
	 * object that implements java.lang.AutoCloseable, which includes all
	 * objects which implement java.io.Closeable, can be used as a resource.
	 */
	public int tryWithResources(String filename) throws FileNotFoundException, IOException {
		BufferedReader testReader =  new BufferedReader(new FileReader(new File(filename)));
		testReader.close();
		testReader.close();
		
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filename))) ) {
			bufferedReader.readLine();
			testReader = bufferedReader;
		} catch (FileNotFoundException ex) {
			return 3;
		} catch (IOException ex) {
			return 4;
		} finally {
			try {
			testReader.close();
			} catch (Exception ex) {
				return 6;
			}
		}
		return 5;
	}

}
