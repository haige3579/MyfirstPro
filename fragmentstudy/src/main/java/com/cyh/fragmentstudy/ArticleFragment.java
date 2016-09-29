package com.cyh.fragmentstudy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ArticleFragment extends Fragment {
    public static final String ARG_POSITION = "position";
    int mCurrentPosition=-1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState!=null){
            mCurrentPosition=savedInstanceState.getInt(ARG_POSITION);
        }
        return inflater.inflate(R.layout.fragment_article, container, false);
    }

//    检查是否有传参
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if (args!=null){
             //            根据参数变
            updateArticleView(args.getInt(ARG_POSITION));
        }else if (mCurrentPosition!=-1){
            //            初始值
            updateArticleView(mCurrentPosition);
        }
    }

    public void updateArticleView(int position){
        TextView article = (TextView) getActivity().findViewById(R.id.article);
        article.setText(Ipsum.Articles[position]);
        mCurrentPosition=position;


    }

//    保存
    public void onSaveInstanceState(Bundle outState){
     outState.putInt(ARG_POSITION,mCurrentPosition);
    }
}
