package utility;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.FileNotFoundException;
import java.io.FileReader;

@Getter
@Setter
@AllArgsConstructor
public class User {

  private String firstName;
  private String middleName;
  private String lastName;
  private String email;
  private String password;
  private String confirmation;


  public static User createUserFrom(String dataFileName, String memberName) {
    try {
      FileReader fileReader = new FileReader("src/test/userdata/" + dataFileName);
      JsonReader reader = new JsonReader(fileReader);
      JsonElement jsonElement = JsonParser.parseReader(reader);
      JsonObject jsonObject = jsonElement.getAsJsonObject();

      return new Gson().fromJson(jsonObject.get(memberName), User.class);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

}
