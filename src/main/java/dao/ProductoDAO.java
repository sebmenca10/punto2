package dao;

import modelo.Precio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private Connection con;

    public ProductoDAO(Connection con) {
        this.con = con;
    }

    public List<Precio> listar() {
        List<Precio> resultado = new ArrayList<>();

        try {
            var querySelected = "SELECT COD_PRODUCTO, PRECIO FROM LISTA_PRECIOS";
            System.out.println(querySelected);

            final PreparedStatement statement = con.prepareStatement(querySelected);
            try (statement) {
                final ResultSet resultSet = statement.executeQuery();
                try (resultSet) {
                    while (resultSet.next()) {
                        var producto = new Precio(resultSet.getString("COD_PRODUCTO"),
                                resultSet.getFloat("PRECIO"));
                        resultado.add(producto);
                    }
                }
                ;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }
}
