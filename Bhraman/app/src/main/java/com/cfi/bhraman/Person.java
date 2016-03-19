package com.cfi.bhraman;

/**
 * Created by chhavi on 19/3/16.
 */
public class Person {

    public Person(String name, String id, int imageResouce) {

        this.name = name;
        this.id = id;
        this.imageResouce = imageResouce;
    }

    public Person(String name, String id) {

        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImageResouce() {
        return imageResouce;
    }

    public void setImageResouce(int imageResouce) {
        this.imageResouce = imageResouce;
    }

    String name;
    String id;
    int imageResouce;
}
