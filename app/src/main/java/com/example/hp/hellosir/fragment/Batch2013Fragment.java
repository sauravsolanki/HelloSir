package com.example.hp.hellosir.fragment;


import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.hellosir.R;
import com.example.hp.hellosir.adapter.StudentAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.example.hp.hellosir.contentprovider.StudentProvider;

/**
 * A simple {@link Fragment} subclass.
 */
public class Batch2013Fragment extends Fragment {
   // private static final String TAG = "RecyclerViewFragment";

    @BindView(R.id.rvbatch2013)
    RecyclerView rv;

    Unbinder unbinder;

    public Batch2013Fragment() {
        // Required empty public constructor
    }


    StudentAdapter studentAdapter;

    int photo[]=new int[7] ;
    String names[]=new String[7];
    String regnos[]=new String[7];


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_batch2013, container, false);
        unbinder = ButterKnife.bind(this, view);

       intialiseData();


        final LinearLayoutManager llm= new LinearLayoutManager(this.getContext());
        rv.setLayoutManager(llm);

        rv.setHasFixedSize(true);

        studentAdapter = new StudentAdapter(photo, regnos, names, getContext());

        //rv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rv.setAdapter(studentAdapter);


        return view;
    }

    private void intialiseData() {
        //get the 2013 batch details
        //use cursor to query it
        String selection="year = ?";
        String[] selectionArgs = new String[]{"2013"};
        Cursor cursor=getContext().getContentResolver().query(StudentProvider.CONTENT_URI,null,selection,selectionArgs,"_id");
        int i=0;
        while (cursor.moveToNext()){
            photo[i]=cursor.getInt(2);
            names[i]=cursor.getString(1);
            regnos[i]=cursor.getString(0);
            i++;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
