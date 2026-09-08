// Attila Juhasz | 9/8/2026 | This code scraps a website to get to the next level

package stuff;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Stuff {

     // Precondition: Website needs to exit
     // Postcondition: Prints the html file name of the next level
     public static void main(String[] args) throws IOException {
          String num = "12345";
          int intNum = 12345;
          int i = 0;
          URL url = new URL("https://www.pythonchallenge.com/pc/def/linkedlist.php?nothing=12345");
          while (true){
               url = new URL("https://www.pythonchallenge.com/pc/def/linkedlist.php?nothing=" + num);
               BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
               
               String line = reader.readLine();
               System.out.println(line);
               System.out.println(intNum);
               if (line.equals("Yes. Divide by two and keep going.")){
                    intNum = intNum / 2;
                    num = "" + intNum;
                    i++;
               }
               else {
                    while (line != null){
                         Pattern pat = Pattern.compile("[0-9]+");
                         Matcher mat = pat.matcher(line);
                         while(mat.find()) {
                              System.out.println(line);
                              System.out.println(mat.group());
                              num = mat.group();
                              intNum = Integer.parseInt(num);
                         }
                         line = reader.readLine();
                         i++;
                    }
               }
          }
     }
}