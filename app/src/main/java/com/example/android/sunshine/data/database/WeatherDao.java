package com.example.android.sunshine.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import java.util.Date;

@Dao public interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) void bulkInsert(WeatherEntry... weathers);

    @Query("SELECT * FROM weather WHERE date = :data") WeatherEntry getWeatherByDate(Date date);
}
