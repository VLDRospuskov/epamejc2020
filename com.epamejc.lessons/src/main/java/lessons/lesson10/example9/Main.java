package lessons.lesson10.example9;

import java.io.IOException;
import java.sql.SQLException;

class BaseCl {
    
    public BaseCl() throws IOException, ArithmeticException {
    
    }
    
    public static void methodA() throws IOException, SQLException {
    }
    
}

class DerivativeCl extends BaseCl {
    
    public DerivativeCl() throws Exception {
        super();
    }
    
    public static void methodA() throws IOException, SQLException {
    }
    
}

class DerivativeCl2 extends BaseCl {
    
    // ошибок компиляции нет
    public DerivativeCl2() throws Exception {
        super();
    }
    
    // compile error
    public static void methodA() throws SQLException {
    }
    
}
