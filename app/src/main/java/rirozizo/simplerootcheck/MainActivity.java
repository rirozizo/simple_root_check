package rirozizo.simplerootcheck;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    ImageView iv;

    private FirebaseAnalytics mFirebaseAnalytics;

    private static final String TAG = "MainActivity";
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        // Google stuff... Ad related code
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // Initializing Views
        tv1 = (TextView) findViewById(R.id.text1);
        iv = (ImageView) findViewById(R.id.image);

        // Failure color by default because why not
        tv1.setTextColor(getResources().getColor(R.color.ROOT_TEXT_COLOR_NOPE));

        String line = "";
        String s = "";
        // Success value by default because I'm inconsistent
        boolean works = true;
        try {
            // Executing the command su
            Process process = Runtime.getRuntime().exec("su");

            // Stream initialization
            OutputStream stdin = process.getOutputStream();
            InputStream stderr = process.getErrorStream();
            InputStream stdout = process.getInputStream();

            // If it worked fine
            stdin.write(("echo YOU HAVE ROOT!\n").getBytes());
            stdin.write("exit\n".getBytes());
            stdin.flush();
            stdin.close();
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(stdout));
            while ((line = br.readLine()) != null) {
                Log.d("[Output]", line);
                s = s + line + "\n";
            }
            br.close();

            // If there's a problem with su
            br =
                    new BufferedReader(new InputStreamReader(stderr));
            while ((line = br.readLine()) != null) {
                Log.e("[Error]", line);
                tv1.setText("THERE'S A PROBLEM WITH ROOT!");
                works = false;
            }
            br.close();
            process.waitFor();
            process.destroy();

        } catch (Exception ex) {
            // If there's a general exception
            tv1.setText("NOPE");
        }

        if (works) {
            // WE HAVE ROOT!
            tv1.setTextColor(getResources().getColor(R.color.ROOT_TEXT_COLOR_WORKS));
            tv1.setText(s);
            iv.setImageResource(R.drawable.works);
        }

        // More Google stuff
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "1");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "root check");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "check");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.APP_OPEN, bundle);
    }
}
