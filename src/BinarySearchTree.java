import java.util.ArrayList;
import java.util.List;


    public class BinarySearchTree {

        private TreeNode root;
        int count = 0;

        /**
         * Constructor - initializes an empty BST.
         */
        public BinarySearchTree() {
            this.root = null;
        }

        /**
         * Insert a value into the BST.
         * If the value already exists, do not insert it (no duplicates allowed).
         *
         * @param value The value to insert
         */
        public void insert(int value) {
            System.out.println();
            System.out.println("Trying to add: " + value);
            // TODO: Implement this method
            TreeNode newNode = new TreeNode(value);
            // Hint: Use a recursive helper method
           // if (!search(value)) {
                System.out.println("value is: "+  value);
                if (root == null) {
                    root = newNode;
                    System.out.println("root is: " + newNode.data);
                    count++;
                    return;
                }
                TreeNode current = root;

                System.out.println("current is: " + current.data);
                boolean isEnd = false;
                while (isEnd == false) {
                    if (newNode.data < current.data) {
                        if (current.left == null) {
                            current.left = newNode;
                            count++;
                            isEnd = true;
                        } else {
                            current = current.left;
                            System.out.println("i scooted left");
                            System.out.println(current.data);
                        }
                    } //end of (smaller than current)
                     if(newNode.data > current.data){
                        if (current.right == null){
                            current.right = newNode;
                            count++;
                            isEnd = true;
                        }
                        else{
                            current = current.right;
                        }
                    } //end of (bigger than current)
                } //end of while loop
          //  } // end of (if node is new value and not already in tree)
        }

        /**
         * Search for a value in the BST.
         *
         * @param value The value to search for
         * @return true if the value exists in the tree, false otherwise
         */
        public boolean search(int value) {
            // TODO: Implement this method
            // Hint: Use recursion and leverage BST property
            TreeNode newNode = new TreeNode(value);
                if (root == null) {
                    return false;
                }
                TreeNode current = root;
                boolean isEnd = false;
                while (!isEnd) {
                    if (newNode.data == current.data) { // if its equal to current else go left or right
                        return true;
                    }
                    else{
                        if (newNode.data < current.data){
                            current = current.left;
                            if (current == null){
                                isEnd = true;
                            }
                        }
                        else{
                            current = current.right;
                            if(current == null){
                                isEnd = true;
                            }
                        }
                    }
                } //end of while loop
            return false;
        }

        /**
         * Delete a value from the BST.
         * If the value doesn't exist, do nothing.
         *
         * @param value The value to delete
         */
        public void delete(int value) {
            // TODO: Implement this method
            // Hint: Handle three cases - leaf, one child, two children
            // For two children, use inorder successor or predecessor
             root = deleteHelp(root,value);
        }
        public TreeNode deleteHelp (TreeNode current, int value){
            System.out.println();
            if(current == null){
                return null;
            }
            if(current.data == value){
                System.out.println("Match found for deletion");
                count--;

               if(getNumOfChildren(current) == 0) { //Zero Children Case
                return null;
            }

              else if(getNumOfChildren(current) == 1) { //One Child Case
                System.out.println("one child");
                if(current.left == null){
                    return current.right;
                }
                if(current.right == null){
                    return current.left;
                }
            }

              else if(getNumOfChildren(current)==2) { //Two Children Case
                System.out.println("two children");
                TreeNode replacement = current.right;

                while(replacement.left != null){
                    replacement = replacement.left;
                }
                current.data = replacement.data;
                current.right = deleteHelp(current.right,replacement.data);
//                current.data = replacement.data;
//                if(current.right != null) {
//                    current.right = current.right.right;
//                }
              }
            }

            else if(value < current.data ){
//                current = current.left;
                TreeNode result = deleteHelp(current.left, value);
                current.left = result;
                System.out.println("Setting " +  current.data + "'s left to: " + result);
            }
            else{
//                current = current.right; Not needed
                current.right = deleteHelp(current.right,value);
            }
            //dont forget to count--
            return current;
        }

        public int getNumOfChildren(TreeNode node) {
            int childrenCount = 0;
            if(node.left != null){
                childrenCount++;
            }
            if(node.right != null) {
                childrenCount++;
            }
            return childrenCount;
        }

        /**
         * Find the minimum value in the BST.
         *
         * @return The minimum value
         * @throws IllegalStateException if the tree is empty
         */
        public int findMin() throws Exception{
            // TODO: Implement this method
            // Hint: Keep going left!
            boolean isEnd = false;
            TreeNode current = root; //mr u if you see this send me an email with your favorite food emoji
            if(root == null){
                throw new IllegalStateException("Tree is empty!!! 🤣🌳");
            }
            while (!isEnd){
                if(current.left == null){
                    return current.data;
                }
                current = current.left;
            }
            return 0;
        }

        /**
         * Find the maximum value in the BST.
         *
         * @return The maximum value
         * @throws IllegalStateException if the tree is empty
         */
        public int findMax() {
            // TODO: Implement this method
            // Hint: Keep going right!
            boolean isEnd = false;
            TreeNode current = root;
            if(root == null){

                throw new IllegalStateException("Tree is empty!!! 🤣🌳");
            }
            while (!isEnd){
                if(current.right == null){
                    return current.data;
                }
                current = current.right;
            }
            return 0;
        }

        /**
         * Perform an inorder traversal of the BST.
         *
         * @return A list of values in inorder sequence
         */
        public List inorderTraversal() {
            // TODO: Implement this method
            // Hint: Left -> Root -> Right
            // Should return values in sorted order!
            List llist = new ArrayList();
            return inorderHelper(root, llist);
        }

        public List inorderHelper(TreeNode current, List llist){
            if(current.left != null ){
                inorderHelper(current.left,llist);
            }
            llist.add(current.data);
            if (current.right != null) {
                inorderHelper(current.right,llist);
            }
            return llist;
        }

        /**
         * Perform a preorder traversal of the BST.
         *
         * @return A list of values in preorder sequence
         */
        public List preorderTraversal() {
            // TODO: Implement this method
            // Hint: Root -> Left -> Right
            List llist = new ArrayList();
            return preorderHelper(root, llist);
        }
        public List preorderHelper(TreeNode current, List llist){
            llist.add(current.data);
            if(current.left != null ){
                preorderHelper(current.left,llist);
            }
            if (current.right != null) {
                preorderHelper(current.right,llist);
            }
            return llist;
        }

        /**
         * Perform a postorder traversal of the BST.
         *
         * @return A list of values in postorder sequence
         */
        public List postorderTraversal() {
            // TODO: Implement this method
            // Hint: Left -> Right -> Root
            List llist = new ArrayList();
            return postorderHelper(root, llist);
        }
        public List postorderHelper(TreeNode current, List llist){
            llist.add(current.data);
            if(current.left != null ){
                postorderHelper(current.left,llist);
            }
            if (current.right != null) {
                postorderHelper(current.right,llist);
            }
            return llist;
        }

        /**
         * Calculate the height of the BST.
         * Height is defined as the number of edges on the longest path from root to leaf.
         * An empty tree has height -1, a tree with one node has height 0.
         *
         * @return The height of the tree
         */
        public int height() {
            // TODO: Implement this method
            // Hint: Use recursion - height = 1 + max(left height, right height)

                return 1+heightHelper(root,0,-1);
            }
        public int heightHelper(TreeNode current , int mhght, int chght){
            chght++;
            if(chght>= mhght){
                mhght = chght;
            }
            if(current.left != null ){
               mhght = heightHelper(current.left, mhght, chght);
            }
            if (current.right != null) {
                mhght = heightHelper(current.right, mhght, chght);
            }
            return mhght;
        }

        /**
         * Count the number of nodes in the BST.
         *
         * @return The number of nodes
         */
        public int size() {
            // TODO: Implement this method
            // Hint: Recursively count nodes
            if(root == null){
                return 0;
            }
            return count;
        }

        /**
         * Check if the BST is empty.
         *
         * @return true if the tree is empty, false otherwise
         */
        public boolean isEmpty() {
            // TODO: Implement this method
            return (root == null);
        }

        /**
         * Get the root of the tree (for testing purposes).
         *
         * @return The root node
         */
        public TreeNode getRoot() {
            return this.root;
        }

        // ========================================
        // HELPER METHODS
        // You may add private helper methods below
        // ========================================

        // Example helper method structure:
        // private TreeNode insertHelper(TreeNode node, int value) {
        //     // Your code here
        // }
    }


