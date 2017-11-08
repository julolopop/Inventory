package com.example.usuario.inventory;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void SingIn_isCorrect() throws Exception {
        //assertEquals(4, 2 + 2);

        //1. el usuario introduce usuario/mail

        //2. el usuario introduce una contraseña

        //3. el usuario exista en la base de datos  (Repository)

        //4. Que la contraseña sea correcta

    }

    @Test
    public void SingUp_isCorrect() throws Exception {
        //assertEquals(4, 2 + 2);

        //1. el usuario introduce usuario

        //2. el usuario introduce una contraseña

        //3. el usuario no exista en la base de datos  (Repository)

        //4. La contraseña tiene que tener al menos 6 caracteres

        //5. Que la contraseña sea correcta doble ab/ar ar/ab

        //6. que mail no existe en la base de datos (Repository)
    }
}