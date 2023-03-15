package adt.bt;

import adt.bst.BSTNode;

public class Util {


	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * @param node
	 * @return - noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		BSTNode<T> rightNode = (BSTNode<T>) node.getRight();

		node.setRight(rightNode.getLeft());
		node.getRight().setParent(node);

		rightNode.setParent(node.getParent());
		
		rightNode.setLeft(node);
		node.setParent(rightNode);

		if (rightNode.getParent() != null) {
			if (rightNode.getParent().getLeft().equals(node)) {
				rightNode.getParent().setLeft(rightNode);
			} else {
				rightNode.getParent().setRight(rightNode);
			}
		}
		return rightNode;
	}

	public static <T extends Comparable<T>> BSTNode<T> zigZagLeftRotation(BSTNode<T> node) {
		rightRotation((BSTNode<T>) node.getRight());
		return leftRotation(node);
	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * @param node
	 * @return noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		BSTNode<T> leftNode = (BSTNode<T>) node.getLeft();

		node.setLeft(leftNode.getRight());
		node.getLeft().setParent(node);

		leftNode.setParent(node.getParent());
		
		leftNode.setRight(node);
		node.setParent(leftNode);

		if (leftNode.getParent() != null) {
			if (leftNode.getParent().getRight().equals(node)) {
				leftNode.getParent().setRight(leftNode);
			} else {
				leftNode.getParent().setLeft(leftNode);
			}
		}
		return leftNode;
	}

	public static <T extends Comparable<T>> BSTNode<T> zigZagRightRotation(BSTNode<T> node) {
		leftRotation((BSTNode<T>) node.getLeft());
		return rightRotation(node);
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}
