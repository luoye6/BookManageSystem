package bms.views;

import bms.dao.BookBorrowDAO;
import bms.dao.BookListDAO;
import bms.domain.BookBorrowPeople;
import bms.domain.BookBorrowRecord;
import bms.domain.BookList;
import bms.service.*;
import bms.utils.Utility;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @author 赵天宇
 * @version 1.0
 */
public class BookManageView {
    private boolean loop = true;
    private String key = "";
    private BookBorrowService bookBorrowService = new BookBorrowService();
    private BookListService bookListService = new BookListService();
    private BookBorrowPeopleService bookBorrowPeopleService = new BookBorrowPeopleService();
    private BookReturnService bookReturnService = new BookReturnService();
    private MemberRegistrationService memberRegistrationService = new MemberRegistrationService();
    private AddBooksService addBooksService = new AddBooksService();
    private ListBookBorrowRecordService listBookBorrowRecordService = new ListBookBorrowRecordService();
    private MemberLogoutService memberLogoutService = new MemberLogoutService();
    private ChangePassWordService changePassWordService = new ChangePassWordService();
    //编写显示图书的方法，并调用BookListService中的方法
    public void listBooks(){
        List<BookList> bookLists = bookListService.list();//调用bookListService中的list方法，返回图书信息给List集合
        System.out.println("\n图书编号\t\t图书名称\t\t图书数量\t\t单价\t\t图书状态\t\t借书人\t\t归还期限");
        for (BookList bookList : bookLists) {
            System.out.println(bookList);
        }
        System.out.println("图书信息显示完毕");
    }
    //编写借书人能够借出图书的方法，并调用BooKBorrowService中的方法
    public void borrowBooks(){
        System.out.print("请确认是否要借出图书(-1退出 1进入): ");
        String key = Utility.readString(2);
        if(key.equals("-1")){
            return;
        }
        System.out.print("请输入要借的图书名称: ");
        String bookName = Utility.readString(50);
        System.out.print("请输入您的姓名: ");
        String bookBorrowPeople = Utility.readString(50);
        LocalDate bookBorrowDate = LocalDate.now();
        if(bookBorrowService.BorrowBooks(bookName, bookBorrowPeople, bookBorrowDate)!=false){
            System.out.println("您已借书成功");
        }else{
            System.out.println("借书失败");
        }

    }
    //编写借书人能够归还图书的方法，并调用BookReturnService中的方法.
    public void returnBooks(){
        System.out.print("请确认是否要归还图书(-1退出 1进入): ");
        String key = Utility.readString(2);
        if(key.equals("-1")){
            return;
        }
        System.out.print("请输入要归还的图书名称: ");
        String bookName = Utility.readString(50);
        System.out.print("请输入您的姓名: ");
        String bookReturnPeople = Utility.readString(50);
        LocalDate returnDate = LocalDate.now();
        if(bookReturnService.returnBooksGetByBookNameAndBookBorrowPeople(bookName,bookReturnPeople,returnDate)==true){//调用bookReturnService中的方法，实现图书的归还
            System.out.println("您已成功归还图书");
        }else{
            System.out.println("归还图书失败");
        }
    }
    //编写一个会员注册的方法
    public void memberRegistration(){
        System.out.println("请问您是否要进行会员注册(Y/N): ");
        String key = Utility.readString(1);
        if((key.equals("Y"))||(key.equals("y"))){
            //调用MemberRegistrationService中的方法，完成会员注册的功能
            System.out.print("请输入你要注册的用户名(账号): ");
            String userId = Utility.readString(50);
            System.out.print("请输入注册账号的密码: ");
            String passwd = Utility.readString(32);
            System.out.print("请输入账号的昵称: ");
            String userName = Utility.readString(50);
            if(memberRegistrationService.Register(userId,passwd,userName)==true){
                System.out.println("会员注册成功");
            }else{
                System.out.println("会员注册失败");
            }
        }else{
            return;
        }
    }
    //编写一个增加图书的方法，调用AddBooksService,完成增加图书的操作
    public void addBooks(){
        //调用AddBooksService
        System.out.print("请确认是否要添加图书(-1退出 1进入): ");
        String key = Utility.readString(2);
        if(key.equals("-1")){
            return;
        }
        System.out.print("请输入要添加的图书名称: ");
        String bookName = Utility.readString(50);
        System.out.print("请输入要添加的图书数量: ");
        Integer bookNumber = Utility.readInt(0);
        System.out.print("请输入图书的单价: ");
        Integer bookPrice = Utility.readInt();
            if(addBooksService.addBooksService(bookName,bookNumber,bookPrice)==true){
                System.out.println("添加图书成功");
            }else{
                System.out.println("添加图书失败");
            }
    }
    //编写一个显示借书记录的方法
    public void listBookBorrowRecord(){
        //调用listBookBorrowRecordService
        List<BookBorrowRecord> bookBorrowRecords = listBookBorrowRecordService.listBookBorrowRecords();
        if(bookBorrowRecords==null) {
            System.out.println("无借书记录");
        }else{
            System.out.println("\n记录编号\t\t图书名称\t\t图书状态\t\t借书人\t\t借书日期\t\t\t\t\t\t归还日期");
            for (BookBorrowRecord bookBorrowRecord : bookBorrowRecords) {
                System.out.println(bookBorrowRecord);
            }
            System.out.println("借书记录显示完毕");
        }
    }
    //编写一个会员注销的方法
    public void memberLogout(){
        System.out.print("请确认是否要注销会员(-1退出 1进入): ");
        String key = Utility.readString(2);
        if(key.equals("-1")){
            return;
        }
        System.out.print("请输入账号的用户名: ");
        String userId = Utility.readString(50);
        System.out.print("请输入账号的密码: ");
        String passwd = Utility.readString(50);
        if(memberLogoutService.logoutMember(userId, passwd)==true){
            System.out.println("会员账号注销成功");
        }else{
            System.out.println("会员账号注销失败");
        }
    }
    //编写一个修改密码的方法
    public void changePassword(){
        System.out.print("请输入您的账号: ");
        String userId = Utility.readString(50);
        System.out.print("请输入原密码: ");
        String oldPassword = Utility.readString(50);
        System.out.print("请输入新密码: ");
        String newPassword = Utility.readString(50);
        if(changePassWordService.changePwd(userId,oldPassword,newPassword)==true){
            System.out.println("您的密码修改成功");
        }else{
            System.out.println("您的密码修改失败");
        }
    }
    public static void main(String[] args) {
        new BookManageView().BookManageSystem();
    }

