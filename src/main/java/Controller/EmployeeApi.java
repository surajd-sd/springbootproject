package Controller;
//6
import Payload.EmployeeDto;
import Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeApi {

    @Autowired
    private EmployeeService employeeService;


    //post employee
    @PostMapping("/test")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
       EmployeeDto createdEmployee= this.employeeService.createEmployee(employeeDto);
       return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }
    //get employee
    @GetMapping("/test/{employeeId}")
    public ResponseEntity<EmployeeDto> getById(@PathVariable Integer employeeId){
        //return this.employeeService.getEmployeeById(employeeId)
        return ResponseEntity.ok(this.employeeService.getEmployeeById(employeeId));
    }
}
