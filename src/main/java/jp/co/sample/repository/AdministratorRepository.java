package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
@Controller
@Repository
@RequestMapping("/AdministratorRepository")
public class AdministratorRepository {

	
	@Autowired
	//自動的にDIされる
	private NamedParameterJdbcTemplate template;
	//DB操作に使用するテンプレートクラス
	
final RowMapper<Administrator> EMPLOYEE_ROW_MAPPER = (rs,i) -> {
		
		Administrator administrator = new Administrator();	
		
		administrator.setId(rs.getInt("id"));
		administrator.setName(rs.getString("name"));
		administrator.setMailAddress(rs.getString("mailAddress"));
		administrator.setPassword(rs.getString("password"));
		
		return administrator;
		
	};//ラムダ式の最後は};にする
	
	
	
	@RequestMapping("/AdministratorRepository1")
	public void insert(Administrator addministrator) {//管理者情報を挿入する
	
		String sql = "SELECT * FROM 	administrator";
		
		SqlParameterSource param	 = new MapSqlParameterSource();
		
		Administrator result = template.queryForObject(sql, param,EMPLOYEE_ROW_MAPPER );
			
		System.out.println("result"+result);
	}
	
	@RequestMapping("/AdministratorRepository2")
public Administrator findByMailAddressAndPassword(String mailAddress,String password) {
	
	String sql = "SELECT id,name,mailAddress,password FROM administrator WHERE mailAddress=:mailAddress OR password=:password";	
			
	SqlParameterSource param	 = new MapSqlParameterSource().addValue("mailAddress", mailAddress).addValue("password", password);
		
	//SqlParameterSource param;
	//String sql;
	List administratorList = template.queryForObject(sql, param,List.class);
	
	if(administratorList.size()==0) {
		
		return null;
	}
	return (Administrator) administratorList;
}	

	
}
