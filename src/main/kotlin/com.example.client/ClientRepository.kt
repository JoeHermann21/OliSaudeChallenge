package com.example.client

import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface ClientRepository : MongoRepository<Client, Integer>{
	
	fun findById(id: Integer|: Optional<Client>)
	
}