package com.example.hp.hellosir.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.hellosir.R;
import com.example.hp.hellosir.activities.StudentDetailsActivity;

import org.w3c.dom.Text;

/**
 * Created by hp on 31-03-2018.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {
    int photoURL[];
    String regnos[];
    String names[];
    Context ct;

    public StudentAdapter(int[] photoURL, String[] regnos, String[] names, Context ct) {
        this.photoURL = photoURL;
        this.regnos = regnos;
        this.names = names;
        this.ct = ct;
    }

    @Override
    public StudentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.student,parent,false);
        return new StudentHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentHolder holder, int position) {
         holder.photo.setImageResource(photoURL[position]);
         holder.name.setText(names[position]);
         holder.regno.setText(regnos[position]);
    }

    @Override
    public int getItemCount() {
        return photoURL.length;
    }

    public class StudentHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView photo;
        TextView name;
        TextView regno;
        public StudentHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            regno=(TextView)itemView.findViewById(R.id.id);
            photo=(ImageView)itemView.findViewById(R.id.pro_pic);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), StudentDetailsActivity.class);
            intent.putExtra("name",names[getPosition()]);
            intent.putExtra("reg",regnos[getPosition()]);
            intent.putExtra("photo",photoURL[getPosition()]);
            view.getContext().startActivity(intent);
        }
    }
}
