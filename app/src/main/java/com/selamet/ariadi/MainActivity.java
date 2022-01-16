package com.selamet.ariadi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageButton btnPrimata,btnElang,btnHiu;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();

    }

    private void inisialisasiView() {
        btnPrimata = findViewById(R.id.btn_buka_ras_Primata);
        btnElang = findViewById(R.id.btn_buka_ras_Elang);
        btnHiu = findViewById(R.id.btn_buka_ras_Hiu);
        btnPrimata.setOnClickListener(view -> bukaGaleri("Primates"));
        btnElang.setOnClickListener(view -> bukaGaleri("Eagle"));
        btnHiu.setOnClickListener(view -> bukaGaleri("Shark"));
    }

    private void bukaGaleri(String jenisHewan) {
        Log.d("MAIN","Buka activity Primata");
        Intent intent = new Intent(this, com.selamet.ariadi.DaftarHewanActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, jenisHewan);
        startActivity(intent);
    }

    public void Pindah(View view) {
        Intent intent = new Intent(MainActivity.this, com.selamet.ariadi.BiodataActivity.class);
        startActivity(intent);
    }
}