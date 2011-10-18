package com.jasonv.portfolio.interviewquestions;

import junit.framework.TestCase;

/**
 * <p>What is recursion?</p>
 * 
 * Recursive programming is when the solution to a problem is defined 
 * in terms of itself.  A function calls itself until it reaches some 
 * terminal state.  
 * 
 */
public class Question_02_Test extends TestCase 
{
	/**
	 * In this case the factorial function calls itself 
	 * until factorial_recursion(1).  As the stack is popped the 
	 * numbers are multiplied.
	 */
	public void test_should_return_correct_factorials()
	{
		assertEquals(factorial_recursion(1),1);
		assertEquals(factorial_recursion(2),2);
		assertEquals(factorial_recursion(3),6);
		assertEquals(factorial_recursion(4),24);
	}

	static int factorial_recursion(int number) 
	{
		if (number <= 1) 
		{
			return 1;
		} 
		else
		{
			return number * factorial_recursion(number-1);
		}
	}
	
	/**
	 * Recursion can lead to stack overflow, so here is a loop-based solution.
	 */
	public void test_should_return_correct_factorials_using_a_loop()
	{
		assertEquals(factorial_recursion(1),1);
		assertEquals(factorial_recursion(2),2);
		assertEquals(factorial_recursion(3),6);
		assertEquals(factorial_recursion(4),24);
	}
	
	static int factorial_loop(int number) 
	{
		int result = 1;
		for(int i=number;i<=1;i--)
		{
			result = result * i;
		}
		return result;
	}
	
}
