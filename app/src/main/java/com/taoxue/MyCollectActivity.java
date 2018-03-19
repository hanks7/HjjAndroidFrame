package com.taoxue;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;

import com.taoxue.adapter.MyCollectAdapter;
import com.taoxue.base.BaseActivity;
import com.taoxue.bean.QryMyCollectionBean;
import com.taoxue.http.HttpAdapter;
import com.taoxue.umeng.base.BaseMyAdapter;
import com.taoxue.umeng.http.OnResponseNoDialogListener2;
import com.taoxue.umeng.model.BasePageModel;
import com.taoxue.umeng.model.PageModel;
import com.taoxue.umeng.view.refresh.ListRefeshMoreView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyCollectActivity extends BaseActivity {
    @BindView(R.id.ListRefeshMoreView)
    ListRefeshMoreView mListRefeshMoreView;

    private ArrayList<QryMyCollectionBean> list;
    private BaseMyAdapter adapter;
    private OnResponseNoDialogListener2<BasePageModel<QryMyCollectionBean>> responseNoDialogListener;


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
        final BasePageModel<QryMyCollectionBean> pageModel2 = new BasePageModel<>();
        PageModel<QryMyCollectionBean> model = new PageModel<>();
        ArrayList<QryMyCollectionBean> list = new ArrayList<>();
        model.setHasNext(true);
        list.add(getBean());
        list.add(getBean());
        list.add(getBean());
        list.add(getBean());
        list.add(getBean());
        list.add(getBean());
        list.add(getBean());
        list.add(getBean());
        model.setResult(list);

        pageModel2.setPage(model);


        responseNoDialogListener = new OnResponseNoDialogListener2<BasePageModel<QryMyCollectionBean>>() {
            @Override
            protected void onSuccess(BasePageModel<QryMyCollectionBean> pageModel) {
                //延迟两秒跳转
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mListRefeshMoreView.onSuccess(pageModel2);
                    }
                },2000);

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
     *
     * collection_num : 2
     * description : 内向性格研究领域的专家马蒂·奥尔森·兰妮博士（Marti Olsen Laney, Psy.D.）继《内向者优势》后的又一力作。她将多年的临川研究经验与自己身为一个内向者的成长经历作为蓝本，为我们总结出了培养好一个内向性格孩子的种种建议。书中更是用不少篇幅向我们解释了内向、外向这两种不同的性格气质形成的原因，科学生动、简明易懂，十分值得一听。
     * resource_id : 402883d2615a382c01615a7c8dbe0158
     * resource_name : 樊登读书会-内向还在的潜在优势
     * resource_picture : http://117.71.57.47:11000/manager/upload/402883d2615a3aff01615a7c64ab0001.jpg
     * visit_num : 32
     */
    private QryMyCollectionBean getBean() {
        QryMyCollectionBean bean = new QryMyCollectionBean();
        bean.setCollection_num(2);
        bean.setDescription("内向性格研究领域的专家马蒂·奥尔森·兰妮博士（Marti Olsen Laney, Psy.D.）继《内向者优势》后的又一力作。她将多年的临川");
        bean.setRead_num("2");
        bean.setResource_id("402883d2615a382c01615a7c8dbe0158");
        bean.setVisit_num(2);
        bean.setResource_name("樊登读书会-内向还在的潜在优势");
        bean.setResource_picture("http://img1.utuku.china.com/640x0/news/20180319/5d21a324-0c94-4e7b-a33a-2c60e6b04743.jpg");
        return bean;
    }


    /**
     * 获得收藏列表(刷新)
     */
    private void netWork(int page) {
        HttpAdapter.getService().collection3(page).enqueue(responseNoDialogListener);
    }


}
