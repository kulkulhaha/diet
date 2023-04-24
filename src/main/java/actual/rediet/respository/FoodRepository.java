package actual.rediet.respository;

import actual.rediet.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,Long> {
}
