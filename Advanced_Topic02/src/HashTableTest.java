import java.util.LinkedList;

class HashTable{
	LinkedList<Node>[] data;
	
	@SuppressWarnings("unchecked")
	public HashTable(int size) {
		this.data = new LinkedList[size];
	}
	
	int getHashCode(String key) {
		int hashCode = 0;
		for(char c: key.toCharArray()) {
			hashCode += c;
		}
		return hashCode;
	}
	
	int convertToIndex(int hashCode) {
		return hashCode % data.length;
	}
	
	Node searchKey(LinkedList<Node> list, String key) {
		if(list == null) return null;
		
		for(Node node : list) {
			if(node.key.equals(key)) {
				return node;
			}
		}
		return null;
	}
	
	void put(String key, String value) {
		int hashCode = getHashCode(key);
		int index = convertToIndex(hashCode);
		
		LinkedList<Node> list = data[index];
		if(list == null) {
			list = new LinkedList<Node>();
			data[index] = list;
		}
		
		Node node = searchKey(list, key);
		if(node==null) {
			list.addLast(new Node(key,value));
		}
		else {
			node.setValue(value);
		}
	}
	
	public String get(String key) {
		int hashCode = getHashCode(key);
		int index = convertToIndex(hashCode);
		LinkedList<Node> list = data[index];
		Node node = searchKey(list, key);
		
		return node == null ? "Not found" : node.getValue();
	}
	
	class Node{
		String key;
		String value;
		
		public Node(String key, String value) {
			this.key = key;
			this.value = value;
		}
		
		public String getValue() {
			return this.value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
	}
	
	public void printHashTable() {
		for(int i=0; i<data.length; i++) {
			if(data[i]==null)continue;
			for(Node node: data[i]) {
				System.out.print(node.getValue()+" ");
			}
			System.out.println();
		}
	}
}

public class HashTableTest {

	
	public static void main(String[] args) {
		
		HashTable ht = new HashTable(3);
		ht.put("sung", "she is pretty");
		ht.put("jin", "she is model");
		ht.put("hee", "she is angel");
		ht.put("min", "she is cute");
		
		ht.printHashTable();
		System.out.println("--------------------");
		System.out.println(ht.get("sung"));
		System.out.println(ht.get("jin"));
		System.out.println(ht.get("hee"));
		System.out.println(ht.get("min"));
		System.out.println(ht.get("jae"));
		
	}

}
