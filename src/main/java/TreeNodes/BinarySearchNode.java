package TreeNodes;

public class BinarySearchNode {
    public int value;
    public BinarySearchNode left;
    public BinarySearchNode right;

    public BinarySearchNode(int nodeValue) {
        this.value = nodeValue;
        left = null;
        right = null;
    }

    public BinarySearchNode() {
        this.value = -1;
        left = null;
        right = null;
    }

    public void insertValue(BinarySearchNode root, int newValue) {
        if(newValue <= root.value) {
            if(root.left == null) {
                root.left = new BinarySearchNode(newValue);
            } else {
                insertValue(root.left, newValue);
            }
        } else {
            if(root.right == null) {
                root.right = new BinarySearchNode(newValue);
            } else {
                insertValue(root.right, newValue);
            }
        }
    }

    public BinarySearchNode findValue(BinarySearchNode root, int targetValue) {
        if(root.value == targetValue) {
            return root;
        } else if(targetValue < root.value) {
            if(root.left == null) {
                return null;
            } else {
                return findValue(root.left, targetValue);
            }
        } else {
            if(root.right == null) {
                return null;
            } else {
                return findValue(root.right, targetValue);
            }
        }
    }

    public boolean deleteNode(int targetNodeValue) {
        return deleteNodeRecursion(targetNodeValue, this, null);
    }

    private boolean deleteNodeRecursion(int targetValue, BinarySearchNode currentNode, BinarySearchNode parent) {
        //Found node to remove
        if(currentNode.value == targetValue) {
            //Target node has no children
            if(currentNode.left == null && currentNode.right == null) {
                if(parent == null) {
                    System.out.println("Error: Found node with no children and no parent. Is this node the only one in the tree?");
                    return false;
                }

                if(parent.left.equals(currentNode)) {
                    parent.left = null;
                    return true;
                } else if (parent.right.equals(currentNode)){
                    parent.right = null;
                    return true;
                } else {
                    System.out.println("Error: Found target node but its parent doesn't see it as a child node");
                    return false;
                }
            }
            //Target node has only a left child
            else if (currentNode.left != null && currentNode.right == null) {
                if(currentNode.value < parent.value) {
                    parent.left = currentNode.left;
                } else {
                    parent.right = currentNode.left;
                }

                return true;
            }
            //Target node has only a right child
            else if (currentNode.right != null && currentNode.left == null) {
                if(currentNode.value < parent.value) {
                    parent.left = currentNode.right;
                } else {
                    parent.right = currentNode.right;
                }
                return true;
            }
            //Target node has a left and right child
            else {
                currentNode.value = findMinimumNode(currentNode.right);
                return deleteNodeRecursion(currentNode.value, currentNode.right, currentNode);
            }
        }
        //Searching for node to remove
        else {
            if(targetValue < currentNode.value && currentNode.left != null) {
                return deleteNodeRecursion(targetValue, currentNode.left, currentNode);
            } else if (targetValue > currentNode.value && currentNode.right != null) {
                return deleteNodeRecursion(targetValue, currentNode.right, currentNode);
            } else {
                System.out.printf("Could not find target node %d.0 in the given tree.", targetValue);
                return false;
            }
        }
    }

    private int findMinimumNode(BinarySearchNode currentNode) {
        if(currentNode.left != null) {
            return findMinimumNode(currentNode.left);
        }
        return currentNode.value;
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof BinarySearchNode) && ((BinarySearchNode) other).value == this.value;
    }
}
