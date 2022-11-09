package tn.esprit.spring.services;




import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.repositories.StockRepository;
import tn.esprit.spring.entities.Stock;

@Service
@Slf4j
public class StockServiceImpl implements IStockService {

	@Autowired
	StockRepository stockRepository;


	@Override
	public List<Stock> retrieveAllStocks() {
		
		log.info("In method retrieveAllStocks");
		List<Stock> stocks =  stockRepository.findAll();
		for (Stock stock : stocks) {
			log.info(" Stock : " + stock);
		}
		log.info("out of method retrieveAllStocks");
		
		return stocks;
	}

	@Override
	public Stock addStock(Stock s) {
		
		return stockRepository.save(s);
		
	}

	@Override
	public void deleteStock(Long stockId) {
		
		stockRepository.deleteById(stockId);

	}

	@Override
	public Stock updateStock(Stock s) {
		
		return stockRepository.save(s);
	}

	@Override
	public Stock retrieveStock(Long stockId) {
		
	
		return stockRepository.findById(stockId).orElse(null);
	
		
		
	
	}

	@Override
	public StringBuilder retrieveStatusStock() {
		StringBuilder finalMessage = new StringBuilder();
		
		
		List<Stock> stocksEnRouge =  stockRepository.retrieveStatusStock();
		for (int i = 0; i < stocksEnRouge.size(); i++) {
			finalMessage.append(stocksEnRouge.get(i).getLibelleStock()).append(stocksEnRouge.get(i).getQte()).append(stocksEnRouge.get(i).getQteMin()).toString();

		}
	
		return finalMessage;
	}

}