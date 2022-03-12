package uz.pdp.ShavkatjonMamurjonov_b9_v2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.ShavkatjonMamurjonov_b9_v2.dto.BookDTO;
import uz.pdp.ShavkatjonMamurjonov_b9_v2.dto.Response;
import uz.pdp.ShavkatjonMamurjonov_b9_v2.entity.Book;
import uz.pdp.ShavkatjonMamurjonov_b9_v2.entity.Category;
import uz.pdp.ShavkatjonMamurjonov_b9_v2.repository.BookRepository;
import uz.pdp.ShavkatjonMamurjonov_b9_v2.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
@Autowired
    CategoryRepository categoryRepository;


    public List<Book> getAll() {
        List<Book> all = bookRepository.findAll();
        return all;
    }

    public Response add(BookDTO bookDTO) {
        String name = bookDTO.getName();

        Book book= new Book();
        book.setName(name);
        book.setAuthor(bookDTO.getAuthor());
        List<Book> all = bookRepository.findAll();
        if (!Services.checkName(name,all)){
            return new Response("Xatolik",false);
        }
        Optional<Category> byId = categoryRepository.findById(bookDTO.getCategory());
        Category category = byId.get();
        book.setCategory(category);
        bookRepository.save(book);
        return new Response("Qo'shildi",true);
    }
    public Response edit(Integer id, BookDTO bookDTO) {
        Book book = bookRepository.getById(id);
        String name = bookDTO.getName();
        book.setName(name);
        book.setAuthor(book.getAuthor());
        List<Book> all = bookRepository.findAll();
        if (!Services.checkName(name,all)){
            return new Response("Xatolik",false);
        }
        Optional<Category> byId = categoryRepository.findById(bookDTO.getCategory());
        Category category = byId.get();
        book.setCategory(category);
        bookRepository.save(book);
        return new Response("O`zgartirildi",true);
    }

    public Response delete(Integer id) {
        bookRepository.deleteById(id);
        return new Response("O`chirildi",true);
    }
}
