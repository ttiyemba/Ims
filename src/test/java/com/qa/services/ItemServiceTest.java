//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import com.qa.persistence.domain.*;
//
//import com.qa.persistence.dao.Dao;
//
//@RunWith(MockitoJUnitRunner.class)
//	public class ItemServiceTest {
//		@Mock
//		private Dao<Item> itemDao;
//		
//		@InjectMocks
//		private ItemServices itemServices;
//		
//		Item Item = new Item("chair");
//		
//		@Test
//		public void itemServicesCreate() {
//			Item item = new Item("Chair");
//			itemServices.create(item);
//			Mockito.verify(itemDao, Mockito.times(1)).create(item);
//		}
//		
//		@Test
//		public void customerServicesRead() {
//			customerServices.readAll();
//			Mockito.verify(customerDao, Mockito.times(1)).readAll();
//		}
//		
//		@Test
//		public void customerServicesUpdate() {
//			Customer customer = new Customer(1,"chris", "perrins");
//			customerServices.update(1,customer);
//			Mockito.verify(customerDao, Mockito.times(1)).update(1,customer);/		}
//	//	
///		@Test
////		public void customerServicesDelete() {
////			customerServices.delete(customer);
////			Mockito.verify(customerDao, Mockito.times(1)).delete(customer);
////		}
//	//}
//	}



