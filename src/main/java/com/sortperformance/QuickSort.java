package com.sortperformance;

import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class QuickSort implements Sorter {

    public ArrayList<SortItem> execute(ArrayList<SortItem> list) {
        ArrayList<SortItem> listClone = (ArrayList<SortItem>) list.clone();

        listClone = quicksort1(listClone);
        return listClone;
    }

    public ArrayList<SortItem> quicksort1(ArrayList<SortItem> numeros) {

        return quicksort2(numeros, 0, numeros.size() - 1);
    }

    public ArrayList<SortItem> quicksort2(ArrayList<SortItem> numeros, int izq, int der) {

        if (izq >= der)
            return numeros;
        int i = izq, d = der;
        if (izq != der) {

            int pivote;
            int aux;
            pivote = izq;
            while (izq != der) {

                while (numeros.get(der).getValue() >= numeros.get(pivote).getValue() && izq < der)
                    der--;
                while (numeros.get(izq).getValue() < numeros.get(pivote).getValue() && izq < der)
                    izq++;

                if (der != izq) {

                    aux = numeros.get(der).getValue();
                    numeros.set(der, new SortItem(numeros.get(izq).getValue()));
                    numeros.set(izq, new SortItem(aux));
                }
            }

            if (izq == der) {

                quicksort2(numeros, i, izq - 1);
                quicksort2(numeros, izq + 1, d);
            }
        }

        else
            return numeros;
        return numeros;

    }

}
