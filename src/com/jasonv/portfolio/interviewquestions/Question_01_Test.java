package com.jasonv.portfolio.interviewquestions;

import junit.framework.TestCase;

/**
 * What is the difference between the equals operator and the equals-equals operator? 
 */

public class Question_01_Test extends TestCase 
{
	
	// For Primitives
	
	/**
	 * The "=" is the assignment operator.  It sets the variable 
	 * to its left to the value on its right.
	 */
	public void test_single_equals_should_do_assignment()
	{
		int a = 1;
		int b = 2;
		b = a;
		assertEquals(1,b);
	}
	
	/**
	 * The "==" is the equivalence operator. It compares two primitives 
	 * and returns true if they are equal. 
	 */
	public void test_double_equals_should_test_for_equality()
	{
		int a = 1;
		int b = 1;
		assertEquals(a==b,true);
	}
	
	// For Objects
	
	/**
	 * For objects like String, the "=" is used to assign a new object to a variable.
	 */
	public void test_single_equal_should_point_a_variable_to_an_object()
	{
		String a = new String("Hello");
		String b = a;
		
		// Same object...
		assertEquals(a==b,true);	
		
		// Same value...
		assertEquals(a.equals(b),true);	
	}
	
	/**
	 * For objects like String, the "==" checks to see if both strings 
	 * are the same object.
	 */
	public void test_double_equal_should_not_work_for_string_comparison()
	{
		String a = new String("Hello");
		String b = new String("Hello");
		assertEquals(a==b,false);
	}
	

	/**
	 * If you want to compare string values you must use the equals method.
	 */
	public void test_equal_method_should_work_for_string_comparison()
	{
		String a = new String("Hello");
		String b = new String("Hello");
		assertEquals(a.equals(b),true);
		
	}
}
