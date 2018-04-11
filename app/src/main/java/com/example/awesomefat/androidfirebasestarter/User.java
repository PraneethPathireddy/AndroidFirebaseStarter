package com.example.awesomefat.androidfirebasestarter;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class User
{

    public String fname;
    public String lname;
    public int age;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String fname, String lname, int age)
    {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("fname", fname);
        result.put("lname", lname);
        result.put("age", age);
        return result;
    }

    public void display()
    {
        System.out.println("***** USER *****");
        System.out.println("Fname: " + this.fname);
        System.out.println("Lname: " + this.lname);
        System.out.println("Age: " + this.age);
    }
}
