package com.cfi.bhraman;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerController;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import net.glxn.qrgen.android.QRCode;
import net.glxn.qrgen.core.scheme.VCard;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;

/**
 * Created by chhavi on 19/3/16.
 */
public class PlaceDetailActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener, View.OnClickListener {
    EditText dateChoose;
    EditText time_choose;
    CheckBox p1;
    CheckBox p2;
    CheckBox p3;
    LinearLayout chooseOthers;
    String date;
    String time;
    ArrayList<String> people;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_detail);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        people = new ArrayList<>();

        p1 = (CheckBox) findViewById(R.id.p1);
        p2 = (CheckBox) findViewById(R.id.p2);
        p3 = (CheckBox) findViewById(R.id.p3);

        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(p1.isChecked()){
                   people.add("Yogesh");
                }else{
                }
            }
        });

        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(p2.isChecked()){
                    people.add("Chhavi");
                }else{
                }
            }
        });

        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(p3.isChecked()){
                    people.add("Aanchal");
                }else{
                }
            }
        });

         dateChoose = (EditText)findViewById(R.id.edit_date);
         time_choose = (EditText)findViewById(R.id.edit_time);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(this);
        dateChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        PlaceDetailActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });

        time_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                TimePickerDialog dpd = TimePickerDialog.newInstance(
                        PlaceDetailActivity.this,
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        false
                );
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });
//        chooseOthers = (LinearLayout)findViewById(R.id.choose_others);
//
//        final String[] others = {"Abhishek", "Yogesh", "Aanchal"};

      /*  chooseOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(PlaceDetailActivity.this)
                        .title("Your Members")
                        .items(others)
                        .itemsCallbackMultiChoice(null, new MaterialDialog.ListCallbackMultiChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, Integer[] which, CharSequence[] text) {
                                *//**
                                 * If you use alwaysCallMultiChoiceCallback(), which is discussed below,
                                 * returning false here won't allow the newly selected check box to actually be selected.
                                 * See the limited multi choice dialog example in the sample project for details.
                                 **//*
                                return true;
                            }
                        })
                        .positiveText("Ok")
                        .show();
            }
        });*/

        VCard johnDoe = new VCard("John Doe")
                .setEmail("john.doe@example.org")
                .setAddress("John Doe Street 1, 5678 Doestown")
                .setTitle("Mister")
                .setCompany("John Doe Inc.")
                .setPhoneNumber("1234")
                .setWebsite("www.example.org");
        Bitmap myBitmap =  QRCode.from(johnDoe).bitmap();
       // Bitmap myBitmap = QRCode.from("www.example.org").bitmap();
//        ImageView myImage = (ImageView) findViewById(R.id.imageview);
//        myImage.setImageBitmap(myBitmap);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        dateChoose.setText(""+year+" "+monthOfYear+" "+dayOfMonth);
        date = dayOfMonth + "/" + monthOfYear + "/" + year;
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {

        time_choose.setText(hourOfDay+" : " + minute);
        time = hourOfDay+" : " + minute;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.floatingActionButton){
            Intent i = new Intent(PlaceDetailActivity.this, SummaryActivity.class);
            Bundle b = new Bundle();
            b.putString("Date", date);
            b.putString("Time", time);
            b.putStringArrayList("People", people);
            i.putExtras(b);
            startActivity(i);
        }
    }


   /* public static Bitmap generateQrCode(String myCodeText) throws WriterException {
        Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H); // H = 30% damage

        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        int size = 256;

        ByteMatrix bitMatrix = qrCodeWriter.encode(myCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);
        int width = bitMatrix.width();
        Bitmap bmp = Bitmap.createBitmap(width, width, Bitmap.Config.RGB_565);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < width; y++) {
                bmp.setPixel(y, x, bitMatrix.get(x, y)==0 ? Color.BLACK : Color.WHITE);
            }
        }
        return bmp;
    }*/
}
