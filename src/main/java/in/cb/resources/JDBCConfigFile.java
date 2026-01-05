package in.cb.resources;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JDBCConfigFile {

	private final String URL = "jdbc:mysql://localhost:3306/profile_manager";
	private final String USER = "root";
	private final String PASS = "root";
	
	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl(URL);
		source.setUsername(USER);
		source.setPassword(PASS);
		
		return source;
	}
	
	@Bean
	public JdbcTemplate geTemplate() {
		return new JdbcTemplate(getDataSource());
	}
	
}
