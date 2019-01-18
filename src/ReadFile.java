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
        } catch (FileNotFoundException e){

        } catch (Exception e){
            System.out.println("Exception "+e);
        }
        return text.toLowerCase();
    }

    public static String readURL(URL url) {
        String text = "";
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(url.openStream()));
            String thisLine;
            while ((thisLine = buf.readLine()) != null)
                text += thisLine + " ";
            buf.close();
        } catch (IOException e){

        } catch (Exception e){
            System.out.println("Exception "+e);
        }
        return text;
    }
}
