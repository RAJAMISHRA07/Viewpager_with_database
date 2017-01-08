package com.example.admin.viewpager_with_database;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.admin.viewpager_with_database.R.id.et3;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {
EditText ed1,ed2,ed3;
    Button b;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment1, container, false);
        ed1= (EditText) view.findViewById(R.id.et1);
        ed2= (EditText) view.findViewById(R.id.et2);
        ed3= (EditText) view.findViewById(R.id.et3);
        b= (Button) view.findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=ed1.getText().toString();//actual logic1
                String sub=ed2.getText().toString();
                String email=ed3.getText().toString();
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.myDatabase.insertStudent(name,sub,email);
                mainActivity.noyifyData();
                Toast.makeText(mainActivity, "insert", Toast.LENGTH_SHORT).show();

            }
        });
        return  view;
    }

}
