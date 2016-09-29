package com.cyh.fragmentstudy;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity implements HeadlinesFragment.OnHeadlinesSelectedListner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);
//        检查碎片是否存在
        if (findViewById(R.id.fragment_container)!=null){
//            恢复状态，不需要做任何动作
            if (savedInstanceState!=null){
                return;
            }
        }

        HeadlinesFragment firstFragment=new HeadlinesFragment();
        firstFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,firstFragment).commit();

    }

    public void onArticleSelected(int position) {
        ArticleFragment articleFragment= (ArticleFragment) getSupportFragmentManager().findFragmentById(R.id.article_fragment);
        if (articleFragment!=null){
            articleFragment.updateArticleView(position);
        }else {
            ArticleFragment newFragment=new ArticleFragment();
            Bundle args=new Bundle();
            args.putInt(ArticleFragment.ARG_POSITION,position);
            newFragment.setArguments(args);
            FragmentTransaction trans=getSupportFragmentManager().beginTransaction();
            trans.replace(R.id.fragment_container,newFragment);
            trans.addToBackStack(null);
            trans.commit();
        }

    }
}
