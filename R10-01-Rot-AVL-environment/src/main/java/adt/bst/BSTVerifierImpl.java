package adt.bst;


import adt.bt.BTNode;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {
	
	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}
	
	private BSTImpl<T> getBSt() {
		return bst;
	}

    private boolean validateLeft(BTNode<T> currentNode, BTNode<T> root) {
        boolean aux = true;

        if (!currentNode.isEmpty()) {
        	if (currentNode.getData().compareTo(root.getData()) < 0) {
        		aux = validateLeft(currentNode.getLeft(), root) && validateLeft(currentNode.getRight(), root);
        	}               
            else {
            	aux = false;
            }
        }
        return aux;
	}

    private boolean isValidLeft(BTNode<T> node) {
        return validateLeft(node.getLeft(), node);
    }

    private boolean validateRight(BTNode<T> currentNode, BTNode<T> root) {
        boolean aux = true;

        if (!currentNode.isEmpty()) {
        	if (currentNode.getData().compareTo(root.getData()) > 0) {
        		aux = validateRight(currentNode.getLeft(), root) && validateRight(currentNode.getRight(), root);
        	} else {
            	aux = false;
            }               
        }
        return aux;
    }

    private boolean isValidRight(BTNode<T> node) {
        return validateRight(node.getRight(), node);
    }
	
	private boolean recursiveIsBST(BTNode<T> currentNode) {
        boolean aux = true;

	    if (!currentNode.isEmpty()) {
	    	if (isValidLeft(currentNode) && isValidRight(currentNode)) {
	    		aux = recursiveIsBST(currentNode.getLeft()) && recursiveIsBST(currentNode.getRight());
	    	} else {
            	aux = false;
            }                
	    }
        return aux;
    }
	
	@Override
	public boolean isBST() {
        return bst.isEmpty() || recursiveIsBST(bst.getRoot());
	}
	
}
