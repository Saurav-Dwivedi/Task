package com.example.task;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task.model.Data;
import com.example.task.retrofit.APIClient;
import com.example.task.retrofit.APIInterface;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    APIInterface apiInterface;
    RecyclerView recyclerView;
    ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = APIClient.getClient().create(APIInterface.class);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        fetchData();


    }

    private void fetchData() {
        ProgressBar progressbar = findViewById(R.id.progressbar);
        progressbar.setVisibility(View.VISIBLE);
        Call<Data> call = apiInterface.getData();
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Log.d("TAG", response.code() + "");
                String displayResponse = "";
                progressbar.setVisibility(View.GONE);
                Data resource = response.body();
                Log.e("**", resource.getResult() + "**");
                MyListAdapter adapter = new MyListAdapter(resource.getResult());
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                call.cancel();
                progressbar.setVisibility(View.GONE);
            }
        });
    }
}

