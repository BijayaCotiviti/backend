package com.task.backend;

import com.task.backend.models.Item;
import com.task.backend.models.User;
import com.task.backend.repository.ItemRepository;
import com.task.backend.repository.UserRepository;
import com.task.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Item item0 = new Item(
				"Cabbage",
				"A delicious vegetable",
				20.0,
				"https://www.bigbasket.com/media/uploads/p/l/1201414_1-fresho-onion.jpg?tr=w-1080,q=80"
		);

		Item item1 = new Item(
				"Tomato",
				"A juicy red fruit",
				15.0,
				"https://www.bigbasket.com/media/uploads/p/l/1201414_1-fresho-onion.jpg?tr=w-1080,q=80"
		);

		Item item2 = new Item(
				"Carrot",
				"A crunchy orange vegetable",
				10.0,
				"https://www.bigbasket.com/media/uploads/p/l/1201414_1-fresho-onion.jpg?tr=w-1080,q=80"
		);

		Item item3 = new Item(
				"Apple",
				"A crisp and sweet fruit",
				25.0,
				"https://www.bigbasket.com/media/uploads/p/l/1201414_1-fresho-onion.jpg?tr=w-1080,q=80"
		);

		Item item4 = new Item(
				"Banana",
				"A tropical yellow fruit",
				12.0,
				"https://www.bigbasket.com/media/uploads/p/l/1201414_1-fresho-onion.jpg?tr=w-1080,q=80"
		);

		Item item5 = new Item(
				"Lettuce",
				"A leafy green vegetable",
				18.0,
				"https://www.bigbasket.com/media/uploads/p/l/1201414_1-fresho-onion.jpg?tr=w-1080,q=80g"
		);

		Item item6 = new Item(
				"Potato",
				"A starchy tuber",
				8.0,
				"https://www.bigbasket.com/media/uploads/p/l/1201414_1-fresho-onion.jpg?tr=w-1080,q=80"
		);

		User user0 = new User(
				"Bijay Joshi",
				"bijay",
				"bijay@joshi.com",
				"password",
				"ROLE_ADMIN"
		);

		User user1 = new User(
				"John Doe",
				"johndoe",
				"johndoe@example.com",
				"secretpassword"
		);

		User user2 = new User(
				"Alice Smith",
				"alicesmith",
				"alice@example.com",
				"mypassword123"
		);


		userRepository.save(user0);
		userRepository.save(user1);
		userRepository.save(user2);




		itemRepository.save(item0);
		itemRepository.save(item1);
		itemRepository.save(item2);
		itemRepository.save(item3);
		itemRepository.save(item4);
		itemRepository.save(item5);
		itemRepository.save(item6);

		Date orderDate = new Date();
		OrderStatus orderStatus = OrderStatus.PENDING;
		Double totalPrice = 100.0;

		orderService.createAndSaveOrder("bijay", orderDate, orderStatus, totalPrice);

		// Repeat the process for additional orders
		Date orderDate2 = new Date();
		OrderStatus orderStatus2 = OrderStatus.PROCESSING;
		Double totalPrice2 = 75.0;

		orderService.createAndSaveOrder("alice", orderDate2, orderStatus2, totalPrice2);

		Date orderDate3 = new Date();
		OrderStatus orderStatus3 = OrderStatus.PENDING;
		Double totalPrice3 = 50.0;

		orderService.createAndSaveOrder("john", orderDate3, orderStatus3, totalPrice3);


	}
}
