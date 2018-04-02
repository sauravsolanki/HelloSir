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
public class SearchByRegFragment extends Fragment {


    @BindView(R.id.ESearch_by_reg)
    EditText ESearchByReg;

    @BindView(R.id.RVSearch_by_reg)
    RecyclerView RVSearchByReg;

    Unbinder unbinder;

    String reg;

    int rphoto[]=new int[5];//rphoto result photo
    String rname[]= new String [5];//result name
    String regnos[]=new String[5];// result for registration number

    StudentAdapter studentAdapter;
    public SearchByRegFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_by_reg, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.IBSearch_by_reg)
    public void onViewClicked() {

        RVSearchByReg.setAdapter(null);
        reg=ESearchByReg.getText().toString();
        if (!reg.equals("")){
            //TO-DO to query the value

            searchForReg(reg);

            //getting NullPointerException

            if (rphoto.length!=0) {

                final LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
                RVSearchByReg.setLayoutManager(llm);

                RVSearchByReg.setHasFixedSize(true);
                studentAdapter = new StudentAdapter(rphoto, regnos, rname, getContext());
                RVSearchByReg.setAdapter(studentAdapter);


            }
            else {
                Toast.makeText(getContext(), "Not Found", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(getContext(), "Enter the registration number first", Toast.LENGTH_SHORT).show();
        }
    }

    private void searchForReg(String reg) {
        String selection = "_id = ?";

        String[] selectionArgs = new String[]{reg};
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
