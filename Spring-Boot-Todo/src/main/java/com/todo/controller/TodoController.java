package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.todo.service.TodoService;
import com.todo.vo.Todo;

@CrossOrigin("*")
@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService service;

    // **유저용 메서드**

    // 특정 사용자의 모든 할일 목록 조회
    @GetMapping("/{userId}")
    public List<Todo> allListById(@PathVariable String userId) {
        return service.allListById(userId);
    }

    // 특정 사용자에 대한 할일 등록
    @PostMapping("/{userId}")
    public boolean addOnUser(@RequestBody Todo todo, @PathVariable String userId) {
        todo.setUserId(userId); // Todo 객체에 userId 설정
        return service.add(todo);
    }

    // 특정 사용자의 할일 수정
    @PutMapping("/{userId}")
    public boolean modifyOnUser(@RequestBody Todo todo, @PathVariable String userId) {
        todo.setUserId(userId); // Todo 객체에 userId 설정
        return service.modify(todo);
    }

    // 특정 사용자의 할일 삭제
    @DeleteMapping("/{userId}/{num}")
    public boolean deleteOnUser(@PathVariable String userId, @PathVariable String num) {
        return service.delete(num);
    }

    // **관리자용 메서드**

    // 모든 할일 목록 조회 (관리자)
    @GetMapping("/all")
    public List<Todo> allList() {
        return service.allList();
    }

    // 모든 사용자에 대해 할일 등록 (관리자)
    @PostMapping("/all")
    public boolean addOnAll(@RequestBody Todo todo) {
        return service.add(todo);
    }

    // 모든 사용자의 할일 수정 (관리자)
    @PutMapping("/all")
    public boolean modifyOnAll(@RequestBody Todo todo) {
        return service.modify(todo);
    }

    // 모든 사용자의 특정 할일 삭제 (관리자)
    @DeleteMapping("/all/{num}")
    public boolean deleteOnAll(@PathVariable String num) {
        return service.delete(num);
    }

    // **공통 기능**

    // 번호 기준으로 할일 검색
    @GetMapping("/search/{num}")
    public Todo find(@PathVariable String num) {
        return service.find(num);
    }

    // 완료 여부 변경 (유저 및 관리자 공용)
    @PutMapping("/complete/{num}")
    public boolean complete(@PathVariable String num) {
        Todo todo = service.find(num);
        return todo != null && service.complete(todo);
    }

    // 모든 할일 삭제 (관리자 권한 등에서 전체 삭제가 필요할 때 사용)
    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        service.deleteAll();
    }
}