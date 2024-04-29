import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataPersistence {
    private static final String FILE_PATH = "data.json";
    private Gson gson;
    
    public DataPersistence() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void saveData(User user) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(user, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User loadData() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
  
}

