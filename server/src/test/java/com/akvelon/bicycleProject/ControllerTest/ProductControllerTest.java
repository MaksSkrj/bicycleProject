package com.akvelon.bicycleProject.ControllerTest;

import com.akvelon.bicycleProject.controllers.ProductController;

import com.akvelon.bicycleProject.model.Product;
import com.akvelon.bicycleProject.service.api.ProductService;
import com.akvelon.bicycleProject.service.impl.ProductServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by maksym.skrypnyk
 */

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductServiceImpl productService;

    @Test
    public void getTopFive() throws Exception {
        List<String> names = Arrays.asList("First Bike", "Second  Bike", "Third  Bike", "Fourth  Bike", "Fifth  Bike");
        List<Product> mocks = new ArrayList<>();
        for (int index = 0; index < names.size(); index++) {
            mocks.add(new Product());
            mocks.get(index).setName(names.get(index));
        }

        when(productService.getTopFive()).thenReturn(mocks);

        mvc.perform(get("/bike/getTop")).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(jsonPath("$[0].name", is("First Bike")))
                .andExpect(jsonPath("$[1].name", is("Second  Bike")))
                .andExpect(jsonPath("$[2].name", is("Third  Bike")))
                .andExpect(jsonPath("$[3].name", is("Fourth  Bike")))
                .andExpect(jsonPath("$[4].name", is("Fifth  Bike")));
    }

}
