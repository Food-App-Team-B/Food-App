import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.io.File;


public class Driver {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		User user;
		DataPersistence dataSaver = new DataPersistence();
		
		if (new File("data.json").exists()) {
			user = dataSaver.loadData();
			System.out.println("Welcome Back " + user.getUsername());
		}
		else {
			System.out.println("Hi, welcome! Please enter your username email and password");
			System.out.print("Username: ");
			
			String username = scanner.next();
			System.out.print("Email: ");
			
			String email = scanner.next();
			
			System.out.print("password: ");
			String password = scanner.next();
			scanner.nextLine(); //consumes newline character in buffer
			
			user = new User(email, username, password);
			System.out.println("Okay! " + user.getUsername()+ " please enter what you have in your pantry that you want to keep track of! and also how much you have :)");
			System.out.println("enter 'xx' when you are done");
			System.out.print("Enter Ingredient: ");
			String ingredi = scanner.nextLine();
			
			while(!ingredi.equals("xx")) {
				String[] parts = ingredi.split(" ");
				
				if (parts.length >= 3) { // Check if the array has at least three elements
			        String name = parts[0];
			        Double quantity = Double.parseDouble(parts[1]);
			        String unit = parts[2];
			        Ingredient ingredient = new Ingredient(name, quantity, unit, "N/A");
			        user.pantry.AddIngredient(ingredient);
			    } 
				
				else {
			        System.out.println("Invalid input. Please enter ingredient in the format 'name quantity unit'.");
			    }
				System.out.print("Enter Ingredient: ");
				ingredi = scanner.nextLine();
			} 
			
			System.out.println("Awesome!");
		}
		
		while(running) {
			System.out.println("What do you want to do");
			System.out.println("1. View your pantry");
			System.out.println("2. Get Recipes");
			System.out.println("3. Edit Pantry");
			System.out.println("4. exit");
			System.out.print("Enter Choice");
			
			int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            switch(choice) {
            case 1:
            	System.out.println(user.pantry.ingredients.toString());
            	break;
            case 2:
            	System.out.println("what in your pantry do you want to use?");
            	System.out.println(user.pantry.ingredients.toString());
            	String ing = scanner.nextLine();
            	String[] list = ing.split(" ");
            	
            	ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(list));
            	
            	SpoonableAPI api = new SpoonableAPI();
            	Map<String, Long> recipeMap = api.findRecipeByIngredients(arrayList);
            	
            	System.out.println("Alright! here are some recipes");
            	
            	for (Map.Entry<String, Long> entry : recipeMap.entrySet()) {
                     System.out.print(entry.getKey() + ", ");
                     System.out.println();
                 }
            	
            	break;
            case 3:
            	//todo 
            	break;
            case 4:
            	running = false;
            	break;
            }
		}
		
		dataSaver.saveData(user);
		scanner.close();
    }
}

