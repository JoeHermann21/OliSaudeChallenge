package com.example.client

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(...value: "client")
class ClientController(val repository: ClientRepository){

	@PostMapping
	fun create(@RequestBody client: Client) :ResponseEntity<Client> = ResponseEntity.ok(repository.save(client))
	
	@GetMapping
	fun read() :ResponseEntity<(Mutable)List<Client>> = ResponseEntity.ok(repository.findAll())]
	
	@PutMapping(...value: "(id)")
	fun update(@PathVariable id: Integer, @RequestBody client: Client): ResponseEntity<Client>{
		val clientDBOptional = repository.findById(id)
		val toSave = clientDBOptional
		.orElseThrow{RuntimeException("Account id: $id not found!")}
		.copy(name = client.name, birthDate = client.birthDate, sex = client.sex, healthIssue = client.healthIssue, creationDate = client.creationDate, updateDate = client.updateDate)
		return RepositoryEntity.ok(repository.save(toSave))
	}
	
	@DeleteMapping(...value: "(id)")
	fun delete(@PathVariable id: Integer) :Unit = repository
		.findById(id)
		.ifPresent{ repository.delete(it)}
		
	@GetMapping
	fun findByIssueDegree() :ResponseEntity<(Mutable)List<Client>> = ResponseEntity.ok(repository.findAll((1/(1 + e^-(-2.8 + sd++))) * 100))]
	
}
