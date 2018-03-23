package com.taoxue.umeng.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.taoxue.umeng.R;
import com.taoxue.umeng.base.HjjActivity;

/**
 * Created by CC on 2016/6/5.
 */

public class TopBar extends RelativeLayout {

    ImageView backButton;

    TextView topTitle;

    ImageView btnTopRight;

    TextView tvTopRight;

    public TopBar(Context context) {
        this(context, null);
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context,attrs);
        init(context, attrs);
    }


    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);

    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_toolbar, this);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.search_view);
        backButton = (ImageView)view.findViewById(R.id.btn_back);
        topTitle = (TextView)view.findViewById(R.id.tv_topTitle);
        btnTopRight = (ImageView)view.findViewById(R.id.btn_top_right);
        tvTopRight = (TextView)view.findViewById(R.id.tv_top_right);
        backButton.setVisibility(array.getBoolean(R.styleable.search_view_is_has_back, true) ? VISIBLE : GONE);
        topTitle.setText(array.getString(R.styleable.search_view_title));
        btnTopRight.setImageDrawable(array.getDrawable(R.styleable.search_view_right_iv));
        tvTopRight.setText(array.getString(R.styleable.search_view_bar_right_tv));
        setOnTranslucent(array.getBoolean(R.styleable.search_view_is_chengjin, true));
        backButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getContext() instanceof HjjActivity)
                    ((HjjActivity) getContext()).onBackPressed();
            }
        });
    }

    public void setTitle(@StringRes int resId) {
        if (topTitle != null)
            topTitle.setText(getResources().getString(resId));
    }

    public void setTitle(CharSequence title) {
        if (topTitle != null) {
            topTitle.setText(title.toString());
        }
    }

    /**
     * 设置右边图片
     *
     * @param resId
     */
    public void setBtnTopRightIcon(@DrawableRes int resId) {
        btnTopRight.setImageResource(resId);
    }

    /**
     * 右边图片按钮点击事件
     *
     * @param clickListener
     */
    public void setBtnTopRightClickListener(OnClickListener clickListener) {
        btnTopRight.setVisibility(VISIBLE);
        btnTopRight.setOnClickListener(clickListener);
    }

    /**
     * 右边文字按钮点击事件
     *
     * @param str
     * @param clickListener
     */
    public void setTvTopRightIcon(String str, OnClickListener clickListener) {
        tvTopRight.setText(str);
        tvTopRight.setVisibility(VISIBLE);
        tvTopRight.setOnClickListener(clickListener);
    }


    /**
     * 返回按钮监听
     *
     * @param onClickListener
     */
    public void setBackButtonListener(OnClickListener onClickListener) {
        backButton.setOnClickListener(onClickListener);
    }


    /**
     * 设置是否需要渐变
     */
    public void setNeedTranslucent(int transAlpha) {
        setBackgroundColor(getContext().getResources().getColor(R.color.colorPrimary));
        getBackground().setAlpha(transAlpha);
    }

    /**
     * 启用 透明状态栏(重写此方法可以取消透明)
     */
    protected void setOnTranslucent(boolean translucent) {
        if (translucent && getContext() instanceof HjjActivity && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int resourceId = getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
            setPadding(0, getContext().getResources().getDimensionPixelSize(resourceId), 0, 0);
        }
    }

}
