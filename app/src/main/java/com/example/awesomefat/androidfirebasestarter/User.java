package com.example.awesomefat.androidfirebasestarter;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class User
{

    public String fname;
    public String lname;
    public int age;
    public ArrayList<Message> messages;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String fname, String lname, int age)
    {
        this.fname = fname;
        this.lname = lname;
        this.age = age;

        this.messages = new ArrayList<Message>();
        for(int i = 0; i < 10; i++)
        {
            this.messages.add(new Message("Title" + i, "body " + i));
        }
    }

    public void display()
    {
        System.out.println("***** USER *****");
        System.out.println("Fname: " + this.fname);
        System.out.println("Lname: " + this.lname);
        System.out.println("Age: " + this.age);
    }
}
