package me.yamlee.demo.performance;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import me.yamlee.demo.BaseActivity;
import me.yamlee.demo.R;

/**
 * Created by yamlee on 9/20/16.
 */

public class MemoryActivity extends BaseActivity {
    String str = new String("");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

    }

    class MyRunnable implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("MyRunnable class running");
            }
        }
    }

    /**
     * 内部类泄露
     *
     * @param view
     */
    public void onClickInnerClassLeak(View view) {
        Toast.makeText(this, "click running", Toast.LENGTH_LONG).show();
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Anonymous inner class running");
                }
            }
        });
        thread1.start();
        thread2.start();
    }

    /**
     * new大量对象
     *
     * @param view
     */
    public void onClickNewLotsObj(View view) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            s.append(s);
        }
    }
}
