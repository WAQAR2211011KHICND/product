package com.example.product;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.is;
import com.example.product.Entity.Product;
import com.example.product.Repository.ProductRepository;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
public class ProductControllerTests {
    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private ProductRepository productRepository;

    private static Product cut;

    @BeforeAll
    public static void setUp() {
        cut = new Product();
    }

    @Test
    public void getAllTheProducts() throws Exception {

            Long id = 10L;
            String name = "Ruby Slippers";
            String shortDescription = "Animpressivepair ofslippersfeaturingthousands ofreal rubies";
            String longDescription = "Long Data";
            String image = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg";
            Long Price = 684750000L;
        
        cut = Product.builder()
                            .id(id)
                            .name(name)
                            .shortDescription(shortDescription)
                            .longDescription(longDescription)
                            .image(image)
                            .price(Price)
                            .build();

        Product cut2 = Product.builder()
                            .id(id+1L)
                            .name(name)
                            .shortDescription(shortDescription)
                            .longDescription(longDescription)
                            .image(image)
                            .price(Price)
                            .build();
        
        List<Product> products = List.of(cut,cut2);
        given(productRepository.findAll()).willReturn(products);
        ResultActions response = mockMvc.perform(get("/product/all"));
        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(products.size())));
    }
}
