import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class ReadFile {
    public static String readFile(String path){
        String text = "";
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine())
                text += scanner.nextLine()+" ";
            scanner.close();
        }catch (Exception e){
            System.out.println("error " + e);
        }
        return text.toLowerCase();
    }

    public static String readURL(URL url) throws IOException {
            BufferedReader buf = new BufferedReader(new InputStreamReader(url.openStream()));
            String thisLine;
            String text = "";
            while ((thisLine = buf.readLine()) != null)
                text += thisLine + " ";
            buf.close();
        return text;
    }
}
