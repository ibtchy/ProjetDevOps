package tn.esprit.spring.controllers;




import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import io.swagger.annotations.Api;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.entities.StockDTO;
import tn.esprit.spring.services.IStockService;


@Slf4j
@RestController
@Api(tags = "Gestion des stocks")
@RequestMapping("/stock")
@CrossOrigin("*")
public class StockRestController {

	@Autowired
	IStockService stockService;

	// http://localhost:8089/SpringMVC/stock/retrieve-all-stocks
	@GetMapping("/retrieve-all-stocks")
	@ResponseBody
	public List<Stock> getStocks() {
		return stockService.retrieveAllStocks();


	}

	// http://localhost:8089/SpringMVC/stock/retrieve-stock/8
	@GetMapping("/retrieve-stock/{stock-id}")
	@ResponseBody
	public Stock retrieveStock(@PathVariable("stock-id") Long stockId) {
		return stockService.retrieveStock(stockId);
	}

	// http://localhost:8089/SpringMVC/stock/add-stock
	@PostMapping("/add-stock")
	@ResponseBody
	public Stock addStock(@RequestBody StockDTO s) {
		return stockService.addStock(s);

	}


	@DeleteMapping("/remove-stock/{stock-id}")
	@ResponseBody
	public void removeStock(@PathVariable("stock-id") Long stockId) {
		stockService.deleteStockById(stockId);
	}

	// http://localhost:8089/SpringMVC/stock/modify-stock
	@PutMapping("/modify-stock")
	@ResponseBody
	public Stock modifyStock(@RequestBody StockDTO stock) {
		return stockService.updateStock(stock);
	}



}