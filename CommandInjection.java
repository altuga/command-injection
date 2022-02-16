import java.util.*; 
import java.io.File;
import java.io.*;

public class CommandInjection { 
    public static void main(String[] args){ 
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter Username"); 
        String user = sc.nextLine();

        String user_path = user;

        File file = new File(user_path);

        try {
            String comm = user_path;
            Process process = Runtime.getRuntime().exec(comm);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
        }
        catch (IOException e) {
            System.out.println("Error executing command");
        }
    }
}