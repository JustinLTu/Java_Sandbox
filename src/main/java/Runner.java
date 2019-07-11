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

        root.depthFirstPreOrder(root);
    }
}
