package com.example.warmupapplication

class Person(val name: String, val age: Int, var online: Boolean) {
    companion object{
        private var lastId = 0

        fun createPersonList(contactsCount: Int): ArrayList<Person> {
            val persons = ArrayList<Person>()
            for (i in 1..contactsCount) {
                persons.add(Person("Person " + ++lastId, lastId + 5, i%2 == 0))
            }

            return persons
        }
    }
}