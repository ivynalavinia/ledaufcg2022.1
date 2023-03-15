package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 *  - insert
 *  - preOrder
 *  - postOrder
 *  - remove
 *  - height
 *  - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		if (!node.isEmpty()) {
			return recursiveHeight((BSTNode<T>) node.getLeft()) - recursiveHeight((BSTNode<T>) node.getRight());
		} else {
			return 0;
		}
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		BSTNode<T> newRoot = null;
		int balance = calculateBalance(node);

		if (Math.abs(balance) > 1) {
			
			if (balance > 1) {
				
				if (calculateBalance((BSTNode<T>) node.getLeft()) < 0) {
					newRoot = Util.zigZagRightRotation(node);
				} else {
					newRoot = Util.rightRotation(node);
				}
			} else {
				
				if (calculateBalance((BSTNode<T>) node.getRight()) > 0) {
					newRoot = Util.zigZagLeftRotation(node);
				} else {
					newRoot = Util.leftRotation(node);
				}
			}
		}
			
		if (getRoot().equals(node) && newRoot != null) {
			root = newRoot;
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if (node.getParent() != null) {
			rebalance((BSTNode<T>) node.getParent());
			rebalanceUp((BSTNode<T>) node.getParent());
		}
	}

	private void recursiveInsert(BSTNode<T> currentNode, T element) {
		
		if (currentNode.isEmpty()) {
			currentNode.setRight(new BSTNode.Builder<T>().parent(currentNode).build());
			currentNode.setLeft(new BSTNode.Builder<T>().parent(currentNode).build());
			currentNode.setData(element);
		} else {
			if (element.compareTo(currentNode.getData()) > 0) {
				recursiveInsert((BSTNode<T>) currentNode.getRight(), element);
			}
			else {
				recursiveInsert((BSTNode<T>) currentNode.getLeft(), element);
			}
			rebalance(currentNode);
		}
	}
	
	@Override
	public void insert(T element) {
		if (element != null) {
			recursiveInsert(root, element);
		}
	}

	@Override
	public void remove(T element) {
		
		if (element != null) {
			
			BSTNode<T> node = search(element);

			if (!node.isEmpty()) {
				
				if (node.isLeaf()) {
					node.setData(null);
					node.setLeft(null);
					node.setRight(null);
					rebalanceUp(node);
				} else if (isDegreeOne(node)) {
					BSTNode<T> childNode = (BSTNode<T>) node.getRight();
					
					if (childNode.isEmpty()) {
						childNode = (BSTNode<T>) node.getLeft();
					}
					
					if (root.equals(node)) {
						root = childNode;
						root.setParent(null);
					} else {
						childNode.setParent(node.getParent());
						
						if (node.getParent().getLeft().equals(node)) {
							node.getParent().setLeft(childNode);
						} else {
							node.getParent().setRight(childNode);
						}
					}
					
					rebalanceUp(node);
				} else {
					T sucessor = sucessor(node.getData()).getData();
					remove(sucessor);
					node.setData(sucessor);
				}
			}
		}
	}
}
