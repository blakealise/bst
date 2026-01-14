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
            // TODO: Implement this method
            TreeNode newNode = new TreeNode(value);
            // Hint: Use a recursive helper method
           // if (!search(value)) {
                System.out.println("value is: "+  value);
                if (root == null) {
                    root = newNode;
                    System.out.println("root is: " + newNode.data);
                    return;
                }
                TreeNode current = root;

                System.out.println("current is: " + current);
                boolean isEnd = false;
                while (isEnd == false) {
                    System.out.println("begin going down tree");
                    if (newNode.data < current.data) {
                        if (current.left == null) {
                            getRoot().left = newNode;
                            count++;
                            isEnd = true;
                        } else {
                            current = current.left;
                        }
                    } //end of (smaller than current)
                    if(newNode.data > current.data){
                        if (current.right == null){
                            getRoot().right = newNode;
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
            TreeNode newNode = new TreeNode(value);
            if (root == null) {
                return;
            }
            if(root.data == newNode.data){
                root = null;
                return;
            }
            TreeNode current = root;
            boolean isEnd = false;
            while (!isEnd) {
                if (newNode.data == current.data) { // if its equal to current else go left or right
                    if(newNode.left == null && newNode.right == null){
                        current = null;
                    }
                }
                else{
                    if (newNode.data < current.data){ //if value is less than data
                        current = current.left;
                        if (current.left == null){
                            isEnd = true;
                        }
                    }
                    else{
                        current = current.right;
                        if(current.right == null){
                            isEnd = true;
                        }
                    }
                }
            } //end of while loop
            count--;
            return;
        }

        /**
         * Find the minimum value in the BST.
         *
         * @return The minimum value
         * @throws IllegalStateException if the tree is empty
         */
        public int findMin() {
            // TODO: Implement this method
            // Hint: Keep going left!
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
            return null;
        }

        /**
         * Perform a preorder traversal of the BST.
         *
         * @return A list of values in preorder sequence
         */
        public List preorderTraversal() {
            // TODO: Implement this method
            // Hint: Root -> Left -> Right
            return null;
        }

        /**
         * Perform a postorder traversal of the BST.
         *
         * @return A list of values in postorder sequence
         */
        public List postorderTraversal() {
            // TODO: Implement this method
            // Hint: Left -> Right -> Root
            return null;
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
            return 0;
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
            return false;
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


