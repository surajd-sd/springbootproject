package ServiceImpl;
//5
import Model.Employee;
import Payload.EmployeeDto;
import Repository.EmployeeRepo;
import Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee=this.dtoToEmployee(employeeDto);
        Employee savedEmployee=this.employeeRepo.save(employee);
        return this.employeeToDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Integer employeeId) {
        Optional<Employee> employee=this.employeeRepo.findById(employeeId);
        if(Optional.empty().isPresent()){
            return this.employeeToDto(employee.get());
        }
        return null;
    }

    private Employee dtoToEmployee(EmployeeDto employeeDto){
        Employee emp=new Employee();
        emp.setEmployeeId(employeeDto.getEmployeeId());
        emp.setEmployeeName(employeeDto.getEmployeeName());
        return emp;
    }

    public EmployeeDto employeeToDto(Employee employee){
        EmployeeDto employeeDto=new EmployeeDto();
        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setEmployeeName(employee.getEmployeeName());
        return employeeDto;
    }
}
