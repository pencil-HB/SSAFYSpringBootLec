package com.todo.service;

import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.mapper.TodoMapper;
import com.todo.vo.Todo;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoMapper mapper;

	@Override
	public List<Todo> allList() {
		return mapper.allList();
	}

	@Override
	public List<Todo> allListById(String userId) {
		return mapper.allListById(userId);
	}

	@Override
	public Todo find(String num) {
		return mapper.find(num);
	}

	@Override
	public boolean add(Todo todo) {
		return mapper.add(todo) > 0;
	}

	@Override
	public boolean modify(Todo todo) {
		return mapper.modify(todo) > 0;
	}

	@Override
	public boolean delete(String num) {
		return mapper.delete(num) > 0;
	}

	@Override
	public boolean complete(Todo todo) {
		if(todo.getDone() == 'Y') {
			todo.setDone('N');
		} else {
			todo.setDone('Y');
		}
		return mapper.complete(todo) > 0;
	}

	@Override
	public void deleteAll() {
		mapper.deleteAll();
		return;
	}

}
