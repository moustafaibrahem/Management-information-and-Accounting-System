package sample.common.dao;


public class AccountingDAOException extends Exception{
    public AccountingDAOException(){
        super();
    }
    public AccountingDAOException(String massage){
        super(massage);
    }
}
