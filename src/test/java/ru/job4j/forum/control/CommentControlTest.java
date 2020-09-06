package ru.job4j.forum.control;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.PostComment;
import ru.job4j.forum.service.PostCommentService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class CommentControlTest {

    @MockBean
    private PostCommentService postCommentService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageForUrlPostCommentCreate() throws Exception {
        this.mockMvc.perform(get("/post/comment/create")
                .param("post.id", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/comment/create"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageForUrlPostCommentSaveWithMethodPost() throws Exception {
        this.mockMvc.perform(post("/post/comment/save")
                .param("desc", "Возможен торг")
                .param("post.id", "1"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/post?id=1"));
        ArgumentCaptor<PostComment> argument = ArgumentCaptor.forClass(PostComment.class);
        verify(postCommentService).save(argument.capture());
        assertThat(argument.getValue().getDesc(), is("Возможен торг"));
    }
}