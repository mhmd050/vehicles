package com.example.vehicles;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements VehicleAdapter.ItemSelected {
    private Button button;
    private TextView textView;
    private RecyclerView recyclerView;
    private VehicleAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Vehicle> vehicles;
    private int[] images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initImgArray();
        initStonesArray();
        myAdapter=new VehicleAdapter(MainActivity.this,vehicles);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setAdapter(myAdapter);
            }
        });
    }

    private void initImgArray() {
        images=new int[6];
        images[0]=R.drawable.img;
        images[1]=R.drawable.img_1;
        images[2]=R.drawable.img_2;
        images[3]=R.drawable.img_3;
        images[4]=R.drawable.img_4;
        images[5]=R.drawable.img_5;
    }

    private void initViews() {
        button=findViewById(R.id.btnShowList);
        recyclerView=findViewById(R.id.list);
        textView=findViewById(R.id.txtDetails);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void initStonesArray() {
        vehicles=new ArrayList<>();
        String[] st=getResources().getStringArray(R.array.stones);
        for (String s:st)
        {
            vehicles.add(new Vehicle(s));
        }
        for (int i=0;i<images.length;i++) {
            vehicles.get(i).setImg(images[i]);
        }

    }

    @Override
    public void onItemClicked(int Index) {
        String Details[]=getResources().getStringArray(R.array.details);
        textView.setText(Details[Index]);
    }
}