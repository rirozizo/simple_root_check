package rirozizo.simplerootcheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class Privacy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);

        TextView policytv = findViewById(R.id.policyText);

        policytv.setText(Html.fromHtml("<!DOCTYPE html>\n" +
                "    <html>\n" +
                "    <head>\n" +
                "      <meta charset='utf-8'>\n" +
                "      <meta name='viewport' content='width=device-width'>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "    <h2>Privacy Policy</h2> <p> Rawad Zahreddine built the Simple Root Check app as an Open Source app. This SERVICE is provided by\n" +
                "                    Rawad Zahreddine at no cost and is intended for use as is.\n" +
                "                  </p> <p>This page is used to inform visitors regarding my policies with the collection, use, and disclosure\n" +
                "                    of Personal Information if anyone decided to use my Service.\n" +
                "                  </p> <p>If you choose to use my Service, then you agree to the collection and use of information in\n" +
                "                    relation to this policy. The Personal Information that I collect is used for providing and improving\n" +
                "                    the Service. I will not use or share your information with anyone except as described\n" +
                "                    in this Privacy Policy.\n" +
                "                  </p> <p>The terms used in this Privacy Policy have the same meanings as in our Terms and Conditions, which is\n" +
                "                    accessible at Simple Root Check unless otherwise defined in this Privacy Policy.\n" +
                "                  </p> <p><strong>Information Collection and Use</strong></p> <p>For a better experience, while using our Service, I may require you to provide us with certain\n" +
                "                    personally identifiable information. The information that I request will be retained on your device and is not collected by me in any way.\n" +
                "                  </p> <p>The app does use third party services that may collect information used to identify you.</p> <div><p>Link to privacy policy of third party service providers used by the app</p> <ul><li><a href=\"https://www.google.com/policies/privacy/\" target=\"_blank\">Google Play Services</a></li><li><a href=\"https://support.google.com/admob/answer/6128543?hl=en\" target=\"_blank\">AdMob</a></li><li><a href=\"https://firebase.google.com/policies/analytics\" target=\"_blank\">Firebase Analytics</a></li><!----><!----><!----><!----><!----></ul></div> <p><strong>Log Data</strong></p> <p> I want to inform you that whenever you use my Service, in a case of\n" +
                "                    an error in the app I collect data and information (through third party products) on your phone\n" +
                "                    called Log Data. This Log Data may include information such as your device Internet Protocol (“IP”) address,\n" +
                "                    device name, operating system version, the configuration of the app when utilizing my Service,\n" +
                "                    the time and date of your use of the Service, and other statistics.\n" +
                "                  </p> <p><strong>Cookies</strong></p> <p>Cookies are files with a small amount of data that are commonly used as anonymous unique identifiers.\n" +
                "                    These are sent to your browser from the websites that you visit and are stored on your device's internal\n" +
                "                    memory.\n" +
                "                  </p> <p>This Service does not use these “cookies” explicitly. However, the app may use third party code and\n" +
                "                    libraries that use “cookies” to collect information and improve their services. You have the option to\n" +
                "                    either accept or refuse these cookies and know when a cookie is being sent to your device. If you choose\n" +
                "                    to refuse our cookies, you may not be able to use some portions of this Service.\n" +
                "                  </p> <p><strong>Service Providers</strong></p> <p> I may employ third-party companies and individuals due to the following reasons:</p> <ul><li>To facilitate our Service;</li> <li>To provide the Service on our behalf;</li> <li>To perform Service-related services; or</li> <li>To assist us in analyzing how our Service is used.</li></ul> <p> I want to inform users of this Service that these third parties have access to\n" +
                "                    your Personal Information. The reason is to perform the tasks assigned to them on our behalf. However,\n" +
                "                    they are obligated not to disclose or use the information for any other purpose.\n" +
                "                  </p> <p><strong>Security</strong></p> <p> I value your trust in providing us your Personal Information, thus we are striving\n" +
                "                    to use commercially acceptable means of protecting it. But remember that no method of transmission over\n" +
                "                    the internet, or method of electronic storage is 100% secure and reliable, and I cannot guarantee\n" +
                "                    its absolute security.\n" +
                "                  </p> <p><strong>Links to Other Sites</strong></p> <p>This Service may contain links to other sites. If you click on a third-party link, you will be directed\n" +
                "                    to that site. Note that these external sites are not operated by me. Therefore, I strongly\n" +
                "                    advise you to review the Privacy Policy of these websites. I have no control over\n" +
                "                    and assume no responsibility for the content, privacy policies, or practices of any third-party sites\n" +
                "                    or services.\n" +
                "                  </p> <p><strong>Children’s Privacy</strong></p> <p>These Services do not address anyone under the age of 13. I do not knowingly collect\n" +
                "                    personally identifiable information from children under 13. In the case I discover that a child\n" +
                "                    under 13 has provided me with personal information, I immediately delete this from\n" +
                "                    our servers. If you are a parent or guardian and you are aware that your child has provided us with personal\n" +
                "                    information, please contact me so that I will be able to do necessary actions.\n" +
                "                  </p> <p><strong>Changes to This Privacy Policy</strong></p> <p> I may update our Privacy Policy from time to time. Thus, you are advised to review\n" +
                "                    this page periodically for any changes. I will notify you of any changes by posting\n" +
                "                    the new Privacy Policy on this page. These changes are effective immediately after they are posted on\n" +
                "                    this page.\n" +
                "                  </p> <p><strong>Contact Us</strong></p> <p>If you have any questions or suggestions about my Privacy Policy, do not hesitate to contact\n" +
                "                    me.\n" +
                "                  </p> <p>This privacy policy page was created at <a href=\"https://privacypolicytemplate.net\" target=\"_blank\">privacypolicytemplate.net</a>\n" +
                "                    and modified/generated by <a href=\"https://app-privacy-policy-generator.firebaseapp.com/\" target=\"_blank\">App\n" +
                "                      Privacy Policy Generator</a></p>\n" +
                "    </body>\n" +
                "    </html>\n" +
                "      ", Html.FROM_HTML_MODE_COMPACT));
    }
}
