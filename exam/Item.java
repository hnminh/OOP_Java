package exam;

public abstract class Item  implements Comparable<Item> {
	
	private String name;
	
	@Override
	public int compareTo(Item another){
		return name.compareToIgnoreCase(another.name);
	}

	public Item(String name) {
		this.name = name;
	}

	public abstract double finalPrice();
	
	public String getName() {
		return name;
	}
}
