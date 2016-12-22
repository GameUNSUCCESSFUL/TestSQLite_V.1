package kku.photong.saitan.testsqlitev3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    DatabaseHelper myDB;
    Button btnAdd, btnView;
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);

        myDB = new DatabaseHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry = editText1.getText().toString();
                if (editText1.length() != 0) {
                    insertData(newEntry);
                    editText1.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "You must put something in the text", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewListContents.class);
                startActivity(intent);
            }
        });
    }

    public void insertData(String newEntry) {
        boolean insertData = myDB.insertData(newEntry);

        if (insertData == true) {
            Toast.makeText(MainActivity.this, "Successfully Entered Data!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "Something went worng :(.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {

    }
}
