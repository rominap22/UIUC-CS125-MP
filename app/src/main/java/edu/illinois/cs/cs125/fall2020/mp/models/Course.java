package edu.illinois.cs.cs125.fall2020.mp.models;

/*
    @return description of the course
 */
public class Course extends Summary {
    private String description;
    public Course() { }
    public Course(String des) {
        description = des;
    }
    public String getDescription() {
        return description;
    }
}
