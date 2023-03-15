package adt.bst;

import java.util.ArrayList;
import java.util.List;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

    protected BSTNode<T> root;

    public BSTImpl() {
        root = new BSTNode<T>();
    }

    public BSTNode<T> getRoot() {
        return this.root;
    }

    @Override
    public boolean isEmpty() {
        return root.isEmpty();
    }
    
    private int recursiveHeight(BSTNode<T> node) {
    	if (node.isEmpty()) {
    		return -1;
    	} else {
    		return 1 + Math.max(recursiveHeight((BSTNode<T>) node.getLeft()), recursiveHeight((BSTNode<T>) node.getRight()));    	}
    }

    @Override
    public int height() {
        return recursiveHeight(root);
    }

    private BSTNode<T> recursiveSearch(BSTNode<T> node, T element) {
        if (!node.isEmpty()) {
        	if (element.compareTo(node.getData()) == 0) {
            	return node;
            } else if (element.compareTo(node.getData()) < 0) {
            	return recursiveSearch((BSTNode<T>) node.getLeft(), element);
            } else {
        		return recursiveSearch((BSTNode<T>) node.getRight(), element);
            }
        }
        return new BSTNode<T>();
    }

    @Override
    public BSTNode<T> search(T element) {
        if (isEmpty()) {
        	return new BSTNode<T>();
        } else {
        	return recursiveSearch(root, element);
        }
    }

    private void recursiveInsert(BSTNode<T> node, T element) {
        if (node.isEmpty()) {
            node.setData(element);
            node.setLeft(new BSTNode.Builder().parent(node).build());
            node.setRight(new BSTNode.Builder().parent(node).build());
        } else {
            if (element.compareTo(node.getData()) < 0) {
                recursiveInsert((BSTNode<T>) node.getLeft(), element);
            } else if (element.compareTo(node.getData()) > 0) {
                recursiveInsert((BSTNode<T>) node.getRight(), element);
            }
        }
    }

    @Override
    public void insert(T element) {
        recursiveInsert(root, element);
    }

    private BSTNode<T> recursiveMaximum(BSTNode<T> node) {
        if (node.getRight().isEmpty()) {
            return node;
        } else {
            return recursiveMaximum((BSTNode<T>) node.getRight());
        }
    }

    @Override
    public BSTNode<T> maximum() {
        if (isEmpty()) {
            return null;
        } else {
            return recursiveMaximum(root);
        }
    }

    private BSTNode<T> recursiveMinimum(BSTNode<T> node) {
        if (node.getLeft().isEmpty()) {
            return node;
        } else {
            return recursiveMinimum((BSTNode<T>) node.getLeft());
        }
    }

    @Override
    public BSTNode<T> minimum() {
        if (isEmpty()) {
            return null;
        } else {
            return recursiveMinimum(root);
        }
    }

    @Override
    public BSTNode<T> sucessor(T element) {

        BSTNode<T> node = search(element);

        if (!node.isEmpty()) {
        	
            if (!node.getRight().isEmpty()) {
                return recursiveMinimum((BSTNode<T>) node.getRight());
            } else {
                BSTNode<T> parentNode = (BSTNode<T>) node.getParent();

                while (parentNode != null && parentNode.getData().compareTo(node.getData()) < 0) {
                    node = parentNode;
                    parentNode = (BSTNode<T>) node.getParent();
                }
                return parentNode;
            }
        }
        return null;
    }

    @Override
    public BSTNode<T> predecessor(T element) {

        BSTNode<T> node = search(element);

        if (!node.isEmpty()) {
        	
            if (!node.getLeft().isEmpty()) {
                return recursiveMaximum((BSTNode<T>) node.getLeft());
            } else {
                BSTNode<T> parentNode = (BSTNode<T>) node.getParent();

                while (parentNode != null && parentNode.getData().compareTo(node.getData()) > 0) {
                    node = parentNode;
                    parentNode = (BSTNode<T>) node.getParent();
                }
                return parentNode;
            }
        }
        return null;
    }

    private boolean isDegreeOne(BSTNode<T> node) {
        return node.getLeft().isEmpty() && !node.getRight().isEmpty() || node.getRight().isEmpty() && !node.getLeft().isEmpty();
    }

    @Override
    public void remove(T element) {

        BSTNode<T> node = search(element);

        if (!node.isEmpty()) {

            if (node.isLeaf()) {
                node.setData(null);
            } else if (isDegreeOne(node)) {

                if (node.getParent() != null) {

                    if (!node.getParent().getLeft().equals(node)) {
                        if (!node.getLeft().isEmpty()) {
                            node.getLeft().setParent(node.getParent());
                            node.getParent().setRight(node.getLeft());
                        } else {
                            node.getRight().setParent(node.getParent());
                            node.getParent().setRight(node.getRight());
                        }
                    } else {
                        if (!node.getLeft().isEmpty()) {
                            node.getLeft().setParent(node.getParent());
                            node.getParent().setLeft(node.getLeft());
                        } else {
                            node.getRight().setParent(node.getParent());
                            node.getParent().setLeft(node.getRight());
                        }
                    }
                } else {
                    if (node.getLeft().isEmpty()) {
                        root = (BSTNode<T>) node.getRight();
                    } else {
                        root = (BSTNode<T>) node.getLeft();
                    }
                    root.setParent(null);
                }
            } else {
                T sucessorNode = sucessor(node.getData()).getData();
                remove(sucessorNode);
                node.setData(sucessorNode);
            }
        }
    }

    private void recursivePreOrder(BSTNode<T> node, List<T> l) {
        if (!node.isEmpty()) {
            l.add(node.getData());
            recursivePreOrder((BSTNode<T>) node.getLeft(), l);
            recursivePreOrder((BSTNode<T>) node.getRight(), l);
        }
    }

    @Override
    public T[] preOrder() {
        List<T> l = new ArrayList<T>();

        if (!isEmpty()) {
            recursivePreOrder(root, l);
        }
        
        return l.toArray((T[]) new Comparable[size()]);
    }

    private void recursiveOrder(BSTNode<T> node, List<T> l) {
        if (!node.isEmpty()) {
            recursiveOrder((BSTNode<T>) node.getLeft(), l);
            l.add(node.getData());
            recursiveOrder((BSTNode<T>) node.getRight(), l);
        }
    }

    @Override
    public T[] order() {
        List<T> l = new ArrayList<T>();

        if (!isEmpty()) {
            recursiveOrder(root, l);
        }
        
        return l.toArray((T[]) new Comparable[size()]);
    }

    private void recursivePostOrder(BSTNode<T> node, List<T> array) {
        if (!node.isEmpty()) {
            recursivePostOrder((BSTNode<T>) node.getLeft(), array);
            recursivePostOrder((BSTNode<T>) node.getRight(), array);
            array.add(node.getData());
        }
    }

    @Override
    public T[] postOrder() {
        List<T> l = new ArrayList<T>();

        if (!isEmpty()) {
            recursivePostOrder(root, l);
        }
        
        return l.toArray((T[]) new Comparable[size()]);
    }

    /**
     * This method is already implemented using recursion. You must understand
     * how it work and use similar idea with the other methods.
     */
    @Override
    public int size() {
        return size(root);
    }

    private int size(BSTNode<T> node) {
        int result = 0;
        // base case means doing nothing (return 0)
        if (!node.isEmpty()) { // indusctive case
            result = 1 + size((BSTNode<T>) node.getLeft()) + size((BSTNode<T>) node.getRight());
        }
        return result;
    }
}
