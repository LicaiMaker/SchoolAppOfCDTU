package com.schoolapp.schoolapp.forum;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.gson.Gson;
import com.schoolapp.schoolapp.R;
import com.schoolapp.schoolapp.bean.ForumNote;
import com.schoolapp.schoolapp.dao.HttpCallBackListener;
import com.schoolapp.schoolapp.shopping.ShoppingIndexActivity;
import com.schoolapp.schoolapp.utils.HttpUtils;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class forumActivity extends AppCompatActivity implements ActionBar.TabListener ,View.OnClickListener{

    private static String mCurrentPhotoStr="1234";//用于保存从相册获取底片的path路径
    private LinearLayout ll_indexInForum;
    private LinearLayout ll_shoppingInForum;
    private static final int PICK_CODE = 0;//用于获取图片时传递Intent请求码
    private static final String UPLOADINGURL="http://192.168.1.113/schoolapp/DownLoadFromServerServlet";
    private static final String UPLOADINSTRGURL="http://192.168.1.113/schoolapp/InsertJsonIntoDataBaseServlet";
    static String message="";//用于记录上传图片成功与否
    static List<Map<String, Object>> NotesList = new ArrayList<Map<String, Object>>();
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    static ViewPager mViewPager;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    public static List<Map<String, Object>> getNearByPlays() {
        Map<String, Object> map = new HashMap<String, Object>();

        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_forum);
        setTitle("");
        //导航栏的首页导航按钮
        ll_indexInForum= (LinearLayout) findViewById(R.id.ll_indexInForum);
        ll_indexInForum.setOnClickListener(this);
        ll_shoppingInForum= (LinearLayout) findViewById(R.id.ll_shoppingInForum);
        ll_shoppingInForum.setOnClickListener(this);
        // Set up the action bar.
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
//                mViewPager.setId(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_forum, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
//        mViewPager.setId(tab.getPosition());
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    public List<Fragment> getFragmentlists() {
        List<Fragment> Fragmentlists = new ArrayList<Fragment>();
        Fragmentlists.add(PlaceholderFragment1.newInstance(1));
        Fragmentlists.add(PlaceholderFragment2.newInstance(2));
        Fragmentlists.add((new PlaceholderFragment3()).newInstance(3));
        return Fragmentlists;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_indexInForum://点击的是首页导航按钮
                this.finish();
                break;
            case R.id.ll_shoppingInForum://点击的是购物按钮
                Intent intent=new Intent(forumActivity.this, ShoppingIndexActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment1 extends Fragment {

        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        //论坛的首页-今日热帖的数据源
        static Map<String, Object> map = new HashMap<String, Object>();//用于存放帖子的map集合

        public PlaceholderFragment1() {

        }

        public static List<Map<String, Object>> getHotNotes() {
            if (map.isEmpty()) {
                map.put("img", R.drawable.note1);
                map.put("title", "成都工业学院摄影比赛开始了");
                map.put("details", "今天，成都工业学院一年一度的摄影大赛开始了，希望小伙伴们踊跃报名，展示你生活中的美吧...");
                NotesList.add(map);
                map = new HashMap<String, Object>();
                map.put("img", R.drawable.note2);
                map.put("title", "有没有要骑行的朋友，求组队");
                map.put("details", "10月12号，骑行川藏线，体验汽车生活，有意愿的朋友打133221211这个电话。。。");
                NotesList.add(map);
                map = new HashMap<String, Object>();
                map.put("img", R.drawable.note3);
                map.put("title", "陈毅杯足球赛的拉拉队招新");
                map.put("details", "为了陈毅杯足球赛招新，请大家踊跃报名，为运动员加加油吧!");
                NotesList.add(map);
                map = new HashMap<String, Object>();
                map.put("img", R.drawable.note1);
                map.put("title", "成都工业学院摄影比赛开始了");
                map.put("details", "今天，成都工业学院一年一度的摄影大赛开始了，希望小伙伴们踊跃报名，展示你生活中的美吧...");
                NotesList.add(map);
                map = new HashMap<String, Object>();
                map.put("img", R.drawable.note2);
                map.put("title", "有没有要骑行的朋友，求组队");
                map.put("details", "10月12号，骑行川藏线，体验汽车生活，有意愿的朋友打133221211这个电话。。。");
                NotesList.add(map);
                map = new HashMap<String, Object>();
                map.put("img", R.drawable.note3);
                map.put("title", "陈毅杯足球赛的拉拉队招新");
                map.put("details", "为了陈毅杯足球赛招新，请大家踊跃报名，为运动员加加油吧!");
                NotesList.add(map);
            }

            return NotesList;
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment1 newInstance(int sectionNumber) {
            PlaceholderFragment1 fragment = new PlaceholderFragment1();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public static SimpleAdapter getAdapter(Context context) {
            SimpleAdapter adapter = new SimpleAdapter(context, getHotNotes(), R.layout.row_of_discovery,
                    new String[]{"img", "title", "details"}, new int[]{R.id.IV_note, R.id.TV_title, R.id.TV_notedetails});
            return adapter;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = null;
            //创建适配器

            rootView = inflater.inflate(R.layout.fragment1_forum, container, false);
//            ((ListView)rootView.findViewById(R.id.LV_note)).setDividerHeight(4);
            SimpleAdapter adapter = getAdapter(getActivity());
            adapter.notifyDataSetChanged();
            ((ListView) rootView.findViewById(R.id.LV_note)).setAdapter(adapter);//为listview添加一个适配器
            return rootView;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment2 extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        static Map<String, Object> map = new HashMap<String, Object>();//用于存放帖子
        static List<Map<String, Object>> NearByPlaysList = new ArrayList<Map<String, Object>>();

        public PlaceholderFragment2() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment2 newInstance(int sectionNumber) {
            PlaceholderFragment2 fragment = new PlaceholderFragment2();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        //论坛第二页--附近好玩的数据源
        public List<Map<String, Object>> getNearByPlays() {
            if (map.isEmpty()) {
                map.put("img", R.drawable.play1);
                map.put("title", "从早到晚的颜色");
                map.put("details", "这是一天的风景，晒晒你的所在地的一天吧...");
                NearByPlaysList.add(map);
                map = new HashMap<String, Object>();
                map.put("img", R.drawable.play2);
                map.put("title", "素描。。。");
                map.put("details", "展示我的高超素描技艺，求赞。。。");
                NearByPlaysList.add(map);
                map = new HashMap<String, Object>();
                map.put("img", R.drawable.note3);
                map.put("title", "陈毅杯足球赛的拉拉队招新");
                map.put("details", "为了陈毅杯足球赛招新，请大家踊跃报名，为运动员加加油吧!");
                NearByPlaysList.add(map);
                map = new HashMap<String, Object>();
                map.put("img", R.drawable.play1);
                map.put("title", "从早到晚的颜色");
                map.put("details", "这是一天的风景，晒晒你的所在地的一天吧...");
                NearByPlaysList.add(map);
                map = new HashMap<String, Object>();
                map.put("img", R.drawable.play2);
                map.put("title", "素描。。。");
                map.put("details", "展示我的高超素描技艺，求赞。。。");
                NearByPlaysList.add(map);
                map = new HashMap<String, Object>();
                map.put("img", R.drawable.note3);
                map.put("title", "陈毅杯足球赛的拉拉队招新");
                map.put("details", "为了陈毅杯足球赛招新，请大家踊跃报名，为运动员加加油吧!");
                NearByPlaysList.add(map);
            }
            return NearByPlaysList;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = null;
            rootView = inflater.inflate(R.layout.fragment2_forum, container, false);
            SimpleAdapter adapter = new SimpleAdapter(getActivity(), getNearByPlays(), R.layout.row_of_nearbyplays,
                    new String[]{"img", "title", "details"}, new int[]{R.id.IV_nearbyplay, R.id.TV_playstitle, R.id.TV_playsdetails});
            ((ListView) rootView.findViewById(R.id.LV_NearByPlays)).setAdapter(adapter);//为listview添加一个适配器
            return rootView;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment3 extends Fragment implements View.OnClickListener {
        private static final String ARG_SECTION_NUMBER = "section_number";
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private Button btn_selectPicture;
        private Button btn_submit;
        private EditText ET_picture;
        private EditText ET_Title;
        private EditText ET_content;

        public PlaceholderFragment3() {
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public PlaceholderFragment3 newInstance(int sectionNumber) {
            PlaceholderFragment3 fragment = new PlaceholderFragment3();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = null;
            rootView = inflater.inflate(R.layout.fragment3_forum, container, false);
            ET_content = (EditText) rootView.findViewById(R.id.ET_Content);
            ET_picture = (EditText) rootView.findViewById(R.id.ET_picture);
            ET_Title = (EditText) rootView.findViewById(R.id.ET_Title);
            btn_selectPicture = (Button) rootView.findViewById(R.id.btn_selectpicture);
            btn_submit = (Button) rootView.findViewById(R.id.btn_notesSumbit);
            btn_selectPicture.setOnClickListener(this);
            btn_submit.setOnClickListener(this);
            return rootView;
        }



        /**
         * 用于将一个forumNote实例上传到服务器
         * @param forumNote
         * @return
         */
        public void notesSubmit(ForumNote forumNote){
            //实现将bean实例转换成json字符串上传到服务
            Gson gson=new Gson();
            String forumNoteString= gson.toJson(forumNote);
            Log.d("TAG", forumNoteString);
            HttpUtils.sendStr(UPLOADINSTRGURL, "POST", forumNoteString, new HttpCallBackListener() {
                @Override
                public void OnFinish(String response) {
                    Log.d("TAG","上传成功！");
                }

                @Override
                public void OnError(Exception e) {
                    Log.d("TAG","上传失败！"+e.getMessage());
                }
            });

        }


        /**
         * 判断图片是否存在
         * @param path--图片的路径
         * @return--字节数组
         */
        public boolean isFileExist(String path){
            try{
                File file=new File(path);
                return file.exists() ;
            }
            catch(Exception e){
                    return false;
                }
        }
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_selectpicture:
                    //将图片的path展示在ET_picture控件中
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent, PICK_CODE);
                    break;
                case R.id.btn_notesSumbit://点击的是发布按钮
                    if ("".equals(ET_Title.getText().toString()) || "".equals( ET_content.getText().toString()))//如果标题或内容为空
                        Toast.makeText(getActivity(), "标题或内容不能为空！", Toast.LENGTH_SHORT).show();
                    else if ("".equals(ET_picture.getText().toString()))
                        Toast.makeText(getActivity(),"图片不能为空！",Toast.LENGTH_SHORT).show();
                    else if(!isFileExist(ET_picture.getText().toString())){
                        Toast.makeText(getActivity(),"图片路径有误！",Toast.LENGTH_SHORT).show();
                    }
                    else {

                        ForumNote forumNote=new ForumNote();
                        forumNote.setForumnote_title(ET_Title.getText().toString());
                        forumNote.setForumnote_content(ET_content.getText().toString());
                        forumNote.setForumnote_location("四川成都");
                        forumNote.setForumnote_time(new Date(new java.util.Date().getTime()));
////                        byte[] b=getPicByte(ET_picture.getText().toString());
                        File file=new File(ET_picture.getText().toString());//根据路径获取文件
//                        //根据图片的路径获取字节数组
                        forumNote.setForumnote_pic(file.getName());
                        notesSubmit(forumNote);
                        HttpUtils.SendObject(UPLOADINGURL, "POST", file, new HttpCallBackListener() {
                            @Override
                            public void OnFinish(String response) {
                                Log.d("TAG", "图片上传成功");
                                message="图片上传成功";
                            }

                            @Override
                            public void OnError(Exception e) {
                                Log.d("TAG", "图片上传失败" + e.getMessage());
                                e.printStackTrace();
                                message="图片上传失败";
                            }
                        });
                        if("图片上传成功".equals(message)){
                            Toast.makeText(getActivity(), "发布成功！", Toast.LENGTH_SHORT).show();
                            mViewPager.setCurrentItem(0);
                        }else if("图片上传失败".equals(message)){

                            Toast.makeText(getActivity(), "发布失败！", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;
            }
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
//        Log.d("TAG","准备。。");
//        Log.d("TAG","resultCode="+resultCode);
//        if (requestCode == PICK_CODE) {
//            Log.d("TAG","执行前。。");
            if (intent != null) {
                Uri uri = intent.getData();
                Cursor cursor = getContentResolver().query(uri, null, null, null, null);
                cursor.moveToFirst();
                int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                mCurrentPhotoStr = cursor.getString(index);
//                Log.d("TAG","执行。。");
                ((EditText)findViewById(R.id.ET_picture)).setText(mCurrentPhotoStr);
                cursor.close();
            }
//        }
//        Log.d("TAG","执行后...");
        super.onActivityResult(requestCode, resultCode, intent);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> Fragmentlists = getFragmentlists();

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment1 (defined as a static inner class below).
            return Fragmentlists.get(position);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return Fragmentlists.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }


}
