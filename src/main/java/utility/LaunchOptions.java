package utility;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LaunchOptions {
  private final List<String> launchOptions;

  public LaunchOptions() {
    launchOptions = new ArrayList<>();
    launchOptions.add("--start-maximized");
    launchOptions.add("--disable-web-security");
    launchOptions.add("--allow-running-insecure-content");
    launchOptions.add("--ignore-certificate-errors");
    launchOptions.add("--remote-allow-origins=*");
  }

}
