import java.io.Serializable;

/**
 *
 * @author Lucas Campanelli de Souza
 */
public class Resposta implements Serializable {

    private int status;
    private float result;

    public Resposta(int status, float result) {
        this.status = status;
        this.result = result;
    }

    public Resposta() {
        // nao faz nada
    }

    public int getStatus() {
        return status;
    }

    public float getResult() {
        return result;
    }

    public void setStatus(int newStatus) {
        status = newStatus;
    }

    public void setResult(float newResult) {
        result = newResult;
    }
}
