package com.example.usuario.inventoryprovaider.provaider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by usuario on 5/02/18.
 */

public class InventoryProvaiderContract {
    public static final String  AUTHORITY = "com.example.usuario.inventoryprovaider";
    public static final Uri AUTHORITY_URI = Uri.parse("Content://"+AUTHORITY);

    private InventoryProvaiderContract(){

    }

    public static class Dependency implements BaseColumns{
        public static final String CONTENT_PATH="dependency";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(InventoryProvaiderContract.AUTHORITY_URI,CONTENT_PATH);

        public static final String NAME = "name";
        public static final String SORTNAME = "sortname";
        public static final String DESCRIPTION = "description";
        public static final String IMAGE = "imageName";

        public static final String[] ALL_COLUMNS = new String[]{_ID, NAME, SORTNAME, DESCRIPTION, IMAGE};
    }


    public static class Sector implements BaseColumns{
        public static final String CONTENT_PATH="sector";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(InventoryProvaiderContract.AUTHORITY_URI,CONTENT_PATH);

        public static final String DEPENDENCY_ID = "dependencyId";
        public static final String NAME = "name";
        public static final String SORTNAME = "sortName";
        public static final String DESCRIPTION = "description";
        public static final String ENABLE = "isEnable";
        public static final String SECTOR_DEFAULT = "isSectorDeafault";

        public static final String[] ALL_COLUMNS = new String[]{_ID, DEPENDENCY_ID, NAME, SORTNAME, DESCRIPTION,
                ENABLE, SECTOR_DEFAULT};


    }

    public static class Category implements BaseColumns{
        public static final String CONTENT_PATH="category";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(InventoryProvaiderContract.AUTHORITY_URI,CONTENT_PATH);

        public static final String NAME = "name";
        public static final String SORTNAME = "sortname";
        public static final String DESCRIPTION = "description";

        public static final String[] ALL_COLUMNS = new String[]{
                _ID, NAME, SORTNAME, DESCRIPTION
        };


    }

    public static class Subcategory implements BaseColumns{
        public static final String CONTENT_PATH="subcategory";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(InventoryProvaiderContract.AUTHORITY_URI,CONTENT_PATH);

        public static final String NAME = "name";
        public static final String SORTNAME = "sortname";
        public static final String DESCRIPTION = "description";

        public static final String[] ALL_COLUMNS = new String[]{
                _ID, NAME, SORTNAME, DESCRIPTION
        };


    }

    public static class ProductClass implements BaseColumns{
        public static final String CONTENT_PATH="productClass";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(InventoryProvaiderContract.AUTHORITY_URI,CONTENT_PATH);

        public static final String DESCRIPTION = "description";

        public static final String[] ALL_COLUMNS = new String[]{
                _ID, DESCRIPTION
        };


    }

    public static class Product implements BaseColumns{
        public static final String CONTENT_PATH="product";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(InventoryProvaiderContract.AUTHORITY_URI,CONTENT_PATH);
        
        public static final String SERIAL = "serial";
        public static final String MODELCODE = "modelCode";
        public static final String SORTNAME = "shortname";
        public static final String DESCRIPTION = "description";
        public static final String CATEGORYID = "categoryID";
        public static final String SUBCATEGORY = "subcategory";
        public static final String PRODUCTCLASS = "productClass";
        public static final String SECTOR = "sector";
        public static final String QUANTITY = "quantity";
        public static final String VALUE = "value";
        public static final String VENDOR = "vendor";
        public static final String BITMAP = "bitmap";
        public static final String IMAGENAME = "imageName";
        public static final String URL = "url";
        public static final String DATEPURCHASE = "datePurchase";
        public static final String NOTES = "notes";


        public static final String C = "category";
        public static final String CNAME = "name";

        public static final String SC = "subcategory";
        public static final String SCNAME = "name";


        public static final String P = "productClass";
        public static final String PDESCRIPTION = "description";

        public static final String S = "sector";
        public static final String SNAME = "name";


        public static final String[] ALL_COLUMNS = new String[]{
                _ID,
                SERIAL,
                MODELCODE,
                SORTNAME,
                DESCRIPTION,
                CNAME,
                SCNAME,
                PDESCRIPTION,
                SNAME,
                QUANTITY,
                VALUE,
                VENDOR,
                BITMAP,
                IMAGENAME,
                URL,
                DATEPURCHASE,
                NOTES
        };


    }

}
