package com.example.hp.hellosir.fragment;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.hellosir.R;
import com.example.hp.hellosir.adapter.StudentAdapter;
import com.example.hp.hellosir.contentprovider.StudentProvider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchByNameFragment extends Fragment {


    @BindView(R.id.Esearch_by_name)
    EditText searchByName;
    Unbinder unbinder;

    String name="";

    int rphoto[]=new int[5];//rphoto result photo
    String rname[]= new String [5];//result name
    String regnos[]=new String[5];// result for registration number

    @BindView(R.id.rvsearch_by_name)
    RecyclerView rvsearchByName;


    public SearchByNameFragment() {
        // Required empty public constructor
    }

    StudentAdapter studentAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_by_name, container, false);
        unbinder = ButterKnife.bind(this, view);


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.imageButton)
    public void onViewClicked() {
        name =searchByName.getText().toString();
        if (!name.equals("")) {
            searchForName(name);

            //getting NullPointerException

            if (rphoto.length!=0) {

                final LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
                rvsearchByName.setLayoutManager(llm);

                rvsearchByName.setHasFixedSize(true);
                studentAdapter = new StudentAdapter(rphoto, regnos, rname, getContext());
                rvsearchByName.setAdapter(studentAdapter);


            }
            else {
                Toast.makeText(getContext(), "Not Found", Toast.LENGTH_SHORT).show();
            }


        } else {
            Toast.makeText(getContext(), "Please enter name to search", Toast.LENGTH_SHORT).show();
        }
    }

    private void searchForName(String name) {
        String selection = "name = ?";

        String[] selectionArgs = new String[]{name};
        Cursor cursor = getContext().getContentResolver().query(StudentProvider.CONTENT_URI, null, selection, selectionArgs, null);
        int i = 0;
        while (cursor.moveToNext()) {
            rphoto[i] = cursor.getInt(2);
            rname[i] = cursor.getString(1);
            regnos[i] = cursor.getString(0);
            i++;
        }
    }
}
