package com.jasonv.portfolio.interviewquestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

/**
 * <p>What is the difference between an ArrayList and a LinkedList, and what
 * advantages does one have over the other?</p>
 * 
 * * Let's say we are dealing with large lists.  If the lists are small, the
 * performance will be very similar.
 * 
 * The ArrayList is good for items that need random access and no insertion.
 * Random access lets you specify the index and the address can be found with
 * basic math because most of the addresses in the array are next to each
 * other in memory.
 * 
 * Insertions require a shift; that can be expensive.
 * 
 * The LinkedList is good for a List that needs insertion and does not need
 * random access. Insertion is easy because the pointers can be changed to add
 * the new object to the chain. Random access is slower because the chain of
 * pointers needs to be traversed to find the right item.
 * 
 */
public class Question_10_Test extends TestCase {

    public void test_should_take_less_time_to_append_to_linked_list()
    {
    	ArrayList<String> arrayList = new ArrayList<String>();
    	LinkedList<String> linkedList = new LinkedList<String>();
    	int numberOfItems = 10000;

    	long timeArrayList = add_items(arrayList,numberOfItems);
		long timeLinkedList = add_items(linkedList,numberOfItems);
		assertEquals(timeArrayList>timeLinkedList, true);
		System.out.format("Question #10: Linked list takes %d less milliseconds to append %d items.\n",
				timeArrayList-timeLinkedList,numberOfItems);
    }

    public void test_should_take_less_time_to_do_randomly_access_array_list()
    {
    	int numberOfItems = 10000;
    	
    	ArrayList<String> arrayList = new ArrayList<String>();
    	LinkedList<String> linkedList = new LinkedList<String>();
    	
    	add_items(arrayList,numberOfItems);
    	add_items(linkedList,numberOfItems);
    	
		long timeArrayList = random_access_items(arrayList,numberOfItems);
		long timeLinkedList = random_access_items(linkedList,numberOfItems);
		assertEquals(timeArrayList<timeLinkedList, true);
		System.out.format("Question #10: Array list takes %d less milliseconds to randomly access %d items.\n",
				timeLinkedList-timeArrayList,numberOfItems);
    }
    
    public void test_should_take_less_time_to_traverse_elements_in_array_list()
    {
    	int numberOfItems = 500000;
    	
    	ArrayList<String> arrayList = new ArrayList<String>();
    	LinkedList<String> linkedList = new LinkedList<String>();
    	
    	add_items(arrayList,numberOfItems);
    	add_items(linkedList,numberOfItems);
    	
		long timeArrayList = traverse_items(arrayList);
		long timeLinkedList = traverse_items(linkedList);
		assertEquals(timeArrayList<timeLinkedList, true);
		System.out.format("Question #10: Array list takes %d less milliseconds to traverse %d items.\n",
				timeLinkedList-timeArrayList,numberOfItems);
    }

	public long add_items(List<String> list,int numberOfItems)
	{
		long start = System.nanoTime();    
		for(int i=0;i<numberOfItems;i++)
		{
			list.add(new String(""+i));
		}
		long elapsedTime = System.nanoTime() - start;
		return elapsedTime/1000000;
	}
	
	public long random_access_items(List<String> list,int numberOfItems)
	{
		long start = System.nanoTime();    
		for(int i=0;i<numberOfItems;i++)
		{
			list.get(i/2);
		}
		long elapsedTime = System.nanoTime() - start;
		return elapsedTime/1000000;
	}

	public long traverse_items(List<String> list)
	{
		long start = System.nanoTime();    
		for(String item:list) 
		{
			item.length();
		}
		long elapsedTime = System.nanoTime() - start;
		return elapsedTime/1000000;
	}

}
