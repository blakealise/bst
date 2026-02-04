import javax.swing.*;

public class main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(20);
        bst.insert(10);

        bst.delete(10);
        System.out.println();
    }
}
