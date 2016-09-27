package utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 工具类
 * Created by CYH on 2016/9/27.
 */
public class StatusTracker {
    private Map<String,String> mStatusMap;
    private List<String> mMethodList;
    private static StatusTracker ourInstance=new StatusTracker();
    private static final String STATUS_SUFFIX="ed";

//  单例模式
    public static StatusTracker getInstance(){
        return ourInstance;
    }
    public StatusTracker(){
        mStatusMap=new LinkedHashMap<>();
        mMethodList=new ArrayList<>();
    }

    public List<String> getMethodList(){
        return mMethodList;
    }

    public void clear(){
        mMethodList.clear();
        mStatusMap.clear();
    }

//    添加状态值
    public void setStatus(String activityName,String status){
        mMethodList.add(activityName+"-"+status+"()");
        if (mStatusMap.containsKey(activityName)) mStatusMap.remove(activityName);
        mStatusMap.put(activityName,status);
    }
// 获得给定的状态值
    public String getStatus(String activityName){
        String status=mStatusMap.get(activityName);
        status=status.substring(2,status.length());
        if (status.endsWith("e")){
            status=status.substring(0,status.length()-1);
        }
        if (status.endsWith("p")){
            status=status+"p";
        }
        status=status+STATUS_SUFFIX;
        return status;
    }

    public Set<String> keySet(){
        return mStatusMap.keySet();
    }

}
