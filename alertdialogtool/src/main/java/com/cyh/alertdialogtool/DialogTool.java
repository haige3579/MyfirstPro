package com.cyh.alertdialogtool;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

/**
 *    对话框封装类
 * Created by CYH on 2016/9/9.
 */
public class DialogTool {
    private static DialogTool instance=null;
//    单例模式
    public static DialogTool getInstance(){
        if (instance==null){
            instance=new DialogTool();
        }
        return instance;
    }

//    普通对话框
   public static Dialog createNormalDialog(Context context,
                 int iconID, String title,String message, Integer btnName, DialogInterface.OnClickListener listenr,Integer btnName2,DialogInterface.OnClickListener listener2){
       Dialog dialog=null;
       android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(context);
       builder.setIcon(iconID);//图标
       builder.setTitle(title);//标题
       builder.setMessage(message);//显示内容
       //添加按钮
       builder.setPositiveButton(btnName,listenr);
       if (btnName2!=null)
       builder.setNegativeButton(btnName2,listener2);
       dialog=builder.create();//创建
       return dialog;
   }

//    列表对话框
    public static Dialog createListDialog(Context context,
                  int iconID, String title,int itemsid, DialogInterface.OnClickListener listenr){
        Dialog dialog=null;
        android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(context);
        builder.setIcon(iconID);//图标
        builder.setTitle(title);//标题
        builder.setItems(itemsid,listenr);//添加按钮
        dialog=builder.create();//创建
        return dialog;
    }

//  单选按钮
    public static Dialog createRadioDialog(Context context,
                      int iconId, String title,int itemsId, DialogInterface.OnClickListener listener,
                       String btnName,DialogInterface.OnClickListener listener2) {
        Dialog dialog=null;
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        // 设置对话框的图标
        builder.setIcon(iconId);
        // 设置对话框的标题
        builder.setTitle(title);
        // 0: 默认第一个单选按钮被选中
        builder.setSingleChoiceItems(itemsId, 0, listener);
        // 添加一个按钮
        builder.setPositiveButton(btnName, listener2) ;
        // 创建一个单选按钮对话框
        dialog = builder.create();
        return dialog;
    }

    public static Dialog createCheckBoxDialog(Context context,
                  int iconId, String title,int itemsId, DialogInterface.OnMultiChoiceClickListener listener,
                   boolean[] flags, String btnName2,DialogInterface.OnClickListener listener2,String btnName3,DialogInterface.OnClickListener listener3){
        Dialog dialog=null;
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        // 设置对话框的图标
        builder.setIcon(iconId);
        // 设置对话框的标题
        builder.setTitle(title);
        builder.setMultiChoiceItems(itemsId, flags, listener);
        // 添加按钮
        builder.setPositiveButton(btnName2, listener2) ;
        builder.setNegativeButton(btnName3,listener3);
        // 创建一个复选对话框
        dialog = builder.create();
        return dialog;
    }

    public static Dialog createMyDialog(Context context,
                  int iconId, String title, View view,String btnName,DialogInterface.OnClickListener listener,String btnName2,DialogInterface.OnClickListener listener2){
        Dialog dialog=null;
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        // 设置对话框的图标
        builder.setIcon(iconId);
        // 设置对话框的标题
        builder.setTitle(title);
        //设置自定义视图
        builder.setView(view);
        // 添加按钮
        builder.setPositiveButton(btnName, listener) ;
        builder.setNegativeButton(btnName2,listener2);
        // 创建一个复选对话框
        dialog = builder.create();
        return dialog;
    }
}
