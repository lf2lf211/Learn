package leetCode.bst;

public class T538 {
	static int sum = 0;

	public static TreeNode convertBST(TreeNode root) {
		if (root != null) {
			if (root.right != null) {
				root.right.val = convertBST(root.right).val;
			}
			root.val = root.val + sum;
			sum = root.val;
			if (root.left != null) {
				root.left.val = convertBST(root.left).val;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(13);

		convertBST(root);
		System.out.println(root.val);

		System.out.println(root.right.val);
		System.out.println(root.left.val);
	}
}
