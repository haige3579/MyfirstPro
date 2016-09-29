package tools;

import android.os.Handler;
import android.widget.TextView;

import java.util.List;

import tools.StatusTracker;

/**
 *   更新textview值
 * Created by CYH on 2016/9/27.
 */
public class Utils {

    public static final StatusTracker mStatusTracker=StatusTracker.getInstance();

    public static void printStatus(final TextView viewMethods,final TextView viewStatus){
        Handler mhandler=new Handler();
        mhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                StringBuffer sbMethods=new StringBuffer();
                List<String> listMethods=mStatusTracker.getMethodList();
                for (String method:listMethods){
                    sbMethods.insert(0,method+"\r\n");
                }
                if (sbMethods!=null){
                    viewMethods.setText(sbMethods.toString());
                }

                StringBuffer sbStatus=new StringBuffer();
                for (String key:mStatusTracker.keySet()){
                    sbStatus.insert(0,key+":"+mStatusTracker.getStatus(key)+"\n");
                }
                if (sbStatus!=null){
                    viewStatus.setText(sbStatus.toString());
                }

            }
        },750);
    }
}
