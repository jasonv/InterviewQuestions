package com.jasonv.portfolio.interviewquestions;

import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * <p>What is an interface?</p>
 * 
 * It is a contract that requires a class to define certain methods. It is
 * a great way to implement a standard, because it requires a coder to
 * specify all of the required methods. 
 */
public class Question_04_Test extends TestCase {
	/**
	 * If you want to book a hotel stay, you
	 * need a check in and a check out date. These two dates could be required
	 * methods of a Booking interface.
	 * 
	 * A class can adhere to multiple interfaces which can be helpful because a
	 * class can extend from only one parent.
	 */
	public void test_should_hold_different_objects_in_same_list() 
	{
		System.out.println("Question #4: Itinerary Table");
		ArrayList<Booking> itinerary = new ArrayList<Booking>();
		itinerary.add((Booking) new HotelBooking("1/1/2011","1/2/2011",2));
		itinerary.add((Booking) new CarBooking("1/2/2011","1/3/2011","Convertable"));
		itinerary.add((Booking) new HotelBooking("1/3/2011","1/4/2011",2));
		
		System.out.format("%10s %10s   %-20s\n", "Start Date", "End Date", "Class");
		for(Booking booking:itinerary)
		{
			System.out.format("%10s %10s   %-20s\n", 
					booking.getStartDate(),
					booking.getEndDate(), 
					booking.getClass().getSimpleName());
		}
		
		assertEquals(itinerary.size(),3);
		System.out.println("");

	}
	
	interface Booking
	{
		public String getStartDate();
		public String getEndDate();
	}
	
	class HotelBooking implements Booking
	{
		HotelBooking(String startDate,String endDate,int numberOfGuests)
		{
			this.startDate = startDate;
			this.endDate=endDate;
			this.numberOfGuests = numberOfGuests;
		}
		public String startDate;
		public String getStartDate() {
			return startDate;
		}

		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}

		public String getEndDate() {
			return endDate;
		}

		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}

		public String endDate;
		int numberOfGuests = 1;

		public int getNumberOfGuests() {
			return numberOfGuests;
		}

		public void setNumberOfGuests(int numberOfGuests) {
			this.numberOfGuests = numberOfGuests;
		}
	}
	
	class CarBooking implements Booking
	{
		CarBooking(String startDate,String endDate,String typeOfCar)
		{
		this.startDate = startDate;
		this.endDate=endDate;
		this.typeOfCar = typeOfCar;
	}
		public String startDate;
		private String endDate;
		public String getStartDate() {
			return startDate;
		}

		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}

		public String getEndDate() {
			return endDate;
		}

		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}

		public String getTypeOfCar() {
			return typeOfCar;
		}

		public void setTypeOfCar(String typeOfCar) {
			this.typeOfCar = typeOfCar;
		}

		public String typeOfCar="";
	}

}
