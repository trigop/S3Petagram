package es.tamareo.s3ejercicio;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Añadimos Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.petToolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.rvPetList);

        //Generamos el Layout como lo necesitamos. En este caso como Linear
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //Añaidmos al recyclerView el Layout definido
        recyclerView.setLayoutManager(llm);

        //Inicializamos las mascotas
        initMascotas();

        //Inicializamos el Adaptador
        initAdaptador();

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fabTakePhoto);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Pulsamos botón de la cámara!", Toast.LENGTH_SHORT).show();

            }
        });


        imageButton = (ImageButton) findViewById(R.id.btnShowLike);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MascotasFavoritas.class);
                startActivity(intent);

            }
        });

    }


    //Iniciamos el adaptador y añadimos al recyclerView el adaptador creado
    private void initAdaptador() {
        MascotaAdapter mascotaAdapter = new MascotaAdapter(mascotas, this);
        recyclerView.setAdapter(mascotaAdapter);
    }


    //Inicializamos el contenido. Creamos un array con las mascotas
    public void initMascotas(){

        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Mascota 1", R.drawable.mascota1));
        mascotas.add(new Mascota("Mascota 2", R.drawable.mascota2));
        mascotas.add(new Mascota("Mascota 3", R.drawable.mascota3));
        mascotas.add(new Mascota("Mascota 4", R.drawable.mascota4));
        mascotas.add(new Mascota("Mascota 5", R.drawable.mascota5));
        mascotas.add(new Mascota("Mascota 6", R.drawable.mascota6));

    }


}
