package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.entities.StockDTO;


public interface IStockService {

	List<Stock> retrieveAllStocks();

	Stock addStock(StockDTO s);

	Stock getStckByid(Long id);

	void deleteStockById(Long id);


	void deleteStock(Stock s);

	Stock updateStock(StockDTO u);

	Stock retrieveStock(Long id);

	StringBuilder retrieveStatusStock();
}
