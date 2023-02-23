package com.example.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.example.product.Entity.Product;
import com.example.product.Repository.ProductRepository;

public class ProductTests {

    @Mock
	private ProductRepository productRepository;

    private static Product cut;

    @BeforeAll
    public static void setUp() {
        cut = new Product();
    }

    @Test
    public void testsId() {
        Long id = 10L;
        cut.setId(id);
        assertNotNull(cut.getId());
        assertEquals(id, cut.getId().longValue());
    }


    @Test 
    public void testsName(){
        String name = "Ruby Slippers";
        cut.setName(name);
        assertEquals(name, cut.getName());
    }

    @Test 
    public void testsShortDescription(){
        String shortDescription = "Animpressivepair ofslippersfeaturingthousands ofreal rubies";
        cut.setShortDescription(shortDescription);
        assertEquals(shortDescription, cut.getShortDescription());
    }



    @Test 
    public void testsLongDescripton(){
        String longDescription = "Long Data";
        cut.setLongDescription(longDescription);
        assertEquals(longDescription, cut.getLongDescription());

    }

    
    @Test 
    public void testImage(){
        String image = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg";
        cut.setImage(image);
        assertEquals(image, cut.getImage());

    }

    @Test
    public void testsPrice(){
        Long Price = 684750000L;
        cut.setPrice(Price);
        assertEquals(Price, cut.getPrice().longValue());
    }


    @Test
    public void testsAllArgConstructor(){
        Long id = 10L;
        String name = "Ruby Slippers";
        String shortDescription = "Animpressivepair ofslippersfeaturingthousands ofreal rubies";
        String longDescription = "Long Data";
        String image = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg";
        Long Price = 684750000L;
        cut = new Product(id, name, shortDescription, longDescription, image, Price);
        assertEquals(id, cut.getId());
		assertEquals(name, cut.getName());
		assertEquals(shortDescription, cut.getShortDescription());
		assertEquals(longDescription, cut.getLongDescription());
		assertEquals(image, cut.getImage());
		assertEquals(Price, cut.getPrice());
        

    }

    @Test
    public void testsProductBuilder(){
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
        assertEquals(id, cut.getId());
		assertEquals(name, cut.getName());
		assertEquals(shortDescription, cut.getShortDescription());
		assertEquals(longDescription, cut.getLongDescription());
		assertEquals(image, cut.getImage());
		assertEquals(Price, cut.getPrice());
    }
    


    // @Test
    // public void testsFindAllProduct(){
    //     Long id = 10L;
    //     String name = "Ruby Slippers";
    //     String shortDescription = "Animpressivepair ofslippersfeaturingthousands ofreal rubies";
    //     String longDescription = "Long Data";
    //     String image = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg";
    //     Long Price = 684750000L;

    //     cut = Product.builder()
    //                         .id(id)
    //                         .name(name)
    //                         .shortDescription(shortDescription)
    //                         .longDescription(longDescription)
    //                         .image(image)
    //                         .price(Price)
    //                         .build();

    //     Product cut2 = Product.builder()
    //                         .id(id+1L)
    //                         .name(name)
    //                         .shortDescription(shortDescription)
    //                         .longDescription(longDescription)
    //                         .image(image)
    //                         .price(Price)
    //                         .build();
        
    //     given(thingRepository.findAll()).willReturn(List.of(cut1, cut2));

        
    // }




    
}
