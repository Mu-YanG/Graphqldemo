package space.lvyang.graphql.demo.model;



import java.util.Date;

/**
 * Created by Nxin on 2019/4/3.
 */


public class Book {
    private Integer bookid;
    private Integer userid;
    private String bookname;
    private Date createtime;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", userid=" + userid +
                ", bookname='" + bookname + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
