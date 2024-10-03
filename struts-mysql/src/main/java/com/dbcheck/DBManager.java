package com.dbcheck;

import javax.servlet.http.*;
import javax.sql.*;
import java.sql.*;
import java.util.*;

public class DBManager {
	private static DBManager db_m;

    public static synchronized DBManager getInstance() {
        if (db_m == null) {
			db_m = new DBManager();
		} 
        return db_m;
    }
    public boolean inputDBCheckData(DBCheckActionForm actionForm, DataSource dataSource) throws Exception {
        Connection con = null;
        PreparedStatement pst = null;

        try {
			con = dataSource.getConnection();
			pst = con.prepareStatement("INSERT INTO userInfo (userName, userId, userPwd) VALUES (?, ?, ?)");

			pst.setString(1, actionForm.getUserName());
            pst.setString(2, actionForm.getUserId());
            pst.setString(3, actionForm.getUserPwd());
			pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
