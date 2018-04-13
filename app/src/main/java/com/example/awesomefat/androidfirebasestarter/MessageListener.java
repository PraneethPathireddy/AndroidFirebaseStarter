package com.example.awesomefat.androidfirebasestarter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class MessageListener implements ValueEventListener
{
    @Override
    public void onDataChange(DataSnapshot dataSnapshot)
    {
        System.out.println(dataSnapshot.toString());
        for(DataSnapshot child : dataSnapshot.getChildren())
        {
            Message value = child.getValue(Message.class);
            value.display();
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError)
    {
        System.out.println("********* Failed to read value. " + databaseError.toException());
    }
}
