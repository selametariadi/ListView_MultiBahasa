package com.selamet.ariadi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import com.selamet.ariadi.model.Elang;
import com.selamet.ariadi.model.Hewan;
import com.selamet.ariadi.model.Hiu;
import com.selamet.ariadi.model.Primata;

public class DaftarHewanActivity extends AppCompatActivity {
    public final static String HEWAN_TERPILIH ="hewan_obj_key";
    List<Hewan> hewans;
    ListView listView;
    String jenisHewan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_hewan);
        Intent intent = getIntent();
        jenisHewan = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        TextView txJudul = findViewById(R.id.text_title_daftar);
        txJudul.setText("DAFTAR BERBAGAI RAS "+jenisHewan.toUpperCase());
        hewans = DataProvider.getHewansByTipe(this,jenisHewan);
        String judul="";
        if(hewans.get(0) instanceof Elang){
            judul = getString(R.string.name_Elang);
        }else if(hewans.get(0) instanceof Hiu){
            judul = getString(R.string.name_Hiu);
        }else if(hewans.get(0)instanceof Primata){
            judul = getString(R.string.name_primata);
        }
        txJudul.setText(judul);
        setupListView();
    }

    private void setupListView() {
        listView = findViewById(R.id.listview_daftar_hewan);
        DaftarHewanAdapter adapter = new DaftarHewanAdapter(this,hewans);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onListClik);
    }

    private AdapterView.OnItemClickListener onListClik = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Hewan terpilih = hewans.get(position);
            bukaProfileHewan(terpilih);
        }
    };

    private void bukaProfileHewan(Hewan hewanTerpilih) {
        Log.d("MAIN","Buka activity galeri");
        Intent intent = new Intent(this, com.selamet.ariadi.ProfilActivity.class);
        intent.putExtra(HEWAN_TERPILIH, hewanTerpilih);
        startActivity(intent);
    }


}