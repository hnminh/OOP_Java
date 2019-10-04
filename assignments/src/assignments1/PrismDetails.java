package assignments1;

public class PrismDetails {

	public static void main(String[] args) {
		Prism p1 = new Prism();
		p1.depth = 12;
		p1.height = 3;
		p1.width = 4.5;

		Prism p2 = new Prism();
		p2.depth = 3.45;
		p2.height = 4;
		p2.width = 9.3;
		
		System.out.println("Prism 1\nDepth: " + p1.depth + "\nHeight: " + p1.height + "\nWidth: " + p1.width);
		System.out.println("Volume: " + p1.volume() + "\n");
		
		System.out.println("Prism 2\nDepth: " + p2.depth + "\nHeight: " + p2.height + "\nWidth: " + p2.width);
		System.out.println("Volume: " + p2.volume() + "\n\n");
	}

}
