package com.example.hp.hellosir.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.hellosir.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentDetailsActivity extends AppCompatActivity {

    @BindView(R.id.IVStudentPhoto)
    ImageView IVStudentPhoto;
    @BindView(R.id.ESname)
    TextView ESname;
    @BindView(R.id.ESReg)
    TextView ESReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            //get the value from intent
            int photo=extras.getInt("photo");
            String name=extras.getString("name");
            String reg=extras.getString("reg");

            IVStudentPhoto.setImageResource(photo);
            ESname.setText(name);
            ESReg.setText(reg);
        }
    }
}
