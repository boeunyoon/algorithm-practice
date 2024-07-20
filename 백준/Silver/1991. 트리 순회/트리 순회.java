import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		Tree tree = new Tree();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char a = st.nextToken().charAt(0);
			char b = st.nextToken().charAt(0);
			char c = st.nextToken().charAt(0);
			tree.addNode(a, b, c);
		}//end input
		preorder(tree.root);
		sb.append("\n");
		inorder(tree.root);
		sb.append("\n");
		postorder(tree.root);
		System.out.println(sb.toString());
	}
	//root, left, right
	static void preorder(TreeNode tree) {
		sb.append(tree.value);
		if(tree.left != null) {
			preorder(tree.left);
		}
		if(tree.right != null) {
			preorder(tree.right);
		}
	}
	//left, root, right
	static void inorder(TreeNode tree) {
		if(tree.left != null) {
			inorder(tree.left);
		}
		sb.append(tree.value);
		if(tree.right != null) {
			inorder(tree.right);
		}
	}
	//left, right, root
	static void postorder(TreeNode tree) {
		if(tree.left != null) {
			postorder(tree.left);
		}
		if(tree.right != null) {
			postorder(tree.right);
		}
		sb.append(tree.value);
	}
	static class Tree{
		TreeNode root;
		void addNode(char value, char left, char right) {
			if(root == null) {
				root = new TreeNode(value);
				if(left != '.') {
					root.left = new TreeNode(left);
				}
				if(right != '.') {
					root.right =new TreeNode(right);
				}
			}else {
				search(root, value, left, right);
			}
		}
		void search(TreeNode root, char value, char left, char right) {
			if(root == null) {
				return;
			}
			if(root.value == value) {
				if(left != '.') {
					root.left = new TreeNode(left);
				}
				if(right != '.') {
					root.right =new TreeNode(right);
				}
			}else {
				search(root.left, value, left, right);
				search(root.right, value, left, right);
			}
		}
	}
	static class TreeNode{
		char value;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(char value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

		public TreeNode(TreeNode left, TreeNode right) {
			super();
			this.left = left;
			this.right = right;
		}
	}
}