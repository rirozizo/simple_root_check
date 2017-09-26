package rirozizo.helloworld1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textViewID);
    }

    public void changeText(View v)
    {
        tv.setText("How are you world");
    }

    public void nextActivity(View v)
    {
        Intent i = new Intent(this,NextActivity.class);
        startActivity(i);
    }
}
