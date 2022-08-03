package bms.service;

import bms.dao.BookBorrowPeopleDAO;

/**
 * @author 赵天宇
 * @version 1.0
 */
public class MemberRegistrationService {
    private BookBorrowPeopleDAO bookBorrowPeopleDAO = new BookBorrowPeopleDAO();
    //编写一个完成会员注册的方法，并调用BookBorrowPeopleDAO,完成对数据库BookBorrowPeople表的增删改查
    public boolean Register(String userId,String passwd,String userName){
        if(bookBorrowPeopleDAO.update("insert into bookborrowpeople values(null,?,md5(?),?)", userId, passwd, userName)!=-1){
            return true;
        }
        return false;
    }
}
