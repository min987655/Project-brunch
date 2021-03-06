package com.cos.brunch.screen.library;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.brunch.R;
import com.cos.brunch.adapter.library.LibraryTap1Adapter;
//import com.cos.brunch.adapter.posts.PostsAdapter;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;
import com.cos.brunch.screen.now.NowActivity;
import com.cos.brunch.screen.post.DetailPostActivity;
import com.cos.brunch.viewmodel.MainViewModel;

import java.util.List;

public class LibraryFrag1 extends Fragment {

    private static final String TAG = "LibraryFrag1";
    public LibraryTap1Adapter libraryTap1Adapter;
    private RecyclerView rvLibraryContent1;
    private MainViewModel mainViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag1_library, container, false);

        init(v);
        initData();
        initlistener();

        return v;
    }

    private void init(View v){

        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        rvLibraryContent1 = v.findViewById(R.id.rv_library_content1);
        libraryTap1Adapter = new LibraryTap1Adapter();
    }

    private void initData(){
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        rvLibraryContent1.setLayoutManager(layoutManager);
        rvLibraryContent1.setAdapter(libraryTap1Adapter);

        Log.d(TAG, "onViewCreated: mainViewModel : " + mainViewModel);

        mainViewModel.DTO구독하기().observe(requireActivity(), new Observer<List<PostRespDto>>() {
            @Override
            public void onChanged(List<PostRespDto> postRespDtos) {
                Log.d(TAG, "onChanged: 구독하고있는 데이터가 변경되었습니다."+postRespDtos);
                libraryTap1Adapter.setPostRespDtos(postRespDtos);
            }
        });
    }

    private void initlistener() {
        libraryTap1Adapter.setOnClickListener(new LibraryTap1Adapter.OnClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Log.d(TAG, "onItemClick: "+pos);
                Intent intent = new Intent(getContext(), DetailPostActivity.class);
                startActivity(intent);
            }
        });
    }
}
