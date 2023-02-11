package lk.ijse.riceMil.dao;

import lk.ijse.riceMil.dao.custom.EmployeeDAO;
import lk.ijse.riceMil.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    public DAOFactory() {
    }

    public static DAOFactory getDaoFactory(){
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER,SUPPLIER,ATTENDANCE,EMPLOYEE,ITEM,ORDER,ORDER_DELIVER,PAYMENT,PLACE_ORDER,PURCHASE_ORDER,SALARY,PURCHASE_ORDER_DETAIL,ORDER_DETAIL
    }

    public SuperDAO getDAO (DAOTypes types){
        switch (types){
            case ATTENDANCE:
                return new AttendanceDAOImpl();
            case ORDER_DELIVER:
                return new OrderDeliverDAOImpl();
            case PURCHASE_ORDER_DETAIL:
                return new PurchaseOrderDetailDAOImpl();
            case PLACE_ORDER:
                return new PlaceOrderDAOImpl();
            case SALARY:
                return new SalaryDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
            case ORDER_DETAIL:
                return new OrderDetailDAOImpl();
            case CUSTOMER:
                return new CustomerDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case PURCHASE_ORDER:
                return new PurchaseOrderDAOImpl();
            case SUPPLIER:
                return new SupplierDAOImpl();
            default:
                return null;
        }
    }
}
