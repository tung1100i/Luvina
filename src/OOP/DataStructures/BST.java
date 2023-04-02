package OOP.DataStructures;

public class BST {
    NodeTree root;

    public BST(NodeTree root) {
        this.root = root;
    }

    public BST() {
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void printTree(NodeTree nodee) {
        if (nodee == null) return;
        printTree(nodee.left);
        System.out.println(nodee.key);
        printTree(nodee.right);
    }
    public boolean searchRec(NodeTree root, int key) {
        if (root == null || root.key == key)
            return true;
        if (root.key < key)
            return searchRec(root.right, key);
        return searchRec(root.left, key);
    }

    NodeTree insert(NodeTree nodee, int x) {
        if (nodee == null) {
            nodee = new NodeTree(x);
            return nodee;
        }
        if (x > nodee.key) {
            nodee.left = insert(nodee.right, x);
        } else
            nodee.right = insert(nodee.left, x);
        return nodee;
    }

    void insertNonRec(int x) {
        if (isEmpty())
            root = new NodeTree(x);

        else {
            NodeTree temp = root;
            NodeTree parent = root;
            while (temp != null) {
                parent = temp;
                if (temp.key > x)
                    temp = temp.left;
                else if (temp.key < x)
                    temp = temp.right;
                else
                    return;
            }
            if (parent.key > x) {
                parent.left = new NodeTree(x);
            } else {
                parent.right = new NodeTree(x);
            }
        }
    }

    public boolean search(int x) {
        if (isEmpty()) {
            return false;
        } else {
            NodeTree tmp = root;
            NodeTree parent = root;
            while (tmp != null) {
                parent = tmp;
                if (tmp.key == x) return true;
                else if (tmp.key > x) tmp = tmp.left;
                else if (tmp.key < x) tmp = tmp.right;
            }
        }
        return false;
    }

//public int delete(NodeTree node) {
//    NodeTree curNode = node.right, parent = node;
//        while (curNode.left != null) {
//            parent = curNode;
//            curNode = curNode.left;
//        }
//        if (curNode != node.right) {
//            parent.left = curNode.right;
//        }
//        else {
//            parent.right = curNode.right;
//        }
//        return curNode.key;
//    }


    public static void main(String[] args) {
        BST bts = new BST();
        bts.insertNonRec(50);
        bts.insertNonRec(10);
        bts.insert(bts.root, 70);
        bts.insertNonRec(40);
        bts.insertNonRec(55);
        bts.insertNonRec(80);
        bts.insertNonRec(60);
        bts.printTree(bts.root);
      //  bts.delete(80);
        System.out.println(bts.searchRec(bts.root, 50));
    }
}




