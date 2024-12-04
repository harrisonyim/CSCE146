import java.io.*;
import java.util.Scanner;
public class VIdeoGameSearcher {
	 private static GameLL gameList = new GameLL();

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        boolean running = true;

	        while (running) {
	            System.out.println("1. Load Game Collection File");
	            System.out.println("2. Search Games");
	            System.out.println("3. Print to File");
	            System.out.println("4. Exit");
	            System.out.print("Choose an option: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine();  // consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter the game collection file name: ");
	                    String fileName = scanner.nextLine();
	                    loadGameCollection(fileName);
	                    break;
	                case 2:
	                    System.out.print("Enter game title (use * for all): ");
	                    String title = scanner.nextLine();
	                    System.out.print("Enter console (use * for all): ");
	                    String console = scanner.nextLine();
	                    GameLL searchResults = gameList.search(title, console);
	                    System.out.println("Search Results:");
	                    searchResults.printList();
	                    break;
	                case 3:
	                    System.out.print("Enter the file name to save results: ");
	                    String outputFile = scanner.nextLine();
	                    saveResultsToFile(outputFile, gameList);
	                    break;
	                case 4:
	                    running = false;
	                    break;
	                default:
	                    System.out.println("Invalid choice. Try again.");
	                    break;
	            }
	        }
	        scanner.close();
	    }

	    private static void loadGameCollection(String fileName) {
	        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
	            String line;
	            gameList.clear();
	            while ((line = br.readLine()) != null) {
	                String[] parts = line.split("\t");
	                if (parts.length == 2) {
	                    gameList.add(new VideoGame(parts[0], parts[1]));
	                }
	            }
	            System.out.println("Game collection loaded.");
	        } catch (IOException e) {
	            System.out.println("Error loading file: " + e.getMessage());
	        }
	    }

	    private static void saveResultsToFile(String fileName, LinkedList<VideoGame> list) {
	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) { // Appending to the file
	            Node<VideoGame> temp = list.head;
	            while (temp != null) {
	                bw.write(temp.data.toString());
	                bw.newLine();
	                temp = temp.next;
	            }
	            System.out.println("Results saved to " + fileName);
	        } catch (IOException e) {
	            System.out.println("Error writing to file: " + e.getMessage());
	        }
	    }
	}
}
