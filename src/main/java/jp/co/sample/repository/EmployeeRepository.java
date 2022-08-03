package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import jp.co.sample.domain.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	//自動的にDIされる
	private NamedParameterJdbcTemplate template;
	//DB操作に使用するテンプレートクラス
	
	final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs,i) -> {
	//フィールド部分に反映させる		
	Employee employee = new Employee();	
		
	employee.setId(rs.getInt("id"));
	employee.setName(rs.getString("name"));
	employee.setImage(rs.getString("image"));
	employee.setGender(rs.getString("gender"));
	employee.setHireDate(rs.getDate("hire_date"));	
	employee.setMailAddress(rs.getString("mailaddress"));
	employee.setZipCode(rs.getString("zipCode"));
	employee.setAddress(rs.getString("address"));
	employee.setTelephone(rs.getString("Telephone"));
	employee.setSalary(rs.getInt("salary"));
	employee.setCharacteristics(rs.getString("salarcharacteristics"));
	employee.setDependentsCount(rs.getInt("dependentsCount"));
	
	return employee;	
};
	
	public List<Employee> findAll(){
		
	String sql = "SELECT * FROM employees ORDER BY hireDate DESC;";
		
	List<Employee> employeeList=template.query(sql, EMPLOYEE_ROW_MAPPER);
		
	return employeeList;		
	}//findAll(){	
	
	public Employee load(Integer id) {
		
		String sql = "SELECT * FROM employees WHERE id=:id";	
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		Employee employee = template.queryForObject(sql, param,EMPLOYEE_ROW_MAPPER );
		
		return employee;	
	}
	
	
public Employee update(Employee employee) {
		
	SqlParameterSource param = new BeanPropertySqlParameterSource(employee);
	
	if(employee.getId()==null) {
		String sql = "UPDATE employees SET  name = :name,image = :image,gender = gender"
				+"hireDate = :hireDate,mailAddress = :mailAddress,zipCode = :zipCode"
				+"address = :address,telephone = :telephone,salary = :salary"
				+"characteristics = :characteristics,dependentsCount = :dependentsCount"
				+ " WHERE id=:id";	
		
		template.update(sql, param);
	}
		return  employee;
		
}
	
	
	
	
	
	
	
	
	
	
	
	
}


