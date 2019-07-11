import java.sql.SQLOutput;

public class Runner {

    public static void main(String args[]) {
        testNaryNodes();
    }

    private static void testNaryNodes() {
        NaryNode root = new NaryNode(1);
        root.add(2, 3, 4);
        root.children.get(0).add(6);
        root.children.get(1).add(7, 8, 9);
        root.children.get(2).add(10);

        System.out.println("Preorder Run");
        root.depthFirstPreOrder(root);

        System.out.println("Postorder Run");
        root.depthFirstPostOrder(root);

        System.out.println("Done");
    }

    private static void testBinaryNodes() {
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
    }
}
