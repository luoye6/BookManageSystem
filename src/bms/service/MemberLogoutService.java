package bms.service;

import bms.dao.BookBorrowPeopleDAO;

/**
 * @author 赵天宇
 * @version 1.0
 */
public class MemberLogoutService {
    private BookBorrowPeopleDAO bookBorrowPeopleDAO = new BookBorrowPeopleDAO();
    public boolean logoutMember(String userId,String pwd){
        if(bookBorrowPeopleDAO.update("delete from bookborrowpeople where bbpId = ? and pwd=md5(?)",userId,pwd)!=-1){
            return true;
        }
        return false;
    }
}
