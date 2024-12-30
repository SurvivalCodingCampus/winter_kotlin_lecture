package day09

import javax.print.attribute.standard.MediaSize.Other

public interface Comparable<in T> {
    public operator fun compareTo(other: T): Int
}