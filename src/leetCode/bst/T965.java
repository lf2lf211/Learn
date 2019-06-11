package leetCode.bst;

public class T965 {
	int val = 0;

	public boolean isUnivalTree(TreeNode root) {

		return true;

	}

	public static void main(String[] args) {
		// TreeNode root = new TreeNode(5);
		// TreeNode rootLeft = root.left = new TreeNode(3);
		// TreeNode rootRight = root.right = new TreeNode(6);
		// rootLeft.left = new TreeNode(2);
		// rootLeft.right = new TreeNode(4);
		// rootRight.right = new TreeNode(7);
		//
		// System.out.println(isCousins(root, 4, 7));

		TreeNode root = new TreeNode(1);
		TreeNode rootLeft = root.left = new TreeNode(2);
		TreeNode rootRight = root.right = new TreeNode(3);
		rootLeft.right = new TreeNode(4);
		rootRight.right = new TreeNode(5);

	}
}
