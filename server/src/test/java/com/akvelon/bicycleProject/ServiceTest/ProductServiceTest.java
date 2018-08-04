package com.akvelon.bicycleProject.ServiceTest;

import com.akvelon.bicycleProject.DAO.impl.ProductDAOImpl;
import com.akvelon.bicycleProject.service.impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

/**
 * Created by maksym.skrypnyk
 */

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
    @Mock
    private ProductDAOImpl productDAO;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void create() {
        when(productDAO.insert(any())).thenReturn(true);

        Assert.assertTrue(productService.insert(any()));
    }
}
