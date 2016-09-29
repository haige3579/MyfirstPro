package com.cyh.fragmentstudy;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 *  定义一个回调接口，消息交互
 * Created by CYH on 2016/9/28.
 */
public class HeadlinesFragment extends ListFragment {
     OnHeadlinesSelectedListner mCallback;
     public interface OnHeadlinesSelectedListner{
         public void onArticleSelected(int position);
     }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        适配不同尺寸的设备
        int layout= Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB ?android.R.layout.simple_list_item_activated_1:android.R.layout.simple_list_item_1;
//        创建一个数组适配器
        setListAdapter(new ArrayAdapter<String>(getActivity(),layout,Ipsum.Headlines));
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getFragmentManager().findFragmentById(R.id.article)!=null){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback= (OnHeadlinesSelectedListner) activity;
        } catch (Exception e) {
           throw new ClassCastException(activity.toString()+" must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mCallback.onArticleSelected(position);
        getListView().setItemChecked(position,true);
    }
}
