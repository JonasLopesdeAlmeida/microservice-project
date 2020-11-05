package com.jmmd.workers.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.jmmd.workers.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}