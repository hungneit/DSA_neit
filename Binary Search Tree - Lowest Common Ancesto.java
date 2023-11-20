public static Node search(Node node, int data) {
    if (node == null) {
        return null;
    }
    if (data < node.data) {
        node.left = search(node.left, data);
    }
    else if (data > node.data) {
        node.right = search(node.right, data);
    }
    return node;
}
public static Node lca(Node root, int v1, int v2) {
    if (root == null) {
        return null;
    }
    if (v1 < root.data && v2 < root.data) {
        return lca(root.left, v1, v2);
    }
    
    if (v1 > root.data && v2 > root.data){
         return lca(root.right, v1, v2);
    }
    return root;
}