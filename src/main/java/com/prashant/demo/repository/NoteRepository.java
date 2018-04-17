package com.prashant.demo.repository;

import com.prashant.demo.modal.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long>{

    @Query("select n.title FROM Note n where n.id=:id ")
    String findTitleById(@Param("id")Long id);

    @Query("select n.title, n.content from Note n where n.id=:id")
    List<Note> findAllData(@Param("id")Long id);


    @Query("select n from Note n where n.user.id=:id")
    List<Note> findJoinData(@Param("id")Long id);
}

