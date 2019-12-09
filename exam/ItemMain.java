package exam;

//import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

public class ItemMain {

	public static void main(String[] args) {
		ArrayList<Item> items = new ArrayList<>();
		items.add(new Product("fan", 40.3));
		items.add(new Product("washing machine", 659));
		items.add(new Product("heater", 50.4));
		items.add(new Service("fixing", 52.6, 3.0));
		items.add(new Service("cleaning", 30.5, 2));
		items.add(new Service("delivery", 10, 3.3));
		
		Collections.sort(items);
		
		for (int i = 0; i < items.size(); i++)
			System.out.println(items.get(i).toString());
		System.out.println();
		
		double sum = 0;
		for (int i = 0; i < items.size(); i++) {
			System.out.println("name: " + items.get(i).getName() + ", final price: " + items.get(i).finalPrice());
			sum += items.get(i).finalPrice();
		}
		System.out.println("Total sum: " + sum);
		//List<Item> itemsClone = items;
		
		//Collections.sort((java.util.List<T>) items);
	}

}
