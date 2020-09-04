package ru.job4j.forum.control;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class LoginControlTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessageForUrlLoginWithFirstIn() throws Exception {
        this.mockMvc.perform(get("/login"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    public void shouldReturnDefaultMessageForUrlLoginWithErrorParam() throws Exception {
        this.mockMvc.perform(get("/login")
                .param("error", "Some text"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(model().attributeExists("errorMessage"))
                .andExpect(view().name("login"));
    }

    @Test
    public void shouldReturnDefaultMessageForUrlLoginWithLogoutParam() throws Exception {
        this.mockMvc.perform(get("/login")
                .param("logout", "Some text"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(model().attributeExists("errorMessage"))
                .andExpect(view().name("login"));
    }

    @Test
    public void shouldReturnDefaultMessageForUrlLogout() throws Exception {
        this.mockMvc.perform(get("/logout"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login?logout=true"));
    }
}