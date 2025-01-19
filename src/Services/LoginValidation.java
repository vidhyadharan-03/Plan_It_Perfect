package Services;

import DAO.UserDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginValidation {
    private int idCheck=0;
    private String nameCheck ="";
    private String collegeCheck=" ";
    private ResultSet rs;

    public LoginValidation(int id,String name , String college) throws SQLException {
        this.idCheck=id;
        this.nameCheck=name;
        this.collegeCheck=college;
        this.rs = UserDao.displayUniqueData(idCheck);
    }

    public boolean validationOfLogin()throws SQLException
    {
        rs.next();
        if((rs.getInt(1)==idCheck)&&((rs.getString(2).equalsIgnoreCase(nameCheck)))&&((rs.getString(3).equalsIgnoreCase(collegeCheck))))
            {
                return true;
            }
            return false;
    }


}
