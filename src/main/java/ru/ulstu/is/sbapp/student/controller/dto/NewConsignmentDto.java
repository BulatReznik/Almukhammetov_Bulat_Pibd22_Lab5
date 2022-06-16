package ru.ulstu.is.sbapp.student.controller.dto;
import ru.ulstu.is.sbapp.student.model.Consignment;

public class NewConsignmentDto {
    @Override
    public String toString() {
        return consignmentName;
    }
    private String consignmentName;
    public void setConsignmentName(Consignment consignment) {
        this.consignmentName = consignment.getConsignmentName();
    }
    public NewConsignmentDto() {}
    public NewConsignmentDto(String consignmentName)
    {
        this.consignmentName=consignmentName;
    }
    public String getConsignmentName() {
        return consignmentName;
    }
}
