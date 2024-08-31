import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * The MarkdownFormatter class reads a markdown file, formats it by adding newlines around
 * LaTeX math expressions enclosed in double dollar signs ($$), and writes the formatted content
 * to a new file.
 */
public class MarkdownFormatter {
    /**
     * The main method that serves as the entry point of the program.
     * 
     * @param args Command line arguments. The first argument should be the path to the markdown file to be formatted.
     */
    public static void main(String[] args) {
        String filePath = args[0]; // Replace with the actual file path
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

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath.replace(".md", "_formatted.md")))) {
            bw.write(newFileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("File formatted successfully!");
    }
}