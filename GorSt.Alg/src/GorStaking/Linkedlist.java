package GorStaking;



public class Linkedlist {
	private Node head;
	
	
	public Linkedlist() {
		head=null; //empty linkedlist
	}
	
	public void add(String item,int count) {
		head = new Node(item, count, head);  
	}										
	
	public boolean deleteHeadNode() {
		if(head!=null) {
			head=head.getLink();    
			return true; 
		}			
		else {
			return false;//alread empty
		}
		
	}
	
	
	public int size() {
		int counter=0;
		Node position=head;    
		while (position!=null) {
			counter++; 
			position=position.getLink(); 
		}
		return counter;
	}
	
	public String find(String target) {
		Node position = head;
		String itemAtPositon;
		while(position!=null) {
			itemAtPositon=position.getItem();
			if(itemAtPositon.equals(target)) {
				return position.getItem();
			}
			else {
				position=position.getLink();
			}
		}
		return null;
	}
	
	public Node findNode(String target) {
		Node position = head;
		String itemAtPositon;
		while(position!=null) {
			itemAtPositon=position.getItem();
			if(itemAtPositon.equals(target)) {
				return position;
			}
			else {
				position=position.getLink();
			}
		}
		return null;
	}
	
	public void outputTheList() {
		Node position=head;
		while (position!=null) {
			System.out.println(position.getItem() +" , " + position.getCount() );
			position=position.getLink();
		}
	}
	
	public void clear() {
		head=null; 
	}
	
	public void whatIsHead() {
		System.out.println(head.getItem());
	}
	public void whatIsGetLink() {
		System.out.println(head.getLink().getItem());
		
	}
	
}
