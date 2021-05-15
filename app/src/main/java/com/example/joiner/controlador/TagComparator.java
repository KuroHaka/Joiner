package com.example.joiner.controlador;

import java.util.Comparator;

public class TagComparator implements Comparator<Tag> {
    public int compare(Tag o1, Tag o2)
    {
        return o1.getPeso().compareTo(o2.getPeso());
    }
}
