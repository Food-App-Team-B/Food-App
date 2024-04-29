import java.time.LocalDate;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@SuppressWarnings("unused")
public class Ingredient {
	
	private String name;
    private Double quantity; // quantity in the base unit
    private String unit;
    private String expirationDate;
    // unit of measurement

    public Ingredient(String name, Double quantity, String unit, String expirationDate) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.expirationDate = expirationDate;
    }

    // Method to add quantity to existing quantity
    public void addQuantity(double amount) {
        this.quantity += amount;
    }

    // Method to subtract quantity from existing quantity
    public void subtractQuantity(double amount) {
        this.quantity -= amount;
    }

    // Getter method for quantity
    public Double getQuantity() {
        return quantity;
    }

    // Getter method for unit
    public String getUnit() {
        return unit;
    }

    // Getter method for name
    public String getName() {
        return name;
    }
    
    public String getExpirationDate() {
    	return expirationDate;
    }
    
    public boolean isExpired() {
        LocalDate currentDate = LocalDate.now();
        return LocalDate.parse(expirationDate).isBefore(currentDate);
    }
    
    public String toString() {
    	
    	return name + " " + quantity + " " + unit + " " + expirationDate;
    }
    
    @SuppressWarnings("unchecked")
	public JSONObject toJSON() {
    	
    	JSONObject json = new JSONObject();
    	json.put("name", name);
    	json.put("quantity", quantity);
    	json.put("unit", unit);
    	json.put("expirationDate", expirationDate.toString());
    	
    	return json;
    }
    
    public static Ingredient fromJSON(JSONObject json) {
    	String name = (String) json.get("name");
        Double quantity = (Double) json.get("quantity"); // quantity in the base unit
        String unit = (String) json.get("unit");
        String expirationDate = (String) json.get("expirationDate");
        
        return new Ingredient(name, quantity, unit, expirationDate);
    }
	
}
