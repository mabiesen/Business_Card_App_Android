package com.andrewbiesen.andrewvendorsjava;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button castingButton;
    Button allVendorsButton;
    Button equipRentalButton;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetViews();
        SetListeners();
        new ImageHelper().execute("https://www.dropbox.com/s/siklxzx4qb9io1s/AndrewBiesenLogo.png?dl=1");
    }


    public void SetListeners(){
        this.castingButton.setOnClickListener(new HandleClickEvent());
        this.allVendorsButton.setOnClickListener(new HandleClickEvent());
        this.equipRentalButton.setOnClickListener(new HandleClickEvent());
        this.imgView.setOnClickListener(new HandleClickEvent());
    }

    public void GetViews()
    {
        this.castingButton = (Button) findViewById(R.id.castingBtn);
        this.allVendorsButton = (Button) findViewById(R.id.allBtn);
        this.equipRentalButton = (Button) findViewById(R.id.equipRentBtn);
        this.imgView = (ImageView) findViewById(R.id.imageView1);
    }

    public void GoToAndrewBiesenSite()
    {
        Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.andrewbiesen.com/"));
        startActivity(intent);
    }

    public void ButtonToVendorListActivity(String myData)
    {
        Intent intent = new Intent(this, VendorListActivity.class);

        intent.putExtra("mygroup",myData);

        startActivity(intent);
    }

    public class HandleClickEvent implements View.OnClickListener {


        public void onClick(View arg0) {
            if(arg0 instanceof Button){
                String btnText = ((Button) arg0).getText().toString();
                ButtonToVendorListActivity(btnText);
            }
            if(arg0 instanceof ImageView){
                GoToAndrewBiesenSite();
            }
        }

    }


    public class ImageHelper extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... params) {
            InputStream input = null;
            try {
                final URL url = new URL(params[0]);
                input = new BufferedInputStream(url.openStream());
                return BitmapFactory.decodeStream(input);
            } catch (final Exception e) {
                e.printStackTrace();
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (final IOException ignored) {
                        // Nothing to do
                    }
                }
            }
            return null;
        }


        @Override
        protected void onPostExecute(Bitmap result) {
            if (result != null) {
                // Set the image here
                ImageView thisview = (ImageView) findViewById(R.id.imageView1);
                thisview.setImageBitmap(result);
            }
        }
    }

}
