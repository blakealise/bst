import javax.swing.*;

public class main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(25);
        bst.insert(70);
        bst.delete(70);
        System.out.println(bst.size());
    }
}
