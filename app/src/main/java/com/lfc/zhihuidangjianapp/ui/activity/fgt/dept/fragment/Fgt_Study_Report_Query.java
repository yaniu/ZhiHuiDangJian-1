package com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hjq.toast.ToastUtils;
import com.lfc.zhihuidangjianapp.R;
import com.lfc.zhihuidangjianapp.app.MyApplication;
import com.lfc.zhihuidangjianapp.base.BaseFragment;
import com.lfc.zhihuidangjianapp.net.http.ApiConstant;
import com.lfc.zhihuidangjianapp.net.http.HttpService;
import com.lfc.zhihuidangjianapp.net.http.ResponseObserver;
import com.lfc.zhihuidangjianapp.net.http.RetrofitFactory;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act.Fgt_Weekend_Details;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act.ForestDetailActivity;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.bean.ChaXunBean_new;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.bean.PopBean;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.bean.QueryPopBean;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.bean.QueryPopRyBean;
import com.lfc.zhihuidangjianapp.ui.activity.model.Forest;
import com.lfc.zhihuidangjianapp.ui.activity.model.ResponseWorkReport;
import com.lfc.zhihuidangjianapp.ui.activity.model.StudyCraftReportList;
import com.lfc.zhihuidangjianapp.ui.activity.model.StudyStrongBureau;
import com.lfc.zhihuidangjianapp.ui.activity.model.WorkReport;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @date: 2019-08-10
 * @autror: guojian
 * @description: 心得查询
 */
