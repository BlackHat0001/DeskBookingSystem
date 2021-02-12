package com.server;

import java.util.ArrayList;

public class Utils {
	
	public static ArrayList<Booking> sort(ArrayList<Booking> sortArray) {
		//Driver method for the merge sort. Calls the merge sort on the booking arraylist parameter and returns a sorted arraylist
		MergeSort ms = new MergeSort();
		//Call the mergsort
		ms.sort(sortArray);
		return sortArray;
	}
	
	public static Booking search(ArrayList<Booking> searchArray, Booking criteria) {
		//Driver method for the binary search. Calls search on a booking search array to search for a date with a given criteria
		//If no result was found then returns a booking with id -1 that is displayed with no data on the admin panel
		
		BinarySearch bs = new BinarySearch();
		int index = -1;
		try {
			//call search
		index = bs.search(searchArray, criteria);
		} catch (Exception e) {
			index = -1;
		}
		//If the result is -1 then the data was not found
		if(index == -1) {
			return new Booking(-1, 0, 0, null, 0, 0);
		}
		//Return the booking that was found
		return searchArray.get(index);
	}
	
}

class MergeSort {
	
	public void sort(ArrayList<Booking> dates) {
		//The dates array must have at least 2 items for it to sort
		if(1 < dates.size()) {
			//Define subarrays
			ArrayList<Booking> splitArray1 = new ArrayList<Booking>();
			ArrayList<Booking> splitArray2 = new ArrayList<Booking>();
			//calculate the mid point of the arraylist
			int mp = dates.size() / 2;
			//Split the left side of the mid point into splitArray1
			splitArray1.addAll(dates.subList(0, mp));
			//Split the right side of the mid point into splitArray2
			splitArray2.addAll(dates.subList(mp, dates.size()));
			//Recursively sort the sub arrays
			sort(splitArray1);
			sort(splitArray2);
			//merge the arraylists together back into dates
			merge(dates, splitArray1, splitArray2);
			
		}
		
	}
	
	public void merge(ArrayList<Booking> datesSorted, ArrayList<Booking> splitArray1, ArrayList<Booking> splitArray2) {
		//Sort the subarrays and merge them in order back into datesSorted
		//Define the indexes of the pointers
		int splitArrayIndex1 = 0;
		int splitArrayIndex2 = 0;
		int datesSortedIndex = 0;
		//Repeat until all elements in the arrays are sorted and merged into datesSorted in order
		while (splitArrayIndex1 < splitArray1.size() && splitArrayIndex2 < splitArray2.size()) {
			//Compare the first date to the second date. As dates are in newest -> oldest, same as date1 > date2
			if(compareDates(splitArray1.get(splitArrayIndex1).getDate(), splitArray2.get(splitArrayIndex2).getDate())) {
				datesSorted.set(datesSortedIndex, splitArray1.get(splitArrayIndex1));
				splitArrayIndex1++;
			} else {
				datesSorted.set(datesSortedIndex, splitArray2.get(splitArrayIndex2));
				splitArrayIndex2++;
			}
			datesSortedIndex++;
		}
		//Add all elements left in splitArray1 to datesSorted
		while (splitArrayIndex1 < splitArray1.size()) {
			datesSorted.set(datesSortedIndex, splitArray1.get(splitArrayIndex1));
			splitArrayIndex1++;
			datesSortedIndex++;
		}
		//Add all elements left in splitArray2 to datesSorted
		while (splitArrayIndex2 < splitArray2.size()) {
			datesSorted.set(datesSortedIndex, splitArray2.get(splitArrayIndex2));
			splitArrayIndex2++;
			datesSortedIndex++;
		}
	}
	
