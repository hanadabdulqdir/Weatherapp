package project.hanad.com.weatherappliction.service;


import android.view.View;

import java.util.List;

import io.reactivex.Observable;
import project.hanad.com.weatherappliction.constants.ApiList;
import project.hanad.com.weatherappliction.model.Model.Weather;
import project.hanad.com.weatherappliction.model.Model.WeatherResponse;
import retrofit2.http.GET;

/**
 * Created by hanad on 07/02/2018.
 */

public  interface IRequestInterface {
    /**
     * //List is used when the beggining of json data is json array, if not then do not use list
     * if [] square brackets, specify the array list
     * if {} curly backets, specifies the object without the list
     * @return
     */
    @GET(ApiList.WeatherList)
    Observable<WeatherResponse> GetWeather();


}
