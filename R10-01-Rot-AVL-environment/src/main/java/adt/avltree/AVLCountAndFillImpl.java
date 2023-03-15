package adt.avltree;

import adt.bst.BSTNode;
import adt.bt.Util;
import java.util.*;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {
		this.LLcounter = 0;
		this.LRcounter = 0;
		this.RRcounter = 0;
		this.RLcounter = 0;
	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	protected void rebalance(BSTNode<T> node) {
		BSTNode<T> newRoot = null;
		
		int balance = calculateBalance(node);

		if (Math.abs(balance) > 1) {
			if (balance > 1) {
				if (calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
					newRoot = Util.rightRotation(node);
					LLcounter++;
				} else {
					newRoot = Util.zigZagRightRotation(node);
					LRcounter++;
				}
			} else {
				if (calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
					newRoot = Util.leftRotation(node);
					RRcounter++;
				}
				else {
					newRoot = Util.zigZagLeftRotation(node);
					RLcounter++;
				}
			}
		}

		if (getRoot().equals(node) && newRoot != null) {
			root = newRoot;
		}	
	}

	private boolean increaseHeight(T[] array, int left, int right, int height) {
		boolean aux = false;

		if (right > left) {
			int middle = left + (right - left) / 2;

			if (height == 0) {
				insert(array[middle]);
				aux = true;
			} else {
				boolean result1 = increaseHeight(array, left, middle, height - 1);
				boolean result2 = increaseHeight(array, middle + 1, right, height - 1);
				aux = result1 || result2;
			}
		}
		return aux;
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		
		Set<T> set = new TreeSet<>(Arrays.asList(order()));
		set.addAll(Arrays.asList(array));
		
		array = (T[]) set.toArray(new Comparable[0]);
		root = new BSTNode<>();
		int height = 0;
		
		while (increaseHeight(array, 0, array.length, height)) {
			height++;
		}
	}
}
