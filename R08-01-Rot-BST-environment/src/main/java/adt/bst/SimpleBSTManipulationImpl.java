package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	private boolean recursiveEquals(BSTNode<T> node1, BSTNode<T> node2) {
		if (node1.isEmpty() && node2.isEmpty()) {
			return true;
		} else if (!node1.isEmpty() && !node2.isEmpty()) {
			if (node1.equals(node2)) {
				return recursiveEquals((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight()) && recursiveEquals((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft());
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		return recursiveEquals((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
	}

	private boolean recursiveIsSimilar(BSTNode<T> node1, BSTNode<T> node2) {
		if (node1.isEmpty() && node2.isEmpty()) {
			return true;
		} else if (!node1.isEmpty() && !node2.isEmpty()) {
			return recursiveIsSimilar((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight()) && recursiveIsSimilar((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft());
		}
		return false;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		return (recursiveIsSimilar((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot()));
	}

	private T recursiveOrderStatistic(BST<T> tree, BSTNode<T> node, int k, int i) {
		if (node != null) {
			if (k == i) {
				return node.getData();
			}
			return recursiveOrderStatistic(tree, tree.sucessor(node.getData()), k, i + 1);
		}
		return null;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		if (tree.isEmpty()) {
			return null;
		}
		return recursiveOrderStatistic(tree, tree.minimum(), k, 1);
	}
}
