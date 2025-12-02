package comt.tree;

public class Main {
    public static void main(String[] args) {
        Node head = new Node("head");
        Node n2 = new Node("node2");
        Node n3 = new Node("node3");
        Node n4 = new Node("node4");
        Node n5 = new Node("node5");
        Node n6 = new Node("node6");
        head.setLeft(n2);
        head.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        BTree tree = new BTree(head);
        System.out.print(tree.print());
    }
}
