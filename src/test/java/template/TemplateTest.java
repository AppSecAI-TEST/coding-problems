package template;

import org.junit.Test;
import test.FileBasedTest;

/**
 * @author Yaroslav
 * @since 04-Mar-17
 */
public class TemplateTest {

    @Test
    public void runTest() throws Exception {
        FileBasedTest.execute(
                this.getClass(),
                Template.class,
                "SolutionTest.in.txt",
                "SolutionTest.out.expected.txt"
        );
    }
}