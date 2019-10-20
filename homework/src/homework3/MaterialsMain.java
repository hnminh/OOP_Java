package homework3;

import java.util.ArrayList;

public class MaterialsMain {
    public static void main(String[] args) {
        ArrayList<Materials> machineParts = new ArrayList<>();

        machineParts.add(new PurchasedMaterials("Camera", 600, 3.5, "Sony"));
        machineParts.add(new PurchasedMaterials("Screen", 500, 100.7, "Samsung"));
        machineParts.add(new OwnMaterials("Glass", 100, 3.4, 2000));
        machineParts.add(new PurchasedMaterials("Antenna", 400, 30.5, "Intel"));
        machineParts.add(new OwnMaterials("Case", 700, 1.4, 200));

        for(int i = 0; i < machineParts.size(); i++)
            System.out.println(machineParts.get(i).toString());

        System.out.println();

        for(int i = 0; i < machineParts.size(); i++)
            System.out.println(machineParts.get(i).getName() + ", inventory value: " + machineParts.get(i).calculateInventoryValue());
    }
}