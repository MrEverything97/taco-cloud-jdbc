package tacos.data;


import tacos.model.Orders;

public interface OrdersRepository {
    Iterable<Orders> findAll();

    Orders findById(String id);

    Orders save(Orders orders);
}
