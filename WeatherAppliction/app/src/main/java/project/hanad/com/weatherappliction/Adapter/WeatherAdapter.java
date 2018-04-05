package project.hanad.com.weatherappliction.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.List;
import io.reactivex.functions.Consumer;
import project.hanad.com.weatherappliction.R;
import project.hanad.com.weatherappliction.model.Model.WeatherResponse;

/**
 * Created by hanad on 07/02/2018.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.MyViewHolder> implements View.OnClickListener {

    private Context applicationContext;
    private int row_customer;
    private WeatherResponse weatherResponse;
    //private Consumer<List<List>> consumer;

    public WeatherAdapter(Context applicationContext, int row_customer, WeatherResponse weatherResponse) {
        this.applicationContext =  applicationContext;
        this.weatherResponse = weatherResponse;
        this.row_customer = row_customer;
        //this.consumer = consumer;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(row_customer,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(weatherResponse.getCity().getName());// get(position).getDescription());

        //For Icon
        String icon = weatherResponse.getList().get(position).getWeather().get(0).getIcon();
        String iconUrl = "http://openweathermap.org/img/w/" + icon + ".png";
        Picasso.with(holder.imageView.getContext()).load(iconUrl).into(holder.imageView);

      //  holder.textView.setText(arrayList.get(position).getDesc());
        //holder.imageView.setImageBitmap();

    }

    @Override
    public int getItemCount() {
        return weatherResponse.getList().size();
    }

    @Override
    public void onClick(View view) {

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {


        private TextView textView;
        private ImageView imageView;


        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViwe1);
            imageView = itemView.findViewById(R.id.imageView);
          //  textView = itemView.findViewById(R.id.textViwe2);
//            imageView = imageView.findViewById(R.id.imageView);
        }

    }
}
