package com.server;

import java.util.ArrayList;

public class Utils {
	
	public static ArrayList<Booking> sort(ArrayList<Booking> sortArray) {
		MergeSort ms = new MergeSort();
		ms.sort(sortArray);
		return sortArray;
	}
	
	public static Booking search(ArrayList<Booking> searchArray, Booking criteria) {
		BinarySearch bs = new BinarySearch();
		int index = -1;
		try {
		index = bs.search(searchArray, criteria);
		} catch (Exception e) {
			index = -1;
		}
		if(index == -1) {
			return new Booking(-1, 0, 0, null, 0, 0);
		}
		return searchArray.get(index);
	}
	
}

class MergeSort {
	
	public void sort(ArrayList<Booking> dates) {
		
		if(1 < dates.size()) {
			
			ArrayList<Booking> splitArray1 = new ArrayList<Booking>();
			ArrayList<Booking> splitArray2 = new ArrayList<Booking>();
			int mp = dates.size() / 2;
			splitArray1.addAll(dates.subList(0, mp));
			splitArray2.addAll(dates.subList(mp, dates.size()));
			sort(splitArray1);
			sort(splitArray2);
			merge(dates, splitArray1, splitArray2);
			
		}
		
	}
	
	public void merge(ArrayList<Booking> datesSorted, ArrayList<Booking> splitArray1, ArrayList<Booking> splitArray2) {
		int splitArrayIndex1 = 0;
		int splitArrayIndex2 = 0;
		int datesSortedIndex = 0;
		while (splitArrayIndex1 < splitArray1.size() && splitArrayIndex2 < splitArray2.size()) {
			if(compareDates(splitArray1.get(splitArrayIndex1).getDate(), splitArray2.get(splitArrayIndex2).getDate())) {
				datesSorted.set(datesSortedIndex, splitArray1.get(splitArrayIndex1));
				splitArrayIndex1++;
			} else {
				datesSorted.set(datesSortedIndex, splitArray2.get(splitArrayIndex2));
				splitArrayIndex2++;
			}
			datesSortedIndex++;
		}
		while (splitArrayIndex1 < splitArray1.size()) {
			datesSorted.set(datesSortedIndex, splitArray1.get(splitArrayIndex1));
			splitArrayIndex1++;
			datesSortedIndex++;
		}
		while (splitArrayIndex2 < splitArray2.size()) {
			datesSorted.set(datesSortedIndex, splitArray2.get(splitArrayIndex2));
			splitArrayIndex2++;
			datesSortedIndex++;
		}
	}
	
	public boolean compareDates(String date1, String date2) {
		int dateYear1 = Integer.parseInt(date2.substring(0, 4));
		int dateYear2 = Integer.parseInt(date2.substring(0, 4));
		if(dateYear1 > dateYear2) {
			return true;
		} else if(dateYear1 < dateYear2) {
			return false;
		} else {
			int dateMonth1 = Integer.parseInt(date1.substring(5, 7));
			int dateMonth2 = Integer.parseInt(date2.substring(5, 7));
			if(dateMonth1 > dateMonth2) {
				return true;
			} else if(dateMonth1 < dateMonth2) {
				return false;
			} else {
				int dateDay1 = Integer.parseInt(date1.substring(8, 10));
				int dateDay2 = Integer.parseInt(date2.substring(8, 10));
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
		try {
		if(searchArray.size() >=1) {
		
			int mp = searchArray.size() / 2;
			
			if(searchArray.get(mp).getDate().equals(criteria.getDate())) {
				return mp;
			}
			
			ArrayList<Booking> splitArray1 = new ArrayList<Booking>();
			ArrayList<Booking> splitArray2 = new ArrayList<Booking>();
			splitArray1.addAll(searchArray.subList(0, mp));
			splitArray2.addAll(searchArray.subList(mp, searchArray.size()));
			
			if(compareDates(searchArray.get(mp).getDate(), criteria.getDate())) {
				return search(splitArray1, criteria);
			} else {
				return search(splitArray2, criteria);
			}
			
		}
		} catch (Exception e) {
			return -1;
		}
		return -1;
		
	}
	
	public boolean compareDates(String date1, String date2) {
		int dateYear1 = Integer.parseInt(date2.substring(0, 4));
		int dateYear2 = Integer.parseInt(date2.substring(0, 4));
		if(dateYear1 > dateYear2) {
			return true;
		} else if(dateYear1 < dateYear2) {
			return false;
		} else {
			int dateMonth1 = Integer.parseInt(date1.substring(5, 7));
			int dateMonth2 = Integer.parseInt(date2.substring(5, 7));
			if(dateMonth1 > dateMonth2) {
				return true;
			} else if(dateMonth1 < dateMonth2) {
				return false;
			} else {
				int dateDay1 = Integer.parseInt(date1.substring(8, 10));
				int dateDay2 = Integer.parseInt(date2.substring(8, 10));
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
