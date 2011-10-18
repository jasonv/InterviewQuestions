package com.jasonv.portfolio.interviewquestions;

import junit.framework.TestCase;

/**
 * <p>What is the default implementation of the .equals method?</p> 
 * 
 * From the Java documentation for Object:
 * "The equals method for class Object implements the most discriminating 
 * possible equivalence relation on objects; that is, for any non-null 
 * reference values x and y, this method returns true if and only if x and y 
 * refer to the same object (x == y has the value true)."
 */
public class Question_03_Test extends TestCase 
{
	public void test_if_points_to_same_object_should_be_true()
	{
		Object x = new Object();
		Object y = x;
		
		assertEquals(x.equals(y),true);
		assertEquals(x==y,true);
	}

	public void test_if_points_to_differnt_object_should_be_false()
	{
		Object x = new Object();
		Object y = new Object();		
		
		assertEquals(x.equals(y),false);
		assertEquals(x==y,false);		
	}

}
