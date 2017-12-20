package tsms.zfsy.com.wangapipay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import tsms.zfsy.com.alipaystander.AliPayInterface;

/**
 * Created by Administrator on 2017/12/19 0019.
 */

public class ProxyActivity extends Activity {

    //要跳转到淘票票的Activity
    private String className;

    AliPayInterface aliPayInterface;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        className = getIntent().getStringExtra("className");

        /*Class clazz = getClassLoader().loadClass(className);
        Class.forName(className);*/

        try {
            Class activityClass = getClassLoader().loadClass(className);
            Constructor constructor = activityClass.getConstructor(new Class[]{});
            Object instance = constructor.newInstance(new Object[]{});

            aliPayInterface = (AliPayInterface) instance;
            aliPayInterface.attach(this);

            //可以传递信息
            Bundle bundle = new Bundle();
            aliPayInterface.onCreate(bundle);
            /**
             * 定义标准
             *
             * 传递生命周期
             */

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        aliPayInterface.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        aliPayInterface.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        aliPayInterface.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        aliPayInterface.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        aliPayInterface.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        aliPayInterface.onSaveInstanceState(outState);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        aliPayInterface.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        aliPayInterface.onBackPressed();
    }

    @Override
    public ClassLoader getClassLoader() {
        return PluginManager.getInstance().getDexClassLoader();
    }

    @Override
    public Resources getResources() {
        return PluginManager.getInstance().getResources();
    }

    @Override
    public void startActivity(Intent intent) {
        String classNameFromTaoPiaoPiao = intent.getStringExtra("className");
        Intent posIntent = new Intent(this, ProxyActivity.class);
        posIntent.putExtra("className", classNameFromTaoPiaoPiao);
        super.startActivity(posIntent);
    }
}
