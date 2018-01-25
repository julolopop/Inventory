package com.example.usuario.inventorydb.data.db.model;

import android.provider.BaseColumns;

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
                "no tengo imagen")+
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
                BaseColumns._ID, COLUMN_NAME, COLUMN_SHORTNAME, COLUMN_DESCRIPTION, COLUMN_DEPENDENCYID,COLUMN_ENABLE,COLUMN_DEFAULSTATE
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
                0)+
                String.format(",('%s','%s','%s',%s,%s,%s);",
                        "Armario2",
                        "ARM2",
                        "Zona para guardar cosas",
                        2,
                        0,
                        0);
    }


}
