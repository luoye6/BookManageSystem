package bms.domain;

/**
 * @author 赵天宇
 * @version 1.0
 * 这是一个javabean,domain,pojo 与数据库中的bookborrowpeople表对应
 * 1.id Integer 11 编号 自增 主键
 * 2.bbpId varchar 50 not null 借书人编号
 * 3.pwd char 32 密码 not null 密码
 * 4.name varchar 50 not null 用户名
 */
public class BookBorrowPeople {
    private Integer id;
    private String bbpId;
    private String pwd;
    private String name;
    public BookBorrowPeople(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBbpId() {
        return bbpId;
    }

    public void setBbpId(String bbpId) {
        this.bbpId = bbpId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookBorrowPeople(Integer id, String bbpId, String pwd, String name) {
        this.id = id;
        this.bbpId = bbpId;
        this.pwd = pwd;
        this.name = name;
    }
}
