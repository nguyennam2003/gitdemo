package com.trung.tamjava.master.Demospring.repository;

import com.trung.tamjava.master.Demospring.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Integer> {

    @Query("select person from Person person where person.age >= :min and person.age <= :max")
    List<Person> search(@Param("min") int min, @Param("max") int max);

    List<Person> findByName(String name);

    @Query("select person from Person person where person.age >= :min and person.age <= :max")
    Page<Person> search(@Param("min") int min, @Param("max") int max, Pageable page);

    //tu gen lenh cho minh - where name =
    //phan trang

    List<Person> findByName(String name, Pageable page);


}
