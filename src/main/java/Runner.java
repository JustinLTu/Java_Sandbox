public class Runner {

    public static void main(String args[]) {
        testBinarySearchNodesRemove();
    }

    private static void testBinarySearchNodes() {
        BinarySearchNode root = new BinarySearchNode(10);
        root.insertValue( root, 4);
        root.insertValue( root, 6);
        root.insertValue( root, 25);
        root.insertValue( root, 12);
        root.insertValue( root, 19);
        root.insertValue( root, 1);
        System.out.println("Finished");

        System.out.println("Found 12?: " + (root.findValue(root, 12) != null));
        System.out.println("Found 5?: " + (root.findValue(root, 5) != null));
    }

    private static void testBinarySearchNodesRemove() {
        BinarySearchNode root = new BinarySearchNode(10);
        root.insertValue( root, 4);
        root.insertValue( root, 6);
        root.insertValue( root, 25);
        root.insertValue( root, 12);
        root.insertValue( root, 19);
        root.insertValue( root, 1);
        root.insertValue(root, 11);
        root.insertValue(root, 30);

        System.out.println(root.deleteNode(1));
        System.out.println(root.deleteNode(4));
        System.out.println(root.deleteNode(10));
    }

    private static void testNaryNodes() {
        /*
         * Expected Tree
         *
         *        1
         *   2    3    4
         *  6   7 8 9   10
         *
         */
        NaryNode root = new NaryNode(1);
        root.add(2, 3, 4);
        root.children.get(0).add(6);
        root.children.get(1).add(7, 8, 9);
        root.children.get(2).add(10);

        System.out.println("\nPreorder Run");
        root.depthFirstPreOrder(root);

        System.out.println("\nPostorder Run");
        root.depthFirstPostOrder(root);

        System.out.println("\nBreadth First Search");
        root.breadthFirstSearch();

        System.out.println("Done");
    }

    private static void testBinaryNodes() {
        /*
         * Expected Tree
         *
         *       1
         *   2       5
         * 3   4   6   7
         *
         */
        BinaryNode root = new BinaryNode(1);

        root.insertLeft(3);
        root.insertRight(7);

        root.insertLeft(2);
        root.insertRight(5);
        root.left.insertRight(4);
        root.right.insertLeft(6);
        System.out.printf("Left is %d.0. Right is %d.0\n", root.left.value, root.right.value);

        System.out.println("\nPre Order Root: \n");
        root.depthFirstPreOrder(root);

        System.out.println("\nIn Order Root: \n");
        root.depthFirstInOrder(root);

        System.out.println("\nPost Order Root: \n");
        root.depthFirstPostOrder(root);

        System.out.println("\nBreadth First Search Root: \n");
        root.breadthFirstSearch();
    }
}
