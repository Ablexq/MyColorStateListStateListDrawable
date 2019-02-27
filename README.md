
参考：

[Android ColorStateList 与StateListDrawable](https://blog.csdn.net/zzyawei/article/details/80853736)

[android的ColorStateList简单使用](https://blog.csdn.net/abc6368765/article/details/51482317)


# xml中selector：

> 定义：

txt_bg.xml：

```
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">

    <item android:drawable="@color/colorAccent" android:state_pressed="true" />
    <item android:drawable="@color/colorPrimaryDark" />

</selector>
```

txt_color.xml：

```
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">

    <item android:color="#45c01a" android:state_pressed="true" />
    <item android:color="#ff8041" />

</selector>

```

> 使用：

```
<TextView
    android:id="@+id/tv1"
    android:layout_width="match_parent"
    android:layout_height="50dp"
    android:clickable="true"
    android:focusable="true"
    android:gravity="center"
    android:text="Hello World!"
    android:background="@drawable/txt_bg"
    android:textColor="@drawable/txt_color"
    android:textSize="25sp"
    android:textStyle="bold" />

```

注意：要添加可点击效果，clickable、focusable

# ColorStateList（常用于文字颜色）：

```
public class ColorStateList extends ComplexColor implements Parcelable {

public abstract class ComplexColor {
```



```
<TextView
    android:id="@+id/tv2"
    android:layout_width="match_parent"
    android:layout_height="50dp"
    android:clickable="true"
    android:focusable="true"
    android:gravity="center"
    android:text="Hello World!"
    android:textStyle="bold" />
```


```
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
```

# StateListDrawable（用于背景颜色）：

```
public class StateListDrawable extends DrawableContainer {

public class DrawableContainer extends Drawable implements Drawable.Callback {

public abstract class Drawable {

```

```
<TextView
    android:id="@+id/tv3"
    android:layout_width="match_parent"
    android:layout_height="50dp"
    android:clickable="true"
    android:focusable="true"
    android:gravity="center"
    android:text="Hello World!"
    android:textSize="25sp"
    android:textStyle="bold" />
```


```
StateListDrawable stateListDrawable = new StateListDrawable();
stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(Color.BLUE));
stateListDrawable.addState(new int[]{}, new ColorDrawable(Color.RED));//默认

//使用
TextView tv3 = (TextView) this.findViewById(R.id.tv3);
tv3.setBackground(stateListDrawable);
```



# ColorStateList与StateListDrawable共同点:

两者具有状态属性 ,状态定义在android.R.attr中：

```
android:state_pressed=["true" | "false"]
android:state_focused=["true" | "false"]
android:state_selected=["true" | "false"]
android:state_checkable=["true" | "false"]
android:state_checked=["true" | "false"]
android:state_enabled=["true" | "false"]
android:state_window_focused=["true" | "false"]
```

选择方式:都是至上而下匹配（xml从上到下，java中int[] 从0～n），如果单个item中有两张状态声明，则同时满足两个状态才匹配成功

默认值:当所有条件都不满足的时候，会返回默认值。也就是最后一个值。

# ColorStateList与StateListDrawable不同点:

ColorStateList 用于颜色选择

StateListDrawable 用于Drawable选择





























