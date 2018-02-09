package com.example.usuario.inventoryprovaider.data.db.repository;

import com.example.usuario.inventoryprovaider.data.db.dao.ProductDao;
import com.example.usuario.inventoryprovaider.pojo.Productos;
import com.example.usuario.inventoryprovaider.pojo.ProductosInner;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductInnerRepository {

    private static ProductInnerRepository productRepository;

    static {
        productRepository = new ProductInnerRepository();
    }

    private IProductDao productDao;

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
