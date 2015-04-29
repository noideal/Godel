package net.noideal.godel;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends ActionBarActivity {

    EditText gdString, gdBigG, gdLittleG, gdOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build(); // replace with '.addTestDevice(DEVICE_ID)' ----\/

        /******** TO OBTAIN TEST DEVICE ID HASH: http://stackoverflow.com/questions/4524752/how-can-i-get-device-id-for-admob
         String android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
             String deviceId = md5(android_id).toUpperCase();
                 Log.i("device id=",deviceId);

                 public String md5(String s) {
                 try {
                 // Create MD5 Hash
                 MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
                 digest.update(s.getBytes());
                 byte messageDigest[] = digest.digest();

                 // Create Hex String
                 StringBuffer hexString = new StringBuffer();
                 for (int i=0; i<messageDigest.length; i++)
                 hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
                 return hexString.toString();

                 } catch (NoSuchAlgorithmException e) {
                 e.printStackTrace();
                 }
             return "";
         }
         ********/

        mAdView.loadAd(adRequest);

        gdString = (EditText) findViewById(R.id.editString);
        gdBigG = (EditText) findViewById(R.id.editBigG);
        gdLittleG = (EditText) findViewById(R.id.editLittleG);
        gdOut = (EditText) findViewById(R.id.editOut);
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("function");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("Function");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Signs");
        tabSpec.setContent(R.id.tab2);
        tabSpec.setIndicator("Signs");
        tabHost.addTab(tabSpec);

        final Button prcBtn = (Button) findViewById(R.id.btnPrc);
        final Button clrBtn = (Button) findViewById(R.id.btnClr);

        final TextView textGD1 = (TextView) findViewById(R.id.textGD1);
        final TextView textGD2 = (TextView) findViewById(R.id.textGD2);
        final TextView textGD3 = (TextView) findViewById(R.id.textGD3);
        final TextView textGD4 = (TextView) findViewById(R.id.textGD4);
        final TextView textGD5 = (TextView) findViewById(R.id.textGD5);
        final TextView textGD6 = (TextView) findViewById(R.id.textGD6);
        final TextView textGD7 = (TextView) findViewById(R.id.textGD7);
        final TextView textGD8 = (TextView) findViewById(R.id.textGD8);
        final TextView textGD9 = (TextView) findViewById(R.id.textGD9);
        final TextView textGD10 = (TextView) findViewById(R.id.textGD10);
        final TextView textGD17 = (TextView) findViewById(R.id.textGD17);
        final TextView textGD19 = (TextView) findViewById(R.id.textGD19);
        final TextView textGD21 = (TextView) findViewById(R.id.textGD21);

        gdString.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                prcBtn.setEnabled(!gdString.getText().toString().trim().isEmpty());
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        gdString.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event.getKeyCode() == KeyEvent.KEYCODE_ENTER || (actionId == EditorInfo.IME_NULL
                        && event.getAction() == KeyEvent.ACTION_DOWN)) && prcBtn.isEnabled()) {
                    prcBtn.performClick();
                    return true;
                }
                return false;
            }
        });

        prcBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String gdString_send = gdString.getText().toString().trim();
                if (!(gdString_send.matches("^[0S+\\*=~⊃∀\\(\\)xyz]*$"))) {
                    Toast.makeText(getApplicationContext(), "Input not valid.", Toast.LENGTH_SHORT).show();
                } else if (gdString_send.length()>17){
                    Toast.makeText(getApplicationContext(), "String exceeds allowed length.", Toast.LENGTH_SHORT).show();
                } else {
                    String gdST = GodelFunction.s_bigG(gdString_send.trim());
                    gdBigG.setText("Γ('" + gdString_send + "') = " + gdST);

                    String gdBG = GodelFunction.s_littleG(gdST);
                    gdLittleG.setText("γ(" + gdST + ") = " + gdBG);

                    String gdOU = GodelFunction.s_funOut(gdBG);
                    gdOut.setText(gdOU);
                }
            }
        });

        clrBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gdString.setText("");
                gdBigG.setText("");
                gdLittleG.setText("");
                gdOut.setText("");
                prcBtn.setEnabled(false);
            }});

        textGD1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {gdString.append("0");}
        });
        textGD2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {gdString.append("S");}
        });
        textGD3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {gdString.append("+");}
        });
        textGD4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {gdString.append("*");}
        });
        textGD5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {gdString.append("=");}
        });
        textGD6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {gdString.append("~");}
        });
        textGD7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {gdString.append("⊃");}
        });
        textGD8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {gdString.append("∀");}
        });
        textGD9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {gdString.append("(");}
        });
        textGD10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {gdString.append(")");}
        });
        textGD17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {gdString.append("x");}
        });
        textGD19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {gdString.append("y");}
        });
        textGD21.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {gdString.append("z");}
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_about) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
