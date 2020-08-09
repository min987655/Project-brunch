package com.cos.brunch.posts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import com.cos.brunch.R;
import com.cos.brunch.model.Post;
import com.cos.brunch.model.User;
import com.cos.brunch.now.ContentVerticalAdapter;
import com.cos.brunch.now.KeywordAdapter;
import com.cos.brunch.now.NowActivity;
import com.cos.brunch.user.UserActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class PostsActivity extends AppCompatActivity {

    private static final String TAG = "PostsActivity";
    private Context mContext = PostsActivity.this;
    private PostsAdapter postsAdapter;
    private RecyclerView rvPostsContent;

    private ImageView imgBack, imgSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        initObject();
        initDesign();
        initData();
        initlistener();
    }

    private void initObject() {
        imgBack = findViewById(R.id.img_toolbar_l);
        imgSearch = findViewById(R.id.img_toolbar_r);

        imgBack.setImageDrawable(getDrawable(R.drawable.img_back_b));
        imgSearch.setImageDrawable(getDrawable(R.drawable.img_search));
    }

    private void initDesign() {
        rvPostsContent = findViewById(R.id.rv_posts_content);
    }

    private void initData() {
        postsAdapter = new PostsAdapter();
        postsAdapter.addPost(new Post("","마음의 고향 제주에서 3주살이",R.drawable.img_cover, "어김없이 새벽에 눈을 뜨고 다시 감았다. 조식을 먹지 않으려했지만 사장님이 이미 빵도 구워 놨다 하셔서"));
        postsAdapter.addPost(new Post("","마음의 고향 제주에서 3주살이",R.drawable.img_cover, "어김없이 새벽에 눈을 뜨고 다시 감았다. 조식을 먹지 않으려했지만 사장님이 이미 빵도 구워 놨다 하셔서"));
        postsAdapter.addPost(new Post("","마음의 고향 제주에서 3주살이",R.drawable.img_cover, "어김없이 새벽에 눈을 뜨고 다시 감았다. 조식을 먹지 않으려했지만 사장님이 이미 빵도 구워 놨다 하셔서"));
        postsAdapter.addPost(new Post("","마음의 고향 제주에서 3주살이",R.drawable.img_cover, "어김없이 새벽에 눈을 뜨고 다시 감았다. 조식을 먹지 않으려했지만 사장님이 이미 빵도 구워 놨다 하셔서"));
        postsAdapter.addPost(new Post("","마음의 고향 제주에서 3주살이",R.drawable.img_cover, "어김없이 새벽에 눈을 뜨고 다시 감았다. 조식을 먹지 않으려했지만 사장님이 이미 빵도 구워 놨다 하셔서"));
        postsAdapter.addPost(new Post("","마음의 고향 제주에서 3주살이",R.drawable.img_cover, "어김없이 새벽에 눈을 뜨고 다시 감았다. 조식을 먹지 않으려했지만 사장님이 이미 빵도 구워 놨다 하셔서"));
        postsAdapter.addPost(new Post("","마음의 고향 제주에서 3주살이",R.drawable.img_cover, "어김없이 새벽에 눈을 뜨고 다시 감았다. 조식을 먹지 않으려했지만 사장님이 이미 빵도 구워 놨다 하셔서"));
        postsAdapter.addPost(new Post("","마음의 고향 제주에서 3주살이",R.drawable.img_cover, "어김없이 새벽에 눈을 뜨고 다시 감았다. 조식을 먹지 않으려했지만 사장님이 이미 빵도 구워 놨다 하셔서"));
        postsAdapter.addPost(new Post("","마음의 고향 제주에서 3주살이",R.drawable.img_cover, "어김없이 새벽에 눈을 뜨고 다시 감았다. 조식을 먹지 않으려했지만 사장님이 이미 빵도 구워 놨다 하셔서"));
        postsAdapter.addPost(new Post("","마음의 고향 제주에서 3주살이",R.drawable.img_cover, "어김없이 새벽에 눈을 뜨고 다시 감았다. 조식을 먹지 않으려했지만 사장님이 이미 빵도 구워 놨다 하셔서"));

        rvPostsContent.setLayoutManager(new LinearLayoutManager(this));
        rvPostsContent.setAdapter(postsAdapter);
    }

    private void initlistener() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, NowActivity.class);
                startActivity(intent);
            }
        });
    }
}