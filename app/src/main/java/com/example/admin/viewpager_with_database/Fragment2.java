package com.example.admin.viewpager_with_database;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {
ListView lv;
    Cursor cursor;
    MyDatabase myDatabase;
    SimpleCursorAdapter simpleCursorAdapter;



    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment2, container, false);
        lv= (ListView) view.findViewById(R.id.listview);
        MainActivity mainActivity= (MainActivity) getActivity();//2nd
        cursor=mainActivity.myDatabase.queryStudent();
        simpleCursorAdapter=new SimpleCursorAdapter(getActivity(),R.layout.row,
                cursor,
                new String[]{"_id","sname","ssub","email"},
        new int[]{R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4});
        lv.setAdapter(simpleCursorAdapter);

        return  view;
    }

}
