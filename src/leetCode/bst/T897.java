package leetCode.bst;

public class T897 {
	public static TreeNode increasingBST(TreeNode root) {
		if (root == null) {
			return root;
		}

		TreeNode resNode = root;
		TreeNode tempNode;

		if (root.left != null) {

			resNode = increasingBST(root.left);
			root.left = null;
			tempNode = resNode;
			while (tempNode.right != null) {

				tempNode = tempNode.right;

			}

			tempNode.right = root;

		}

		root.right = increasingBST(root.right);

		return resNode;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);

		root.right = new TreeNode(13);
		increasingBST(root);
	}
}
