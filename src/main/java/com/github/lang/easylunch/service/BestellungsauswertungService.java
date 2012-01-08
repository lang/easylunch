package com.github.lang.easylunch.service;

import com.github.lang.easylunch.domain.Speise;
import com.github.lang.easylunch.domain.Bestellung;
import java.util.List;

public interface BestellungsauswertungService {
	
	/**
	 * Returns true if the whole order-list is compliable - regarding to the amount in stock
	 */
	boolean isOrderCompliable(List<Speise> mealList, List<Bestellung> orderList);
	
}
