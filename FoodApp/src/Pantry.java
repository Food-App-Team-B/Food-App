import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Pantry {
	
	public ArrayList<Ingredient> ingredients;
	
	public Pantry(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	
	public void AddIngredient(Ingredient a) {
		ingredients.add(a);
	}
	
	public void RemoveIngredient(Ingredient a) {
		ingredients.remove(a);
	}
	
	public void restockIngredient(Ingredient a, double quantity) {
		 for (Ingredient i : ingredients) {
	            if (i.equals(a)) {
	                i.addQuantity(quantity);
	                break;
	            }
	        }
	} 
	
	public void useIngredient(Ingredient a, double quantity) {
		for (Ingredient i : ingredients) {
            if (i.equals(a)) {
            	i.subtractQuantity(quantity);
                break;
            }
        }
	}
	
	 public double getAvailableQuantity(Ingredient ingredient) {
	       for (Ingredient i : ingredients) {
	            if (i.equals(ingredient)) {
	                return i.getQuantity();
	            }
	        }
	       return 0; // Ingredient not found
	 }
	 
	 public void removeExpiredIngredients() {
		 Iterator<Ingredient> iterator = ingredients.iterator();
		 while(iterator.hasNext()) {
			 Ingredient ingredient = iterator.next();
			 if(ingredient.isExpired()) {
				 iterator.remove();
			 }
		 }
	 }
	 
	 @SuppressWarnings("unchecked")
	public JSONObject toJSON() {
	    JSONObject json = new JSONObject();
	    JSONArray list = new JSONArray();
	    	
	    for(Ingredient i : ingredients) {
	    	list.add(i.toJSON());
	    }
	    
	    json.put("ingredients", list);
	    
	    return json;
	    	
	 }
	 
	 @SuppressWarnings("unchecked")
	public static Pantry fromJSON(JSONObject json) {
		 ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
		 
		 JSONArray list = (JSONArray) json.get("ingredients");
		 Iterator<JSONObject> i = list.iterator();
		
		 while(i.hasNext()) {
			 JSONObject ing = i.next();
			 ingredients.add(Ingredient.fromJSON(ing));
		 }
		 
		 return new Pantry(ingredients);
	 }
	 
}
