package com.fundamentosplatzi.springboot.fundamentos.repository;

import com.fundamentosplatzi.springboot.fundamentos.dto.UserDto;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /*@Query("Select u FROM User u WHERE u.email=?1")
    Optional<User> findByEmail(String email);

    @Query("Select u FROM User u WHERE u.name LIKE  ?1%")
    List<User> findAndSort(String name, Sort sort);

    List<User> findByName(String name);*/

    Optional<User> findByEmailAndName(String email, String name);

    List<User> findByNameLike(String name);

    @Query("SELECT new com.fundamentosplatzi.springboot.fundamentos.dto.UserDto(u.Id, u.name, u.birthDate)" +
            " FROM User u" +
            " where u.birthDate=:parametroFecha" +
            " and u.email=:parametroEmail")
    List<UserDto> getAllByBirthDayAndEmail(@Param("parametroFecha") LocalDate date,
                                           @Param("parametroEmail") String email);

}
