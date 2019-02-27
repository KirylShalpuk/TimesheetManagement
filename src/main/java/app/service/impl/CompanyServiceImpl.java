package app.service.impl;

import app.dao.factory.FactoryDao;
import app.entities.Company;
import app.entities.Employee;
import app.entities.Project;
import app.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Override
    public void addEmployee(Company company, Employee employee) {
        company.addEmployee(employee);
    }

    @Override
    public void addProject(Company company, Project project) {
        company.addProject(project);
    }

    @Override
    public List<Employee> getEmployees(Company company) {
        return company.getEmployees();
    }

    @Override
    public List<Project> getProjects(Company company) {
        return company.getProjects();
    }

    @Override
    public Company findById(int id) {
        return FactoryDao.getInstance().getCompanyDao().findById(id);
    }

    @Override
    public void save(Company company) {
        FactoryDao.getInstance().getCompanyDao().save(company);
    }

    @Override
    public void delete(Company company) {
        FactoryDao.getInstance().getCompanyDao().delete(company);
    }


}
