package com.cos.brunch.dto;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.cos.brunch.R;
import com.squareup.picasso.Picasso;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentRespDto {
    private String title;
    private String profileImage;
    private int id;
    private String nickName;
    private String createDate;
    private String content;

    @BindingAdapter({"coverImg"})
    public static void loadImage(ImageView view, String coverImg){
        Picasso.get()
                .load(coverImg)
                .error(R.drawable.ic_error)
                .placeholder(R.drawable.ic_load)
                .resize(50,50)
                .into(view);
    }
}
