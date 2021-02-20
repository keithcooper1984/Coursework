
public class Node {
		Node next;
		Node previous;
		String name;
		Object value;
		
		public Node (String datavalue, Object data, Node previousIn) {
			next = null;
			previous = previousIn;
			name = datavalue;
			value = data;
		}
		
		public String getData() {
			return (name + ": " + value);
		}
		
		public String getName() {
			return name;
		}
		
		public Node getNext() {
			return next;
		}
		
		public void setName(String nameIn) {
			name = nameIn;
		}
		
		public void setValue(Object valueIn) {
			value = valueIn;
		}
		
		public void setNext(Node nextIn) {
			next = nextIn;
		}
		
		public void setPrevious(Node previousIn) {
			previous = previousIn;
		}
		
	}