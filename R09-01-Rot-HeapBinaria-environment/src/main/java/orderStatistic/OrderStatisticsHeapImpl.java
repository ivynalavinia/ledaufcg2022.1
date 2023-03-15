package orderStatistic;

import java.util.PriorityQueue;

public class OrderStatisticsHeapImpl<T extends Comparable<T>> implements OrderStatistics<T> {

    /**
     * Existem diversas formas de se calcular uma estatistica de ordem.
     * Voce deve fazer isso usando uma heap restricoes:
     * - nenhuma copia ou estrutura array auxiliar serah permitida, exceto o uso de
     * uma PriorityQueue
     * - caso a estatistica de ordem procurada nao exista no array o metodo deve retornar null
     *
     * @param array
     * @param k
     * @return
     */

    @Override
    public T getOrderStatistics(T[] array, int k) {
        if (k >= 1 && k <= array.length) {
            T orderStatistic = null;
            PriorityQueue<T> aux = new PriorityQueue<>();
            for (int i = 0; i < array.length; i++) {
                aux.add(array[i]);
            }
            for (int i = k; i > 0; i--) {
                orderStatistic = aux.poll();
            }
            return orderStatistic;
        }
        return null;
    }

}
