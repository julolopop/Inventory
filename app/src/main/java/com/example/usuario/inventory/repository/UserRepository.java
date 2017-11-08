package com.example.usuario.inventory.repository;

import com.example.usuario.inventory.pojo.Sector;
import com.example.usuario.inventory.pojo.User;

import java.util.ArrayList;

/**
 * @Aurtor Juan Manuel Diaz Ortiz
 * @Version 1.0
 * @Descripcion Creacion del array de Dependencias
 */

public class UserRepository {
    //declaración
    ArrayList<User> users;

    private static UserRepository userRepository;

    //Inicialización
    //inicialización de todos los atributos de ámbito stático o de la clase
    static {
        userRepository = new UserRepository();
    }

    /**
     * El metodo tiene que se privado para asegurar que siempre se ejecute
     */
    private UserRepository() {
        this.users = new ArrayList<>();
        Initialize();
    }


    //Metodos

    public void Initialize() {
        addUser(new User(1, "Juanma", "123", "juanma",
                "jm@gmail.com", true, true));
        addUser(new User(2, "Juanma2", "123", "juanma2",
                "jm2@gmail.com", false, false));
        addUser(new User(3, "Juanma3", "123", "juanma3",
                "jm3@gmail.com", false, true));
        addUser(new User(4, "Juanma4", "123", "juanma4",
                "jm4@gmail.com", true, false));
        addUser(new User(5, "Juanma5", "123", "juanma5",
                "jm5@gmail.com", true, false));
        addUser(new User(6, "Juanma6", "123", "juanma6",
                "jm6@gmail.com", false, true));
        addUser(new User(7, "Juanma7", "123", "juanma7",
                "jm7@gmail.com", false, false));
        addUser(new User(8, "Juanma8", "123", "juanma8",
                "jm8@gmail.com", true, true));
        addUser(new User(9, "Juanma9", "123", "juanma9",
                "jm9@gmail.com", true, false));


    }

    //patrón sigletón
    public static UserRepository getInstance() {
        if (userRepository == null)
            userRepository = new UserRepository();
        return userRepository;
    }

    /**
     * @param user
     */
    public void addUser(User user) {
        this.users.add(user);
    }


}
