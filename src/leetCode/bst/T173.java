package leetCode.bst;

import java.util.ArrayList;
import java.util.List;


public class T173 {
	List<TreeNode> minsList;

	public T173(TreeNode root) {
		minsList = new ArrayList<TreeNode>();

		while (root != null) {
			minsList.add(root);
			root = root.left;
		}

	}

	/** @return the next smallest number */
	public int next() {
		TreeNode min = minsList.remove(minsList.size() - 1);// 拿出最小

		TreeNode subright = min.right;
		while (subright != null) {
			minsList.add(subright);
			subright = subright.left;
		}

		System.out.println("next  : " + min.val);
		return min.val;

	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		System.out.println("hasNext  : " + ((minsList.size() > 0) ? true : false));
		return (minsList.size() > 0) ? true : false;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		TreeNode rootRight = root.right = new TreeNode(15);
		rootRight.left = new TreeNode(9);

		rootRight.right = new TreeNode(20);
		T173 iterator = new T173(root);

		iterator.next();    // return 3
		iterator.next();    // return 7
		iterator.hasNext(); // return true
		iterator.next();    // return 9
		iterator.hasNext(); // return true
		iterator.next();    // return 15
		iterator.hasNext(); // return true
		iterator.next();    // return 20
		iterator.hasNext(); // return false
	}
}
