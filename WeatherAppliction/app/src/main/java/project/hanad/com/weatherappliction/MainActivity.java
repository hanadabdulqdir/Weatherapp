package project.hanad.com.weatherappliction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import project.hanad.com.weatherappliction.Adapter.WeatherAdapter;
import project.hanad.com.weatherappliction.model.Model.WeatherResponse;
import project.hanad.com.weatherappliction.service.IRequestInterface;
import project.hanad.com.weatherappliction.service.ServiceConnection;

public class MainActivity extends AppCompatActivity {

    private IRequestInterface iRequestInterface;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recycler);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        iRequestInterface = ServiceConnection.getConnection();
        Log.i(" posted",  " onCreate check ");
        iRequestInterface.GetWeather()//get data
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeatherResponse>() {
                               @Override
                               public void accept(WeatherResponse weathers) {
                                   //Pass the data to the recyclerView
                                   recyclerView.setAdapter(new WeatherAdapter(getApplicationContext(), R.layout.row,weathers));
                                   Log.i(" posted",  " accepted post ");
                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                                Log.i(" posted",  " check message ");
                            }
                        }
                );
    }
}