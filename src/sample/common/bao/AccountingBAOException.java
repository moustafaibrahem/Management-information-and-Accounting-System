package sample.common.bao;

public class AccountingBAOException extends Exception{
    public AccountingBAOException(){
        super();
    }
    public AccountingBAOException(String massage){
        super(massage);
    }
}
