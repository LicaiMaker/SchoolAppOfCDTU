package com.schoolapp.schoolapp.bean;


import java.sql.Date;

/**
 * Created by LiCai on 2016/3/4.
 */
public class ForumNote {

/**
 * forumnote_id(integer):帖子的序号(设为主键)
 forumnote_titlSe(varchar(50)):帖子的标题
 forumnote_content(varchar(500)):帖子的内容
 forumnote_picurl(varchar(200)):帖子的图片的存放路径
 forumnote_location(varchar(50)):发帖者的位置
 forumnote_time(date):发帖的时间
 */


    private String forumnote_title;
    private String forumnote_content;
    private String forumnote_pic;
    private String forumnote_location;
    private Date forumnote_time;

    public ForumNote() {
    }

    public ForumNote(String forumnote_location,String forumnote_pic, String forumnote_content, String forumnote_title, Date forumnote_time) {
        this.forumnote_location = forumnote_location;
        this.forumnote_pic = forumnote_pic;
        this.forumnote_content = forumnote_content;
        this.forumnote_title = forumnote_title;
        this.forumnote_time = forumnote_time;
    }


    public String getForumnote_title() {
        return forumnote_title;
    }

    public void setForumnote_title(String forumnote_title) {
        this.forumnote_title = forumnote_title;
    }

    public String getForumnote_content() {
        return forumnote_content;
    }

    public void setForumnote_content(String forumnote_content) {
        this.forumnote_content = forumnote_content;
    }

    public String getForumnote_location() {
        return forumnote_location;
    }

    public void setForumnote_location(String forumnote_location) {
        this.forumnote_location = forumnote_location;
    }

    public String getForumnote_pic() {
        return forumnote_pic;
    }

    public void setForumnote_pic(String forumnote_pic) {
        this.forumnote_pic = forumnote_pic;
    }

    public Date getForumnote_time() {
        return forumnote_time;
    }

    public void setForumnote_time(Date forumnote_time) {
        this.forumnote_time = forumnote_time;
    }
}
