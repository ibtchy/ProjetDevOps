package tn.esprit.spring.services;



import java.text.SimpleDateFormat;
import java.util.Date;
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
		// récuperer la date à l'instant t1
		log.info("In method retrieveAllStocks");
		List<Stock> stocks = (List<Stock>) stockRepository.findAll();
		for (Stock stock : stocks) {
			log.info(" Stock : " + stock);
		}
		log.info("out of method retrieveAllStocks");
		// récuperer la date à l'instant t2
		// temps execution = t2 - t1
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String msgDate = sdf.format(now);
		
		String newLine = System.getProperty("line.separator");
		List<Stock> stocksEnRouge = (List<Stock>) stockRepository.retrieveStatusStock();
		for (int i = 0; i < stocksEnRouge.size(); i++) {
			finalMessage.append(stocksEnRouge.get(i).getLibelleStock()).append(stocksEnRouge.get(i).getQte()).append(stocksEnRouge.get(i).getQteMin()).toString();

		}
	
		return finalMessage;
	}

}