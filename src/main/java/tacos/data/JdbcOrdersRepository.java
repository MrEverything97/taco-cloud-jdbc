package tacos.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tacos.model.Orders;

import java.sql.ResultSet;
import java.sql.SQLException;
@Repository
public class JdbcOrdersRepository implements OrdersRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public JdbcOrdersRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Orders> findAll() {
        return jdbc.query("select id, deliveryName, deliveryStreet,deliveryCity,deliveryState,deliveryZip,ccNumber,ccExpiration,ccCVV,placedAt from Taco_order", this::mapRowToOrder);
    }


    @Override
    public Orders findById(String id) {
        return jdbc.queryForObject("select id, deliveryName, deliveryStreet,deliveryCity,deliveryState,deliveryZip,ccNumber,ccExpiration,ccCVV,placedAt from Taco_order where id=?", this::mapRowToOrder, id);
    }

    private Orders mapRowToOrder(ResultSet rs, int rowNum) throws SQLException {
        return new Orders(rs.getLong("id"),
                rs.getString("deliveryName"),
                rs.getString("deliveryStreet"),
                rs.getString("deliveryCity"),
                rs.getString("deliveryState"),
                rs.getString("deliveryZip"),
                rs.getString("ccNumber"),
                rs.getString("ccExpiration"),
                rs.getString("ccCVV"),
                rs.getDate("placedAt")
        );
    }

    @Override
    public Orders save(Orders orders) {
        jdbc.update("insert into Taco_order (id, deliveryName, deliveryStreet,deliveryCity,deliveryState,deliveryZip,ccNumber,ccExpiration,ccCVV) values (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                orders.getId(),
                orders.getName(),
                orders.getStreet(),
                orders.getCity(),
                orders.getState(),
                orders.getZip(),
                orders.getCcNumber(),
                orders.getCcExpiration(),
                orders.getCcCVV());
        return orders;
    }
}
