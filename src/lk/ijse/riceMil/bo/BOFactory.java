package lk.ijse.riceMil.bo;

import lk.ijse.riceMil.bo.custom.PaymentBO;
import lk.ijse.riceMil.bo.custom.impl.*;
import lk.ijse.riceMil.dao.custom.impl.PaymentDAOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    public BOFactory() {
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOType{
        CUSTOMER,SUPPLIER,ATTENDANCE,EMPLOYEE,ITEM,ORDER,ORDER_DELIVER,PAYMENT,PLACE_ORDER,PURCHASE_ORDER,SALARY,PURCHASE_ORDER_DETAIL,ORDER_DETAIL
    }

    public SuperBO getBo(BOType boType){
        switch (boType){
            case ATTENDANCE:
                return new AttendanceBOImpl();
            case ORDER_DELIVER:
                return new OrderDeliverBOImpl();
            case PURCHASE_ORDER_DETAIL:
                return new PurchaseOrderDetailBOImpl();
            case PLACE_ORDER:
                return new PlaceOrderBOImpl();
            case SALARY:
                return new SalaryBOImpl();
            case PAYMENT:
                return new PaymentBOImpl();
            case ORDER_DETAIL:
                return new OrderDetailBOImpl();
            case CUSTOMER:
                return new CustomerBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case ORDER:
                return new OrderBOImpl();
            case PURCHASE_ORDER:
                return new PurchaseOrderBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            default:
                return null;
        }
    }
}
