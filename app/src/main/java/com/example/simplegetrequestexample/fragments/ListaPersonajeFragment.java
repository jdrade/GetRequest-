package com.example.simplegetrequestexample.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.simplegetrequestexample.R;
import com.example.simplegetrequestexample.adaptadores.AdaptadorPersonaje;
import com.example.simplegetrequestexample.entidades.PersonajeVo;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListaPersonajeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListaPersonajeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaPersonajeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<PersonajeVo> listaPersonajes;
    RecyclerView recyclerPersonajes;

    public ListaPersonajeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaPersonajeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaPersonajeFragment newInstance(String param1, String param2) {
        ListaPersonajeFragment fragment = new ListaPersonajeFragment();
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

        final View vista = inflater.inflate(R.layout.fragment_lista_personaje, container, false);

        listaPersonajes = new ArrayList<>();
        recyclerPersonajes = vista.findViewById(R.id.recyclerId);
        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarListaPersonajes();
        AdaptadorPersonaje adapter = new AdaptadorPersonaje(listaPersonajes);
        recyclerPersonajes.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Selecciona" + listaPersonajes.get(recyclerPersonajes.getChildAdapterPosition(view)).getNombre(),Toast.LENGTH_SHORT).show();
            }
        });

        return vista;
    }

    private void llenarListaPersonajes() {
        listaPersonajes.add(new PersonajeVo("A","1st",R.drawable.a));
        listaPersonajes.add(new PersonajeVo("B","2nd",R.drawable.b));
        listaPersonajes.add(new PersonajeVo("C","3rd",R.drawable.c));
        listaPersonajes.add(new PersonajeVo("D","4th",R.drawable.d));
        listaPersonajes.add(new PersonajeVo("E","5th",R.drawable.e));
        listaPersonajes.add(new PersonajeVo("F","6th",R.drawable.f));
        listaPersonajes.add(new PersonajeVo("G","7th",R.drawable.g));
        listaPersonajes.add(new PersonajeVo("H","8th",R.drawable.h));

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
