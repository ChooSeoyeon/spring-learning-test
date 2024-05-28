package cholog;

import cholog.TodoException.NotFound;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

public class TodoClientWithRestClient {
    private final RestClient restClient;

    public TodoClientWithRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<Todo> getTodos() {
        // TODO: restClient의 get 메서드를 사용하여 요청을 보내고 결과를 Todo 리스트로 변환하여 반환
        String baseUrl = "http://jsonplaceholder.typicode.com/todos";
        Todo[] response = restClient.get()
                .uri(baseUrl)
                .retrieve()
                .body(Todo[].class);
        return Arrays.asList(response);
    }

    public Todo getTodoById(Long id) {
        // TODO: restClient의 get 메서드를 사용하여 요청을 보내고 결과를 Todo로 변환하여 반환
        // TODO: 존재하지 않는 id로 요청을 보낼 경우 TodoException.NotFound 예외를 던짐
        try {
            String baseUrl = "http://jsonplaceholder.typicode.com/todos";
            return restClient.get()
                    .uri(baseUrl + "/" + id)
                    .retrieve()
                    .body(Todo.class);
        } catch (RestClientException e) {
            throw new NotFound(id);
        }
    }
}
