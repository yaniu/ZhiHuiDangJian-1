package com.lfc.zhihuidangjianapp.ui.activity.model;

import java.util.List;

/**
 * @date: 2019-08-03
 * @autror: guojian
 * @description:
 */
public class DeptDetail {

    private Dept dept;
    private List<DeptDetailUser> userlist;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public List<DeptDetailUser> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<DeptDetailUser> userlist) {
        this.userlist = userlist;
    }
}