public class Fgt_Study_Report_Query extends BaseFragment {
    @BindView(R.id.tv_dw_et)
    EditText tvDwEt;
    @BindView(R.id.tv_dw_lin)
    LinearLayout tvDwLin;
    @BindView(R.id.tv_zz_et)
    EditText tvZzEt;
    @BindView(R.id.tv_zz_lin)
    LinearLayout tvZzLin;
    @BindView(R.id.tv_zb_et)
    EditText tvZbEt;
    @BindView(R.id.tv_zb_lin)
    LinearLayout tvZbLin;
    @BindView(R.id.tv_ry_et)
    EditText tvRyEt;
    @BindView(R.id.tv_ry_lin)
    LinearLayout tvRyLin;
    @BindView(R.id.tv_quey)
    TextView tvQuey;
    @BindView(R.id.lin)
    LinearLayout lin;
    Unbinder unbinder;
    private int size = 10;
    private int num = 1;
    private PopupWindows_pop popupWindows_pop;
    private ListView listView;
    //  private RecyclerView recyclerView;
    private String deptNumberdw = "";//党委deptNumber
    private String deptNumberzz = "";//总支deptNumber
    private String deptNumberzb = "";//支部deptNumber
    private String deptNumberry = "";//人员deptNumber
    private  RecyclerView recyclerView;
    private PopupWindows_pop_sx popupWindows_pops_sx;
    SmartRefreshLayout mRefreshLayout;
    private boolean isData = true;
    List<StudyStrongBureau> datas_new = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.weekend_query;
    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected void initData() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tv_dw_et, R.id.tv_zz_et, R.id.tv_zb_et, R.id.tv_ry_et, R.id.tv_quey})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_dw_et:
                //type  1党委弹出  2总支弹出  3支部弹出  4人员弹出  5查询弹出
                getPoP(1);
                Log.i("YY",deptNumberdw +"==" + deptNumberzz +"=="+deptNumberzb +"==" +deptNumberry);
                break;
            case R.id.tv_zz_et:

                if (tvDwEt.getText().toString().trim().equals("")) {
                    ToastUtils.show("请选择党委");
                    return;
                }
                getPoP(2);
                Log.i("YY",deptNumberdw +"==" + deptNumberzz +"=="+deptNumberzb +"==" +deptNumberry);
                break;
            case R.id.tv_zb_et:
                if (tvZzEt.getText().toString().trim().equals("")) {
                    ToastUtils.show("请选择总支");
                    return;
                }
                getPoP(3);
                Log.i("YY",deptNumberdw +"==" + deptNumberzz +"=="+deptNumberzb +"==" +deptNumberry);
                break;
            case R.id.tv_ry_et:
                if (tvZbEt.getText().toString().trim().equals("")) {
                    ToastUtils.show("请选择支部");
                    return;
                }
                getPoP(4);
                Log.i("YY",deptNumberdw +"==" + deptNumberzz +"=="+deptNumberzb +"==" +deptNumberry);
                break;
            case R.id.tv_quey:
                if (tvDwEt.getText().toString().trim().equals("")) {
                    ToastUtils.show("请选择党委");
                    return;
                }
                if (tvZzEt.getText().toString().trim().equals("")) {
                    ToastUtils.show("请选择总支");
                    return;
                }
                if (tvZbEt.getText().toString().trim().equals("")) {
                    ToastUtils.show("请选择支部");
                    return;
                }
                Log.i("YY",deptNumberdw +"==" + deptNumberzz +"=="+deptNumberzb +"==" +deptNumberry);
                getPoP();

                break;
        }
    }
    //弹出底部窗口选择底部弹出刷新
    private void getPoP() {
        popupWindows_pops_sx = new PopupWindows_pop_sx(getActivity());
    }

    /**
     * 弹出popup 选择底部弹出刷新
     *
     * @author lijipei
     */
    public class PopupWindows_pop_sx extends PopupWindow {
        public PopupWindows_pop_sx(Context mContext) {
            View view = View.inflate(mContext, R.layout.item_pop_query_shuaxin, null);
            setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
            setBackgroundDrawable(new BitmapDrawable());
            // 设置SelectPicPopupWindow弹出窗体动画效果
            // this.setAnimationStyle(R.style.hh_window_share_anim);
            setFocusable(true);
            setOutsideTouchable(true);
            setContentView(view);
            showAtLocation(lin, Gravity.BOTTOM, 0, 0);
            View cView = view.findViewById(R.id.item_popupwindows_view);
            TextView quxiao = (TextView) view
                    .findViewById(R.id.item_pop_quxiao);
            TextView m_pop_text = (TextView) view
                    .findViewById(R.id.m_pop_text);
                m_pop_text.setText("查询结果");

            recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            mRefreshLayout = view.findViewById(R.id.refreshLayout);
            mRefreshLayout.setEnableRefresh(true);//是否启用下拉刷新功能
            mRefreshLayout.setEnableLoadMore(true);//是否启用上拉加载功能
            //内容跟随偏移
            mRefreshLayout.setEnableHeaderTranslationContent(true);
            //设置 Header 为 Material风格
            mRefreshLayout.setRefreshHeader(new MaterialHeader(getContext()).setShowBezierWave(false));
            //设置 Footer 为 普通样式
            mRefreshLayout.setRefreshFooter(new ClassicsFooter(getContext()).setSpinnerStyle(SpinnerStyle.Scale));
            //设置 Header 为 普通样式
            mRefreshLayout.setRefreshHeader(new ClassicsHeader(getContext()).setSpinnerStyle(SpinnerStyle.Scale));
            refresh();
            getDatas();

            cView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    dismiss();
                }
            });
            quxiao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    dismiss();
                }
            });


        }
    }
    private void refresh() {

        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {

                num = 1;
                getDatas();
                refreshlayout.finishRefresh(2000);

            }
        });
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                if (!isData) {
                    //                mDefineBAGLoadView.setFooterTextOrImage("没有更多数据", false);
                } else {
                    //                    mDefineBAGLoadView.setFooterTextOrImage("正在玩命加载中...", true);
                    num++;
                    getDatas();
                }
                refreshLayout.finishLoadMore(2000);
            }
        });

    }
    private void getDatas() {
        //查询周报信息
        getWeekQuery(deptNumberzb, deptNumberry);
    }
    //查询心得信息
    private void getWeekQuery(String deptNumberzb, String deptNumberry) {

        Map<String, Object> map = new HashMap<>();
        map.put("createCode", deptNumberry);
        map.put("deptNumber", deptNumberzb);
        map.put("pageSize", size);
        map.put("pageNumber", num);
        map.put("studyStrongBureauType",2);
        RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
                .queryStudyStrongBureauPageList(map, MyApplication.getLoginBean().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResponseObserver<StudyCraftReportList>(getActivity()) {
                    @Override
                    protected void onNext(StudyCraftReportList response) {
                        Log.e("onNext= ", response.toString());

                            if (response == null) return;
                            if (response.getStudyStrongBureauList().getDatas().size() == 0) {
                                toast("暂无数据");
                                popupWindows_pops_sx.dismiss();
                            } else {
                                // setRecyclerView_shaux(response.getWeeklyWorkReportList().getDatas());
                                List<StudyStrongBureau> datas = response.getStudyStrongBureauList().getDatas();
                                if (num == 1) {
                                    datas_new.clear();
                                }
                                if (datas.size() == 0) {
                                    if (num == 1 && datas_new.size() == 0) {
                                        isData = true;
                                        num--;
                                    } else {
                                        isData = false;
                                    }
                                } else {
                                    datas_new.addAll(datas);
                                    if (datas.size() < 8) {
                                        isData = false;
                                    } else {
                                        isData = true;
                                    }
                                    setRecyclerView_shaux(datas_new);
                                }

                        }

                    }

                    @Override
                    protected void onError(Throwable e) {
                        super.onError(e);
                        Log.e("Throwable= ", e.getMessage());
                    }
                }.actual());
    }

    private void setRecyclerView_shaux(List<StudyStrongBureau> datas) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new CommonAdapter<StudyStrongBureau>(getActivity(), R.layout.item_mine_work_report,datas) {
            @Override
            protected void convert(ViewHolder holder, StudyStrongBureau data, int position) {
                TextView tv_name = (TextView) holder.getConvertView().findViewById(R.id.tv_time);
                TextView tv_content = (TextView) holder.getConvertView().findViewById(R.id.tv_content);
                tv_name.setText(datas.get(position).getReleaseDate());
                tv_content.setText(datas.get(position).getAuthor());
                holder.getConvertView().setOnClickListener(detail->{
                    Intent intent = new Intent(getActivity(), com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.act.Act_Strong_Study_Experience.class);
                    intent.putExtra("studyStrongBureauId", data.getStudyStrongBureauId()+"");
                    intent.putExtra("appTitle","学习心得");
                    startActivity(intent);
                });
            }

        });
    }



    //弹出底部窗口
    private void getPoP(int type) {
         popupWindows_pop = new PopupWindows_pop(getActivity(), type);
    }

    /**
     * 弹出popup 选择底部弹出
     *
     * @author lijipei
     */
    public class PopupWindows_pop extends PopupWindow {
        public PopupWindows_pop(Context mContext,int type) {
            View view = View.inflate(mContext, R.layout.item_pop_query, null);
            setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
            setBackgroundDrawable(new BitmapDrawable());
            // 设置SelectPicPopupWindow弹出窗体动画效果
            // this.setAnimationStyle(R.style.hh_window_share_anim);
            setFocusable(true);
            setOutsideTouchable(true);
            setContentView(view);
            showAtLocation(lin, Gravity.BOTTOM, 0, 0);
            View cView = view.findViewById(R.id.item_popupwindows_view);
            TextView quxiao = (TextView) view
                    .findViewById(R.id.item_pop_quxiao);
            TextView m_pop_text = (TextView) view
                    .findViewById(R.id.m_pop_text);
            //设置头部标题
            if (type == 1) {
                m_pop_text.setText("选择党委");
            } else if (type == 2) {
                m_pop_text.setText("选择总支");
            } else if (type == 3) {
                m_pop_text.setText("选择支部");
            } else if (type == 4) {
                m_pop_text.setText("选择人员");
            } else {
                m_pop_text.setText("查询结果");

            }
            listView = (ListView) view.findViewById(R.id.item_pop_list);
            //设置数据
            getData(type);
            cView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    dismiss();
                }
            });
            quxiao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    dismiss();
                }
            });


        }
    }

    //设置数据
    private void getData(final int type) {
        if (type == 1) {
            ArrayList<PopBean> list1 = new ArrayList<>();
            PopBean phBean1 = new PopBean("DT000001", "中共山西省中条山国有林管理局委员会");
            list1.add(phBean1);
            getSetPop(list1, type);
        } else if (type == 2) {
            List<PopBean> list = new ArrayList<>();
            Map<String, Object> map = new HashMap<>();
            map.put("deptNumber", deptNumberdw);
            RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
                    .getQuery(map, MyApplication.getLoginBean().getToken())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new ResponseObserver<QueryPopBean>(getActivity()) {
                        @Override
                        protected void onNext(QueryPopBean response) {
                            Log.e("onNext= ", response.toString());
                            if (response == null) return;
                            List<QueryPopBean.DeptListBean> deptList = response.getDeptList();
                            if (deptList.size() != 0) {
                                for (int i = 0; i < deptList.size(); i++) {
                                    PopBean phBean1 = new PopBean(deptList.get(i).getDeptNumber(), deptList.get(i).getAbbreviation());
                                    list.add(phBean1);
                                }
                                getSetPop(list, type);
                            }else{
                                toast("暂无权限");
                                popupWindows_pop.dismiss();
                            }
                        }

                        @Override
                        protected void onError(Throwable e) {
                            super.onError(e);
                            Log.e("Throwable= ", e.getMessage());
                        }
                    }.actual());
        } else if (type == 3) {
            List<PopBean> list = new ArrayList<>();
            Map<String, Object> map = new HashMap<>();
            map.put("deptNumber", deptNumberzz);
            RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
                    .getQuery(map, MyApplication.getLoginBean().getToken())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new ResponseObserver<QueryPopBean>(getActivity()) {
                        @Override
                        protected void onNext(QueryPopBean response) {
                            Log.e("onNext= ", response.toString());
                            if (response == null) return;
                            List<QueryPopBean.DeptListBean> deptList = response.getDeptList();
                            if (deptList.size() != 0) {
                                for (int i = 0; i < deptList.size(); i++) {
                                    PopBean phBean1 = new PopBean(deptList.get(i).getDeptNumber(), deptList.get(i).getAbbreviation());
                                    list.add(phBean1);
                                }
                                getSetPop(list, type);
                            }else{
                                toast("暂无权限");
                                popupWindows_pop.dismiss();
                            }
                        }

                        @Override
                        protected void onError(Throwable e) {
                            super.onError(e);
                            Log.e("Throwable= ", e.getMessage());
                        }
                    }.actual());
        } else if (type == 4) {
            List<PopBean> list = new ArrayList<>();
            Map<String, Object> map = new HashMap<>();
            map.put("deptNumber", deptNumberzb);
            RetrofitFactory.getDefaultRetrofit().create(HttpService.class)
                    .getQueryRy(map, MyApplication.getLoginBean().getToken())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new ResponseObserver<QueryPopRyBean>(getActivity()) {

                        @Override
                        protected void onNext(QueryPopRyBean response) {
                            Log.e("onNext= ", response.toString());
                            if (response == null) return;
                            List<QueryPopRyBean.UserlistBean> deptList = response.getUserlist();
                            if (deptList.size() != 0) {
                                for (int i = 0; i < deptList.size(); i++) {
                                    PopBean phBean1 = new PopBean(deptList.get(i).getLoginName(), deptList.get(i).getSealName());
                                    list.add(phBean1);
                                }
                                getSetPop(list, type);
                            }else{
                                toast("暂无权限");
                                popupWindows_pop.dismiss();
                            }
                        }

                        @Override
                        protected void onError(Throwable e) {
                            super.onError(e);
                            Log.e("Throwable= ", e.getMessage());
                        }
                    }.actual());
        } else {
            //查询周报信息
            getWeekQuery(deptNumberzb, deptNumberry);
        }
    }


    private void getSetPop(final List<PopBean> data, int type) {
        final MyAdapter adapter = new MyAdapter(data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String balance = data.get(position).getName() + "";
                if (type == 1) {
                    tvDwEt.setText(balance);
                    deptNumberdw = data.get(position).getId();
                } else if (type == 2) {
                    tvZzEt.setText(balance);
                    deptNumberzz = data.get(position).getId();
                } else if (type == 3) {
                    tvZbEt.setText(balance);
                    deptNumberzb = data.get(position).getId();
                } else if (type == 4) {
                    tvRyEt.setText(balance);
                    deptNumberry = data.get(position).getId();
                }
                popupWindows_pop.dismiss();
            }
        });
    }

    //适配器（党委  总支  支部  人员）
    public class MyAdapter extends BaseAdapter {
        private List<PopBean> stuList;
        private LayoutInflater inflater;
        public MyAdapter(List<PopBean> stuList) {
            this.stuList = stuList;
            this.inflater = LayoutInflater.from(getActivity());
        }

        @Override
        public int getCount() {
            return stuList == null ? 0 : stuList.size();
        }

        @Override
        public PopBean getItem(int position) {
            return stuList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //加载布局为一个视图
            View view = inflater.inflate(R.layout.item_pop_text, null);
            TextView tv_name = (TextView) view.findViewById(R.id.text_mm);
            tv_name.setText(stuList.get(position).getName());
            return view;
        }
    }

}
