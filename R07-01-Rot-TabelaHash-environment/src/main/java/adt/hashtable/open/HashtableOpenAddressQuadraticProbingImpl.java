package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable> extends AbstractHashtableOpenAddress<T> {

    public HashtableOpenAddressQuadraticProbingImpl(int size, HashFunctionClosedAddressMethod method, int c1, int c2) {
        super(size);
        hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
        this.initiateInternalTable(size);
    }

    @Override
    public void insert(T element) {
        if (!isFull() && element != null) {
            int probe = 0;

            while (probe < capacity()) {
                int elementHash = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, probe);

                if (table[elementHash] == null || table[elementHash].equals(deletedElement)) {
                    table[elementHash] = element;
                    COLLISIONS += probe;
                    elements += 1;
                    break;
                } else if (table[elementHash].equals(element)) {
                    break;
                } else {
                    probe += 1;
                }
            }
            if (probe == capacity()) {
                throw new HashtableOverflowException();
            }
        } else if (isFull()) {
            throw new HashtableOverflowException();
        }
    }

    @Override
    public void remove(T element) {
        if (!isEmpty() && element != null) {
            int probe = 0;

            while (probe < capacity()) {
                int elementHash = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, probe);

                if (table[elementHash] != null) {
                    if (table[elementHash].equals(element)) {
                        table[elementHash] = deletedElement;
                        COLLISIONS -= probe;
                        elements -= 1;
                        break;
                    }
                    probe += 1;
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public T search(T element) {
        int elementIndex = indexOf(element);

        if (elementIndex != -1) {
            return element;
        } else {
            return null;
        }
    }

    @Override
    public int indexOf(T element) {
        if (!isEmpty() && element != null) {
            int probe = 0;

            while (probe < capacity()) {
                int elementHash = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, probe);

                if (table[elementHash] != null) {
                    if (table[elementHash].equals(element)) {
                        return elementHash;
                    }
                    probe += 1;
                } else {
                    break;
                }
            }
        }
        return -1;
    }

}
