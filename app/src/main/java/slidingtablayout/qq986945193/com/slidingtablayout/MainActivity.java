package slidingtablayout.qq986945193.com.slidingtablayout;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
/**
 * @author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub:https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @交流Qq ：986945193
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vp = (ViewPager) findViewById(R.id.vp);
        //创建slidingTabLayou对象，并且绑定布局
        SlidingTabLayout slidingTab = (SlidingTabLayout) findViewById(R.id.sliding_tab);
        MyAdapter adapter = new MyAdapter();
        vp.setAdapter(adapter);
        //SlidingTabLayout绑定Viewpager
        slidingTab.setViewPager(vp);


    }

    //创建 颜色数组 用来做viewpager的背景
    int[] colors = {0xFF123456, 0xFF654321, 0xFF336699, 0xFF123456};

    class MyAdapter extends PagerAdapter {
        //准备用来做tab的标题数组
        String[] title = { "c#", "android", "ios", "php"};
        ArrayList<LinearLayout> lists = new ArrayList<>();

        /**
         * 设置viewpager的背景颜色
         */
        public MyAdapter() {
            for (int i = 0; i < 4; i++) {
                LinearLayout ll = new LinearLayout(MainActivity.this);
                ll.setBackgroundColor(colors[i]);
                ll.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                lists.add(ll);
            }
        }

        @Override
        public int getCount() {
            return lists.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(lists.get(position));
            return lists.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        /**
         * 将 标题的数组文字 添加到title上面
         *
         * @param position
         * @return
         */
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}