package cholog;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class QueryingDAO {
    private final RowMapper<Customer> rowMapper = (resultSet, rowNum) -> new Customer(
            resultSet.getLong("id"),
            resultSet.getString("first_name"),
            resultSet.getString("last_name")
    );

    private JdbcTemplate jdbcTemplate;

    public QueryingDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * public <T> T queryForObject(String sql, Class<T> requiredType) -> 조회 결과 매핑할 클래스 타입
     */
    public int count() {
        //TODO : customers 디비에 포함되어있는 row가 몇개인지 확인하는 기능 구현
        return jdbcTemplate.queryForObject("select count(*) from customers", Integer.class);
    }

    /**
     * public <T> T queryForObject(String sql, Class<T> requiredType, @Nullable Object... args) -> 쿼리문에 바인딩할 파라미터
     */
    public String getLastName(Long id) {
        //TODO : 주어진 Id에 해당하는 customers의 lastName을 반환
        return jdbcTemplate.queryForObject("select last_name from customers where id = ?", String.class, id);
    }

    /**
     * public <T> T queryForObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args)
     */
    public Customer findCustomerById(Long id) {
        String sql = "select id, first_name, last_name from customers where id = ?";
        //TODO : 주어진 Id에 해당하는 customer를 객체로 반환
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    /**
     * public <T> List<T> query(String sql, RowMapper<T> rowMapper)
     */
    public List<Customer> findAllCustomers() {
        String sql = "select id, first_name, last_name from customers";
        //TODO : 저장된 모든 Customers를 list형태로 반환
        return jdbcTemplate.query(sql, rowMapper);
    }

    /**
     * public <T> List<T> query(String sql, RowMapper<T> rowMapper, @Nullable Object... args)
     */
    public List<Customer> findCustomerByFirstName(String firstName) {
        String sql = "select id, first_name, last_name from customers where first_name = ?";
        //TODO : firstName을 기준으로 customer를 list형태로 반환
        return jdbcTemplate.query(sql, rowMapper, firstName);
    }
}
