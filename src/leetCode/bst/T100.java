package leetCode.bst;

public class T100 {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		return compare(p, q);
	}

	public boolean compare(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}

		if (p == null || q == null) {
			return false;
		}

		return p.val == q.val && compare(p.left, q.left) && compare(p.right, q.right);

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(13);

	}
}