    public void BookManageSystem() {
        while (loop) {
            System.out.println("====================图书管理系统(1.0)====================");
            System.out.println("\t\t 1.登录图书管理系统");
            System.out.println("\t\t 2.退出图书管理系统");
            System.out.println("\t\t 3.会员注册");
            System.out.println("\t\t 4.会员注销");
            System.out.println("\t\t 5.修改密码");
            System.out.print("请输入你的选择: ");
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.print("请输入您的用户名: ");
                    String userId = Utility.readString(50);
                    System.out.print("请输入您的密码: ");
                    String passwd = Utility.readString(50);
                    BookBorrowPeople bookBorrowPeople = bookBorrowPeopleService.getBBPbyNameAndPwd(userId,passwd);
                    if (bookBorrowPeople != null) {//与数据库中的用户名和密码作匹配，如果成功则继续显示图书管理系统的二级菜单
                        System.out.println("====================用户(" + bookBorrowPeople.getName() + ")登录成功====================");
                        while (loop) {
                            System.out.println("====================图书管理系统(1.0)(二级菜单)====================");
                            System.out.println("\t\t 1.显示图书");
                            System.out.println("\t\t 2.借出图书");
                            System.out.println("\t\t 3.归还图书");
                            System.out.println("\t\t 4.增加图书");
                            System.out.println("\t\t 5.显示借书记录");
                            System.out.println("\t\t 6.退出图书管理系统");
                            System.out.print("请输入你的选择: ");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    listBooks();
                                    break;
                                case "2":
                                    borrowBooks();
                                    break;
                                case "3":
                                    returnBooks();
                                    break;
                                case "4":
                                    addBooks();
                                    break;
                                case "5":
                                    listBookBorrowRecord();
                                    break;
                                case "6":
                                    System.out.println("您退出了图书管理系统");
                                    loop = false;
                                    break;
                            }
                        }
                    } else {
                        System.out.println("登录失败，该用户不存在");
                    }
                    break;
                case "2":
                    System.out.println("您退出了图书管理系统");
                    loop = false;
                    break;
                case "3":
                    memberRegistration();
                    break;
                case "4":
                    memberLogout();
                    break;
                case "5":
                    changePassword();
                    break;
            }

        }
    }
}
