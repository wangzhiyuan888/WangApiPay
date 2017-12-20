package tsms.zfsy.com.alipaystander;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2017/12/14 0014.
 */

public interface AliPayInterface {
    public void onCreate(Bundle saveInstance);
    public void onStart();
    public void onResume();
    public void onPause();
    public void onStop();
    public void onDestroy();
    public void onSaveInstanceState(Bundle outState);
    public boolean onTouchEvent(MotionEvent event);
    public void onBackPressed();

    /**
     * 需要注入上下文
     */
    public void attach(Activity activity);
}
