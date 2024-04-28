import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataPersistence {
    private static final String FILE_PATH = "data.json";

    public void saveData(User user) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            JSONObject userJson = user.toJSON();
            writer.write(userJson.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User loadData() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONParser parser = new JSONParser();
            JSONObject userJson = (JSONObject) parser.parse(reader);
            return User.fromJSON(userJson);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

