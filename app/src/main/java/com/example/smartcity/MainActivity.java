package com.example.smartcity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.smartcity.Fragment.AllFragment;
import com.example.smartcity.Fragment.HuanbaoFragment;
import com.example.smartcity.Fragment.IndexFragment;
import com.example.smartcity.Fragment.MyFragment;
import com.example.smartcity.Fragment.NewsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.indexPage)
    LinearLayout indexPage;
    @BindView(R.id.allPage)
    LinearLayout allPage;
    @BindView(R.id.huanbaoPage)
    LinearLayout huanbaoPage;
    @BindView(R.id.newsPage)
    LinearLayout newsPage;
    @BindView(R.id.myPage)
    LinearLayout myPage;
    @BindView(R.id.fragmentContent)
    LinearLayout fragmentContent;
    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fm = getFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContent,new IndexFragment());

        ft.commit();

    }

    @OnClick({R.id.indexPage, R.id.allPage, R.id.huanbaoPage, R.id.newsPage, R.id.myPage})
    public void onViewClicked(View view) {
        ft = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.indexPage:
                ft.replace(R.id.fragmentContent, new IndexFragment());
                break;
            case R.id.allPage:
                ft.replace(R.id.fragmentContent, new AllFragment());
                break;
            case R.id.huanbaoPage:
                ft.replace(R.id.fragmentContent, new HuanbaoFragment());
                break;
            case R.id.newsPage:
                ft.replace(R.id.fragmentContent, new NewsFragment());
                break;
            case R.id.myPage:
                ft.replace(R.id.fragmentContent, new MyFragment());
                break;
        }
        ft.commit();
    }
}