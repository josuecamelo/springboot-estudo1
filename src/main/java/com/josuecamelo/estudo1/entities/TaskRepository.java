package com.josuecamelo.estudo1.entities;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface TaskRepository extends CrudRepository<Task, Long> {
	public Task findByName(String name);
	public Task findByNameIgnoreCase(String name);
	public Task findByNameAndId(String name, Long id);
	public List<Task> findAllByOrderById();
	public List<Task> findAllByOrderByName();
}
