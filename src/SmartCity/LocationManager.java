package SmartCity;

public class LocationManager {
    private Graph graph;
    private AVLTree locationTree;

    public LocationManager(Graph graph, AVLTree tree) {
        this.graph = graph;
        this.locationTree = tree;
    }

    public void addLocation(String location) {
        graph.addLocation(location);
        locationTree.insert(location);
        System.out.println("✅ Location '" + location + "' added successfully.");
    }

    public void removeLocation(String location) {
        graph.removeLocation(location);
        locationTree.delete(location);
        System.out.println("🗑 Location '" + location + "' removed.");
    }

    public void addRoad(String from, String to) {
        graph.addRoad(from, to);
    }

    public void removeRoad(String from, String to) {
        graph.removeRoad(from, to);
    }

    public void displayConnections() {
        graph.displayConnections();
    }

    public void displayLocations() {
        System.out.print("🌆 All Locations (In-order): ");
        locationTree.inOrder();
        System.out.println();
    }
}