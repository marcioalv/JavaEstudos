
public class Testes {

    public static void main(String[] args) {
        
        try {
          CpfCnpj cpfCnpj = new CpfCnpj(1861915969L);
          System.out.println(cpfCnpj.getNumero());          
          System.out.println(cpfCnpj.getNumeroLong());                    
          System.out.println(cpfCnpj.getNumeroFormatado());                    
        } catch (IllegalCpfCnpjException excecao) {
          System.out.println(excecao.getMessage());
        }


    }
    
}