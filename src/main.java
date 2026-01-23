import javax.swing.*;

public class main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(25);
        bst.insert(75);
        bst.insert(60);
        bst.insert(80);
        bst.insert(65);




        System.out.println(bst.height());
    }
}
