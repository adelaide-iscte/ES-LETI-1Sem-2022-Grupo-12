package Grupo12.Projeto_ES;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({CalendarTest.class, ReuniaoTest.class })
public class AllTests {

}
