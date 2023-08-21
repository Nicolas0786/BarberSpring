package barber.project.barber.exception;

public class RecordNotFundExecption extends RuntimeException {
    
    private static final Long serialVersionUID =  1L;

    public RecordNotFundExecption(Long id){
        super("Registro não encontrado com id: " +id);
    }

}
