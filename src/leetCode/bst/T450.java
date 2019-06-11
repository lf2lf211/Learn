package leetCode.bst;

public class T450 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode rootLeft = root.left = new TreeNode(3);
		TreeNode rootRight = root.right = new TreeNode(6);
		rootLeft.left = new TreeNode(2);
		rootLeft.right = new TreeNode(4);
		rootRight.right = new TreeNode(7);

		// System.out.println(root.val);
		// System.out.println(root.left.val);
		// System.out.println(root.right.val);

		System.out.println(deleteNode(root, 3).val);
		System.out.println(deleteNode(root, 3).left.val);
		System.out.println(deleteNode(root, 3).right.val);
		System.out.println(deleteNode(root, 3).left.left.val);
		System.out.println(deleteNode(root, 3).right.right.val);
	}

	private static TreeNode delete(TreeNode root) {

		if (root == null) {
			return null;
		}
		// 右邊左邊沒有則回傳右邊
		if (root.left == null) {
			return root.right;
		}

		// 右邊沒有則回傳左邊
		if (root.right == null) {
			return root.left;
		}
		// 找出右邊最小
		TreeNode min = findMin(root.right);

		// 再把刪除的root的左邊放進min左邊
		min.left = root.left;

		return root.right;
	}

	private static TreeNode findMin(TreeNode root) {
		// 找到該root左邊最小直
		while (root.left != null) {
			root = root.left;

		}

		return root;
	}

	public static TreeNode deleteNode(TreeNode root, int key) {
		TreeNode currentNode = root;// 當前
		TreeNode previousNode = null;// 上一個
		// 找到key值的node
		while (currentNode != null && currentNode.val != key) {
			previousNode = currentNode;
			if (key < currentNode.val) {
				currentNode = currentNode.left;
			} else if (key > currentNode.val) {
				currentNode = currentNode.right;
			}
		}

		// 沒有上一個 等於當前就是要刪除的目標
		if (previousNode == null) {
			return delete(currentNode);
		}

		// 判斷目標是左還又 開始刪除
		if (previousNode.left == currentNode) {
			previousNode.left = delete(currentNode);
		} else {
			previousNode.right = delete(currentNode);
		}

		return root;
	}
}
