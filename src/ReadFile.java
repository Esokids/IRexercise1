import java.io.File;
import java.util.Scanner;

public class ReadFile {
    public static String readFile(String path){
        String thisFile = "";
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine())
                thisFile += scanner.nextLine()+" ";
            scanner.close();
        }catch (Exception e){
            System.out.println("error " + e);
        }
        return thisFile.toLowerCase();
    }
}
