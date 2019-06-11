package leetCode.bst;

import java.util.HashSet;
import java.util.Set;


public class T993 {

	public static boolean isCousins(TreeNode root, int x, int y) {
		Set<Integer> xstack = new HashSet<>(), ystack = new HashSet<>();
		path(xstack, root, x);
		path(ystack, root, y);

		return xstack.size() == ystack.size() && xstack.retainAll(ystack) && xstack.size() < ystack.size() - 1;
	}

	private static boolean path(Set<Integer> stack, TreeNode n, int val) {
		if (n == null)
			return false;
		if (n.val == val || path(stack, n.left, val) || path(stack, n.right, val)) {
			stack.add(n.val);
			return true;
		}
		return false;
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

		System.out.println(isCousins(root, 4, 5));
	}
}
