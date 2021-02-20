
public class dictionary {	
	
	static int tableSize = 11;
	Node[] array;
	int count = 0;
	
	public dictionary() {
		array = new Node[tableSize];
		for (int i = 0; i < tableSize; i++) {
			array[i] = new Node("head", null, null);
		}
	}
				
	public void addValue(String name, int value) {
		name = name.toUpperCase();
		int encoded = hash(name);
		Node current = array[encoded];
		while (current.getNext() != null) {
			current = current.getNext();
		}		
		Node temp = new Node (name, value, current);
		current.setNext(temp);
		System.out.println(name + " successfully created");
		count++;
	}
	
	public String searchName(String nameIn) {
		nameIn = nameIn.toUpperCase();
		int encoded = hash(nameIn); 
		Node current = array[encoded];
		while (current != null) {		
			if (current.getName().equals(nameIn)) {
				return ("Stored data = " + current.getData() + "\n");
			}
			else {
				current = current.getNext();
			}
		}
		return (nameIn + " not found");
	}
	
	public static int hash(String name) {
		int sum = 0;
		for (int i = 0; i < name.length(); i++) {
			char x = name.charAt(i);
			int value = (int) x;
			sum += value;
		}		
		int hash = sum % tableSize;
		System.out.println("Hashcode for " + name + " is " + hash);
		return hash;
	}
	
	public int getTableSize() {
		return tableSize;
	}
	
	public int getCount() {
		return count;
	}
	
	public double loadFactor() {
		return (double) count/tableSize;
	}
	
	public void increaseTableSize() {
		tableSize = primes(tableSize * 2);
	}
	
	public static int primes(int x) {
		int num = x;
		int array = 0;
		while (array == 0) {
			boolean flag = true;
			for (int i = 2; i < num; i++) {
				if(num % i == 0) {
					flag = false;
					System.out.println(num + ", " + i);
					break;
				}
			}
			if (flag == true) {
				array = num;
				return array;
			}
			else {
				num++;
			}
		}
		return 0;
	}
}
