import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class MarkdownFormatter {
    public static void main(String[] args) {
        String filePath = "./Tarea1.md"; // Replace with the actual file path
        StringBuilder fileContentStringBuilder = new StringBuilder();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContentStringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileContent = fileContentStringBuilder.toString();
        String regex = "\\$\\$([^\\$]+)\\$\\$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fileContent);

        String newFileContent = matcher.replaceAll("\n\\$\\$\n$1\n\\$\\$\n");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./Tarea1Formatted.md"))) {
            bw.write(newFileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("File formatted successfully!");
    }
}