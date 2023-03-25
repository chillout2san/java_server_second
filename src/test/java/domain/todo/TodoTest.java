package domain.todo;

import java.util.stream.Stream;

import static domain.todo.Status.WORK_IN_PROGRESS;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class TodoTest {

  private class CreateTestCase {

    private String testTitle;
    private String name;
    private String content;

    private CreateTestCase(String testTitle, String name, String content) {
      this.testTitle = testTitle;
      this.name = name;
      this.content = content;
    }
  }

  private class ReconstructTestCase {

    private String testTitle;
    private String id;
    private String name;
    private String content;
    private Status status;

    private ReconstructTestCase(String testTitle, String id, String name, String content,
        Status status) {
      this.testTitle = testTitle;
      this.id = id;
      this.name = name;
      this.content = content;
      this.status = status;
    }
  }

  @TestFactory
  public Stream<DynamicNode> CreateTest() {
    return Stream.of(new CreateTestCase("正常系", "dummy_name", "dummy_content"))
        .map(testcase -> DynamicTest.dynamicTest(
            testcase.testTitle, () -> {
              try {
                var todo = Todo.create(testcase.name, testcase.content);

                assertEquals(testcase.name, todo.getName());
                assertEquals(testcase.content, todo.getContent());
                assertEquals(WORK_IN_PROGRESS, todo.getStatus());
              } catch (Exception e) {
              }
            }));
  }

  @TestFactory
  public Stream<DynamicNode> ReconstructTest() {
    return Stream.of(new ReconstructTestCase("正常系", "dummy_id", "dummy_name", "dummy_content",
        WORK_IN_PROGRESS)).map(testcase -> DynamicTest.dynamicTest(testcase.testTitle, () -> {
      try {
        var todo = Todo.reconstruct(TodoId.create(testcase.id), testcase.name, testcase.content,
            testcase.status);

        assertEquals(testcase.name, todo.getName());
        assertEquals(testcase.content, todo.getContent());
        assertEquals(testcase.status, todo.getStatus());
      } catch (Exception e) {
      }
    }));
  }

}
