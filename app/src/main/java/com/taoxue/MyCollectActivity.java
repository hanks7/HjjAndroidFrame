package com.taoxue;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.taoxue.adapter.MyCollectAdapter;
import com.taoxue.base.BaseActivity;
import com.taoxue.bean.QryMyCollectionBean;
import com.taoxue.http.HttpAdapter;
import com.taoxue.umeng.base.BaseMyAdapter;
import com.taoxue.umeng.http.OnResponseNoDialogListener;
import com.taoxue.umeng.model.BasePageModel;
import com.taoxue.umeng.view.refresh.ListRefeshMoreView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyCollectActivity extends BaseActivity {
    @BindView(R.id.ListRefeshMoreView)
    ListRefeshMoreView mListRefeshMoreView;

    private ArrayList<QryMyCollectionBean> list;
    private BaseMyAdapter adapter;
    private OnResponseNoDialogListener<BasePageModel<QryMyCollectionBean>> responseNoDialogListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collect);
        ButterKnife.bind(this);
        init();
    }


    private void init() {
        list = new ArrayList<>();
        adapter = new MyCollectAdapter(this, list);

        responseNoDialogListener = new OnResponseNoDialogListener<BasePageModel<QryMyCollectionBean>>() {
            @Override
            protected void onSuccess(BasePageModel<QryMyCollectionBean> pageModel) {
                mListRefeshMoreView.onSuccess(pageModel);
            }

            @Override
            protected void onFailure() {
                mListRefeshMoreView.onFailure();
            }

        };
        mListRefeshMoreView.initListView(adapter, new ListRefeshMoreView.NetworkInterface() {
            @Override
            public void http(int page) {
                netWork(page);
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }

        });


    }


    /**
     * 获得收藏列表(刷新)
     */
    private void netWork(int page) {
        HttpAdapter.getService().collection3(page).enqueue(responseNoDialogListener);


    }


}
