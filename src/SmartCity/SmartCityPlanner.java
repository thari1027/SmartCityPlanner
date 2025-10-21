package SmartCity;

import java.util.Scanner;

public class SmartCityPlanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph graph = new Graph();
        AVLTree tree = new AVLTree();
        LocationManager manager = new LocationManager(graph, tree);

        // ✅ Add default locations and roads
        System.out.println("Loading default city data...");
        String[] defaultLocations = {"Colombo", "Kandy", "Galle", "Jaffna", "Negombo"};
        for (String loc : defaultLocations) {
            manager.addLocation(loc);
        }

        manager.addRoad("Colombo", "Kandy");
        manager.addRoad("Colombo", "Galle");
        manager.addRoad("Kandy", "Jaffna");
        manager.addRoad("Galle", "Negombo");
        manager.addRoad("Negombo", "Colombo");
        System.out.println("Default city data loaded successfully.\n");

        int choice;
        do {
            System.out.println("\n--- Smart City Route Planner ---");
            System.out.println("1. Add a new location");
            System.out.println("2. Remove a location");
            System.out.println("3. Add a road between locations");
            System.out.println("4. Remove a road");
            System.out.println("5. Display all connections");
            System.out.println("6. Display all locations (AVL Tree)");
            System.out.println("7. BFS Traversal");
            System.out.println("8. DFS Traversal");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("❌ Invalid input. Enter a number: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter location name: ");
                    manager.addLocation(sc.nextLine());
                    break;

                case 2:
                    System.out.print("Enter location name to remove: ");
                    manager.removeLocation(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Enter first location: ");
                    String from = sc.nextLine();
                    System.out.print("Enter second location: ");
                    String to = sc.nextLine();
                    manager.addRoad(from, to);
                    break;

                case 4:
                    System.out.print("Enter first location: ");
                    from = sc.nextLine();
                    System.out.print("Enter second location: ");
                    to = sc.nextLine();
                    manager.removeRoad(from, to);
                    break;

                case 5:
                    manager.displayConnections();
                    break;

                case 6:
                    manager.displayLocations();
                    break;

                case 7:
                    System.out.print("Enter starting location: ");
                    graph.bfsTraversal(sc.nextLine());
                    break;

                case 8:
                    System.out.print("Enter starting location: ");
                    graph.dfsTraversal(sc.nextLine());
                    break;

                case 9:
                    System.out.println("👋 Exiting Smart City Planner. Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }

        } while (choice != 9);
        sc.close();
        System.out.println("Resources released. Exiting application.");
    }

}