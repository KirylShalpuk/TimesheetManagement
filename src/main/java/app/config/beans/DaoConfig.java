package app.config.beans;


<<<<<<< HEAD
=======

import app.dao.CompanyDao;
import app.dao.EmployeeDao;
import app.dao.LogsDao;
import app.dao.ProjectDao;
import app.dao.impl.CompanyDaoImpl;
import app.dao.impl.EmployeeDaoImpl;
import app.dao.impl.ProjectDaoImpl;
>>>>>>> 3096cc76bff10e24c8a38359f8e8d14529959644
import app.dao.*;
import app.dao.impl.*;
import app.entities.Company;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {

    @Bean
    public BasicCrudDao<Company> getCompanyDao() {
        return new CompanyDaoImpl();
    }

    @Bean
    public EmployeeDao getEmployeeDao() {
        return new EmployeeDaoImpl();
    }

    @Bean
    public LogsDao getLogsDao() {
        return new LogsDaoImpl();
    }

    @Bean
    public ProjectDao getProjectDao() {
        return new ProjectDaoImpl();
    }

    @Bean
<<<<<<< HEAD
=======
    public AssignmentDao getAssignmentDao() {
        return new AssignmentDaoImpl();
    }

>>>>>>> 3096cc76bff10e24c8a38359f8e8d14529959644
    public InvitationDao getInvitationDao(){
        return new InvitationDaoImpl();
    }

    @Bean
    public AssignmentDao getAssignmentDao() {
        return new AssignmentDaoImpl();
    }
<<<<<<< HEAD

    @Bean
    public NotificationDaoImpl getNotificationDao() {
        return new NotificationDaoImpl();
    }

=======
>>>>>>> 3096cc76bff10e24c8a38359f8e8d14529959644
}
