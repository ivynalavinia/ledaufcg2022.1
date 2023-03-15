package problems;

import java.util.Set;
import java.util.TreeSet;

import adt.bst.BSTNode;

public class ConsecutiveParentChildBSTImpl extends BSTInteger implements ConsecutiveParentChildBST{
	
	private Set<Pair> recursiveFindConsecutives(BSTNode<Integer> node, Set<Pair> pairsSet) {
		
		if (!node.isEmpty()) {
			
			if (!node.getLeft().isEmpty()) {
				Integer subLeft = node.getData() - node.getLeft().getData();
				if (Math.abs(subLeft) == 1) {
					pairsSet.add(new Pair(node.getData(), node.getLeft().getData()));
				}
				recursiveFindConsecutives((BSTNode<Integer>) node.getLeft(), pairsSet);
			}
			
			if (!node.getRight().isEmpty()) {
				Integer subRight = node.getData() - node.getRight().getData();
				if (Math.abs(subRight) == 1) {
					pairsSet.add(new Pair(node.getData(), node.getRight().getData()));
				}
				recursiveFindConsecutives((BSTNode<Integer>) node.getRight(), pairsSet);
			}
		}
		
		return pairsSet;
	}
	
    public Set<Pair> findConsecutives(){
    	Set<Pair> pairsSet = new TreeSet<Pair>();
    	
    	if (!isEmpty()) {
    		recursiveFindConsecutives(root, pairsSet);
    	}
    	
    	return pairsSet;
    }
}
