import java.util.ArrayList;

public class Tester {

public static void main(String[] args) {	
	SpoonableAPI api = new SpoonableAPI();
	ArrayList<String> a = new ArrayList<String>();
	
	a.add("apples");
	a.add("flour");
	a.add("sugar");
	
	api.findRecipeByIngredients(a);
	
	}
}
