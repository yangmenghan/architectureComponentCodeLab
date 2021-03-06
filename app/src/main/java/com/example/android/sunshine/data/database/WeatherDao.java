package com.example.android.sunshine.data.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import java.util.Date;
import java.util.List;

@Dao public interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) void bulkInsert(WeatherEntry... weathers);

    @Query("SELECT * FROM weather WHERE date = :date") LiveData<WeatherEntry> getWeatherByDate(Date date);

    @Query("SELECT count(*) FROM weather") int countAllFullWeather();

    @Query("DELETE FROM weather WHERE date < :date") void deleteOldData(Date date);

    @Query("SELECT id, weatherIconId, min, max, date FROM weather WHERE date > :date")
    LiveData<List<WeatherSummaryEntry>> getWeathersAfterDate(Date date);
}
