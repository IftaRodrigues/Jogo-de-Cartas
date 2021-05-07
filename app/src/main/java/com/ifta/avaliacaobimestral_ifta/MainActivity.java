package com.ifta.avaliacaobimestral_ifta;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private static final int CODIGO_SOLICITACAO = 1;
    private static final String PERMISSAO_CAM = Manifest.permission.CAMERA;
    private static final String PERMISSAO_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solicitarPermissao(PERMISSAO_CAM, PERMISSAO_STORAGE);
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_descricao,
                R.id.nav_player_one,R.id.nav_player_two, R.id.nav_gerar_pesos, R.id.nav_resultado)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent= new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void solicitarPermissao(String permissao1, String permissao2 ){
        int temPermissao1 = ContextCompat.checkSelfPermission(this, permissao1);
        int temPermissao2 = ContextCompat.checkSelfPermission(this, permissao2);
        if (temPermissao1 != PackageManager.PERMISSION_GRANTED && temPermissao2 != PackageManager.PERMISSION_GRANTED ) {
            ActivityCompat.requestPermissions(this, new String[]{permissao1, permissao2}, CODIGO_SOLICITACAO);
        } else {
            tirarFoto();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                tirarFoto();
            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                Toast.makeText(this, "Permissão necessaria", Toast.LENGTH_SHORT).show();
            } else {
                finish();
            }
        }
    }

    public void tirarFoto(){
        Intent tirarfoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File caminhofoto = new File(getApplicationContext().getFilesDir(), "images");
        File arquivofoto = new File(caminhofoto,System.currentTimeMillis()+".jpg");
        Uri caminhoArmazenar = FileProvider.getUriForFile(getApplicationContext(), "com.ifta.avaliacaobimestral_ifta.permissao", arquivofoto);

        tirarfoto.putExtra(MediaStore.EXTRA_OUTPUT, caminhoArmazenar);
        startActivityForResult(tirarfoto,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if (data != null){
                Bundle extras= data.getExtras();
                if (extras != null){
                    Bitmap image= (Bitmap)extras.get("data");
                    Intent i =new Intent(getApplicationContext(), CamActivity.class);
                    i.putExtra("foto",image);
                    startActivity(i);
                }else {
                    System.out.println("Erro ao pegar o extra");
                }
            }else {
                System.out.println("Erro ao pegar o data");
            }
        }
}