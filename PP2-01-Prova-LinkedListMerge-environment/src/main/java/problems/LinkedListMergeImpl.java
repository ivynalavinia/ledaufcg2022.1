package problems;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListMergeImpl<T extends Comparable<T>> implements LinkedListMerge<T>{
		
	public LinkedListMergeImpl() {
	}
	
    public SingleLinkedListNode<T> merge(SingleLinkedListNode<T> node1, SingleLinkedListNode<T> node2){
    	
    	SingleLinkedListNode<T> nodeAux = new SingleLinkedListNode<T>();
    	SingleLinkedListNode<T> emptyNode = new SingleLinkedListNode<T>();
    	
    	if (node1 == null && node2 == null) {
    		return emptyNode;
    	} else if (node1 == null && node2 != null) {
    		return node2;
    	} else if (node2 == null && node1 != null) {
    		return node1;
    	}
    	
    	if (node1.getData() != null && node2.getData() != null) {
    		if (node1.getData().compareTo(node2.getData()) <= 0) {
    			nodeAux.setData(node1.getData());
    			nodeAux.setNext(merge(node1.getNext(), node2));
    		} else {
    			nodeAux.setData(node2.getData());
    			nodeAux.setNext(merge(node1, node2.getNext()));
    		}
    	} else if (node1.getData() == null && node2.getData() != null) {
    		return node2;
    	} else if (node2.getData() == null && node1.getData() != null) {
    		return node1;
    	} else {
    		return emptyNode;
    	}
    	return nodeAux;
    }
}
