package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Stock;


public interface IStockService {

	List<Stock> retrieveAllStocks();

	Stock addStock(Stock s);

	void deleteStock(Long id);

	Stock updateStock(Stock u);

	Stock retrieveStock(Long id);

	StringBuilder retrieveStatusStock();
}
