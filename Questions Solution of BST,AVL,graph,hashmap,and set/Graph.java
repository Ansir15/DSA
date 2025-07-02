//import java.util.*;
//
//class DeliveryNetwork {
//    private Map<String, List<String>> graph;
//
//    public DeliveryNetwork() {
//        graph = new HashMap<>();
//    }
//
//    // Add a hub (if not already exists)
//    public void addHub(String name) {
//        graph.putIfAbsent(name, new ArrayList<>());
//    }
//
//    // Connect two hubs (undirected)
//    public void connectHubs(String hub1, String hub2) {
//        if (graph.containsKey(hub1) && graph.containsKey(hub2)) {
//            graph.get(hub1).add(hub2);
//            graph.get(hub2).add(hub1);
//        }
//    }
//
//    // Display the graph map
//    public void printNetworkMap() {
//        System.out.println("Delivery Network Map:");
//        for (String hub : graph.keySet()) {
//            System.out.println(hub + " → " + graph.get(hub));
//        }
//    }
//
//    // Perform BFS from a specific hub
//    public void bfsFrom(String startHub) {
//        if (!graph.containsKey(startHub)) {
//            System.out.println("Hub does not exist.");
//            return;
//        }
//
//        Set<String> visited = new HashSet<>();
//        Queue<String> queue = new LinkedList<>();
//        queue.offer(startHub);
//        visited.add(startHub);
//
//        System.out.println("Reachable hubs from " + startHub + " (BFS):");
//        while (!queue.isEmpty()) {
//            String current = queue.poll();
//            System.out.print(current + " ");
//            for (String neighbor : graph.get(current)) {
//                if (!visited.contains(neighbor)) {
//                    visited.add(neighbor);
//                    queue.offer(neighbor);
//                }
//            }
//        }
//        System.out.println();
//
//        // Print unreachable hubs after BFS
//        if (visited.size() != graph.size()) {
//            System.out.println("Some hubs are disconnected.");
//            for (String hub : graph.keySet()) {
//                if (!visited.contains(hub)) {
//                    System.out.println(hub + " is disconnected from the main network.");
//                }
//            }
//        } else {
//            System.out.println("All hubs are connected.");
//        }
//    }
//}
//public class Graph {
//    public static void main(String[] args) {
//        DeliveryNetwork network = new DeliveryNetwork();
//
//        // Add hubs
//        network.addHub("HubA");
//        network.addHub("HubB");
//        network.addHub("HubC");
//        network.addHub("HubD");
//        network.addHub("HubE");
//
//        // Connect hubs
//        network.connectHubs("HubA", "HubB");
//        network.connectHubs("HubB", "HubC");
//        network.connectHubs("HubC", "HubD");
//
//        // Print map
//        network.printNetworkMap();
//        System.out.println();
//
//        // BFS from HubA
//        network.bfsFrom("HubA");
//    }
//}


//====================================================================================

import java.util.*;

class TownMap {
    private Map<String, List<String>> adjacencyList;

    public TownMap() {
        adjacencyList = new HashMap<>();
    }

    // Add a zone to the town map
    public void addZone(String name) {
        adjacencyList.putIfAbsent(name, new ArrayList<>());
    }

    // Add a road between two zones (undirected edge)
    public void addRoad(String zone1, String zone2) {
        addZone(zone1);
        addZone(zone2);
        adjacencyList.get(zone1).add(zone2);
        adjacencyList.get(zone2).add(zone1);
    }

    // Perform BFS from a starting zone and return reachable zones
    public List<String> bfsFrom(String startZone) {
        List<String> reachable = new ArrayList<>();
        if (!adjacencyList.containsKey(startZone)) {
            return reachable;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(startZone);
        visited.add(startZone);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            reachable.add(current);

            for (String neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return reachable;
    }

    // Check if the entire town is fully connected
    public boolean isFullyConnected() {
        if (adjacencyList.isEmpty()) {
            return true;
        }

        // Start DFS from the first zone
        String startZone = adjacencyList.keySet().iterator().next();
        Set<String> visited = new HashSet<>();
        dfs(startZone, visited);

        return visited.size() == adjacencyList.size();
    }

    // DFS helper method
    private void dfs(String current, Set<String> visited) {
        visited.add(current);
        for (String neighbor : adjacencyList.get(current)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }

    // Print all disconnected zones
    public void printDisconnectedZones() {
        if (adjacencyList.isEmpty()) {
            System.out.println("Town is empty.");
            return;
        }

        Set<String> allZones = new HashSet<>(adjacencyList.keySet());
        Set<String> visited = new HashSet<>();

        // Find all connected components
        for (String zone : adjacencyList.keySet()) {
            if (!visited.contains(zone)) {
                Set<String> component = new HashSet<>();
                dfs(zone, component);

                // If component size doesn't match total zones, there are disconnected zones
                if (component.size() != allZones.size()) {
                    Set<String> disconnected = new HashSet<>(allZones);
                    disconnected.removeAll(component);
                    for (String dcZone : disconnected) {
                        System.out.println(dcZone + " is DISCONNECTED.");
                    }
                    return;
                }
                visited.addAll(component);
            }
        }

        System.out.println("All zones are connected.");
    }

    // Print the town map representation
    public void printTownMap() {
        System.out.println("Town Map:");
        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        TownMap town = new TownMap();

        // Add zones and roads
        town.addZone("A");
        town.addZone("B");
        town.addZone("C");
        town.addZone("D");
        town.addZone("E");

        town.addRoad("A", "B");
        town.addRoad("A", "C");
        town.addRoad("B", "D");

        // Print the town map
        town.printTownMap();

        // Check reachability from A
        System.out.println("Zones reachable from A (BFS):");
        List<String> reachable = town.bfsFrom("A");
        System.out.println(String.join(" ", reachable));

        // Check connectivity
        if (!town.isFullyConnected()) {
            System.out.println("\nSome zones are disconnected.");
            town.printDisconnectedZones();
        }
    }
}