package com.xq.mycolorstateliststatelistdrawable;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test2();
        test3();
    }

    private void test2() {
        // 颜色数组
        int[] colors = new int[]{Color.BLUE, Color.RED};
        // 颜色数组对应的状态
        int[][] states = new int[2][];
        states[0] = new int[]{android.R.attr.state_pressed};
        states[1] = new int[]{};//默认
        ColorStateList colorList = new ColorStateList(states, colors);

        //使用
        TextView tv2 = (TextView) this.findViewById(R.id.tv2);
        tv2.setTextColor(colorList);
    }

    //StateListDrawable
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void test3() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(Color.BLUE));
        stateListDrawable.addState(new int[]{}, new ColorDrawable(Color.RED));//默认

        //使用
        TextView tv3 = (TextView) this.findViewById(R.id.tv3);
        tv3.setBackground(stateListDrawable);
    }
}
