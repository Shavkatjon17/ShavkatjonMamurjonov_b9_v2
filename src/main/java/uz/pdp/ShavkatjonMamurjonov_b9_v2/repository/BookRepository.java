package uz.pdp.ShavkatjonMamurjonov_b9_v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ShavkatjonMamurjonov_b9_v2.entity.Book;


public interface BookRepository extends JpaRepository<Book, Integer> {
}
