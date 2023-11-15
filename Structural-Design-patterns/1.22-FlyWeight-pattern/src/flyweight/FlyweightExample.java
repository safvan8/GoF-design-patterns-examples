package flyweight;

public class FlyweightExample {
    public static void main(String[] args) {
        // Create a forest and plant some trees with shared attributes
        Forest forest = new Forest();
        forest.plantTree(1, 2, "Oak", "Green", "Leafy");
        forest.plantTree(3, 4, "Pine", "Green", "Needles");
        forest.plantTree(5, 6, "Oak", "Brown", "Leafy");

        // Draw the entire forest
        forest.draw("MainCanvas");
    }
}
