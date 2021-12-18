package com.example.booklist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class BookViewAdapter extends ArrayAdapter<BookView> {

    ArrayList<BookView> list;
    ArrayList<BookView> arrayList;

    public BookViewAdapter(@NonNull Context context, ArrayList<BookView> arrayList) {
        super(context, R.layout.custom_listview, arrayList);
        this.list = arrayList;
    }

    public void Update(ArrayList<BookView> arrayList) {
        this.list = arrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    public BookView getItem(int position) {
        return this.list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentBookView = convertView;
        RecordHolder holder = null;

        if (currentBookView == null) {
            currentBookView = LayoutInflater.from(getContext()).inflate(R.layout.custom_listview, parent, false);

            holder = new RecordHolder();

            holder.imageView1 = currentBookView.findViewById(R.id.imageView1);
            holder.textBookName = currentBookView.findViewById(R.id.textBookName);
            holder.textBookType = currentBookView.findViewById(R.id.textBookType);
            holder.textBookPages = currentBookView.findViewById(R.id.textBookPages);

            currentBookView.setTag(holder);
        } else {
            holder = (RecordHolder) currentBookView.getTag();
        }

        BookView currentBookPosition = getItem(position);

        holder.imageView1.setImageResource(currentBookPosition.getIdBookImage());
        holder.textBookName.setText(currentBookPosition.getBookName());
        holder.textBookType.setText(currentBookPosition.getCategory());
        holder.textBookPages.setText("" + currentBookPosition.getPages());

        return currentBookView;
    }


    public class RecordHolder {
        ImageView imageView1;
        TextView textBookName;
        TextView textBookType;
        TextView textBookPages;
    }


}
