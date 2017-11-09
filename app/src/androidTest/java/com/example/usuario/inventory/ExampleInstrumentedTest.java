package com.example.usuario.inventory;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    /*@Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.usuario.inventory", appContext.getPackageName());
    }*/

    @Before
    public void Inicialize() {
    }

    @After
    public void Destruction() {

    }

    //1. el usuario introduce usuario/mail (instrumentales)
    @Test
    public void IsUserEmpty() throws  Exception{

    }


    //2. el usuario introduce una contraseña(instrumentales)
    @Test
    public void IsPasswordEmpty() throws  Exception{

    }

    //4. La contraseña tiene que tener al menos 6 caracteres(instrumentales)
    @Test
    public void IsPasswordWith6char() throws  Exception{

    }
    //5. Que la contraseña sea correcta doble ab/ar ar/ab(instrumentales)
    @Test
    public void PasswordWithDoubleCheck() throws  Exception{

    }
}
