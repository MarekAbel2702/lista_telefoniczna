package com.example.listatelefoniczna;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FormularzFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FormularzFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FormularzFragment() {
        super(R.layout.fragment_formularz);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FormularzFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FormularzFragment newInstance(String param1, String param2) {
        FormularzFragment fragment = new FormularzFragment();
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
        return inflater.inflate(R.layout.fragment_formularz, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        EditText formularzName = view.findViewById(R.id.formularzName);
        EditText formularzPhone = view.findViewById(R.id.formularzPhone);
        EditText formularzEmail = view.findViewById(R.id.formularzEmail);
        Button formularzZapisz = view.findViewById(R.id.formularzZapisz);

        formularzZapisz.setOnClickListener(v -> {
            String name = formularzName.getText().toString().trim();
            String phone = formularzPhone.getText().toString().trim();
            String email = formularzEmail.getText().toString().trim();

            if (name.isEmpty() || phone.isEmpty())
            {
                Toast.makeText(getContext(), "Podaj imię i telefon", Toast.LENGTH_SHORT).show();
                return;
            }

            if (email.isEmpty()) email = "-";

            Wszystkie_Kontakty.add(new Contact(name, phone, email));

            getParentFragmentManager().setFragmentResult("contact_added", new Bundle());

            Navigation.findNavController(v).popBackStack();
        });
    }
}