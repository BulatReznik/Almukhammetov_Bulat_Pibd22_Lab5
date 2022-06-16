package ru.ulstu.is.sbapp.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ulstu.is.sbapp.student.controller.dto.NewConsignmentDto;
import ru.ulstu.is.sbapp.student.model.Consignment;

import java.util.List;

public interface ConsignmentRepository extends JpaRepository<Consignment, Long>{
    @Query("SELECT new ru.ulstu.is.sbapp.student.controller.dto.NewConsignmentDto(cons.consignmentName) "
            +"FROM Orderr ord "
            +"JOIN ord.customer cust "
            +"JOIN ord.consignments cons "
            +"WHERE cust.id=:customerget ")
    List<NewConsignmentDto> getConsignmentForCustomer(@Param("customerget") Long getId );

}






