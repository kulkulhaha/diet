package actual.rediet.respository;

import actual.rediet.domain.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {
    @Query
    @EntityGraph(attributePaths = {"bodyInfos"})
    Member findMemberById(Long id);
}
