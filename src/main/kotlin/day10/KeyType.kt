package org.example.day10

enum class KeyType(val trialLimit: Int) {

    padlock(1024),
    button(10000),
    dial(30000),
    finger(1000000);

}