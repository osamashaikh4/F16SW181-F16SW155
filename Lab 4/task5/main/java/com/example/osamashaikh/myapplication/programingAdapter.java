package com.example.muhammadwaqar.myapplication;



import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class programingAdapter extends RecyclerView.Adapter<programingAdapter.programmingViewHolder> {
       private  String[] data;
        programingAdapter(String[] data){
            this.data = data;
        }

    @Override
    public programmingViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext()) ;
        View view = layoutInflater.inflate(R.layout.list_item_layout, viewGroup, false);

        return new programmingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(programmingViewHolder programmingViewHolder, int i) {
        String title = data[i];
        programmingViewHolder.txtTitle.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class programmingViewHolder extends RecyclerView.ViewHolder {
        ImageView imgIcon;
        TextView txtTitle;
        programmingViewHolder(View view){
            super(view);
            imgIcon = itemView.findViewById(R.id.imgIcon);
            txtTitle = itemView.findViewById(R.id.txtTitle);

            itemView.setClickable(true);
            itemView.setFocusableInTouchMode(true);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(itemView.getContext(), "Position: " + Integer.toString(getAdapterPosition()), Toast.LENGTH_LONG).show();
                }
            });



        }
    }





















    }

