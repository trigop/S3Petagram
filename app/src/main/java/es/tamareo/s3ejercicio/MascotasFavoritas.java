package es.tamareo.s3ejercicio;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {


    ArrayList<Mascota> mascotas;
    private RecyclerView recyclerView;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);
        //Añadimos Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.petToolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.rvPetListFav);

        //Generamos el Layout como lo necesitamos. En este caso como Linear
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //Añaidmos al recyclerView el Layout definido
        recyclerView.setLayoutManager(llm);

        //Inicializamos las mascotas
        initMascotas();

        //Inicializamos el Adaptador
        initAdaptador();


        imageButton = (ImageButton) findViewById(R.id.btnShowLike);
        imageButton.setVisibility(View.INVISIBLE);

    }


    //Iniciamos el adaptador y añadimos al recyclerView el adaptador creado
    private void initAdaptador() {
        MascotaAdapter mascotaAdapter = new MascotaAdapter(mascotas, this);
        recyclerView.setAdapter(mascotaAdapter);
    }


    //Inicializamos el contenido. Creamos un array con las mascotas
    public void initMascotas(){

        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Mascota 6", R.drawable.mascota6));
        mascotas.add(new Mascota("Mascota 5", R.drawable.mascota5));
        mascotas.add(new Mascota("Mascota 4", R.drawable.mascota4));
        mascotas.add(new Mascota("Mascota 3", R.drawable.mascota3));
        mascotas.add(new Mascota("Mascota 2", R.drawable.mascota2));
        mascotas.add(new Mascota("Mascota 1", R.drawable.mascota1));

    }


}
