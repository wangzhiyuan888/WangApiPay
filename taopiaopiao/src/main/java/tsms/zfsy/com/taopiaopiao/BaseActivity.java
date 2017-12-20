package tsms.zfsy.com.taopiaopiao;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import tsms.zfsy.com.alipaystander.AliPayInterface;

/**
 * Created by Administrator on 2017/12/19 0019.
 */

@SuppressLint("MissingSuperCall")
public class BaseActivity extends Activity implements AliPayInterface {

    protected Activity that;

    /**
     * super.setContentView(layoutResID) 是系统注入的上下文
     * @param layoutResID
     */
    @Override
    public void setContentView(int layoutResID) {
        if(that == null){
            super.setContentView(layoutResID);

        }else {
            that.setContentView(layoutResID);
        }
    }

    @Override
    public <T extends View> T findViewById(int id) {
        if(that == null){
            return super.findViewById(id);

        }else {
            return that.findViewById(id);

        }
    }

    @Override
    public ClassLoader getClassLoader() {
        if(that == null){
            return super.getClassLoader();

        }else {
            return that.getClassLoader();

        }
    }

    @NonNull
    @Override
    public LayoutInflater getLayoutInflater() {
        if(that == null){
            return super.getLayoutInflater();

        }else {
            return that.getLayoutInflater();

        }
    }

    @Override
    public Window getWindow() {
        if(that == null){
            return super.getWindow();

        }else {
            return that.getWindow();

        }
    }

    @Override
    public WindowManager getWindowManager() {
        if(that == null){
            return super.getWindowManager();

        }else {
            return that.getWindowManager();

        }
    }

    @Override
    public void onCreate(Bundle saveInstance) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void attach(Activity activity) {
        this.that = activity;

    }

    @Override
    public void startActivity(Intent intent) {
        Intent newIntent = new Intent();
        newIntent.putExtra("className", intent.getComponent().getClassName());
        if(that == null){
            super.startActivity(newIntent);

        }else {
            that.startActivity(newIntent);

        }
    }
}
