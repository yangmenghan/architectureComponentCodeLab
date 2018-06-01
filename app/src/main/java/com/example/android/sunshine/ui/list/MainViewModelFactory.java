package com.example.android.sunshine.ui.list;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import com.example.android.sunshine.data.SunshineRepository;

public class MainViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private SunshineRepository repository;

    public MainViewModelFactory(SunshineRepository repository) {
        this.repository = repository;
    }

    @Override public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainActivityViewModel(repository);
    }
}
