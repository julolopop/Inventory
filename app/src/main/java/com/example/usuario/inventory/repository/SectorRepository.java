package com.example.usuario.inventory.repository;

import com.example.usuario.inventory.pojo.Dependency;
import com.example.usuario.inventory.pojo.Sector;

import java.util.ArrayList;

/**
 * @Aurtor Juan Manuel Diaz Ortiz
 * @Version 1.0
 * @Descripcion Creacion del array de Dependencias
 */

public class SectorRepository {
    //declaración
    ArrayList<Sector> sectors;

    private static SectorRepository sectorRepository;

    //Inicialización
    //inicialización de todos los atributos de ámbito stático o de la clase
    static {
        sectorRepository = new SectorRepository();
    }

    /**
     *El metodo tiene que se privado para asegurar que siempre se ejecute
     */
    private SectorRepository() {
        this.sectors = new ArrayList<>();
        Initialize();
    }


    //Metodos

    public void Initialize() {
        addSectors(new Sector(1,"Armario1","ARM1","Zona para guardar cosas",
                1,true,true));
        addSectors(new Sector(2,"Armario2","ARM2","Zona para guardar cosas",
                2,true,true));
        addSectors(new Sector(3,"Armario3","ARM3","Zona para guardar cosas",
                3,true,true));
        addSectors(new Sector(4,"Armario4","ARM4","Zona para guardar cosas",
                4,true,true));
        addSectors(new Sector(5,"Armario5","ARM5","Zona para guardar cosas",
                5,true,true));
        addSectors(new Sector(6,"Armario6","ARM6","Zona para guardar cosas",
                6,true,true));

    }

    //patrón sigletón
    public static SectorRepository getInstance(){
        if (sectorRepository == null)
            sectorRepository = new SectorRepository();
        return sectorRepository;
    }

    /**
     * Metodo que añade una dependencia
     *
     * @param sectors
     */
    public void addSectors(Sector sectors) {
        this.sectors.add(sectors);
    }

    public ArrayList<Sector> getSectors() {
        return this.sectors;
    }
}
