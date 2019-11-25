#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.testscenario;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ${package}.testscript.TestScript;

public class TestScenaio  {
TestScript script=new TestScript();

@Parameters({"browserType"})
@Test
public void setBrowser(String browserType) throws IOException {
	script.openBrowser(browserType);
}
}
