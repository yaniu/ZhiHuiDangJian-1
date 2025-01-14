package com.lfc.zhihuidangjianapp.net.http;

import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.bean.ChaXunBean_new;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.bean.ChangeBean;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.bean.MianDeptBeanD;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.bean.MonthBean;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.bean.MonthDetailsBean;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.bean.QueryPopBean;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.bean.QueryPopRyBean;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.bean.WeekendDetailsBean;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.dept.bean.queryUserListByFirstPinYinBean;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.bean.AnnouncementBean;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.home.act.bean.ZtBean;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.personal.act.bean.MyInteagalBeabMingXI;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.personal.act.bean.MyIntegalBean;
import com.lfc.zhihuidangjianapp.ui.activity.fgt.personal.act.bean.QueryDepMemberBean;
import com.lfc.zhihuidangjianapp.ui.activity.model.AliPay;
import com.lfc.zhihuidangjianapp.ui.activity.model.AppConfigLists;
import com.lfc.zhihuidangjianapp.ui.activity.model.BaseResponse;
import com.lfc.zhihuidangjianapp.ui.activity.model.Dept;
import com.lfc.zhihuidangjianapp.ui.activity.model.DeptDetail;
import com.lfc.zhihuidangjianapp.ui.activity.model.Depts;
import com.lfc.zhihuidangjianapp.ui.activity.model.DynamicDetail;
import com.lfc.zhihuidangjianapp.ui.activity.model.ForestDistrict;
import com.lfc.zhihuidangjianapp.ui.activity.model.FriendList;
import com.lfc.zhihuidangjianapp.ui.activity.model.HomeHeadLines;
import com.lfc.zhihuidangjianapp.ui.activity.model.JoinPartyStage;
import com.lfc.zhihuidangjianapp.ui.activity.model.MailList;
import com.lfc.zhihuidangjianapp.ui.activity.model.OrganizationalLifeDetail;
import com.lfc.zhihuidangjianapp.ui.activity.model.PartyOrganiza;
import com.lfc.zhihuidangjianapp.ui.activity.model.Payment;
import com.lfc.zhihuidangjianapp.ui.activity.model.ResponseForestDetail;
import com.lfc.zhihuidangjianapp.ui.activity.model.ResponseMeetingMine;
import com.lfc.zhihuidangjianapp.ui.activity.model.ResponseOrganizationalLife;
import com.lfc.zhihuidangjianapp.ui.activity.model.ResponsePartyDynamicList;
import com.lfc.zhihuidangjianapp.ui.activity.model.ResponsePartyPayment;
import com.lfc.zhihuidangjianapp.ui.activity.model.ResponseStudyStrong;
import com.lfc.zhihuidangjianapp.ui.activity.model.ResponseWorkReport;
import com.lfc.zhihuidangjianapp.ui.activity.model.StudyCraftReportList;
import com.lfc.zhihuidangjianapp.ui.activity.model.StudyCraftTrainingList;
import com.lfc.zhihuidangjianapp.ui.activity.model.StudyStrongBureauDetail;
import com.lfc.zhihuidangjianapp.ui.activity.model.UserInfo;
import com.lfc.zhihuidangjianapp.ui.activity.model.WechatPay;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface HttpService {
    @POST(ApiConstant.LOGIN)
    Observable<String> LOGIN(@QueryMap Map<String, String> map);

    @GET(ApiConstant.queryHomeNoticeAnnouncementPageList)
    Observable<String> queryHomeNoticeAnnouncementPageList(@Header("token") String token);

    @POST(ApiConstant.queryAppConfigList)
    Observable<BaseResponse<AppConfigLists>> queryAppConfigList(@Header("token") String token);

    @POST(ApiConstant.queryNoticeAnnouncementDetail)
    Observable<String> queryNoticeAnnouncementDetail(@QueryMap Map<String, String> map, @Header("token") String token);

    @POST(ApiConstant.queryLeadDemonstrationPageList)
    Observable<String> queryLeadDemonstrationPageList(@QueryMap Map<String, String> map, @Header("token") String token);

    @POST(ApiConstant.queryMyPartyPaymentHisPageList)
    Observable<String> queryMyPartyPaymentHisPageList(@QueryMap Map<String, String> map, @Header("token") String token);

    @POST(ApiConstant.queryJoinPartyStageDeatil)
    Observable<String> queryJoinPartyStageDeatil(@Header("token") String token);


    @POST(ApiConstant.queryPartyPaymentHisPageList)
    Observable<String> queryPartyPaymentHisPageList(@QueryMap Map<String, String> map, @Header("token") String token);

    /**
     * app-Banner
     *
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.queryAppConfigList)
    Observable<BaseResponse<AppConfigLists>> queryAppConfigList(@QueryMap Map<String, String> map, @Header("token") String token);

    /**
     * 党建矩阵
     *
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryDeptList")
    Observable<BaseResponse<Depts>> queryDeptList(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 党支部详情
     *
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryDeptDetail")
    Observable<BaseResponse<DeptDetail>> queryDeptDetail(@QueryMap Map<String, Object> map, @Header("token") String token);
       /**
     * 党支部详情--党委成员
     *
     * @param map
     * @param token
     * @return
     */
    @POST("/sysDept/queryDeptMember")
    Observable<BaseResponse<QueryDepMemberBean>> queryDeptMember(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 分页查询党建动态信息
     *
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryPartyDynamicPageList")
    Observable<BaseResponse<ResponsePartyDynamicList>> queryPartyDynamicPageList(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 党建动态详情
     *
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryPartyDynamicDetail")
    Observable<BaseResponse<DynamicDetail>> queryPartyDynamicDetail(@QueryMap Map<String, Object> map, @Header("token") String token);
    /**
     * 首页进来党建动态详情
     *
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryExamineDetail")
    Observable<BaseResponse<MianDeptBeanD>> queryExamineDetail(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 学习强局首页
     *
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryStudyStrongBureauVideoPageList")
    Observable<BaseResponse<ResponseStudyStrong>> queryStudyStrongBureauVideoPageList(@Header("token") String token);

    /**
     * 学习心得详情
     *
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryStudyStrongBureauDetail")
    Observable<BaseResponse<StudyStrongBureauDetail>> queryStudyStrongBureauDetail(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 分页查询工匠培养-林草咨询(学习心得传studyStrongBureauType=1)
     *
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryStudyStrongBureauConsultationPageList")
    Observable<BaseResponse<StudyCraftTrainingList>> queryStudyStrongBureauConsultationPageList(@QueryMap Map<String, Object> map,@Header("token") String token);

    /**
     * 分页查询工匠培养-林业技能培养
     *
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryStudyStrongBureauCraftsmanPageList")
    Observable<BaseResponse<StudyCraftTrainingList>> queryStudyStrongBureauCraftsmanPageList(@QueryMap Map<String, Object> map,@Header("token") String token);

    /**
     * 微信支付订单
     *
     *
     * @param token
     * @return
     */
    @POST("weiXin2Pay/wxPayToApp")
    Observable<BaseResponse<WechatPay>> wxPayToApp(@QueryMap Map<String, Object> map,@Header("token") String token);

    /**
     * 支付宝订单
     *
     *
     * @param token
     * @return
     */
    @POST("alipay/alipayToApp")
    Observable<BaseResponse<AliPay>> alipayToApp(@QueryMap Map<String, Object> map,@Header("token") String token);

    /**
     * 党员信息
     *
     * @param token
     * @return
     */
    @POST(ApiConstant.queryJoinPartyStageDeatil)
    Observable<BaseResponse<UserInfo>> queryJoinPartyInfo(@Header("token") String token);

    /**
     * 通讯录
     *
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryDeptListToAddressBook")
    Observable<BaseResponse<MailList>> queryDeptListToAddressBook(@Header("token") String token);

    /**
     * 好友列表
     *
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryUserListByFirstPinYin")
    Observable<BaseResponse<FriendList>> queryUserListByFirstPinYin(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 新增党组织关系转移信息
     *
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/insertTransferOrganizationalRelations")
    Observable<BaseResponse<Object>> insertTransferOrganizationalRelations(@QueryMap Map<String, Object> map, @Header("token") String token);
    /**
     * 修改党组织关系转移信息
     *
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/updateTransfer")
    Observable<BaseResponse<Object>> updateTransfer(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 查看党组织关系转移详情信息
     *
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryTransferOrganizationalRelationsDetail")
    Observable<BaseResponse<Object>> queryTransferOrganizationalRelationsDetail(@Header("token") String token);

    /**
     * 是否转移党组织
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryMyTransferOrganizationalRelationsDetail")
    Observable<BaseResponse<ChangeBean>> queryMyTransferOrganizationalRelationsDetail(@Header("token") String token);

    /**
     * 我的党费（待缴党费信息+党费缴纳列表）
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryMyPartyPaymentHisPageList")
    Observable<BaseResponse<ResponsePartyPayment>> queryMyPartyPaymentHisPageList(@Header("token") String token);

    /**
     * 分页查询林区风采信息-通过forestDistrictType林区风采类型(0:先进基层党组织1:优秀共产党员2:优秀党务工作者3:优秀党建联络员)
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryForestDistrictPageList")
    Observable<BaseResponse<ForestDistrict>> queryForestDistrictPageList(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 分页查询林区风采信息-通过forestDistrictType林区风采类型(0:先进基层党组织1:优秀共产党员2:优秀党务工作者3:优秀党建联络员)
     * new 新接口
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryForestShowPageList")
    Observable<BaseResponse<ForestDistrict>> queryForestShowPageList(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 分页查询组织生活信息
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryOrganizationalLifePageList")
    Observable<BaseResponse<ResponseOrganizationalLife>> queryOrganizationalLifePageList(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 查看组织生活详情信息
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryOrganizationalLifeDetail")
    Observable<BaseResponse<OrganizationalLifeDetail>> queryOrganizationalLifeDetail(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 新增周报
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/insertWeeklyWorkReport")
    Observable<BaseResponse<Object>> insertWeeklyWorkReport(@QueryMap Map<String, Object> map,@Header("token") String token);

    /**
     * 分页查询精选周报信息
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryWeeklyWorkReportTopPageList")
    Observable<BaseResponse<Object>> queryWeeklyWorkReportTopPageList(@Header("token") String token);

    /**
     * 分页查询我的周报信息
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryMyWeeklyWorkReportPageList")
    Observable<BaseResponse<ResponseWorkReport>> queryMyWeeklyWorkReportPageList(@QueryMap Map<String, Object> map,@Header("token") String token);
    /**
     * 分页查询周报信息
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryWeeklyWorkReportPageList")
    Observable<BaseResponse<ResponseWorkReport>> queryWeeklyWorkReportPageList(@QueryMap Map<String, Object> map,@Header("token") String token);

    /**
     * 分页查询周报信息
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryWeeklyWorkReportPageList")
    Observable<BaseResponse<ChaXunBean_new>> queryWeeklyWorkReportPageList_new(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 分页查询学习强局信息 -- 学习心得传studyStrongBureauType=2
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryStudyStrongBureauPageList")
    Observable<BaseResponse<StudyCraftReportList>> queryStudyStrongBureauPageList(@QueryMap Map<String, Object> map, @Header("token") String token);
    /**
     * 分页查询学习强局信息 -- 我的学习心得传studyStrongBureauType=2
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryMyStudyStrongBureauPageList")
    Observable<BaseResponse<StudyCraftReportList>> queryMyStudyStrongBureauPageList(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 新增学习强局信息
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/insertStudyStrongBureau")
    Observable<BaseResponse<Object>> insertStudyStrongBureau(@QueryMap Map<String, Object> map,@Header("token") String token);
    /**
     * 修改学习强局信息--学习心得
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/updateStudyStrongBureauApp")
    Observable<BaseResponse<Object>> updateStudyStrongBureauApp(@QueryMap Map<String, Object> map,@Header("token") String token);

    /**
     * 分页查询精选周报信息
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryWeeklyWorkReportTopPageList")
    Observable<BaseResponse<Object>> queryWeeklyWorkReportTopPageList(@QueryMap Map<String, Object> map,@Header("token") String token);

    /**
     * 公告列表
     * @param token
     * @return
     */
    @POST(ApiConstant.queryNoticeAnnouncementPageList)
    Observable<String> queryNoticeAnnouncementPageList(@Header("token") String token);

    /**
     * 根据用户ID查询用户信息
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryUserByUserId")
    Observable<BaseResponse<UserInfo>> queryUserByUserId(@QueryMap Map<String, Object> map,@Header("token") String token);

    /**
     * 新增会议信息
     * @param token
     * @return
     */
    @POST(ApiConstant.MEETING + "/insertMeeting")
    Observable<BaseResponse<UserInfo>> insertMeeting(@QueryMap Map<String, Object> map,@Header("token") String token);

    /**
     * 我的会议信息
     * @param token
     * @return
     */
    @POST(ApiConstant.MEETING + "/queryMyMeetingPageList")
    Observable<BaseResponse<ResponseMeetingMine>> queryMyMeetingPageList(@Header("token") String token);

    /**
     * 会议列表信息
     * @param token
     * @return
     */
    @POST(ApiConstant.MEETING + "/queryMeetingPageList")
    Observable<BaseResponse<ResponseMeetingMine>> queryMeetingPageList( @Header("token") String token);

    /**
     * 历史会议列表信息
     * @param token
     * @return
     */
    @POST(ApiConstant.MEETING + "/queryMeetingHisPageList")
    Observable<BaseResponse<ResponseMeetingMine>> queryMeetingHisPageList( @Header("token") String token);

    /**
     * 创建会议上报
     * @param token
     * @return
     */
    @POST(ApiConstant.HUANXIN + "/createChatroom")
    Observable<BaseResponse<Object>> createChatroom(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     *  首页-头条-党务资讯
     * @param token
     * @return
     */
    @GET(ApiConstant.API + "/queryHomeHeadLinesList")
    Observable<BaseResponse<HomeHeadLines>> queryHomeHeadLinesList(@Header("token") String token);

    /**
     * 查看林区风采详情信息
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryForestDistrictDetail")
    Observable<BaseResponse<ResponseForestDetail>> queryForestDistrictDetail(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 查询党费缴费记录信息-我的组织
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryMyPartyPaymentHis")
    Observable<BaseResponse<Payment>> queryMyPartyPaymentHis(@Header("token") String token);

    /**
     * 新增发展党员信息
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/insertJoinPartyStage")
    Observable<BaseResponse<Object>> insertJoinPartyStage(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 查询发展党员信息
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryJoinPartyStageDeatil")
    Observable<BaseResponse<JoinPartyStage>> queryDevelopPartyDeatil(@Header("token") String token);

    /**
     * 更新发展党员信息
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/updateJoinPartyStage")
    Observable<BaseResponse<Object>> updateJoinPartyStage(@QueryMap Map<String, Object> map,@Header("token") String token);

    /**
     * 修改密码
     * @param token
     * @return
     */
    @POST("login/updatePwd")
    Observable<BaseResponse<Object>> updatePwd(@QueryMap Map<String, Object> map,@Header("token") String token);

    /**
     * 支部一级一级查询有权限
     *
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryDeptListByLevel")
    Observable<BaseResponse<QueryPopBean>> getQuery(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 支部一级一级查询无权限
     *
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryDeptListByLevelNoPromise")
    Observable<BaseResponse<QueryPopBean>> queryDeptListByLevelNoPromise(@QueryMap Map<String, Object> map, @Header("token") String token);
    /**
     * 支部一级一级人员查询
     *
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryDeptListByLevel")
    Observable<BaseResponse<QueryPopRyBean>> getQueryRy(@QueryMap Map<String, Object> map, @Header("token") String token);
    /**
     * 查看周报详情信息
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryWeeklyWorkReportDetail")
    Observable<BaseResponse<WeekendDetailsBean>> queryWeeklyWorkReportDetail(@QueryMap Map<String, Object> map, @Header("token") String token);
    /**
     * 退出登录
     * @param token
     * @return
     */
    @POST("/login/logout")
    Observable<BaseResponse<Object>> logout(@Header("token") String token);
   /**
     * 分页查询我的积分
     * @param token
     * @return
     */
    @POST( "/integralManagement/queryMyTotal")
    Observable<BaseResponse<MyIntegalBean>> queryMyTotal( @Header("token") String token);
    /**
     * 分页查询我的积分明细
     * @param token
     * @return
     */
    @POST("/integralManagement/queryMyIntegralDetailPageList")
    Observable<BaseResponse<MyInteagalBeabMingXI>> queryMyIntegralDetailPageList(@QueryMap Map<String, Object> map, @Header("token") String token);

    /**
     * 周报查询党支部
     *
     * @param map
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryDeptDetail")
    Observable<BaseResponse<QueryPopBean>> queryDeptDetail_Q(@QueryMap Map<String, Object> map, @Header("token") String token);

    //专题--列表
    @POST("appApi/queryLeadDemonstrationPageList")
    Observable<BaseResponse<ZtBean>> queryLeadDemonstrationPageList_new(@QueryMap Map<String, String> map, @Header("token") String token);
    /**
     * 公告列表
     * @param token
     * @return
     */
    @POST("appApi/queryNoticeAnnouncementPageList")
    Observable<BaseResponse<AnnouncementBean>> queryNoticeAnnouncementPageList_new(@QueryMap Map<String, String> map, @Header("token") String token);
    /**
     * 分页查询我的月报信息
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryMonthWorkReportPageList")
    Observable<BaseResponse<MonthBean>> queryMonthWorkReportPageList( @Header("token") String token);
    /**
     * 查看月报详情信息
     * @param token
     * @return
     */
    @POST(ApiConstant.API + "/queryMonthWorkReportDetail")
    Observable<BaseResponse<MonthDetailsBean>> queryMonthWorkReportDetail(@QueryMap Map<String, Object> map, @Header("token") String token);
}