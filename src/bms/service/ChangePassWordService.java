package bms.service;

import bms.dao.BookBorrowPeopleDAO;
import bms.domain.BookBorrowPeople;

/**
 * @author 赵天宇
 * @version 1.0
 */
public class ChangePassWordService {
    private BookBorrowPeopleDAO bookBorrowPeopleDAO = new BookBorrowPeopleDAO();

    //编写一个能够实现密码修改的方法
    public boolean changePwd(String userId, String oldPasswd, String newPassword) {
        BookBorrowPeople bookBorrowPeople = bookBorrowPeopleDAO.querySingle("select * from bookborrowpeople where bbpId = ? and pwd=md5(?)", BookBorrowPeople.class, userId, oldPasswd);
        if (bookBorrowPeople == null) {
            return false;
        }

        if (bookBorrowPeopleDAO.update("update bookborrowpeople set pwd=md5(?) where bbpId = ? and pwd=md5(?)", newPassword, userId, oldPasswd) != -1) {
            return true;
        }
        return false;


    }
}
