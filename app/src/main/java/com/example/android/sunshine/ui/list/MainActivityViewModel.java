package com.example.android.sunshine.ui.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import com.example.android.sunshine.data.SunshineRepository;
import com.example.android.sunshine.data.database.WeatherEntry;
import com.example.android.sunshine.data.database.WeatherSummaryEntry;
import com.example.android.sunshine.utilities.SunshineDateUtils;
import java.util.Date;
import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private LiveData<List<WeatherSummaryEntry>> weathersForecasts;

    public MainActivityViewModel(SunshineRepository repository) {
        Date today = SunshineDateUtils.getNormalizedUtcDateForToday();
        weathersForecasts = repository.getWeathersForecasts(today);
    }

    public LiveData<List<WeatherSummaryEntry>> getWeathersForecasts() {
        return weathersForecasts;
    }
}
