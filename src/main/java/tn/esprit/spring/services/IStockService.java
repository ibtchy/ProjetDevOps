package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Stock;


public interface IStockService {

	List<Stock> retrieveAllStocks();

	Stock addStock(Stock s);

	Stock getStckByid(Long id);

	void deleteStockById(Long id);


	void deleteStock(Stock s);

	Stock updateStock(Stock u);

	Stock retrieveStock(Long id);

	String retrieveStatusStock();
}
