package adt.hashtable.closed;

import adt.hashtable.hashfunction.HashFunction;
import adt.hashtable.hashfunction.HashFunctionClosedAddress;
import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionFactory;
import util.Util;

import java.util.LinkedList;

public class HashtableClosedAddressImpl<T> extends AbstractHashtableClosedAddress<T> {

    /**
     * A hash table with closed address works with a hash function with closed
     * address. Such a function can follow one of these methods: DIVISION or
     * MULTIPLICATION. In the DIVISION method, it is useful to change the size
     * of the table to an integer that is prime. This can be achieved by
     * producing such a prime number that is bigger and close to the desired
     * size.
     * <p>
     * For doing that, you have auxiliary methods: Util.isPrime and
     * getPrimeAbove as documented bellow.
     * <p>
     * The length of the internal table must be the immediate prime number
     * greater than the given size (or the given size, if it is already prime).
     * For example, if size=10 then the length must
     * be 11. If size=20, the length must be 23. You must implement this idea in
     * the auxiliary method getPrimeAbove(int size) and use it.
     *
     * @param desiredSize
     * @param method
     */

    @SuppressWarnings({"rawtypes", "unchecked"})
    public HashtableClosedAddressImpl(int desiredSize, HashFunctionClosedAddressMethod method) {
        int realSize = desiredSize;

        if (method == HashFunctionClosedAddressMethod.DIVISION) {
            realSize = getPrimeAbove(desiredSize); // real size must the
            // the immediate prime
            // above
        }
        initiateInternalTable(realSize);
        HashFunction function = HashFunctionFactory.createHashFunction(method, realSize);
        hashFunction = function;
    }

    // AUXILIARY

    /**
     * It returns the prime number that is closest (and greater) to the given
     * number.
     * If the given number is prime, it is returned.
     * You can use the method Util.isPrime to check if a number is
     * prime.
     */
    int getPrimeAbove(int number) {
        while (!Util.isPrime(number)) {
            number++;
        }
        return number;
    }

    @Override
    public void insert(T element) {
        if (element != null && indexOf(element) == -1) {
            int elementHash = ((HashFunctionClosedAddress<T>) hashFunction).hash(element);

            if (table[elementHash] != null) {
                COLLISIONS += 1;
            } else {
                table[elementHash] = new LinkedList<T>();
            }

            elements += 1;
            ((LinkedList<T>) table[elementHash]).addFirst(element);
        }
    }

    @Override
    public void remove(T element) {
        if (element != null && !isEmpty()) {
            int elementIndex = indexOf(element);

            if (elementIndex != -1) {
                LinkedList<T> row = (LinkedList<T>) table[elementIndex];

                if (row.size() > 1) {
                    COLLISIONS -= 1;
                }

                row.remove(element);
                elements -= 1;
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
        if (element != null && !isEmpty()) {
            int elementHash = ((HashFunctionClosedAddress<T>) hashFunction).hash(element);

            LinkedList<T> row = (LinkedList<T>) table[elementHash];

            if (row != null && row.contains(element)) {
                return elementHash;
            }
        }
        return -1;
    }

}
