package adt.bst.extended;

import adt.bst.BSTImpl;

import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

    private BSTImpl<Integer> arrayToBst(Integer[] array) {
        BSTImpl<Integer> bst = new BSTImpl<Integer>();
        for (int i : array) {
            bst.insert(i);
        }
        return bst;
    }

    private Integer recursiveFloor(BSTNode<Integer> node, double num) {

        if (node.getData() == null) {
            return null;
        }
        if (num == node.getData()) {
            return node.getData();
        }
        if (num < node.getData()) {
            return recursiveFloor((BSTNode<Integer>) node.getLeft(), num);
        }

        Integer value = recursiveFloor((BSTNode<Integer>) node.getRight(), num);
        if (value != null) {
            return value;
        } else {
            return node.getData();
        }
    }

    @Override
    public Integer floor(Integer[] array, double numero) {
        BSTImpl<Integer> tree = arrayToBst(array);
        return recursiveFloor(tree.getRoot(), numero);
    }

    private Integer recursiveCeil(BSTNode<Integer> node, double num) {
        if (node.getData() == null) {
            return null;
        } else if (node.getData() == num) {
            return node.getData();
        } else if (num > node.getData()) {
            return recursiveCeil((BSTNode<Integer>) node.getRight(), num);
        }

        Integer value = recursiveCeil((BSTNode<Integer>) node.getLeft(), num);
        if (value != null) {
            return value;
        } else {
            return node.getData();
        }
    }

    @Override
    public Integer ceil(Integer[] array, double numero) {
        BSTImpl<Integer> tree = arrayToBst(array);
        return recursiveCeil(tree.getRoot(), numero);
    }
}
