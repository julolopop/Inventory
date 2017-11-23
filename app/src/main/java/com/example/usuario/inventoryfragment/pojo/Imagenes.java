package com.example.usuario.inventoryfragment.pojo;

/**
 * @Aurtor Juan Manuel Diaz Ortiz
 * @Version 1.0
 * @Descripcion Clase para grardar las imagenes que seran espuestas en el DashBoard
 */

public class Imagenes {

    private int img;
    private int id;

    public int getImg() {
        return img;
    }


    public int getId() {
        return id;
    }

    public Imagenes(int img, int id) {
        this.img = img;
        this.id = id;
    }
}
