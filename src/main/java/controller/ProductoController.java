package controller;

import dao.ProductoDAO;
import factory.ConnectionFactory;
import modelo.Precio;
import modelo.Producto;

import java.util.List;

public class ProductoController {
    private ProductoDAO productoDAO;

    public ProductoController(){
        var factory = new ConnectionFactory();
        this.productoDAO = new ProductoDAO(factory.recuperaConexion());
    }

    public List<Precio> listar() {
        return productoDAO.listar();
    }

}
