import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.HashMap;
import java.util.Map;

public class SpoonableAPI {
	private URL url;
	String api_key = "4f8dacc258c84b57be1e22d613b58736";
	String name = "https://api.spoonacular.com/";
	
	
	public Map<String, Long> findRecipeByIngredients(ArrayList<String> ingredients) {
		
		StringBuilder urlBuilder = new StringBuilder(name);
		urlBuilder.append("recipes/findByIngredients?ingredients=");
		String filePath = "recipes.json";

		// Append each ingredient to the URL
		for (int i = 0; i < ingredients.size(); i++) {
		    urlBuilder.append(ingredients.get(i));
		    if (i < ingredients.size() - 1) {
		        urlBuilder.append(",+");
		    }
		}

		urlBuilder.append("&number=2");
		urlBuilder.append("&apiKey=").append(api_key);

		String finalUrl = urlBuilder.toString();
		
		try {
			url = new URL(finalUrl);
			// Open a connection to the URL
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			File file = new File(filePath);
			
			
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	        String inputLine;
	        while ((inputLine = in.readLine()) != null) {
	            bufferedWriter.write(inputLine);
	        }
	            // Close writers
	        bufferedWriter.close();
	        fileWriter.close();
	        in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}


        // Map to store titles and IDs
        Map<String, Long> recipeMap = new HashMap<>();

        // Parse JSON file
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(filePath)) {
            // Parse JSON array
            JSONArray recipes = (JSONArray) parser.parse(reader);

            // Iterate through recipes
            for (Object obj : recipes) {
                JSONObject recipe = (JSONObject) obj;
                // Get title and ID of each recipe
                String title = (String) recipe.get("title");
                Long id = (Long) recipe.get("id");
                // Put title and ID into the map
                recipeMap.put(title, id);
            }


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
		
        return recipeMap;
        
	}
	
	public Recipe getRecipe(long id) {
		String filePath = "recipeInfo.json";
		StringBuilder urlBuilder = new StringBuilder(name);
		
		urlBuilder.append("/recipes");
		urlBuilder.append("/").append(Long.toString(id));
		urlBuilder.append("/information");
		urlBuilder.append("?includeNutrition=false&addWinePairing=false&addTasteData=false");
		urlBuilder.append("&apiKey=").append(api_key);
		
		String finalUrl = urlBuilder.toString();
		
		Recipe recipe;
		try {
			url = new URL(finalUrl);
			// Open a connection to the URL
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			recipe = Recipe.fromJson(in);
			return recipe;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
