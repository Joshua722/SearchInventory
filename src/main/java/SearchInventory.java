import java.sql.Array;
import java.util.*;

public class SearchInventory {
    public static void main(String[] args) {

        ArrayList<Product> inventory = getInventory();

        Scanner scanner = new Scanner(System.in);

        System.out.println("We carry the following inventory: ");

        for(int i = 0; i < inventory.size(); i++){
            Product p = inventory.get(i);

            System.out.printf("id:%d %s - Price: $%.2f ",p.getId(),p.getName(), p.getPrice());

        }
    }
    public static ArrayList<Product> getInventory(){
        ArrayList<Product> inventory = new ArrayList<Product>();
        inventory.add(new Product(22,"Milk",2.33F));
        inventory.add(new Product(23,"Butter",4.23F));
        inventory.add(new Product(24,"Cheese",3.23F));
        inventory.add(new Product(25,"Eggs",1.23F));
        inventory.add(new Product(26,"Watermelon",.59F));

        Collections.sort(inventory, (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));


        return inventory;
    }

}
