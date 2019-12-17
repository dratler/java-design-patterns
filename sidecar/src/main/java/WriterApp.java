import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Callable;

public class WriterApp extends SideCarApp implements Callable {

  private String path = "";

  public WriterApp(){}

  public WriterApp(String path){
    this.path = path;
  }

  public Object call() throws IOException {
    String str = "I am a SideCar app!";
    if (path.equals("")) {
      path = System.getProperty("user.dir");
      File file = new File(path+"/file.txt");
      FileWriter writer = new FileWriter(file.getPath());
      writer.write(str);
      writer.close();
    } else {
      FileWriter writer = new FileWriter(path);
      writer.write(str);
      writer.close();
    }
    return this;
  }

  public void setProps(Map<String, String> props) {
    if (props.containsKey("path")) {
      path = props.get("path");
    }
  }

}
