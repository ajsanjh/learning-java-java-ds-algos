package com.example.hashtable;

/**
 * def:
 * 
 * 
 * Impl using linked list so duplicates can be adjusted.
 * 	-- create an array of linked list
 * 	-- any value needs saving goes into the array index as head of nested linked list
 * 	-- any duplicates hash values goes in as second entry of linked list at that index.
 * 
 * @author AJ
 *
 */
class HashTable {

	private StudentList[] arr;
	private int size;
	private int totalStudents;
	
	public HashTable() {
		this.size = 1000;
		this.arr = new StudentList[this.size];
	}
	
	
	public int toHashCode(String rollno) {
		int addasciis = 0;
		for(int i=0; i < rollno.length(); i++)
			addasciis = addasciis + (int)rollno.charAt(i);
		return addasciis % this.size;
	}

	
	public boolean insert(int key, Student data) {
		if(arr[key] == null) {
			arr[key] = new StudentList();
		} 
			arr[key].insert(data);
			return true;
	}
	
	
	public int getTotal() {
		return this.totalStudents;
	}
	
	
	
	/* **** ************************************************************* */
	/* **** ***********    MAIN METHOD       ******************* */
	/* **** ************************************************************* */
	public static void main(String[] args) {
		StudentList sl = new StudentList();
		sl.insert(new Student("ajay", "602", 5.7));
		sl.add(new Student("robin", "606", 4.7));
		sl.insert(new Student("renee", "601", 7.7));
		sl.print();
		
	}
	
}




