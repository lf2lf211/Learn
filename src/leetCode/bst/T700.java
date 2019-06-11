package leetCode.bst;

public class T700 {

	public TreeNode searchBST(TreeNode root, int val) {

		TreeNode currentNode = root;
		// 找到key值的node
		while (currentNode != null && currentNode.val != val) {
			if (val < currentNode.val) {
				currentNode = currentNode.left;
			} else if (val > currentNode.val) {
				currentNode = currentNode.right;
			}
		}
		return currentNode;
	}

	public static void main(String[] args) {

	}
}
