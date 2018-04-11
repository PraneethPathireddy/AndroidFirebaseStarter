package com.example.awesomefat.androidfirebasestarter;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class Message
{
    public String title;
    public String body;

    public Message() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Message(String title, String body)
    {
        this.title = title;
        this.body = body;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("title", title);
        result.put("body", body);
        return result;
    }

    public void display()
    {
        System.out.println("***** MESSAGE *****");
        System.out.println("Title: " + this.title);
        System.out.println("Body: " + this.body);
    }
}