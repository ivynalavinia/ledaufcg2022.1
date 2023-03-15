package adt.avltree;

import adt.bst.BSTNode;
import adt.bst.BSTVerifierImpl;

/**
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeVerifierImpl<T extends Comparable<T>> extends BSTVerifierImpl<T> implements AVLTreeVerifier<T> {

	private AVLTreeImpl<T> avlTree;

	public AVLTreeVerifierImpl(AVLTree<T> avlTree) {
		super(avlTree);
		this.avlTree = (AVLTreeImpl<T>) avlTree;
	}

	private AVLTreeImpl<T> getAVLTree() {
		return avlTree;
	}

	private boolean recursiveIsAVL(BSTNode<T> currentNode) {
		if (!currentNode.isEmpty()) {
			if (Math.abs(avlTree.calculateBalance(currentNode)) <= 1) {
				return recursiveIsAVL((BSTNode<T>) currentNode.getLeft()) && recursiveIsAVL((BSTNode<T>) currentNode.getRight());
			} else {
				return false;
			}
		}
		return true;
	}

	private boolean isAVL() {
		return avlTree.isEmpty() || recursiveIsAVL(avlTree.getRoot());
	}

	@Override
	public boolean isAVLTree() {
		return isBST() && isAVL();
	}
}
