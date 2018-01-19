package com.example.usuario.inventoryfragment;

import com.example.usuario.inventoryfragment.pojo.User;
import com.example.usuario.inventoryfragment.data.db.repository.UserRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    ArrayList<User> users;
    @Mock
    UserRepository userRepository;

    @Before
    public void Inicialize() {
        users = new ArrayList<>();
        userRepository = mock(UserRepository.class);

        users.add(new User(1, "Juanma", "123", "juanma",
                "jm@gmail.com", true, true));
        users.add(new User(2, "Juanma2", "123", "juanma2",
                "jm2@gmail.com", false, false));
        users.add(new User(3, "Juanma3", "123", "juanma3",
                "jm3@gmail.com", false, true));
        users.add(new User(4, "Juanma4", "123", "juanma4",
                "jm4@gmail.com", true, false));
        users.add(new User(5, "Juanma5", "123", "juanma5",
                "jm5@gmail.com", true, false));
        users.add(new User(6, "Juanma6", "123", "juanma6",
                "jm6@gmail.com", false, true));
        users.add(new User(7, "Juanma7", "123", "juanma7",
                "jm7@gmail.com", false, false));
        users.add(new User(8, "Juanma8", "123", "juanma8",
                "jm8@gmail.com", true, true));
        users.add(new User(9, "Juanma9", "123", "juanma9",
                "jm9@gmail.com", true, false));

    }

    @After
    public void Destruction() {
        users = null;
        userRepository=null;
    }

    @Test
    public void IsUserExits_isCorrect() throws Exception {
        //3. el usuario exista en la base de datos  (Repository)
        //para realizar esta prueba se tiene que probar dos objetos de tipo user
        /*User user = new User(1, "Juanma", "123", "juanma",
                "jm@gmail.com", true, true);
        assertEquals(user, users.get(0));*/

        //cuando se llame el metodos IsUserExits , devuelva un valor predeterminado
        when(userRepository.IsUserExits(users.get(0))).thenReturn(true);

        assertTrue(userRepository.IsUserExits(users.get(0)));
    }


    @Test
    public void GetUser_isCorrect(){
        when(userRepository.GetUsers()).thenReturn(users);

        assertEquals(users.get(0),userRepository.GetUsers().get(0));
    }

    public void Password_isCorrect() {
        //4. Que la contraseña sea correcta (Repository)

        when(userRepository.GetUsers()).thenReturn(users);

        assertEquals(users.get(0).getPassword(),userRepository.GetUsers().get(0).getPassword());
    }

    @Test
    public void SingIn_isCorrect() throws Exception {
        //assertEquals(4, 2 + 2);






    }

    @Test
    public void SingUp_isCorrect() throws Exception {
        //assertEquals(4, 2 + 2);

        //1. el usuario introduce usuario(instrumentales)

        //2. el usuario introduce una contraseña(instrumentales)

        //3. el usuario no exista en la base de datos  (Repository)

        //4. La contraseña tiene que tener al menos 6 caracteres(instrumentales)

        //5. Que la contraseña sea correcta doble ab/ar ar/ab(instrumentales)

        //6. que mail no existe en la base de datos (Repository)
    }
}