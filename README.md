# SlidingTabLayout
【Android】SlidingTabLayout实现标题栏，教你制作title标题 简单易学。
作者：程序员小冰，CSDN博客：http://blog.csdn.net/qq_21376985， 
QQ986945193 微博：http://weibo.com/mcxiaobing

首先先给大家看一下效果图：
![这里写代码片](http://img.blog.csdn.net/20160906103734672)

介绍：本小demo里面引用了两个google的官方类，SlidingTabLayout和SlidingTabStrip，
我们将它烤进我们的项目中引用即可，具体请看详细代码。特别说明，本项目对slidingTablayout
的源代码进行了修改，如果你是从别处下载的，看到的效果是不一样的，当然标题不是剧中的，
如果想要居中，可以设置代码：
在Android SlidingTabLayout源代码中有一个方法：
private void populateTabStrip();
我们添加一些代码即可：
LinearLayout.LayoutParams layoutParams= new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);  
tabView.setLayoutParams(layoutParams); 
放在：    tabTitleView.setText(adapter.getPageTitle(i));  
          tabView.setOnClickListener(tabClickListener);  
  
            //添加在此位置
            LinearLayout.LayoutParams layoutParams= new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);  
            tabView.setLayoutParams(layoutParams);  
            //
              
            mTabStrip.addView(tabView); 
如果要修改 选中效果 的颜色,或者加上选中颜色过度效果，或者 分割线的颜色，可以为 SlidingTabLayout设置属性
tab.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {  
            @Override  
            public int getIndicatorColor(int position) {  
                return colors[position];//每个选项卡所对应的颜色  
            }  
<span style="white-space:pre">    </span>    //分割线颜色  
            @Override  
            public int getDividerColor(int position) {  
                return 0x00FFFFFF;  
            }  
        });  

如果对您有帮助，欢迎star，fork。。。
