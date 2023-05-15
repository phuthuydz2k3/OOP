package test;

import java.util.ArrayList;
import java.util.Collections;
public class Cart
{
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered;
    private int qtyOrdered;

    public Cart()
    {
        itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
        qtyOrdered = 0;
    }


    public void addDigitalVideoDics(DigitalVideoDisc disc)
    {
        if (qtyOrdered <= MAX_NUMBERS_ORDERED)
        {
            itemsOrdered[qtyOrdered++] = disc;
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc)
    {
        ArrayList<DigitalVideoDisc> arrls = new ArrayList<>(qtyOrdered);
        Collections.addAll(arrls, itemsOrdered);
        arrls.remove(disc);
        itemsOrdered = arrls.toArray(new DigitalVideoDisc[--qtyOrdered]);
    }

    public float totalCost()
    {
        float total = (float) 0.0;

        for (int i = 0; i < qtyOrdered; i++)
        {
            total += itemsOrdered[i].getCost();
        }

        return total;
    }
}
