import org.json.simple.JSONObject;

public class User {
	
	private String email;
	private String username;
	private String password;
	private Pantry pantry;
	
	public User(String email, String username, String password, Pantry pantry) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.pantry = pantry;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Pantry getPantry() {
		return pantry;
	}
	
	 @SuppressWarnings("unchecked")
	public JSONObject toJSON() {
	        JSONObject json = new JSONObject();
	        json.put("username", username);
	        json.put("email", email);
	        json.put("password", password);
	        json.put("pantry", pantry.toJSON());
	        return json;
	    }
	 
	public static User fromJSON(JSONObject json) {
	        String username = (String) json.get("username");
	        String email = (String) json.get("email");
	        String password = (String) json.get("password");
	        Pantry pantry = Pantry.fromJSON((JSONObject) json.get("pantry"));
	        return new User(username, email, password, pantry);
	    }
}
