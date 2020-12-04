package com.will.parcial2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase db;
    private EditText NewR;
    private TextView CurrentQ;
    private Button SendBtn;
    public  Nquestion nquestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseDatabase.getInstance();
        CurrentQ = findViewById(R.id.CurrentQ);
        NewR = findViewById(R.id.NewR);
        SendBtn = findViewById(R.id.SendBtn);

        SendBtn.setOnClickListener(this);


        DatabaseReference ref = (DatabaseReference) db.getReference().child("Group").child("Questions");

                ref.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot data) {
                        //CurrentQ.setText("");
                        for (DataSnapshot child : data.getChildren()) {
                            nquestion = child.getValue(Nquestion.class);
                            CurrentQ.setText(nquestion.getNq() + "\n");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }


        );






    }


    private void readW(){

    }


    @Override
    public void onClick(View view) {
       switch(view.getId()){
           case R.id.SendBtn:

               String id= db.getReference().child("Group").child("Questions").push().getKey();
               DatabaseReference references = db.getReference().child("Group").child("Questions").child(id);


               Rate rate = new Rate (
                       id,
                       NewR.getText().toString(),
                       nquestion.getNq()
               );

               references.setValue(rate);
               NewR.setText(null);
               break;

       }
    }
}