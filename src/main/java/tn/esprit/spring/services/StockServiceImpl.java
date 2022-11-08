package tn.esprit.spring.services;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.repositories.StockRepository;
import tn.esprit.spring.entities.Stock;

import static java.lang.System.currentTimeMillis;


@Service
@Slf4j
public class StockServiceImpl implements IStockService {

	@Autowired
	StockRepository stockRepository;




	@Override
	public List<Stock> retrieveAllStocks() {


		List<Stock> stocks = stockRepository.findAll();

		log.info("getting data from db"+ stocks);

		return stocks;
	}

	@Override
	public Stock addStock(Stock s) {


		return stockRepository.save(s);
		
	}

	@Override
	public Stock getStckByid(Long id) {
		// récuperer la date à l'instant t1


		return stockRepository.getById(id);

	}



	@Override
	public void deleteStockById(Long stockId) {

		stockRepository.deleteById(stockId);

	}

	@Override
	public void deleteStock(Stock s) {

		stockRepository.delete(s);

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
	   public String retrieveStatusStock() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String msgDate = sdf.format(now);
		String finalMessage = "";
		String newLine = System.getProperty("line.separator");
		List<Stock> stocksEnRouge = stockRepository.retrieveStatusStock();
		for (int i = 0; i < stocksEnRouge.size(); i++) {
			finalMessage = newLine + finalMessage + msgDate + newLine + ": le stock "
					+ stocksEnRouge.get(i).getLibelleStock() + " a une quantité de " + stocksEnRouge.get(i).getQte()
					+ " inférieur à la quantité minimale a ne pas dépasser de " + stocksEnRouge.get(i).getQteMin()
					+ newLine;





		}
		log.info(finalMessage);
		return finalMessage;
	}

}