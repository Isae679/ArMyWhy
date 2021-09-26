package com.biancaesquibel.armywhy.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.biancaesquibel.armywhy.R;
import com.biancaesquibel.armywhy.adapter.CardViewAdapter;
import com.biancaesquibel.armywhy.model.Image;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        //toolbar
        showToolBar("",false, view);

        //recyclerview
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_profile);

        //layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //el adapter
        CardViewAdapter cardViewAdapter = new CardViewAdapter(buidImages(), R.layout.cardview_image, getActivity());
        recyclerView.setAdapter(cardViewAdapter);
        return view;
    }

    public void showToolBar(String titulo, boolean botonSubir, View view){
        Toolbar toolbar = view.findViewById(R.id.toolbar_profile);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titulo);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(botonSubir);
    }

    //creamos la lista de imagenes
    public ArrayList<Image> buidImages(){
        ArrayList<Image> images = new  ArrayList<>();

        images.add(new Image("https://boliviatravelsite.com/Images/Attractionphotos/incachaca-004.jpg","kevin Salazar", "2 dias", "1 me gusta"));
        images.add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c6/Cristo_de_La_Concordia_de_Cochabamba.jpg/800px-Cristo_de_La_Concordia_de_Cochabamba.jpg","Luis Peres", "3 dias", "5 me gusta"));
        images.add(new Image("https://media-cdn.tripadvisor.com/media/photo-s/0e/1b/f4/2a/fuerte-de-samaipata.jpg","Fernando Torrico", "6 dias", "4 me gusta"));
        images.add(new Image("https://i.pinimg.com/originals/b5/e4/a0/b5e4a018a916b51ee5fa35f30776348a.jpg","Nicol Mendoza", "5 dias", "7 me gusta"));
        images.add(new Image("https://media.iatiseguros.com/wp-content/uploads/2019/07/04011702/visitar-salar-uyuni-4.jpg","Alexander Lara", "3 dias", "3 me gusta"));
        images.add(new Image("https://chullostravelperu.com/wp-content/uploads/2021/04/Laguna-Colorada-Salar-de-Uyuni.jpg","Maissel Valdivia", "4 dias", "9 me gusta"));
        images.add(new Image("https://laicismo.org/wp-content/uploads/2017/02/Monumento-Virgen-de-Socavon-en-Oruro-Bolivia.jpg","William Jimenez", "2 dias", "6 me gusta"));
        images.add(new Image("https://www.ibolivia.org/wp-content/uploads/2018/10/castillo-de-la-glorieta.jpg","Roberta Montaño", "2 dias", "2 me gusta"));
        images.add(new Image("https://cdn.bolivia.com/sdi/2017/12/15/el-parque-nacional-tunari-sera-sometido-una-campana-de-reforestacion-591725.jpg","Vivian Ledezma", "6 dias", "3 me gusta"));
        images.add(new Image("https://imgs-akamai.mnstatic.com/ab/d0/abd0efc0216af826cc5cff7fe14e50e5.jpg?quality=75&format=pjpg&fit=bounds&width=980&height=880","Rafael Rojas", "5 dias", "1 me gusta"));


        return images;
    }
}