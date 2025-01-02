package day09

interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}