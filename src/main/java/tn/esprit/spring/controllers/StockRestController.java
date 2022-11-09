package tn.esprit.spring.controllers;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import io.swagger.annotations.Api;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.services.IStockService;

@RestController
@Api(tags = "Gestion des stocks")
@RequestMapping("/stock")
@CrossOrigin("*")
public class StockRestController {

	@Autowired
	IStockService stockService;




	@GetMapping("/retrieve-stock/{stock-id}")
	@ResponseBody
	public Stock retrieveStock(@PathVariable("stock-id") Long stockId) {
		return stockService.retrieveStock(stockId);
	}

	
	@PostMapping("/add-stock")
	@ResponseBody
	public Stock addStock(@RequestBody Stock s) {
		return stockService.addStock(s);
	
	}


	@DeleteMapping("/remove-stock/{stock-id}")
	@ResponseBody
	public void removeStock(@PathVariable("stock-id") Long stockId) {
		stockService.deleteStock(stockId);
	}

	
	@PutMapping("/modify-stock")
	@ResponseBody
	public Stock modifyStock(@RequestBody Stock stock) {
		return stockService.updateStock(stock);
	}

	

}