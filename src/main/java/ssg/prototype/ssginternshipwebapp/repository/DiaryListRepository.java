package ssg.prototype.ssginternshipwebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ssg.prototype.ssginternshipwebapp.domain.Diary;

public interface DiaryListRepository extends JpaRepository<Diary, Long> {

    List<Diary> findByUser(String user);
}