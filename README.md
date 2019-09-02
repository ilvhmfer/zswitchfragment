# zswitchfragment
点击底部按钮，动态添加、切换fragment。支持自定义底部菜单View

使用方法：

# layout文件

    <com.zyc.sw.fragment.view.ZFlContainView
            android:id="@+id/zFlContainView"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:loc="bottom"
            app:bottomHeight="50dp"
            app:bottomPadBottom="0dp"
            app:bottomPadTop="0dp"
            app:bottomPadLeft="0dp"
            app:bottomPadRight="0dp"
            app:hasDivider="true"
            app:dividerColor="#333333"
            app:dividerWidth="1dp"
            app:dividerMarginTopAndBottom="5dp"
            app:bottomBackgroundColor="#652344" />

   	loc: 菜单位置，顶部，底部
   	bottomHeight：菜单栏高度
   	bottomPadTop：菜单栏的padtop
   	hasDivider:菜单之间是否有分割线
   	dividerColor：分割线颜色
   	dividerWidth：分割线宽度
   	dividerMarginTopAndBottom：分割线距离上下边界的距离
   	bottomBackgroundColor：菜单栏背景颜色

# 一、文本菜单

    zFlContainView = (ZFlContainView) findViewById(R.id.zFlContainView);
    zFlContainView.setData(getSupportFragmentManager(), new Fragment1(), getData());
    zFlContainView.setCallback(new ZCallback() {
        @Override
        public void onClick(int index, ZItemData zViewData) {
            if(zViewData.fragment == null){
                //按钮对应fragment
                zViewData.fragment = new Fragment5("一级菜单切换fragment" + index);
            }
            zViewData.btnView.getViewData();//按钮数据信息
            zViewData.btnView.getView();//按钮View
        }
    });

    private List<IView> getData() {
        List<IView> list = new ArrayList<>();
        ZBaseTextView zBaseTextView1 = new ZBaseTextView(mActivity);
        ZImageTextData zImageTextData = new ZImageTextData.Builder().setText("菜单1").setTextColor(Color.WHITE, Color.RED).setGravity(Gravity.CENTER).build();
        zBaseTextView1.setViewData(zImageTextData);
        list.add(zBaseTextView1);
        //
        ZBaseTextView zBaseTextView2 = new ZBaseTextView(mActivity);
        ZImageTextData zImageTextData2 = new ZImageTextData.Builder().setText("菜单2").setTextColor(Color.WHITE, Color.RED).setGravity(Gravity.CENTER).build();
        zBaseTextView2.setViewData(zImageTextData2);
        list.add(zBaseTextView2);
        return list;
    }


# 二、图标菜单

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm2, null);
        zFlContainView2 = (ZFlContainView) view.findViewById(R.id.zFlContainView3);
        zFlContainView2.setData(getFragmentManager(), new Fragment3(), getData2());
        zFlContainView2.setCallback(new ZCallback() {
            @Override
            public void onClick(int index, ZItemData zViewData) {
                if(zViewData.fragment == null) {
                    zViewData.fragment = new Fragment5("三级菜单切换fragment"+ index);
                }
            }
        });
        return view;
    }

    private List<IView> getData2() {
        List<IView> list = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            ZBaseImageView btnView = new ZBaseImageView(getContext());
            ZImageViewData zImageViewData = null;
            switch(i) {
                case 0:
                    zImageViewData = new ZImageViewData.Builder()
                            .setSize(50, 50)
                            .setImageBitmapResourceId(R.mipmap.num0_normal_new, R.mipmap.num0_pressed_new)
                            .setGravity(Gravity.CENTER)
                            .build();
                    break;
                case 1:
                    zImageViewData = new ZImageViewData.Builder()
                            .setSize(50, 50)
                            .setImageBitmapResourceId(R.mipmap.num1_normal_new, R.mipmap.num1_pressed_new)
                            .setGravity(Gravity.CENTER)
                            .build();
                    break;
                case 2:
                    zImageViewData = new ZImageViewData.Builder()
                            .setSize(50, 50)
                            .setImageBitmapResourceId(R.mipmap.num2_normal_new, R.mipmap.num2_pressed_new)
                            .setGravity(Gravity.CENTER)
                            .build();
                    break;
            }
            btnView.setViewData(zImageViewData);
            list.add(btnView);
        }
        return list;
    }


# 三、图标+文本 菜单

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm3, null);
        zFlContainView2 = (ZFlContainView) view.findViewById(R.id.zFlContainView4);
        zFlContainView2.setData(getFragmentManager(), new Fragment4(), getData2());
        zFlContainView2.setCallback(new ZCallback() {
            @Override
            public void onClick(int index, ZItemData zViewData) {
                if(zViewData.fragment == null) {
                    zViewData.fragment = new Fragment5("四级菜单切换fragment"+ index);
                }
            }
        });
        return view;
    }

    private List<IView> getData2() {
        List<IView> list = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            ZBaseImageTextView btnView = new ZBaseImageTextView(getContext());
            ZImageTextData zImageTextData = null;
            switch(i) {
                case 0:
                    zImageTextData = new ZImageTextData.Builder()
                            .setText("四级菜单" + i)
                            .setTextColor(Color.BLACK, Color.RED)
                            .setDrawPadding(5)
                            .setTextSize(14)
                            .setSize(40,40)
                            .setImageBitmapResourceId(R.mipmap.num0_normal_new, R.mipmap.num0_pressed_new)
                            .setGravity(Gravity.CENTER)
                            .build();
                    break;
                case 1:
                    zImageTextData = new ZImageTextData.Builder()
                            .setText("四级菜单" + i)
                            .setTextColor(Color.BLACK, Color.RED)
                            .setDrawPadding(5)
                            .setTextSize(14)
                            .setSize(40,40)
                            .setImageBitmapResourceId(R.mipmap.num1_normal_new, R.mipmap.num1_pressed_new)
                            .setGravity(Gravity.CENTER)
                            .build();
                    break;
                case 2:
                    zImageTextData = new ZImageTextData.Builder()
                            .setText("四级菜单" + i)
                            .setTextColor(Color.BLACK, Color.RED)
                            .setDrawPadding(5)
                            .setTextSize(14)
                            .setSize(40,40)
                            .setImageBitmapResourceId(R.mipmap.num2_normal_new, R.mipmap.num2_pressed_new)
                            .setGravity(Gravity.CENTER)
                            .build();
                    break;
            }
            btnView.setViewData(zImageTextData);
            list.add(btnView);
        }
        return list;
    }

# 四 自定义View

    继承ZBaseView，或参考ZBaseView实现IView接口。

# 截图


<img src="https://github.com/ilvhmfer/zswitchfragment/blob/master/jpg/r1.png"/>


## 使用中如有问题，请发邮件：121346023@qq.com




