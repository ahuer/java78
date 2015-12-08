package com.points.java7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Java7Additions {

	/*
	 * Garbage-First Collector (G1) 
	 * Whole-heap operations, such as global marking, are performed concurrently with 
	 * the application threads. This prevents interruptions proportional to heap or live-data size.
	 * Applications running today with either the CMS or the Parallel-Old garbage collector 
	 * would benefit switching to G1 if the application has one or more of the following traits:
	 * 
	 * - More than 50% of the Java heap is occupied with live data. 
	 * - The rate of object allocation rate or promotion varies significantly. 
	 * - Undesired long garbage collection or compaction pauses (longer than 0.5 to 1 second)
	 */
	public void newGarbageCollection() {
		// can't really show it working
	}

	/*
	 * Auto-closing Files with Try/Catch 
	 * The try-with-resources statement ensures that each resource is closed 
	 * at the end of the statement. Any object that implements java.lang.AutoCloseable, 
	 * which includes all objects which implement java.io.Closeable, can be used as a resource.
	 */
	public static boolean tryWithResources(String filename) {
		File file = new File(filename);
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file)) ) {
			bufferedReader.readLine();
			FileUtils.touch(file);
		} catch (FileNotFoundException ex) {
			return false;
		} catch (IOException ex) {
			return false;
		}	
		
		return true;
	}
	
	/*
	 * Handling More Than One Type of Exception
	 * Use a pipe to handle more than one exception type at a time
	 */	
	public static boolean catchingMultipleExceptions(String filename) {
		File file = new File(filename);
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file)) ) {
			bufferedReader.readLine();
		} catch (ArrayIndexOutOfBoundsException|IOException ex) {
			return false;
		} 		
		return true;
	}
	
	/*
	 * Switch statement with Strings
	 * In the JDK 7 release, you can use a String object in the expression of a switch statement
	 */
	public static int switchStrings(String input) {
		switch(input) {
			case "first":
				return 1;
			case "second":
				return 2;
			default:
				return 0;
		}
	}

}
