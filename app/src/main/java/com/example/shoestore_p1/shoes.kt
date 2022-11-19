package com.example.shoestore_p1

class shoes(name: String, company: String, size: String, description: String) {
    lateinit var name: String
    lateinit var company: String
    lateinit var size: String
    lateinit var description: String
    init{
        this.name = name
        this.company = company
        this.size = size
        this.description = description
    }
}