	public boolean compareDates(String date1, String date2) {
		//Custom comparator for comparing dates
		//Get the year as a number from the date strings
		int dateYear1 = Integer.parseInt(date1.substring(0, 4));
		int dateYear2 = Integer.parseInt(date2.substring(0, 4));
		//if year of date1 is bigger than year of date2, then date 1 is newer than date 2
		if(dateYear1 > dateYear2) {
			return true;
		} else if(dateYear1 < dateYear2) {
			return false;
		} else {
			//Get the month as a number from the date strings
			int dateMonth1 = Integer.parseInt(date1.substring(5, 7));
			int dateMonth2 = Integer.parseInt(date2.substring(5, 7));
			//if month of date1 is bigger than month of date2, then date 1 is newer than date 2 as the years are the same
			if(dateMonth1 > dateMonth2) {
				return true;
			} else if(dateMonth1 < dateMonth2) {
				return false;
			} else {
				//Get the day as a number from the date strings
				int dateDay1 = Integer.parseInt(date1.substring(8, 10));
				int dateDay2 = Integer.parseInt(date2.substring(8, 10));
				//if day of date1 is bigger than day of date2, then date 1 is newer than date 2 as the years and months are the same 
				if(dateDay1 > dateDay2) {
					return true;
				} else if(dateDay1 < dateDay2) {
					return false;
				}
			}
			
		}
		return true;
	}
	
}

class BinarySearch {
	
	public int search(ArrayList<Booking> searchArray, Booking criteria) {
		//Recursive binary search algorithm until data is found or the end of the array is encountered
		//in which case -1 is returned
		try {
		//In order for there to be search then the array to search must have more than 1 item
		if(searchArray.size() >=1) {
			//Get the midpoint of the search arraylist
			int mp = searchArray.size() / 2;
			//If the date of the booking at the midpoint in the arraylist is the same as the criteria then
			//the data has been found and the index is returned
			if(searchArray.get(mp).getDate().equals(criteria.getDate())) {
				return mp;
			}
			
			//If not found then the following happens
			//Sub arrays are created
			ArrayList<Booking> splitArray1 = new ArrayList<Booking>();
			ArrayList<Booking> splitArray2 = new ArrayList<Booking>();
			//splitArray1 is populated with all bookings on the left side of the mid point
			splitArray1.addAll(searchArray.subList(0, mp));
			//splitArray1 is populated with all bookings on the right side of the mid point
			splitArray2.addAll(searchArray.subList(mp, searchArray.size()));
			//If the date to search is newer than the current midpoint date, then it is in splitArray1 else it is in splitArray2
			if(compareDates(criteria.getDate(), searchArray.get(mp).getDate())) {
				//Recursively search the subarray
				return search(splitArray1, criteria);
			} else {
				//Recursively search the subarray
				return search(splitArray2, criteria);
			}
			
		}
		} catch (Exception e) {
			return -1;
		}
		//If data was not found then -1 is returned
		return -1;
		
	}
	
	public boolean compareDates(String date1, String date2) {
		//Custom comparator for comparing dates
		//Get the year as a number from the date strings
		int dateYear1 = Integer.parseInt(date1.substring(0, 4));
		int dateYear2 = Integer.parseInt(date2.substring(0, 4));
		//if year of date1 is bigger than year of date2, then date 1 is newer than date 2
		if(dateYear1 > dateYear2) {
			return true;
		} else if(dateYear1 < dateYear2) {
			return false;
		} else {
			//Get the month as a number from the date strings
			int dateMonth1 = Integer.parseInt(date1.substring(5, 7));
			int dateMonth2 = Integer.parseInt(date2.substring(5, 7));
			//if month of date1 is bigger than month of date2, then date 1 is newer than date 2 as the years are the same
			if(dateMonth1 > dateMonth2) {
				return true;
			} else if(dateMonth1 < dateMonth2) {
				return false;
			} else {
				//Get the day as a number from the date strings
				int dateDay1 = Integer.parseInt(date1.substring(8, 10));
				int dateDay2 = Integer.parseInt(date2.substring(8, 10));
				//if day of date1 is bigger than day of date2, then date 1 is newer than date 2 as the years and months are the same 
				if(dateDay1 > dateDay2) {
					return true;
				} else if(dateDay1 < dateDay2) {
					return false;
				}
			}
			
		}
		return true;
	}
	
}
