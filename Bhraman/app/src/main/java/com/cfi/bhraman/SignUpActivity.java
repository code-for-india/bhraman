package com.cfi.bhraman;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class SignUpActivity extends AppCompatActivity {

    Button uploadAadhar;
    ImageView aadhar;
    private int PICK_IMAGE_REQUEST = 1;
    private String FilePath;
    private boolean isProfilePicSet = false;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        uploadAadhar = (Button)findViewById(R.id.uploadAadhar);
        aadhar = (ImageView) findViewById(R.id.aadarcard);
        uploadAadhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImageChooser();
            }
        });
    }

    private void showImageChooser() {
        Intent chosePhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(chosePhoto, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            FilePath = String.valueOf(filePath);
            try {
                //Getting the Bitmap from Gallery
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                Log.v("filepath", "file path of image = " + String.valueOf(filePath));
                //Setting the Bitmap to ImageView
                aadhar.setImageBitmap(bitmap);
                isProfilePicSet = true;
                Log.v("profile", "isProfilePicSet = " + String.valueOf(isProfilePicSet));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Uri selectedImage = null;

        Log.v("result", "dialog onActivity result hit with resultCode " + resultCode + "and Requestcode " + requestCode);
        if (resultCode == Activity.RESULT_OK) {
            selectedImage = data.getData();
            if (selectedImage != null) {
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String filePath = cursor.getString(columnIndex);
                cursor.close();
                aadhar.setImageURI(Uri.parse(filePath));
                bitmap = BitmapFactory.decodeFile(filePath);
                aadhar.setImageBitmap(bitmap);
            }

        }
    }
}
