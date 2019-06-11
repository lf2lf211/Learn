package leetCode.bst;

public class T104 {

	public static int maxDepth(TreeNode root) {

		return count(root);
	}

	public static int count(TreeNode root) {

		if (root == null) {
			return 0;
		}
		if (root.right == null && root.left == null) {
			return 1;
		}

		return Math.max(count(root.left), count(root.right)) + 1;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode rootLeft = root.left = new TreeNode(3);
		TreeNode rootRight = root.right = new TreeNode(6);
		rootLeft.left = new TreeNode(2);
		rootLeft.right = new TreeNode(4);
		rootRight.right = new TreeNode(7);
		rootRight.right.right = new TreeNode(5);
		System.out.println(maxDepth(root));

	}
}
