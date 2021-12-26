package com.kennie.example.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.kennie.example.view.R;
import com.kennie.example.view.adapter.MainAdapter;
import com.kennie.example.view.widget.WidgetExampleActivity;

import java.util.Arrays;
import java.util.List;

public class MainWidgetActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_widget);
        recyclerView = findViewById(R.id.rv);
        List<String> list = Arrays.asList(getResources().getStringArray(R.array.widget_main_array));
        adapter = new MainAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainWidgetActivity.this, WidgetExampleActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });
    }
}