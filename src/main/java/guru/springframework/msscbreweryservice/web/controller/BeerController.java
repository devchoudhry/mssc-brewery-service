/**
 * 
 */
package guru.springframework.msscbreweryservice.web.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbreweryservice.web.model.BeerDto;

/**
 * @author devchoudhry
 *
 */
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
	
	@GetMapping("/{beerid}")
	ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {
		//Todo Imppl
		return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity saveNewBeer(@RequestBody BeerDto beerDto) {
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity<BeerDto> updateBeerById(@PathVariable("beerid") UUID beerId, @RequestBody BeerDto beerDto) {
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
}

