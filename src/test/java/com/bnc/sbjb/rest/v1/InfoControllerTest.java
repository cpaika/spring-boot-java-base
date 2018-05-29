package com.bnc.sbjb.rest.v1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.bnc.sbjb.config.WebConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@Import({
    WebConfiguration.class,
})
@WebMvcTest(InfoController.class)
public class InfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getInfo() throws Exception {
        mockMvc.perform(get("/1/info")).andExpect(status().isOk());
    }
}