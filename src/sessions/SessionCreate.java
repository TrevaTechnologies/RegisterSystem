package sessions;

import java.util.Date;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Akshai
 */
public class SessionCreate {

    public static Session adminses = null, session = null, adminses1 = null;

    public static SessionFactory factory;
    public static int status = 0;
    //for user login (must set for all users)
    public static int userid = 0, PROFILELINK = 0, deptid = 0, usergpid = 0;
    public static String fnm = null, mnm = null, lnm = null, fullname = null, username = null, deptname = null, degree = null, designation = null;
    public static Date session_startime = null, session_closetime = null;
    //location and module
    public static int locationid = 0, moduleid = 0, terminalid = 0;
    public static String location = null, module = null, terminal = null;
    //for doctors and nurse
    public static int docid = 0, nurseid = 0, docdeptid = 0, nursedeptid = 0, DOCPROFILELINK = 0, NURSEPROFILELINK = 0;
    public static String docname = null, nursename = null, docusername = null, nurseusername = null, docdept = null, nursedept = null, docdegree = null, nursedegree = null, docdesignation = null, nursedesignation = null;

    public SessionCreate() {
        Configuration c = new Configuration();
        c.configure("/hibernate.cfg.xml");
        try {
            factory = c.buildSessionFactory();
            status = 1;
            System.out.println("session created");
        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(null, "Server Connection Error : Contact @dmin", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            status = 0;
            System.exit(0);
        }
    }
}
