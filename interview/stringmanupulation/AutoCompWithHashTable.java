package stringmanupulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AutoCompWithHashTable {
	public static void main(String[] args) {
		
		String[] data = {"ab", "abc", "abcd", "acd", "bcd", "def", "a", "aba"};
		
		Dictionary.save(data);
		
		System.out.println(Dictionary.getList("abc"));
		
	}
}

class Dictionary {
	private static WordList[] dict = new WordList[26];
	
	
	public static void save(String[] data) {
		for (int i = 0; i < data.length; i++) {
			int hash = getHashCode(data[i]);
			if(dict[hash] == null) {
				dict[hash] = new WordList();
			}
			dict[hash].add(data[i]);
		}
	}
	
	private static int getHashCode(String data) {
		return (int)data.charAt(0) - (int)'a';
	}
	
	public static List<String> getList(String data){
		char c = data.charAt(0);
		List<String> fcm = 
				dict[(int)c-(int)'a'].list();
		List<String> temp = new ArrayList<>();
		for (String i : fcm) {
			if(i.length() >= data.length() && i.startsWith(data)) {
				temp.add(i);
			}
		}
		return temp.stream().sorted().collect(Collectors.toList());
	}
	
}


class WordList {
	private class Node {
		String value;
		Node next;
		public Node(String value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
	
	private Node head;
	public WordList() {
		this.head = new Node(null, null);
	}
	
	public boolean add(String value) {
		if(this.head.next == null) {
			this.head.next = new Node(value, null);
			return true;
		} else {
			Node itr = this.head.next;
			while(itr.next != null) {
				itr = itr.next;
			}
			itr.next = new Node(value, null);
			return true;
		}
	}
	
	public List<String> list() {
		List<String> list = new ArrayList<>();
		Node itr = this.head.next;
		while(itr.next != null) {
			list.add(new String(itr.value));
			itr = itr.next;
		}
		return list;
	}
}






