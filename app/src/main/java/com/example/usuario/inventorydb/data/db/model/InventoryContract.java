package com.example.usuario.inventorydb.data.db.model;

import android.graphics.Bitmap;
import android.provider.BaseColumns;

import java.util.Date;

/**
 * Created by usuario on 19/01/18.
 */

public class InventoryContract {

    private InventoryContract() {

    }

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "inventory.db";

    //por cada tabla se crea una clase que se implementa en la interfaz

    public static class DependencyEntry implements BaseColumns {
        public static final String TABLE_NAME = "dependency";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SHORTNAME = "shortname";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_IMAGENAME = "imageName";
        public static final String[] ALL_COLUMNS = new String[]{
                BaseColumns._ID, COLUMN_NAME, COLUMN_SHORTNAME, COLUMN_DESCRIPTION, COLUMN_IMAGENAME
        };
        public static final String DEFAULT_ORDER = "name";
        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NO NULL," +
                        "%s TEXT NO NULL," +
                        "%s TEXT NO NULL," +
                        "%s TEXT)",
                TABLE_NAME,
                BaseColumns._ID,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_IMAGENAME);
        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES ('%s','%s','%s','%s')",
                TABLE_NAME,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_IMAGENAME,
                "Aula de 2cfgc",
                "2cfgs",
                "aula de los repos",
                "no tengo imagen") +
                String.format(",('%s','%s','%s','%s');",
                        "Aula de 1cfgc",
                        "1cfgs",
                        "aula de los repos",
                        "no tengo imagen");
    }


    public static class SectorEntry implements BaseColumns {
        public static final String TABLE_NAME = "sector";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SHORTNAME = "shortname";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_DEPENDENCYID = "dependencyid";
        public static final String COLUMN_ENABLE = "enable";
        public static final String COLUMN_DEFAULSTATE = "defaulstate";
        public static final String[] ALL_COLUMNS = new String[]{
                BaseColumns._ID, COLUMN_NAME, COLUMN_SHORTNAME, COLUMN_DESCRIPTION, COLUMN_DEPENDENCYID, COLUMN_ENABLE, COLUMN_DEFAULSTATE
        };
        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NO NULL," +
                        "%s TEXT NO NULL," +
                        "%s TEXT NO NULL," +
                        "%s INTEGER NO NULL," +
                        "%s INTEGER NO NULL," +
                        "%s INTEGER NO NULL)",
                TABLE_NAME,
                BaseColumns._ID,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_DEPENDENCYID,
                COLUMN_ENABLE,
                COLUMN_DEFAULSTATE);
        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s (%s,%s,%s,%s,%s,%s) VALUES ('%s','%s','%s',%s,%s,%s)",
                TABLE_NAME,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_DEPENDENCYID,
                COLUMN_ENABLE,
                COLUMN_DEFAULSTATE,
                "Armario1",
                "ARM1",
                "Zona para guardar cosas",
                1,
                0,
                0) +
                String.format(",('%s','%s','%s',%s,%s,%s);",
                        "Armario2",
                        "ARM2",
                        "Zona para guardar cosas",
                        2,
                        0,
                        0);
    }


    public static class ProductosEntry implements BaseColumns {
        public static final String TABLE_NAME = "productos";
        public static final String COLUMN_SERIAL = "serial";
        public static final String COLUMN_MODELCODE = "modelcode";
        public static final String COLUMN_SHORTNAME = "shortname";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_CATEGORIA = "categoria";
        public static final String COLUMN_SUBCATEGORIA = "subcategoria";
        public static final String COLUMN_PRODUCCLASS = "productosclass";
        public static final String COLUMN_SECTOR = "sector";
        public static final String COLUMN_CANTIDAD = "cantidad";
        public static final String COLUMN_VALOR = "valor";
        public static final String COLUMN_VENDEDOR = "vendor";
        public static final String COLUMN_BITMAP = "bitmap";
        public static final String COLUMN_BASE64 = "imagebase64";
        public static final String COLUMN_NAME = "imageName";
        public static final String COLUMN_URI = "uri";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_NOTAS = "notas";

        public static final String[] ALL_COLUMNS = new String[]{
                BaseColumns._ID, COLUMN_SERIAL, COLUMN_MODELCODE, COLUMN_SHORTNAME, COLUMN_DESCRIPTION, COLUMN_CATEGORIA,
                COLUMN_SUBCATEGORIA, COLUMN_PRODUCCLASS, COLUMN_SECTOR, COLUMN_CANTIDAD, COLUMN_VALOR, COLUMN_VENDEDOR,
                COLUMN_BITMAP, COLUMN_BASE64, COLUMN_NAME, COLUMN_URI, COLUMN_DATE, COLUMN_NOTAS

        };
        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NO NULL," +
                        "%s TEXT NO NULL," +
                        "%s TEXT NO NULL," +
                        "%s TEXT NO NULL," +
                        "%s INTEGER NO NULL," +
                        "%s INTEGER NO NULL," +
                        "%s INTEGER NO NULL," +
                        "%s INTEGER NO NULL," +
                        "%s INTEGER NO NULL," +
                        "%s INTEGER NO NULL," +
                        "%s DOUBLE NO NULL," +
                        "%s BLOB NO NULL," +
                        "%s TEXT NO NULL," +
                        "%s TEXT NO NULL," +
                        "%s TEXT NO NULL," +
                        "%s NUMERIC NO NULL," +
                        "%s TEXT NO NULL)",
                TABLE_NAME,
                BaseColumns._ID,
                COLUMN_SERIAL,
                COLUMN_MODELCODE,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_CATEGORIA,
                COLUMN_SUBCATEGORIA,
                COLUMN_PRODUCCLASS,
                COLUMN_SECTOR,
                COLUMN_CANTIDAD,
                COLUMN_VALOR,
                COLUMN_VENDEDOR,
                COLUMN_BITMAP,
                COLUMN_BASE64,
                COLUMN_NAME,
                COLUMN_URI,
                COLUMN_DATE,
                COLUMN_NOTAS);

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s " +
                        "VALUES (NULL,'%s','%s','%s','%s',%s,%s,%s,%s,%s,'%s','%s','%s','%s','%s','%s','%s','%s')",
                TABLE_NAME,
                "serial",
                "modelo",
                "corto",
                "des",
                1,
                1,
                1,
                0,
                1,
                "vendedor",
                "aa",
                "ima",
                "imas",
                "as",
                new Date(),
                "as") +
                String.format(",(NULL,'%s','%s','%s','%s',%s,%s,%s,%s,%s,'%s','%s','%s','%s','%s','%s','%s','%s')",
                        "serial1",
                        "modelo1",
                        "corto1",
                        "des1",
                        1,
                        1,
                        1,
                        0,
                        1,
                        "vendedor1",
                        "aa1",
                        "ima1",
                        "imas1",
                        "as1",
                        new Date(),
                        "as1");
    }

}
