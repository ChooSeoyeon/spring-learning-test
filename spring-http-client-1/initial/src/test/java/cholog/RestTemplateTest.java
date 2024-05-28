package cholog;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RestTemplateTest {

    @Autowired
    private TodoClientWithRestTemplate todoClient;

    @Test
    public void testGetTodoWithId() {
        Todo todo = todoClient.getTodoById(1L);
        assertThat(todo.getTitle()).isNotEmpty();
    }

    @Test
    public void testGetTodoWithNonExistentId() {
        Long nonExistentId = 9999L;

        assertThatThrownBy(() -> todoClient.getTodoById(nonExistentId))
                .isInstanceOf(TodoException.NotFound.class)
                .hasMessage("Todo not found with id: 9999");
    }
}
