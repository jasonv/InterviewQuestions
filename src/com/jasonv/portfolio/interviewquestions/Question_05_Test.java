package com.jasonv.portfolio.interviewquestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;

import junit.framework.TestCase;

/**
 * <p>What is an Iterator?</p>
 * 
 * An object used to step through a List. 
 * List and Set objects support this. 
 */
public class Question_05_Test extends TestCase {
	private ArrayList<String> list = new ArrayList<String>();
	private HashSet<String> set = new HashSet<String>();
	
	/**
	 * Setup a simple List and Set.
	 */
	public Question_05_Test()
	{
		list.add("A");
		list.add("B");
		list.add("C");
		
		set.add("X"); 
		set.add("Y"); 
		set.add("Z"); 
	}
	
	
	public void test_should_step_through_list_in_order() 
	{
		String result = "";
		ListIterator<String> listIterator = list.listIterator();
		while(listIterator.hasNext())
		{
			String item = listIterator.next();
			result+=item;
		}		
		assertEquals("ABC",result);
	}

	public void test_should_step_through_list_in_reverse() 
	{
		String result = "";
		ListIterator<String> listIterator = list.listIterator(list.size());
		while(listIterator.hasPrevious())
		{
			String item = listIterator.previous();
			result+=item;
		}		
		assertEquals("CBA",result);
	}
	
	public void test_should_step_through_each_element_in_any_order() 
	{
		String result = "";
		Iterator<String> setIterator = set.iterator();
		while(setIterator.hasNext())
		{
			String item = setIterator.next();
			result+=item;
		}		
		assertTrue(result.contains("X"));
		assertTrue(result.contains("Y"));
		assertTrue(result.contains("Z"));
		assertTrue(result.length()==3);
	}
}
