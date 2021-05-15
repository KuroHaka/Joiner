package com.example.joiner.controlador;

import java.util.Comparator;

public class TagComparator implements Comparator<Tag> {
    public int compare(Tag o1, Tag o2)
    {
        return ((Integer)o1.getPeso()).compareTo((Integer) o2.getPeso());
    }
}
