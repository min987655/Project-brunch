package com.cos.brunch.network.service;

import com.cos.brunch.dto.CommonRespDto;
import com.cos.brunch.dto.PostRespDto;
import com.cos.brunch.model.Post;
import com.cos.brunch.model.User;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface PostService {

//    @GET("posts")
//    Call<List<Post>> getPosts();

    @GET("main/post")
    Call<List<PostRespDto>> getPostRespDto();

    @POST("post/save")
    Call<Post> createPost(@HeaderMap Map<String, Object> data,
                          @Body Post post);
}


