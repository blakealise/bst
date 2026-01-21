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
//            if (!search(value)){
//                return;
//            }
            System.out.println("begin deletion");
            TreeNode newNode = new TreeNode(value);
            if (root == null) {
                return;
            }


            TreeNode current = root;
            boolean isEnd = false;
            while (!isEnd) {
                if(current != null){
//                    System.out.println("Checking " + value + " against: " + current.data);
                    if(value < current.data){ //This tells us we gotta go left if true
//                        System.out.println("I should go left");
                        if(current.left != null){ //Make sure we can do something on current node's left child (like get its value)
                            if(current.left.data == value){ //We found the node to delete, hurray
//                                System.out.println("I should begin deletion");
                                /*
                                    In this section, we can (eventually) write the logic for all 3 deletion cases
                                 */
                                if(current.left.left == null && current.left.right == null){
//                                    System.out.println("no children scenario");
                                    current.left = null;
                                    count--;
                                    return;
                                }
                                if(current.left.left != null && current.left.right !=  null){
                                    TreeNode replacement = current;
                                    replacement = replacement.left.right;
                                    if(replacement.left == null){
                                        current.left.data = replacement.data;
                                        current.left.right = null;
                                    }
                                    while (!isEnd){
                                        if(replacement.left.left == null){ //do not change
                                            current.left.data = replacement.left.data;
                                            if(replacement.left.right != null){
                                                replacement.left = replacement.left.right;
                                            }
                                            else{
                                                replacement.left = null;
                                            }

                                        }
                                        replacement = replacement.left;
                                    }
                                }
                                else{
//                                    System.out.println("one child scenario");
                                    if(current.left.left!= null){
                                        current.left = current.left.left;
                                        count--;
                                        return;
                                    }
                                    else{
                                        current.left = current.left.right;
                                        count--;
                                        return;
                                    }
                                }
                                current.left = null; //Deletion Case 1 - No Children
                                count--;
                                return;
                            }
                            else{
                                current = current.left;
                            }
                        }
                    }
                    if(value > current.data){ //This tells us we gotta go left if true
//                        System.out.println("I should go left");
                        if(current.right != null){ //Make sure we can do something on current node's left child (like get its value)
                            if(current.right.data == value){ //We found the node to delete, hurray
                                System.out.println("I should begin deletion");
                                /*
                                    In this section, we can (eventually) write the logic for all 3 deletion cases
                                 */
                                if(current.right.left == null && current.right.right == null){
//                                    System.out.println("no children scenario");
                                    current.right = null;
                                    count--;
                                    return;
                                }
                                if(current.right.left != null && current.right.right !=  null){
                                    TreeNode replacement = current;
                                    replacement = replacement.right.right;
                                    while (!isEnd){
                                        if(replacement.left.left == null){ //do not change
                                            current.right = replacement.left;
                                            replacement.left = null;
                                        }
                                        replacement = replacement.left;
                                    }
                                }
                                else{
//                                    System.out.println("one child scenario");
                                    if(current.right.left!= null){
                                        current.right = current.right.left;
                                        count--;
                                        return;
                                    }
                                    else{
                                        current.right = current.right.right;
                                        count--;
                                        return;
                                    }
                                }
                                current.right = null; //Deletion Case 1 - No Children
                                count--;
                                return;
                            }
                            else{
                                current = current.right;
                            }
                        }
                    }
                    else{ //Root Scenario
                        if(current.left == null && current.right == null){
                            System.out.println("no children scenario");
                            root = null;
                            count--;
                            return;
                        } //yay up to here
                        if(current.left != null && current.right !=  null){ //Two Children
                            System.out.println("Two Child");
                            current = root;
                            TreeNode replacement = current;
                            current = current.right;
                            while(current.left.left != null) {
                                System.out.println("Begin finding smallest");
                                current = current.left;
                            }
                            replacement = current.left;
                            root.data = replacement.data;
                            current.left = replacement.right;
                            count--;
                            return;

//
//
//                            if(replacement.left == null){
//                                current.data = replacement.data;
//                                current.right = current.right.right;
//                            }
//                            while (!isEnd){
//                             //   TreeNode parentOfReplacement = null;
//                               // if(replacement.left.left==null) {
//                               //     parentOfReplacement = replacement;
//                               // }
//
//                                if(replacement.left == null){
//                                    root.data = replacement.data;
//
//                                    if(replacement.right != null){ // if it has a child
//                                        replacement.data = replacement.right.data;
//                                        replacement.right = replacement.right.right;
//                                        count--;
//                                    }
//                                    else{
//                                        System.out.println("???");
//                                      //  parentOfReplacement.left = null;
//                                    }
//
//                                }
//                                replacement = replacement.left;
//                            }
                        }
                        else{ //One child
                            if(current.left!= null){
                                root = current.left;
                                count--;
                                return;
                            }
                            else{
                                root = current.right;
                                count--;
                                return;
                            }
                        }
                    }
                }
            } //end of while loop
            return;
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
            return 0;
        }
        public int heightHelper(TreeNode current , int hght){
            hght++;
            if(current.left != null ){
          //      postorderHelper(current.left,hght);
            }
            if (current.right != null) {
         //       postorderHelper(current.right,hght);
            }
            return hght;
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


