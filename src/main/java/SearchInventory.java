import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SearchInventory {
    public static ArrayList<Product> inventory = new ArrayList<>();

    public static void main(String[] args) {

        inventoryReader();

        Scanner scanner = new Scanner(System.in);

        System.out.println("We carry the following inventory: ");
        Collections.sort(inventory, (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));


        for(int i = 0; i < inventory.size(); i++){
            Product p = inventory.get(i);

            System.out.printf("id:%d %s - Price: $%.2f \n",p.getId(),p.getName(), p.getPrice());


        }
        getInventory();
    }
    public static void inventoryReader(){
        String input;
        try {
            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((input = bufferedReader.readLine()) != null){
                String[] inventoryCSV = input.split("\\|");
                int id = Integer.parseInt(inventoryCSV[0]);
                String name = inventoryCSV[1];
                double productPrice = Double.parseDouble(inventoryCSV[2]);
                inventory.add(new Product(id,name,(float)productPrice));
            }
            fileReader.close();
            bufferedReader.close();
        }

        catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void getInventory(){

        for(Product product: inventory)

            System.out.println(product.getId());
    }
}
