package com.cos.brunch.screen.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.cos.brunch.R;
import com.cos.brunch.adapter.main.MainFragmentAdapter;
import com.cos.brunch.databinding.Frag3MainBinding;
import com.cos.brunch.model.Post;
import com.cos.brunch.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainFrag3 extends Fragment {

    private static final String TAG = "MainFrag3";
    private MainViewModel mainViewModel;
    public MainFragmentAdapter mainFragmentAdapter;
    public List<Post> post = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final Frag3MainBinding layout = DataBindingUtil.inflate(inflater,R.layout.frag3_main, container, false);

        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        Log.d(TAG, "onViewCreated: mainViewModel : " + mainViewModel);

        mainViewModel.구독하기().observe(requireActivity(), new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                Log.d(TAG, "onChanged: 구독 !!!! " + posts);
                String title = posts.get(2).getTitle();
                layout.tvTitle3.setText(title);
                Log.d(TAG, "onChanged: layout.tvTitle : " + title);
                Log.d(TAG, "onChanged: layout.tvTitle : " + layout.tvTitle3);
            }

        });

        return layout.getRoot();
    }

}