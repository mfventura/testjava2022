package es.beonit.testjava2022manuelfernandezventura;

import es.beonit.testjava2022manuelfernandezventura.controllers.ApiV1Controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class Testjava2022ManuelfernandezventuraApplicationTests {
	@Autowired
	private ApiV1Controller controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

	/**
	 * -          Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	 * -          Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	 * -          Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	 * -          Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
	 * -          Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
	 */

	@Test
	void testCase1(){
		final var priceDto = controller.findPrices(35455, 1, "2020-06-14-10.00.00");
		assertThat(priceDto).isNotNull();
		assertThat(priceDto.getPrice()).isEqualTo(35.5);
		assertThat(priceDto.getPriceList()).isEqualTo(1);
	}

	@Test
	void testCase2(){
		final var priceDto = controller.findPrices(35455, 1, "2020-06-14-16.00.00");
		assertThat(priceDto).isNotNull();
		assertThat(priceDto.getPrice()).isEqualTo(25.45);
		assertThat(priceDto.getPriceList()).isEqualTo(2);
	}

	@Test
	void testCase3(){
		final var priceDto = controller.findPrices(35455, 1, "2020-06-14-21.00.00");
		assertThat(priceDto).isNotNull();
		assertThat(priceDto.getPrice()).isEqualTo(35.5);
		assertThat(priceDto.getPriceList()).isEqualTo(1);
	}

	@Test
	void testCase4(){
		final var priceDto = controller.findPrices(35455, 1, "2020-06-15-10.00.00");
		assertThat(priceDto).isNotNull();
		assertThat(priceDto.getPrice()).isEqualTo(30.5);
		assertThat(priceDto.getPriceList()).isEqualTo(3);
	}

	@Test
	void testCase5(){
		final var priceDto = controller.findPrices(35455, 1, "2020-06-16-21.00.00");
		assertThat(priceDto).isNotNull();
		assertThat(priceDto.getPrice()).isEqualTo(38.95);
		assertThat(priceDto.getPriceList()).isEqualTo(4);
	}


}
