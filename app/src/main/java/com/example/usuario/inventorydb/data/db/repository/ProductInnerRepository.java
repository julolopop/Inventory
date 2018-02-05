package com.example.usuario.inventorydb.data.db.repository;

import com.example.usuario.inventorydb.data.db.dao.ProductDao;
import com.example.usuario.inventorydb.pojo.Productos;
import com.example.usuario.inventorydb.pojo.ProductosInner;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductInnerRepository {

    private static ProductInnerRepository productRepository;

    static {
        productRepository = new ProductInnerRepository();
    }

    private ProductDao productDao;

    private ProductInnerRepository() {
        productDao = new ProductDao();
    }


    public static ProductInnerRepository getInstance() {
        if (productRepository == null)
            productRepository = new ProductInnerRepository();
        return productRepository;
    }

    public ArrayList<ProductosInner> getProduct(String shortName) {
        return productDao.loadProducto(shortName);
    }
}
