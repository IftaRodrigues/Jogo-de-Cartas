package com.ifta.avaliacaobimestral_ifta;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class CamActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam);
        imageView=findViewById(R.id.foto);
        getFoto();
    }

    private void getFoto(){
        Bundle extras = getIntent().getExtras();
            Bitmap image= (Bitmap)extras.get("foto");
            imageView.setImageBitmap(image);
    }
}