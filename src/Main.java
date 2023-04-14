import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter the name of a file:");
        String fileName = userInput.nextLine();

        try (Scanner fileInput = new Scanner(Paths.get(fileName))) {
            System.out.println("File " + Paths.get(fileName).getFileName() + " accessed.");
            Boolean searchAgain = true;

            do {
                System.out.println("What is the word you would like to search for?: ");
                String target = userInput.next();
                target = target.trim().toLowerCase();

                ArrayList<Line> lines = new ArrayList<>();

                for (int i = 0; fileInput.hasNextLine(); i++) {
                    String next = fileInput.nextLine();
                    String[] nextWords = next.replaceAll("[^A-Za-z]", " ").trim().split(" ");

                    for (String word : nextWords) {
                        if (word.equals(target)) {
                            lines.add(new Line(i, next));
                        }
                    }

                }

                if (lines.isEmpty()) {
                    System.out.println("There were no matches of '" + target + "'.");
                } else {
                    for (Line l : lines) {
                        System.out.println(l.getNumber() + ": " + l.getContent());
                    }
                }

                System.out.println("Would you like to search again? Y/N:");
                char response = userInput.next().toLowerCase().charAt(0);

                if (response == 'y')
                {
                    searchAgain = true;
                } else if (response == 'n')
                {
                    searchAgain = false;
                } else
                {
                    searchAgain = true;
                }
            } while (!searchAgain);
        } catch (IOException | NoSuchElementException e) {
            throw new RuntimeException(e);
        }
    }
}