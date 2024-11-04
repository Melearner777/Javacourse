/*Write a Java program to read and write data from and to text files using FileReader and FileWriter. Implement exception handling for scenarios like file not found, access denied, and I/O errors. The program should also use the Scanner class to take user input and write it to a file, then read back the content from the file and display it.

Sample Input:
data.txt
1
Hello, this is the first line.
This is the second line.
END

Sample Output:
Written Content:
Hello, this is the first line.
This is the second line.
*/

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine().trim();
        try {

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                // Writing to file
                
                StringBuilder content = new StringBuilder();
                String line;
                while (!(line = scanner.nextLine()).equals("END")) {
                    content.append(line).append("\n");
                }

                writeFile(fileName, content.toString());

                // Display content without trailing newline
                String writtenContent = content.toString().trim();
                System.out.print("Written Content:\n" + writtenContent);

            } else if (choice == 2) {
                // Reading from file
                String content = readFile(fileName);

                // Display content without trailing newline
                String readContent = content.trim();
                System.out.print("Read Content from File:\n" + readContent);

            } else {
                System.out.println("Invalid choice. Please select 1 or 2.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error Message: File not found. Please check the file name and try again.");
        } catch (IOException e) {
            System.out.println("Error Message: An I/O error occurred.");
        } catch (SecurityException e) {
            System.out.println("Error Message: Access denied. You do not have the necessary permissions.");
        } finally {
            scanner.close();
        }
    }

    private static void writeFile(String fileName, String content) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(content);
        }
    }

    private static String readFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}
