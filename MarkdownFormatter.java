import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MarkdownFormatter {
    public static void main(String[] args) {
        String filePath = "./Tarea1.md"; // Replace with the actual file path
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}