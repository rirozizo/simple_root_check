package rirozizo.simplerootcheck;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    TextView tv2;
    TextView tv3;
    ImageView iv;

    private FirebaseAnalytics mFirebaseAnalytics;

    private static final String TAG = "MainActivity";
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing Strings
        String line = "";
        String root_check = "";
        String version_check = "";
        String device_check = "";

        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "PUT YOURS SON!");

        // Obtain the Firebase Analytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        // Google stuff... Ad related code
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // Initializing Views
        tv1 = (TextView) findViewById(R.id.text1);
        tv2 = (TextView) findViewById(R.id.textView);
        tv3 = (TextView) findViewById(R.id.textView2);
        iv = (ImageView) findViewById(R.id.image);

        // Failure color by default because why not
        tv1.setTextColor(getResources().getColor(R.color.ROOT_TEXT_COLOR_NOPE));

        // Success value by default because I'm inconsistent
        boolean works = false;
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
                root_check = root_check + line + "\n";
                works = true;
            }
            br.close();

            // If there's a problem with su
            br =
                    new BufferedReader(new InputStreamReader(stderr));
            while ((line = br.readLine()) != null) {
                Log.e("[Error]", line);
                tv1.setText(R.string.root_problem);
                works = false;
            }
            br.close();
            process.waitFor();
            process.destroy();

        } catch (Exception ex) {
            // If there's a general exception
            tv1.setText(R.string.problem);
        }

        // More Google stuff
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "1");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "root check");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "check");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.APP_OPEN, bundle);

        try {
            // Executing the command su
            Process process = Runtime.getRuntime().exec("su");

            // Stream initialization
            OutputStream stdin = process.getOutputStream();
            InputStream stderr = process.getErrorStream();
            InputStream stdout = process.getInputStream();

            // If it worked fine
            stdin.write(("getprop ro.build.version.release\n").getBytes());
            stdin.write("exit\n".getBytes());
            stdin.flush();
            stdin.close();
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(stdout));
            while ((line = br.readLine()) != null) {
                Log.d("[Output]", line);
                version_check = version_check + line + "\n";
            }
            br.close();

            // If there's a problem with su
            br =
                    new BufferedReader(new InputStreamReader(stderr));
            while ((line = br.readLine()) != null) {
                Log.e("[Error]", line);
                tv1.setText(R.string.root_problem);
                works = false;
            }
            br.close();
            process.waitFor();
            process.destroy();

        } catch (Exception ex) {
            // If there's a general exception
            tv1.setText(R.string.problem);
        }

        try {
            // Executing the command su
            Process process = Runtime.getRuntime().exec("su");

            // Stream initialization
            OutputStream stdin = process.getOutputStream();
            InputStream stderr = process.getErrorStream();
            InputStream stdout = process.getInputStream();

            // If it worked fine
            stdin.write(("getprop ro.product.device\n").getBytes());
            stdin.write("exit\n".getBytes());
            stdin.flush();
            stdin.close();
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(stdout));
            while ((line = br.readLine()) != null) {
                Log.d("[Output]", line);
                device_check = device_check + line + "\n";
            }
            br.close();

            // If there's a problem with su
            br =
                    new BufferedReader(new InputStreamReader(stderr));
            while ((line = br.readLine()) != null) {
                Log.e("[Error]", line);
                tv1.setText(R.string.root_problem);
                works = false;
            }
            br.close();
            process.waitFor();
            process.destroy();

        } catch (Exception ex) {
            // If there's a general exception
            tv1.setText(R.string.problem);
        }

        if (works) {

            // WE HAVE ROOT!
            tv1.setTextColor(getResources().getColor(R.color.ROOT_TEXT_COLOR_WORKS));
            tv1.setText(root_check);
            iv.setImageResource(R.drawable.works);

            // Dynamically changing resources in strings.xml to avoid hardcoded values as much as possible
            Resources res = getResources();
            String version = String.format(res.getString(R.string.version), version_check);
            String device = String.format(res.getString(R.string.device), device_check);

            tv2.setText(version);

            tv3.setText(device);

            iv.setImageResource(R.drawable.works);
        }
    }
}
