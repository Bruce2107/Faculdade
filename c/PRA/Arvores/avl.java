import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// Java program for insertion in AVL Tree
class Node {
    int key, height;
    Node left, right;

    Node(int d) {
        key = d;
        height = 1;
    }
}

class AVLTree {
    int count = 0;
    Node root;

    // A utility function to get the height of the tree
    int height(Node N) {
        count++;
        if (N == null)
            return 0;

        return N.height;
    }

    static int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i; // storing random integers in an array
        }
//        Random rand = new Random();
//
//        for (int i = 0; i < arr.length; i++) {
//            int randomIndexToSwap = rand.nextInt(arr.length);
//            int temp = arr[randomIndexToSwap];
//            arr[randomIndexToSwap] = arr[i];
//            arr[i] = temp;
//        }
        return arr;
    }

    // A utility function to get maximum of two integers
    int max(int a, int b) {
        count++;
        return (a > b) ? a : b;
    }

    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    Node rightRotate(Node y) {
        count++;
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node leftRotate(Node x) {
        count++;
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    int getBalance(Node N) {
        count++;
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    Node insert(Node node, int key) {
        count++;
        /* 1.  Perform the normal BST insertion */
        if (node == null)
            return (new Node(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;

        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),
                height(node.right));
 
        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    // A utility function to print preorder traversal
    // of the tree.
    // The function also prints height of every node
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
//        int size = 10, sum = 0;
//        for(int i = 1; i <= 1000; i++) { // quantidade de chaves
//            while (size > 0) {
//                AVLTree tree = new AVLTree();
//                tree.count = 0;
//                int[] values = generateRandomArray(i);
//                for(int j = 0; j < i; j++) {
//                    tree.root = tree.insert(tree.root, values[j]);
//                }
//                sum += tree.count;
//                size--;
//            }
//            size = 10;
//            int result = sum / 10;
//            sum = 0;
//            System.out.println("AVL;"+i+";"+result);
//        }
        for (int i = 1; i <= 1000; i++) {
            AVLTree tree = new AVLTree();
            tree.count = 0;
            int[] values = generateRandomArray(i);
            for (int j = 0; j < i; j++) {
                tree.root = tree.insert(tree.root, values[j]);
            }
            System.out.println("AVL;" + i + ";" + tree.count);
        }
    }
}
// This code has been contributed by Mayank Jaiswal