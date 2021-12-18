package com.example.booklist;

import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<BookView> arrayList;
    BookViewAdapter bookViewAdapter;
    ListView bookListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<>();

        arrayList.add(new BookView(R.drawable.book1977, "T01", "1977!", "History", 107, "566"));
        arrayList.add(new BookView(R.drawable.germanhumor, "T02", "200 Years of German Humor", "History", 14, "9566"));
        arrayList.add(new BookView(R.drawable.system, "T03", "Ask Your System Administrator", "Computer", 1226, "25667"));
        arrayList.add(new BookView(R.drawable.unconsciously, "T04", "But I Dit It Unconsciously", "Biography", 510, "13001"));
        arrayList.add(new BookView(R.drawable.platitudes, "T05", "Exchange of Platitudes", "Computer", 201, "201440"));
        arrayList.add(new BookView(R.drawable.never, "T06", "How About Never?", "History", 473, "11320"));
        arrayList.add(new BookView(R.drawable.mother, "T07", "I Blame My Mother", "Biography", 333, "1500200"));
        arrayList.add(new BookView(R.drawable.stop, "T08", "One Last Stop", "History", 86, "4095"));
        arrayList.add(new BookView(R.drawable.egg, "T09", "Not Without My Faberge Egg", "Biography", 22, "5000"));
        arrayList.add(new BookView(R.drawable.computerscience, "T010", "Computer Science", "Computer", 826, "94123"));
        arrayList.add(new BookView(R.drawable.cryingtree, "T011", "The Crying Tree", "Biography", 507, "100001"));
        arrayList.add(new BookView(R.drawable.light, "T012", "All The Light We Cannot See", "History", 802, "10467"));

        bookListView = findViewById(R.id.listView);
        bookViewAdapter = new BookViewAdapter(this, arrayList);
        bookListView.setAdapter((ListAdapter) bookViewAdapter);

        TextView textView = findViewById(R.id.idTVSee);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookViewAdapter.Update(arrayList);
            }
        });

        TextView idTVHistoryTotal = findViewById(R.id.idTVHistoryTotal);
        CardView cardView1 = findViewById(R.id.cardView1);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<BookView> list = filterList("History");
                bookViewAdapter.Update(list);
                idTVHistoryTotal.setText("" + list.size());
            }
        });

        TextView idTVBiographyTotal = findViewById(R.id.idTVBiographyTotal);
        CardView cardView2 = findViewById(R.id.cardView2);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<BookView> list = filterList("Biography");
                bookViewAdapter.Update(list);
                idTVBiographyTotal.setText("" + list.size());

            }
        });

        TextView idTVComputerTotal = findViewById(R.id.idTVComputerTotal);
        CardView cardView3 = findViewById(R.id.cardView3);
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<BookView> list = filterList("Computer");
                bookViewAdapter.Update(list);
                idTVComputerTotal.setText("" + list.size());
            }
        });

        TextView idTVPsychologyTotal = findViewById(R.id.idTVPsychologyTotal);
        CardView cardView4 = findViewById(R.id.cardView4);
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<BookView> list = filterList("Psychology");
                bookViewAdapter.Update(list);
                idTVPsychologyTotal.setText("" + list.size());
            }
        });
    }

    public ArrayList<BookView> filterList(String type){
        ArrayList<BookView> list = new ArrayList<>();

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getCategory().equals(type)) {
                list.add(arrayList.get(i));
            }
        }
        if(list.size()<=0){
            Toast.makeText(getApplicationContext(), "Book Not Found!!!", Toast.LENGTH_SHORT).show();
        }
        return list;
    }
}