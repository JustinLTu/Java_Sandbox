import java.util.LinkedList;

public class NaryNode {
    public int value;
    public LinkedList<NaryNode> children;

    public NaryNode() {
        this.value = -1;
        children = new LinkedList<NaryNode>();
    }

    public NaryNode(int value) {
        this.value = value;
        children = new LinkedList<NaryNode>();
    }

    public boolean isLeaf() {
        return children.size() == 0;
    }

    public void add(int childValue) {
        children.add(new NaryNode(childValue));
    }

    public void add(int ... childValues) {
        for(int i = 0; i < childValues.length; i++) {
            int value = childValues[i];
            children.add(new NaryNode(value));
        }
    }

    public void depthFirstPreOrder(NaryNode current) {
        System.out.printf("Found %d.0 \n", current.value);

        for (int i = 0; i < current.children.size(); i++) {
            NaryNode child = current.children.get(i);
            depthFirstPreOrder(child);
        }
    }

    public void depthFirstPostOrder(NaryNode current) {
        for (int i = 0; i < current.children.size(); i++) {
            NaryNode child = current.children.get(i);
            depthFirstPostOrder(child);
        }

        System.out.printf("Found %d.0 \n", current.value);
    }

    public void breadthFirstSearch() {
        LinkedList<NaryNode> queue = new LinkedList();
        queue.add(this);

        while(!queue.isEmpty()) {
            NaryNode first = queue.removeFirst();
            System.out.printf("Current value = %d.0\n", first.value);

            for(NaryNode child: first.children) {
                queue.add(child);
            }
        }
    }
}
