package com.example.JiangHu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhibinxiao on 2017/2/5.
 */

public class Constant {
    public static String[] TAGS = {"homepage", "discover", "submit", "message", "profile"};
    public static String[] MissionTypes = new String[]{ "上课考试", "跑腿救急", "鹊桥交友", "求职面试", "游戏互动", "资源共享",
            "二手交易", "兼职代理" };
    public static String Status_standby = "0";
    public static String Status_doing = "1";
    public static String Status_done = "2";
    public static String Status_evaluate = "3";
    public static String [] StatusType = {Status_standby, Status_doing, Status_done};
    public static List<TaskItem> TaskFactory = new ArrayList<>();
    public static Map<Integer,PersonInfo> personMap = new HashMap<>();
    public static String NAME = "name";
    public static String ID ="id";
    public static String PRICE ="price";
    public static String CONTENT = "content";
    public static String CONTACTNUMBER = "contactNumber";

    public static String TYPE = "type";
    public static String STATUS = "Status";
    public static String USERID = "UserID";
    public static String TAKERUSERID = "TakerUserID";
    public static String TITLE = "title";

    public static int ADMIN = 100;

    static {
        personMap.put(ADMIN, createNewPerson("大美女", R.drawable.mask));
        personMap.put(personMap.size(), createNewPerson("小王", R.drawable.head_001));
        personMap.put(personMap.size(), createNewPerson("小李", R.drawable.head_002));
        personMap.put(personMap.size(), createNewPerson("小张", R.drawable.head_003));
        personMap.put(personMap.size(), createNewPerson("小赵", R.drawable.head_004));
        personMap.put(personMap.size(), createNewPerson("小明", R.drawable.head_005));
        personMap.put(personMap.size(), createNewPerson("小欣", R.drawable.head_006));

        //{ "上课考试", "跑腿救急", "鹊桥交友", "求职面试", "游戏互动", "资源共享", "二手交易", "兼职代理" };
        TaskFactory.add(createNewItem(0,1, "送泡面", "深夜12点女朋友饿了，寻5号楼女同学给308寝的xx送包泡面", "20", "0", 500, R.drawable.item_001));
        TaskFactory.add(createNewItem(1,1, "送伞", "女朋友聊天在上自习，寻A市B校同学去102自习室送一把伞", "20", "0", 1500, R.drawable.item_002));
        TaskFactory.add(createNewItem(2,1, "拉萨明信片\n", "相识纪念日，寻拉萨大学的同学给女朋友寄一张明信片到南京大学", "30", "0", 300, R.drawable.item_003));
        TaskFactory.add(createNewItem(3,1, "求床位", "下周有同学来北京玩，学校内寻求两个床位", "40", "2", 500, R.drawable.item_004));
        TaskFactory.add(createNewItem(4,5, "介绍校况", "高三学生，寻学长介绍一下学校情况", "30", "2", 2500, R.drawable.item_005));
        TaskFactory.add(createNewItem(5,5, "求导师信息", "跨城市考研，了解xx导师信息。", "200", "2", 1500, R.drawable.item_006));
        TaskFactory.add(createNewItem(2,7, "组织活动", "毕业10周年聚会，请一位同学帮忙联系学校组织活动。", "200", "2", 1500, R.drawable.item_007));
        TaskFactory.add(createNewItem(1,0, "补考试题", "上学期高数挂科了，马上补考，寻补考试题。", "100", "1", 200, R.drawable.item_008));
        TaskFactory.add(createNewItem(3,3, "面经", "明天华为二面，寻找一位拿到offer的同学，咨询面试技巧。", "100", "0", 300, R.drawable.item_009));
        TaskFactory.add(createNewItem(4,5, "求联系方式", "求外语系美女联系方式，打赏100元。", "100", "1", 500, R.drawable.item_010));
        TaskFactory.add(createNewItem(5,1, "求西藏拍照", "给女朋友惊喜，求西藏学友在布达拉宫旁边写字拍照", "200", "0", 600, R.drawable.item_011));
        TaskFactory.add(createNewItem(1,7, "求钢琴兼职", "侄子要学习钢琴，求介绍广州音乐学院钢琴专业兼职", "30", "1", 500, R.drawable.item_012));
        TaskFactory.add(createNewItem(2,1, "北京稻香村", "想吃稻香村点心，求北京同学买和邮寄，打赏五十元", "50", "2", 800, R.drawable.item_013));
        TaskFactory.add(createNewItem(3,7, "快闪", "2月14号想给女友惊喜，求十个人快闪，每人打赏五十元。", "50", "1", 200, R.drawable.item_014));
        TaskFactory.add(createNewItem(4,7, "聚活动", "家乐福开业，寻三十人参与，一小时20元。", "20", "2", 500, R.drawable.item_015));
        TaskFactory.add(createNewItem(5,1, "电脑维修", "电脑坏了急用，求维修。", "100", "2", 400, R.drawable.item_016));
        TaskFactory.add(createNewItem(0,7, "魔兽副本", "魔兽世界，求三人组队带刷副本。", "20", "1", 700, R.drawable.item_017));
        TaskFactory.add(createNewItem(1,1, "图书馆占座", "明天早上8.30，求图书馆占两位置，打赏十元。", "10", "0", 200, R.drawable.item_018));
        TaskFactory.add(createNewItem(2,0, "代上英语", "明天上午前两节英语课求同学代上", "10", "2", 500, R.drawable.item_019));
        TaskFactory.add(createNewItem(3,0, "英语四级答案", "求英语四级答案", "500", "2", 500, R.drawable.item_020));
        TaskFactory.add(createNewItem(4,0, "物理期末考题", "马上考试，求大学物理去年期末考题", "50", "2", 600, R.drawable.item_021));
        TaskFactory.add(createNewItem(5,1, "代取快递", "308寝室寻人长期代取快递", "1", "1", 100, R.drawable.item_022));
        TaskFactory.add(createNewItem(1,1, "带烟", "已经熄灯锁门，求一包香烟", "20", "0", 700, R.drawable.item_023));
        TaskFactory.add(createNewItem(2,1, "买演唱会门票", "明天下午寻一同学帮忙排队买演唱会门票", "50", "1", 800, R.drawable.item_024));
        TaskFactory.add(createNewItem(3,5, "借吉他", "哪位同学有吉他，借用三天", "30", "2", 300, R.drawable.item_025));
        TaskFactory.add(createNewItem(4,5, "借自行车", "借自行车一天", "10", "1", 400, R.drawable.item_026));
        TaskFactory.add(createNewItem(5,1, "代资料", "天下午有去深圳大学的同学吗？顺便帮忙代一份资料过去", "6", "2", 2500, R.drawable.item_027));

        TaskFactory.add(createNewItem(0,5, "江湖通缉令", "邀请五位同学下载江湖app，获取随机红包！", "3", "2", 0, R.drawable.item_028));
        TaskFactory.add(createNewItem(0,7, "华山论剑", "根据任务积分评选盟主，每个学校一个盟主！", "3", "2", 0, R.drawable.item_029));
        TaskFactory.add(createNewItem(0,7, "诚招江湖代理", "负责app推广，待遇面议！", "6", "3", 0, R.drawable.item_030));
        TaskFactory.add(createNewItem(0,4, "软文推广", "转发排名前1000位，获取小米手环！", "6", "3", 0, R.drawable.item_031));
        TaskFactory.add(createNewItem(0,4, "积少成多", "获取1000银两，可换取500m移动流量！", "6", "3", 0, R.drawable.item_032));

//        TaskFactory.get(0).setStatus("1");
//        TaskFactory.get(1).setStatus("1");
    }

    private static PersonInfo createNewPerson(String name, int imageID) {
        return new PersonInfo(name, personMap.size(), imageID);
    }


    public static TaskItem createNewItem(int userID, int type, String title, String info, String price, String access, int distance, int imageID) {
            TaskItem orderListItem1 = new TaskItem();
            orderListItem1.setId(TaskFactory.size());
            orderListItem1.setUserID(userID);
            orderListItem1.setType(type);
            orderListItem1.setTitle(title);
            orderListItem1.setContent(info);
            orderListItem1.setPayment(price + "元");
            orderListItem1.setStatus(Status_standby);
            orderListItem1.setBeginDate("2017-02-14 10:20");
            orderListItem1.setAcccessbility(access);
            orderListItem1.setDistance(distance);
            orderListItem1.setImageID(imageID);
            orderListItem1.setPhoneNumber("13818881666");
            return orderListItem1;
        }


}
