package com.example.demo.controllers;

class StudentNotFoundException extends RuntimeException {

    StudentNotFoundException(Integer id) {
        super("Could not find student " + id);
    }
}
