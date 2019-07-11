public class BinaryNode {
    public int value;
    public BinaryNode left;
    public BinaryNode right;

    public BinaryNode() {
        this.value = -1;
        left = null;
        right = null;
    }

    public BinaryNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    public boolean isLeaf() {
        return (this.left == null) && (this.right == null);
    }

    public void insertLeft(int newValue) {
        if(this.left == null) {
            this.left = new BinaryNode(newValue);
        } else {
            BinaryNode replacement = new BinaryNode(newValue);
            replacement.left = this.left;
            this.left = replacement;
        }
    }

    public void insertRight(int newValue) {
        if(this.right == null) {
            this.right = new BinaryNode(newValue);
        } else {
            BinaryNode replacement = new BinaryNode(newValue);
            replacement.right = this.right;
            this.right = replacement;
        }
    }

    public void depthFirstPreOrder(BinaryNode current) {
        System.out.printf("Found %d.0 \n", current.value);

        if(current.left != null) {
            depthFirstPreOrder(current.left);
        }

        if(current.right != null) {
            depthFirstPreOrder(current.right);
        }
    }

    public void depthFirstInOrder(BinaryNode current) {
        if(current.left != null) {
            depthFirstInOrder(current.left);
        }

        System.out.printf("Found %d.0 \n", current.value);

        if(current.right != null) {
            depthFirstInOrder(current.right);
        }
    }

    public void depthFirstPostOrder(BinaryNode current) {
        if(current.left != null) {
            depthFirstPostOrder(current.left);
        }

        if(current.right != null) {
            depthFirstPostOrder(current.right);
        }
        System.out.printf("Found %d.0 \n", current.value);
    }
}
