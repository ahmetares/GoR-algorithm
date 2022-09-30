package GorStaking;


public class Node {
	
	private String item;
	private int count;
	private Node link;  //bi sonraki node 
	
	public Node() {
		item=null;
		count=0;
		link=null;
	}
	
	public Node(String item,int count,Node linkValue) {
		this.count=count;
		this.item=item;
		this.link=linkValue;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}
	
	

}

