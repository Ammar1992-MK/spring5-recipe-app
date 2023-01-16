package guru.springframework.repository;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {


    @Autowired
    CategoryRepository categoryRepository;

    @Before
    public void setUp() throws Exception {

        Category category1 = new Category();
        category1.setDescription("American");

        categoryRepository.save(category1);
    }

    @Test
    public void findByDescription() {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        assertEquals("American",categoryOptional.get().getDescription());
    }
}