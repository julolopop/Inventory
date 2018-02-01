package com.example.usuario.inventorydb.data.db.repository;

import com.example.usuario.inventorydb.data.db.dao.ProductDao;
import com.example.usuario.inventorydb.pojo.Productos;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductRepository {

    private static ProductRepository productRepository;

    static {
        productRepository = new ProductRepository();
    }

    private ProductDao productDao;

    private ProductRepository() {
        productDao = new ProductDao();
    }


    public static ProductRepository getInstance() {
        if (productRepository == null)
            productRepository = new ProductRepository();
        return productRepository;
    }

    public ArrayList<Productos> getProducts() {
        return productDao.loadAll();
    }

    public void addProduct(Productos product) {
        long id = productDao.add(product);
    }

    public ArrayList<Productos> getProduct(String shortName) {
        return productDao.loadProducto(shortName);
    }
}
