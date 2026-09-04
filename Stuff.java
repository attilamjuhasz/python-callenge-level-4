package stuff;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Stuff {
     public static void main(String[] args) throws IOException {
          String num = "12345";
          int i = 0;
          URL url = new URL("https://www.pythonchallenge.com/pc/def/linkedlist.php?nothing=12345");
          while (i < 1000){
               url = new URL("https://www.pythonchallenge.com/pc/def/linkedlist.php?nothing=" + num);
               BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
               
               String line = reader.readLine();
               while (line != null){
                    Pattern pat = Pattern.compile("[0-9]+");
                    Matcher mat = pat.matcher(line);
                    while(mat.find()) {
                         System.out.println(line);
                         System.out.println(mat.group());
                         num = mat.group();
                    }
                    line = reader.readLine();
                    i++;
               }
          }
     }
}