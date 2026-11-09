package com.example.workoutlog.repository;

import com.example.workoutlog.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    List<Workout> findAllByOrderByDateDesc();
}
