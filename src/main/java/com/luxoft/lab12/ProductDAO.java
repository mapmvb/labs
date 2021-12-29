package com.luxoft.lab12;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public static final String DB_DRIVER = "org.h2.Driver";
    public static final String DB_CONNECTION_URL = "jdbc:h2:D:\\Обучение\\Trainings\\SQA\\SQA-049\\2020-03-30\\test";
    public static final String DB_USER = "sa";
    public static final String DB_PASSWORD = "";

    private Connection getConnection() throws Exception {
        // load DB driver
        try {
            Class.forName(DB_DRIVER).newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your H2 JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return null;
        }

        return DriverManager.getConnection(DB_CONNECTION_URL,DB_USER,DB_PASSWORD);
    }

    public void createTable() {
        String createTableSQL = "CREATE TABLE products( " +
                "id INTEGER NOT NULL, " +
                "description VARCHAR(20) NOT NULL, " +
                "rate FLOAT NOT NULL, " +
                "quantity INTEGER NOT NULL, " +
                " PRIMARY KEY (ID) )";
        performSQL(createTableSQL, "CreateTable");
    }

    public void dropTable() {
        String dropTableSQL = " DROP TABLE PRODUCTS";
        performSQL(dropTableSQL, "DropTable");
    }

     private void performSQL(String command, String commandName) {
        try (Connection con = this.getConnection();
             Statement st = con.createStatement()){
           st.execute(command);
            System.out.printf("Command %s performed!%n", commandName);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public List<Product> getProductById(int id) throws Exception{
        String selectTableSQL = "SELECT description, rate, quantity "+
                                "FROM products "+
                                " WHERE id = ?";

        List<Product> products = new ArrayList<>();
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement(selectTableSQL);
        st.setInt(1,id);

        ResultSet rs = st.executeQuery();

        Product product;
        while (rs.next()){
            product = new Product(
                    id,
                    rs.getString(1),
                    rs.getFloat(2),
                    rs.getInt(3)
            );
            products.add(product);
        }

        rs.close();
        con.close();
        return products;
    }

    public void addProduct(Product product) throws Exception {
        String insertTableSQL = "INSERT INTO products"
                + "(id, description, rate, quantity) "
                + "VALUES"
                + "(?, ?, ?, ?)";
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(insertTableSQL);

        st.setInt(1,product.getId());
        st.setString(2, product.getDescription());
        st.setFloat(3, product.getRate());
        st.setInt(4, product.getQuantity());

        int count = st.executeUpdate();
        System.out.printf("%d record(s) is added in products table%n", count);

        con.close();
    }

    public void setProduct(Product product) throws Exception {
        String updateTableSQL = "UPDATE products"
                + " SET description = ?, rate = ?, quantity = ?"
                + " WHERE id  = ?";

        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(updateTableSQL);

        st.setString(1, product.getDescription());
        st.setFloat(2, product.getRate());
        st.setInt(3, product.getQuantity());
        st.setInt(4, product.getId());

        int count = st.executeUpdate();
        System.out.printf("%d record(s) is updated in products table%n", count);

        con.close();
    }

    public void removeProduct(int id) throws Exception {
        String deleteTableSQL = "DELETE products WHERE id = ?";
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(deleteTableSQL);

        st.setInt(1, id);

        int count = st.executeUpdate();
        System.out.printf("%d record(s) is deleted in products table%n", count);

        con.close();
    }
}


