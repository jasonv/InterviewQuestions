package com.jasonv.portfolio.interviewquestions;

import junit.framework.TestCase;

/**
 * <p>How do you define an Exception that doesn't have to be explicitly caught?</p>
 * 
 * Extend the exception from RuntimeException.
 */
public class Question_08_Test extends TestCase 
{
	/**
	 * This class extends RuntimeException.
	 */
	class ExampleRuntimeException extends RuntimeException
	{
		private static final long serialVersionUID = 1L;
		public ExampleRuntimeException(String message) 
		{
			super(message);
		}
	}

	
	/**
	 * This method has no "throws" keyword.
	 * If it was a regular exception, "throws" would be required.
	 */
	public void f(boolean throwException)
	{
		if(throwException)
		{
			throw new ExampleRuntimeException("Exception");
		}
	}

	
	/**
	 * An exception can be thrown from the f() function but 
	 * it does not need to be caught.
	 */
	public void test_should_call_function_without_try_catch_or_throws()
	{
		f(false);		
	}

	/**
	 * If an exception is thrown, we catch it so that
	 * the test case will not break.
	 */
	public void test_should_pass_exception_without_throws_keyword()
	{
		String message = "";
		try
		{
			f(true);			
		}
		catch(ExampleRuntimeException ere)
		{
			message = ere.getMessage();
		}
		assertEquals("Exception",message);
	}
	
	
	
}
