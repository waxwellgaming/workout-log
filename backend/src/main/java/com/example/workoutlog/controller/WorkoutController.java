package com.example.workoutlog.controller;

import com.example.workoutlog.model.Workout;
import com.example.workoutlog.repository.WorkoutRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
@RequiredArgsConstructor
public class WorkoutController {
    private final WorkoutRepository workoutRepository;

    @GetMapping
    public List<Workout> getAll() {
        return workoutRepository.findAllByOrderByDateDesc();
    }

    @GetMapping("/{id}")
    public Workout getOne(@PathVariable Long id) {
        return workoutRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Workout create(@Valid @RequestBody Workout workout) {
        return workoutRepository.save(workout);
    }
}
