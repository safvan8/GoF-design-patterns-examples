package flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Flyweight class
class TreeType {
	private String name;
	private String color;
	private String texture;

	// Constructor to initialize intrinsic properties
	public TreeType(String name, String color, String texture) {
		this.name = name;
		this.color = color;
		this.texture = texture;
	}

	// Method to draw the tree on the canvas
	public void draw(String canvas, int x, int y) {
		System.out.println("Drawing " + color +" "+ name + " tree at coordinates (" + x + ", " + y + ")");
		// Include logic to draw the tree based on the type, color, and texture
	}
}

// Flyweight Factory class
class TreeFactory {
	private static Map<String, TreeType> treeTypes = new HashMap<>();

	// Method to get or create a flyweight based on name, color, and texture
	public static TreeType getTreeType(String name, String color, String texture) {
		String key = name + color + texture;
		TreeType type = treeTypes.get(key);

		if (type == null) {
			type = new TreeType(name, color, texture);
			treeTypes.put(key, type);
		}

		return type;
	}
}

//Contextual Object class
class Tree {
	private int x, y;
	private TreeType type; // Reference to the shared flyweight

	// Constructor to initialize extrinsic properties and set the flyweight
	public Tree(int x, int y, TreeType type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}

	// Method to draw the tree using the shared flyweight
	public void draw(String canvas) {
		type.draw(canvas, x, y);
	}
}

// Client class
class Forest {
	private List<Tree> trees = new ArrayList<>();

	// Method to plant a tree with shared attributes
	public void plantTree(int x, int y, String name, String color, String texture) {
		TreeType type = TreeFactory.getTreeType(name, color, texture);
		Tree tree = new Tree(x, y, type);
		trees.add(tree);
	}

	// Method to draw all trees in the forest
	public void draw(String canvas) {
		for (Tree tree : trees) {
			tree.draw(canvas);
		}
	}
}
