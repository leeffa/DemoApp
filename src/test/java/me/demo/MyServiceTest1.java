package me.demo;

import me.demo.MyService;
import me.demo.Order;
import me.demo.external.ExternalService;
import me.demo.external.OrderException;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

/**
 * Created by Admin on 3/22/2017.
 */
@RunWith(MockitoJUnitRunner.class)

public class MyServiceTest1 {

    @Mock
    ExternalService externalService;

    @InjectMocks
    MyService myService = new MyService();

    @BeforeClass
    public static void beforeClazz() {
        System.out.print("This is before class 1");
    }

    @AfterClass
    public static void afterClazz() {
        System.out.print("This is after class 1");
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this.getClass());
    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void testProcessOrderSucessfull() throws Exception {
       Order order = generateOrder();

        assertTrue(myService.processOrder(order));

        //Verify method called with expected parameter
        verify(externalService).processOrder(eq(order));

        //Verify times
        verify(externalService, times(1)).processOrder(eq(order));
    }

    @Test
    public void testProcessOrderExternalServiceThrowExceptionFail() throws Exception {
        Order order = generateOrder();

        //Stub method
        doThrow(new OrderException("Wrong")).when(externalService).processOrder(any(Order.class));

        assertFalse(myService.processOrder(order));

        //Verify method called with expected parameter
        verify(externalService).processOrder(eq(order));

        //Verify times
        verify(externalService, times(1)).processOrder(eq(order));
    }

    @Test(expected = OrderException.class)
    public void testGetOrderDetailsThrowException() throws Exception {

        //Stub
        when(externalService.getOrderDetails(anyInt())).thenThrow(new OrderException("Wrong id"));
        //doThrow(new OrderException("msg")).when(externalService).getOrderDetails(anyInt());

        myService.getOrderDetails(100);

    }

    @Test
    public void testGetOrderDetailsOK() throws Exception {

        final Order order = generateOrder();
        //Stub
        when(externalService.getOrderDetails(anyInt())).thenReturn(order);
//        doReturn(order).when(externalService).getOrderDetails(anyInt());
//        doAnswer(new Answer() {
//            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
//                Object[] arguments = invocationOnMock.getArguments();
//                assertEquals("service should be called with correct paras", 100, arguments[0]);
//                return order;
//            }
//        }).when(externalService).getOrderDetails(anyInt());

        Order orderDetails = myService.getOrderDetails(100);

        assertSame("should be the same", order, orderDetails);

    }

    @Spy
    List<String> spiedList = new ArrayList<String>();

    @Test
    public void whenUseSpyAnnotation_thenSpyIsInjected() {
        spiedList.add("one");
        spiedList.add("two");

        Mockito.verify(spiedList).add("one");
        Mockito.verify(spiedList).add("two");

        assertEquals(2, spiedList.size());

        Mockito.doReturn(100).when(spiedList).size();
        assertEquals(100, spiedList.size());
    }
    private Order generateOrder() {
        Order order = new Order();
        order.setItemId(1);
        order.setPrice(BigDecimal.TEN);
        order.setQuantity(10);
        order.setNote("Note");
        return order;
    }
}