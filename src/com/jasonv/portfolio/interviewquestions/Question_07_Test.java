package com.jasonv.portfolio.interviewquestions;

import java.util.HashSet;

import junit.framework.TestCase;

/**
 * <p>If you override the .equals method of an object, what must you be careful to
 * always do?</p>
 * 
 * Override the hashCode() method so that it creates a unique code. This will keep hash
 * searches efficient.
 */
public class Question_07_Test extends TestCase {
	HashSet<Item> hashSetWithHashCode = new HashSet<Item>();
	HashSet<Item> hashSetWithoutHashCode = new HashSet<Item>();
	
	public void test_should_be_faster_with_hash() 
	{
		fillHashWithItems(hashSetWithHashCode, true);
		fillHashWithItems(hashSetWithoutHashCode, false);
		long timeWithHashCode = checkForEveryItem(hashSetWithHashCode,true);
		long timeWithoutHashCode = checkForEveryItem(hashSetWithoutHashCode,false);		
		assertEquals(timeWithHashCode<timeWithoutHashCode, true);
		System.out.format("Question #7: Hash access is %d milliseconds faster with a good hashCode on %d items.",
				timeWithoutHashCode-timeWithHashCode,hashSetWithHashCode.size());
	}
	
	
	public void fillHashWithItems(HashSet<Item> hash,boolean setupHashCode)
	{
		String l[] = {"A","B","C","D","E"};
		for(int a=0;a<5;a++)
		{
			for(int b=0;b<5;b++)
			{
				for(int c=0;c<5;c++)
				{
					for(int d=0;d<5;d++)
					{
						for(int e=0;e<5;e++)
						{
							String itemString = l[a]+l[b]+l[c]+l[d]+l[e];
							int hashCode = 0;
							if(setupHashCode) hashCode = (a+1)*100000 + (b+1)*10000 + (c+1)*1000 + (d+1)*100 + (e+1)*10;
							hash.add(new Item(itemString,hashCode));
						}
					}
				}
			}
		}
	}
	
	
	public long checkForEveryItem(HashSet<Item> hash,boolean useHashCode)
	{
		long start = System.nanoTime();    
		String l[] = {"A","B","C","D","E"};
		for(int a=0;a<5;a++)
		{
			for(int b=0;b<5;b++)
			{
				for(int c=0;c<5;c++)
				{
					for(int d=0;d<5;d++)
					{
						for(int e=0;e<5;e++)
						{
							String itemString = l[a]+l[b]+l[c]+l[d]+l[e];
							int hashCode = 0;
							if(useHashCode) hashCode = (a+1)*100000 + (b+1)*10000 + (c+1)*1000 + (d+1)*100 + (e+1)*10;
							if(!hash.contains(new Item(itemString,hashCode)))
							{
								throw new RuntimeException("Item " + itemString + " not found.");
							}
						}
					}
				}
			}
		}
		long elapsedTime = System.nanoTime() - start;
		return elapsedTime/1000000;
	}

	
	class Item
	{
		Item(String value,int hashCode)
		{
			this.value = value;	
			this.hashCode = hashCode;
		}
		String value;
		int hashCode = 0;
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public boolean equals(Object object)
		{
			// Same physical object.
		    if ( this == object ) return true;

		    // Same class
		    if ( !(object instanceof Item) ) return false;
		    Item item = (Item)object;
		    
		    // Same value
		    return value.equals(item.value);
		}
		public int hashCode() 
		{
			return hashCode;
		}
		
		
	}



}
