package it.alex.quizmulti;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);
    }

    public void startClicked(View v){
        Intent intent = new Intent(this, MainActivity.class);
        setResult(RESULT_OK);
        startActivity(intent);
    }

}
