package com.example.newfoodlistchoco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewHorizontal;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    public static TextView tv;

    public Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //     toolbar = findViewById(R.id.toolbar);
        //  setSupportActionBar(toolbar);

      /*  getSupportActionBar().setTitle("Foodish");
        toolbar.setTitleTextColor(0xFFFFFFFF);*/

        //   mLayoutManager=new GridLayoutManager(getApplicationContext(),2);

      /*  recyclerViewHorizontal = findViewById(R.id.horizontal_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewHorizontal.setLayoutManager(linearLayoutManager);*/

        recyclerView = findViewById(R.id.mRecyclerViewOfr);
        recyclerView.setLayoutManager(mLayoutManager);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager2);
        RetrofitInterface retrofitService = RetrofitClient.getClient().create(RetrofitInterface.class);

        Call<Chocolatelist> call = retrofitService.getChocolateList();
        call.enqueue(new Callback<Chocolatelist>() {
            @Override
            public void onResponse(Call<Chocolatelist> call, retrofit2.Response<Chocolatelist> response) {
            /*    List<GeneralFood> popularFoods = response.body().getPopularFood();
                recyclerViewHorizontal.setAdapter(new HorizontalAdapter(popularFoods, R.layout.recyclerview_horizontal, MainActivity.this));
*/
                List<Prprice> regularFoods = response.body().getPrprice();
                recyclerView.setNestedScrollingEnabled(false);
                recyclerView.setAdapter(new ChocolateAdapter(regularFoods, R.layout.product_list, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<Chocolatelist> call, Throwable t) {

            }
        });
    }

   /* public static void cartUpdate() {
        if (tv != null && cartFoods != null)
            tv.setText(Integer.toString(cartFoods.size()));
    }

    @Override
    protected void onResume() {
        invalidateOptionsMenu();
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        finish();
}*/
}

