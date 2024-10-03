package com.dbcheck;

import org.apache.struts.action.*;
import javax.servlet.http.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.*;
import java.sql.*;
import java.util.*;

public class DBCheckAction extends Action {
	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse response) throws Exception {
		// req.setAttribute("dbCheckObj", form);
		// return mapping.findForward("dbResult");
		DataSource dataSource = null;
		// Connection con = null;
		// PreparedStatement pst = null;
		// if (dataSource == null) {
		// 	dataSource = getDataSource(req, "mysql");
		// }
		try {
            InitialContext ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/MySQLDataSource"); // JNDI lookup
        } catch (NamingException e) {
            e.printStackTrace();
            return mapping.findForward("dbFail");
        }
		DBCheckActionForm dbcheckActionForm = (DBCheckActionForm) form;
		DBManager manager = DBManager.getInstance();
		if(manager.inputDBCheckData(dbcheckActionForm, dataSource)) {
			return mapping.findForward("dbSuccess");
		} else {
			return mapping.findForward("dbFail");
		}
	}
}