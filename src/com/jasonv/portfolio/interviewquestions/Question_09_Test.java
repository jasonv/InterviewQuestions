package com.jasonv.portfolio.interviewquestions;

import java.util.ArrayList;
import java.util.HashSet;

import junit.framework.TestCase;

/**
 * <p>What is the difference between a Set and a List, and what advantages does one
 * have over the other?</p>
 * 
 * A Set is unordered and duplicates are not allowed. A List is ordered and
 * duplicates are allowed. One is not better than the other. It all depends
 * on the problem. Use the best one for the problem.
 */
public class Question_09_Test extends TestCase 
{
	private ArrayList<String> list = new ArrayList<String>();
	private HashSet<String> set = new HashSet<String>();
	
	/**
	 * Setup a simple List and Set.
	 */
	public Question_09_Test()
	{
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("A");
		
		set.add("X"); 
		set.add("Y"); 
		set.add("Z"); 
		set.add("X"); 
	}
	
	public void test_should_be_ordered() 
	{
		String result = "";
		for(String item:list)
		{
			result+=item;
		}
		assertEquals("ABCA",result);
	}

	public void test_should_preserve_duplicates() 
	{
		String result = "";
		for(String item:list)
		{
			result+=item;
		}
		assertEquals("ABCA",result);
		assertEquals(result.length(),4);
	}
	
	public void test_might_be_unordered_should_be_not_duplicates() 
	{
		String result = "";
		for(String item:set)
		{
			result+=item;
		}
		
		// Each character found is in the Set.
		assertTrue(result.contains("X"));
		assertTrue(result.contains("Y"));
		assertTrue(result.contains("Z"));
		
		// Length is 3 because the duplicate "X" is removed.
		assertEquals(result.length(),3);
	}
	


}
