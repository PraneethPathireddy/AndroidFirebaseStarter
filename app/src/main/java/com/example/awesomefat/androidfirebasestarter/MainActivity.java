package com.example.awesomefat.androidfirebasestarter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference messageRef = database.getReference("messages");
        DatabaseReference usersRef = database.getReference("users");


        // Read from the database

        MessageListener messageList = new MessageListener();
        messageRef.addValueEventListener(messageList);

        //These are called automatically from Firebase whenever the database change

        //These are called automatically from Firebase whenever the database changes
        usersRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                System.out.println(dataSnapshot.toString());
                for(DataSnapshot child : dataSnapshot.getChildren())
                {
                    User value = child.getValue(User.class);
                    value.display();
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                System.out.println("********* Failed to read value. " + error.toException());
            }
        });

        Random r = new Random();
        for(int i = 0; i < 10; i++)
        {
            //push() gets a unique key for this entry
            DatabaseReference tempUser = usersRef.push();
            User usr = new User("First Name " + i, "Last Name " + i, r.nextInt(15) + 7);
            tempUser.setValue(usr);

        }

    }
}
