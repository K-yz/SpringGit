package khly.codelean.project2.repositories;

import khly.codelean.project2.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
