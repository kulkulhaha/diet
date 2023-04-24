package actual.rediet.respository;

import actual.rediet.domain.Diet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietRepository extends JpaRepository<Diet,Long> {
}
