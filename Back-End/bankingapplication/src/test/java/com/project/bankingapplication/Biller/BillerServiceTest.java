//package com.project.bankingapplication.Biller;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.project.bankingapplication.entity.BillerStatement;
//import com.project.bankingapplication.repo.StatementRepository;
//import com.project.bankingapplication.service.Implementation.StatementService;
//
//@ExtendWith(MockitoExtension.class)
//public class BillerServiceTest {
//	@InjectMocks
//	StatementService statementService;
//
//	@Mock
//	StatementRepository statementRepository;
//
//	// Test for BillerStatement
//	@Test
//	public void testFindAllEmployees() {
//		List<BillerStatement> list = new ArrayList<BillerStatement>();
//		BillerStatement bState = new BillerStatement(4, 934, "debit", 8385, 565, 456);
//		BillerStatement bState1 = new BillerStatement(5, 65, "debit", 46, 46, 64);
//
//		list.add(bState);
//		list.add(bState1);
//
//		when(statementRepository.findAll()).thenReturn(list);
//
//		// test
//		List<BillerStatement> billState = statementService.listAllBillerStatement();
//
//		assertEquals(2, billState.size());
//		verify(statementRepository, times(1)).findAll();
//	}
//
//}
