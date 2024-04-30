import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Recipe {
	//easy under title
	private String title;
	//easy under id
	private long id;
	//from extended ingredients array need "orignalName" "ammount" and "unit"
	private ArrayList<Ingredient> ingredients;
	//easy under sourceURL
	private String sourceURL;
	//from analyzed instructions I need  
	private ArrayList<String> instructions; 
	
	public Recipe(String title, long id, ArrayList<Ingredient> ingredients, String sourceURL, ArrayList<String> instructions) {
		this.title = title;
		this.id = id;
		this.ingredients = ingredients;
		this.sourceURL = sourceURL;
		this.instructions = instructions;
	}
	
	 public String getTitle() {
	        return title;
	    }

	 public void setTitle(String title) {
	        this.title = title;
	    }

	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public ArrayList<Ingredient> getIngredients() {
	        return ingredients;
	    }

	    public void setIngredients(ArrayList<Ingredient> ingredients) {
	        this.ingredients = ingredients;
	    }

	    public String getSourceURL() {
	        return sourceURL;
	    }

	    public void setSourceURL(String sourceURL) {
	        this.sourceURL = sourceURL;
	    }

	    public ArrayList<String> getInstructions() {
	        return instructions;
	    }

	    public void setInstructions(ArrayList<String> instructions) {
	        this.instructions = instructions;
	    }
	
	public static void print(Recipe recipe) {
		System.out.println(recipe.getTitle());
		System.out.println();
		System.out.println(recipe.getSourceURL());
		System.out.println();
		System.out.println("Ingredients:");
		for (int i = 0; i < recipe.getIngredients().size(); i++) {
			System.out.println(recipe.getIngredients().get(i).toString());
		}
		System.out.println();
		System.out.println("Instructions:");
		for (int i = 0; i < recipe.getInstructions().size(); i++) {
			System.out.println(recipe.getInstructions().get(i));
		}
	}
	
	 public static Recipe fromJson(String filepath) {
		JSONParser parser = new JSONParser();
		try (FileReader reader = new FileReader(filepath)){
			JSONObject jsonObject = (JSONObject) parser.parse(reader);

            // Extracting title
            String title1 = (String) jsonObject.get("title");
            
            String sourceURL1 = (String) jsonObject.get("sourceUrl");

            // Extracting id
            long id1 = (long) jsonObject.get("id");

            // Extracting ingredients
            JSONArray ingredientsArray = (JSONArray) jsonObject.get("extendedIngredients");
            ArrayList<Ingredient> ingredients = new ArrayList<>();
            for (Object obj : ingredientsArray) {
                JSONObject ingredientObj = (JSONObject) obj;
                String name = (String) ingredientObj.get("nameClean");
                double amount = (double) ingredientObj.get("amount");
                String unit = (String) ingredientObj.get("unit");
                ingredients.add(new Ingredient(name, amount, unit));
            }

            // Extracting instructions
            JSONArray analyzedInstructions = (JSONArray) jsonObject.get("analyzedInstructions");
            ArrayList<String> instructions = new ArrayList<>();
            for (Object obj : analyzedInstructions) {
                JSONObject instructionObj = (JSONObject) obj;
                JSONArray steps = (JSONArray) instructionObj.get("steps");
                for (Object stepObj : steps) {
                    JSONObject step = (JSONObject) stepObj;
                    String stepText = (String) step.get("step");
                    instructions.add(stepText);
                }
            }
            
            return new Recipe(title1, id1, ingredients, sourceURL1, instructions);
		}
		catch (IOException | ParseException e) {
            e.printStackTrace();
        }
		
		return null;
	}
	 
	 public static Recipe fromJson(BufferedReader json) {
			JSONParser parser = new JSONParser();
			try {
				JSONObject jsonObject = (JSONObject) parser.parse(json);

	            // Extracting title
	            String title1 = (String) jsonObject.get("title");
	            
	            String sourceURL1 = (String) jsonObject.get("sourceUrl");

	            // Extracting id
	            long id1 = (long) jsonObject.get("id");

	            // Extracting ingredients
	            JSONArray ingredientsArray = (JSONArray) jsonObject.get("extendedIngredients");
	            ArrayList<Ingredient> ingredients = new ArrayList<>();
	            for (Object obj : ingredientsArray) {
	                JSONObject ingredientObj = (JSONObject) obj;
	                String name = (String) ingredientObj.get("nameClean");
	                double amount = (double) ingredientObj.get("amount");
	                String unit = (String) ingredientObj.get("unit");
	                ingredients.add(new Ingredient(name, amount, unit));
	            }

	            // Extracting instructions
	            JSONArray analyzedInstructions = (JSONArray) jsonObject.get("analyzedInstructions");
	            ArrayList<String> instructions = new ArrayList<>();
	            for (Object obj : analyzedInstructions) {
	                JSONObject instructionObj = (JSONObject) obj;
	                JSONArray steps = (JSONArray) instructionObj.get("steps");
	                for (Object stepObj : steps) {
	                    JSONObject step = (JSONObject) stepObj;
	                    String stepText = (String) step.get("step");
	                    instructions.add(stepText);
	                }
	            }
	            
	            return new Recipe(title1, id1, ingredients, sourceURL1, instructions);
			}
			catch (IOException | ParseException e) {
	            e.printStackTrace();
	        }
			
			return null;
		}
	
}
