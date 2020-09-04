package ru.job4j.forum.control;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class PostControlTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageForUrlEdit() throws Exception {
        this.mockMvc.perform(get("/edit"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(model().attributeExists("post"))
                .andExpect(view().name("post/edit"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageForUrlPost() throws Exception {
        this.mockMvc.perform(get("/post")
                .param("id", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/post"));
    }
}