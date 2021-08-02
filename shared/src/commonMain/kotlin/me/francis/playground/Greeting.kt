package me.francis.playground

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}