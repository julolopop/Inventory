package com.example.usuario.inventoryprovaider.data.db.repository;

import com.example.usuario.inventoryprovaider.data.db.dao.SubCategoryDao;
import com.example.usuario.inventoryprovaider.pojo.SubCategory;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class SubCategoryRepository {

    private static SubCategoryRepository subCategoryRepository;

    static {
        subCategoryRepository = new SubCategoryRepository();
    }

    private SubCategoryDao subCategoryDao;

    private SubCategoryRepository() {
        subCategoryDao = new SubCategoryDao();
    }


    public static SubCategoryRepository getInstance() {
        if (subCategoryRepository == null)
            subCategoryRepository = new SubCategoryRepository();
        return subCategoryRepository;
    }

    public ArrayList<SubCategory> getSubCategories() {
        return subCategoryDao.loadAll();
    }

    public void addcategory(SubCategory subCategory) {
        long id = subCategoryDao.add(subCategory);
    }


}
