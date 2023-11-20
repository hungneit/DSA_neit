public static int m = 0;
	public static int height(Node root) {
        if (root == null) { 
            return -1;
        }
        m = Math.max(height(root.left), height(root.right))+1;
        return m;
    }