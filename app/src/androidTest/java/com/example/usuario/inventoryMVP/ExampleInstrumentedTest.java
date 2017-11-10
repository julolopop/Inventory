package com.example.usuario.inventoryMVP;


import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;



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


    private void CheckSnackBarDisplayByMessage(int error) {
        onView(withText(error)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    //1. el usuario introduce usuario/mail (instrumentales)
    @Test
    public void IsUserEmpty() throws  Exception{
        onView(withId(R.id.btnSignIn)).perform(click());
        CheckSnackBarDisplayByMessage(R.string.ErrorUser);

    }



    //2. el usuario introduce una contraseña(instrumentales)
    @Test
    public void IsPasswordEmpty() throws  Exception{
        onView(withId(R.id.btnSignIn)).perform(click());
        CheckSnackBarDisplayByMessage(R.string.ErrorPassword);
    }

    //4. La contraseña tiene que tener al menos 6 caracteres(instrumentales)
    @Test
    public void IsPasswordWith6char() throws  Exception{
        onView(withId(R.id.edtUser)).perform(typeText("Juanma"),closeSoftKeyboard());
        onView(withId(R.id.edtPassword)).perform(typeText("Jua"),closeSoftKeyboard());
        onView(withId(R.id.btnSignIn)).perform(click());

        CheckSnackBarDisplayByMessage(R.string.ErrorpasswordLength);
    }
    //5. Que la contraseña sea correcta doble ab/ar ar/ab(instrumentales)
    @Test
    public void PasswordWithDoubleCheck() throws  Exception{

    }
}
