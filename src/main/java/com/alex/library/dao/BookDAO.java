package com.alex.library.dao;

import com.alex.library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Optional<Book> show(String email){
        return jdbcTemplate.query("SELECT * FROM Book WHERE email = ?", new Object[] {email},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny();
    }


    public Book show(int id){
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null); //   Лямда выражение* Поиск объекта (id) в списке. Если его нет - null
    }

    public void save(Book book){

        jdbcTemplate.update("INSERT INTO Person(title ,author, book_year) VALUES(?, ?, ?)", book.getTitle(), book.getAuthor(), // Добавить инкремент
                book.getBook_Year());
    }

    public void update(int id, Book updateBook){ //Внимательно с синтаксисом!! ... = ? WHERE...
        jdbcTemplate.update("UPDATE Book SET title = ?, author =?, book_year = ? WHERE id = ?", updateBook.getTitle(),
                updateBook.getAuthor(), updateBook.getBook_Year(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Book WHERE id = ?", id);
    }
}
