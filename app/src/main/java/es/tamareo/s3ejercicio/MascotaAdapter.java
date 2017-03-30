package es.tamareo.s3ejercicio;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by paco on 29/3/17.
 */

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{

    //Inicializamos las variables globales que tenemos que usar y serán inicializadas el el constructor
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdapter(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    //Inflamos el layout que hemos creado llamando al viewHolder con cada elemento
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascota_cardview, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {

        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.petName.setText(mascota.getNombre());
        mascotaViewHolder.petImg.setImageResource(mascota.getFoto());

        //TODO: HACER ALCO CUANDO PULSAMOS EN LA ACTIVIDAD

        mascotaViewHolder.btnPetLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Like mascota: "+ mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        //Declaramos los campos que vamos a cambiar
        private ImageView petImg;
        private TextView petName;
        private ImageButton btnPetLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            petImg  = (ImageView) itemView.findViewById(R.id.petImg);
            petName = (TextView) itemView.findViewById(R.id.petName);
            btnPetLike = (ImageButton) itemView.findViewById(R.id.btnPetLike);

        }
    }








}
