package leetCode.bst;

public class T226 {
	public static TreeNode invertTree(TreeNode root) {

		if (root == null) {
			return null;
		}

		TreeNode left = root.left;
		TreeNode right = root.right;

		root.right = left;

		root.left = right;

		invertTree(left);
		invertTree(right);

		return root;

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(4);
		TreeNode rootLeft = root.left = new TreeNode(2);
		TreeNode rootRight = root.right = new TreeNode(7);
		rootLeft.left = new TreeNode(1);
		rootLeft.right = new TreeNode(3);
		rootRight.left = new TreeNode(6);
		rootRight.right = new TreeNode(9);

	}

}
