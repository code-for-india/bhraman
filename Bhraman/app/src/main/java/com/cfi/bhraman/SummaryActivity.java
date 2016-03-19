package com.cfi.bhraman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Bundle b = this.getIntent().getExtras();
        String date = b.getString("Date");
        Log.i("Date", date);

    /*    VCard johnDoe = new VCard("John Doe")
                .setEmail("john.doe@example.org")
                .setAddress("John Doe Street 1, 5678 Doestown")
                .setTitle("Mister")
                .setCompany("John Doe Inc.")
                .setPhoneNumber("1234")
                .setWebsite("www.example.org");
        QRCode.from(johnDoe).file();*/

    }
}
