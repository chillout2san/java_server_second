package domain.todo;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class TodoTest {

  private class CreateTestCase {

    private String testTitle;
    private String name;
    private String content;
    private String expectedException;

    private CreateTestCase(String testTitle, String name, String content,
        String expectedException) {
      this.testTitle = testTitle;
      this.name = name;
      this.content = content;
      this.expectedException = expectedException;
    }
  }

  @TestFactory
  public Stream<DynamicNode> TodoCreateTest() {
    return Stream.of(new CreateTestCase("正常系", "dummy_name", "dummy_content", ""))
        .map(testcase -> DynamicTest.dynamicTest(
            testcase.testTitle, () -> {
              try {
                var todo = Todo.create(testcase.name, testcase.content);
                assertEquals(testcase.name, todo.getName());
                assertEquals(testcase.content, todo.getContent());
              } catch (Exception e) {
                assertEquals(testcase.expectedException, e.getMessage());
              }
            }));
  }
}
