package com.thehartford.library.step_definitions;

public class MyClass {
    private String name = "Chris";

    public MyClass(String name) {
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static void main(String ... name) {
        MyClass myClass = new MyClass("Jim");
        System.out.println(myClass.getName());

    }

}