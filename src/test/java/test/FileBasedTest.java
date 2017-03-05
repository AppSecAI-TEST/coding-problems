package test;

import org.junit.Assert;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

/**
 * Utility class which allows to test the application using a set of files with inputs
 * and match the actual output against set of files with expected outputs.
 *
 * @author Yaroslav
 * @since 04-Mar-17
 */
public class FileBasedTest {

    public static void execute(Class<?> testClass,
                               Class<?> targetClass,
                               String inFile, String outFile) throws Exception {
        String input = readFileToString(testClass, inFile);
        String expected = readFileToString(testClass, outFile);
        String actual = execute(targetClass, input);
        Assert.assertEquals("The actual and expected outputs do not match", expected.trim(), actual.trim());
    }

    private static String execute(Class<?> targetClass, String input) throws IOException,
            URISyntaxException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        InputStream sysIn = System.in;
        PrintStream sysOut = System.out;
        String result;
        try {
            // set input stream
            ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
            System.setIn(bais);

            // set output stream
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            System.setOut(ps);

            // execute the program
            Method mainMethod = targetClass.getMethod("main", String[].class);
            mainMethod.invoke(null, (Object) null);
            result = baos.toString();
        } finally {
            // reset input and output streams
            System.setOut(sysOut);
            System.setIn(sysIn);
        }

        return result;
    }

    private static String readFileToString(Class testClass, String fileName) throws IOException, URISyntaxException {
        java.net.URL url = testClass.getResource(fileName);
        java.nio.file.Path resPath = java.nio.file.Paths.get(url.toURI());
        return new String(java.nio.file.Files.readAllBytes(resPath), "UTF8");
    }
}
