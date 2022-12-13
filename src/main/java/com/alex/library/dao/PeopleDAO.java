package com.alex.library.dao;

import com.alex.library.models.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class PeopleDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PeopleDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public List<People> index() {
        return jdbcTemplate.query("SELECT * FROM People", new BeanPropertyRowMapper<>(People.class));
    }




    public People show(int id){
        return jdbcTemplate.query("SELECT * FROM People WHERE id_people=?", new Object[]{id}, new BeanPropertyRowMapper<>(People.class))
                .stream().findAny().orElse(null); //   Лямда выражение* Поиск объекта (id) в списке. Если его нет - null
    }

    public void save(People people){

        jdbcTemplate.update("INSERT INTO People(name ,surname, age ) VALUES(?, ?, ?)", people.getName(), people.getSurname(), // Добавить инкремент
                people.getAge());
    }

    public void update(int id, People updatePeople){ //Внимательно с синтаксисом!! ... = ? WHERE...
        jdbcTemplate.update("UPDATE People SET surname = ?, name =?, age = ? WHERE id_people = ?", updatePeople.getSurname(),
                updatePeople.getName(),updatePeople.getAge(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM People WHERE id_people = ?", id);
    }
}
