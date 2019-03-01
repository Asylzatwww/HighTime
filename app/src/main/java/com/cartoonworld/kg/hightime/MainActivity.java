package com.cartoonworld.kg.hightime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /** Called when the user taps the Send button */
    public void ONasActivityOpen(View view) {
        Intent intent = new Intent(this, ONasActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /** Called when the user taps the Send button */
    public void StudentamActivityOpen(View view) {
        Intent intent = new Intent(this, InstructionActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


    /** Called when the user taps the Send button */
    public void InstructionActivityOpen(View view) {
        Intent intent = new Intent(this, StudentamActivity.class);

        startActivity(intent);
    }

    /** Called when the user taps the Send button */
    public void RegisterActivityOpen(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);

        startActivity(intent);
    }

    public void FilialActivityOpen(View view) {
        Intent intent = new Intent(this, FilialyActivity.class);

        startActivity(intent);
    }

    public void ContactActivityOpen(View view) {
        Intent intent = new Intent(this, ContactActivity.class);

        startActivity(intent);
    }

    public void NashaComandaActivityOpen(View view) {
        Intent intent = new Intent(this, NashaKomandaActivity.class);

        startActivity(intent);
    }


}
