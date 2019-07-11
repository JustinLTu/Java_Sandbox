import java.sql.SQLOutput;

public class Runner {

    public static void main(String args[]) {
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
