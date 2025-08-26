import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int op;
        do {
            space();
            System.out.println("<========================> \n" +
                    "-> 1 - Salvar novo ativo \n" +
                    "-> 2 - Listar ativos \n" +
                    "-> 3 - Informar venda\n" +
                    "-> 0 - Sair da aplicacao \n" +
                    "\n" +
                    "-> Informe sua opcao(Numero): ");

            op = scanner.nextInt();
            switch (op) {
                case 1:
                    space();
                    saveActive();
                    break;
                case 2:
                    space();
                    listActives();
                    break;
                case 3:
                    space();
                    reportSale();
                case 0:
                    break;
                default:
                    System.err.println("Erro: opcao incorreta");
            }
        } while (op != 0);

        scanner.close();
    }

    public static void saveActive() {
        Active active = new Active();
        try{

            System.out.println("\n ==> Adicionar ativo <=== \n");
            System.out.println("-> Informe o codigo do ativo: ");
            active.setCode(scanner.next());
            System.out.println("-> Informe a quantidade: ");
            active.setQuantity(scanner.nextInt());
            System.out.println("-> Informe o valor por unitario: ");
            active.setPrice(Double.parseDouble(scanner.next()));

            ActiveService.save(active);

            System.out.println("\n => Adicionado com sucesso");
            System.out.println("\n -> 0 - Retornar ao menu" );
            scanner.next();

        }catch(Exception e){
            System.err.println("Erro: input incorreto " + e.getLocalizedMessage());
        }

    }

    public static void listActives(){

        System.out.println("\n ==> Listar ativos da carteira ===> ");
        var list = ActiveService.getActiveList();

        if(list.isEmpty()){
            System.out.println("\n--> List vazia!");
        }

        list.forEach(active ->  System.out.println(
                "\n Codigo: " + active.getCode() +
                "\n Valor Unitario: " + active.getPrice() +
                "\n Valo Total: " + active.getPriceTotal() +
                "\n Data de Compra: " + active.getDateBuy() +
                        " \n ----------------\n"
        ));

        System.out.println("-> 0 - Retornar ao menu");
        scanner.next();
    }

    /*Esse comando servirá para informar a venda de um ativo. O usuário irá informar o código do ativo e
    quantas unidades ele vendeu. O usuário não deve conseguir vender ativos que não existem na carteira.*/

    public static void reportSale() {

        System.out.println("\n ==> Informar venda do ativo ==> \n");
        System.out.println("-> Informe o codigo do ativo: ");
        String code = scanner.next();

        System.out.println("-> Informe a quantidade: ");
        int quantity = scanner.nextInt();

        if(!ActiveService.existsActiveByCode(code)){
            System.out.println("Erro: ativo inexistente");
            scanner.next();
        }else{

            var active = ActiveService.getActiveByCode(code);

            if(active != null && active.getQuantity() >= quantity){
                ActiveService.reportSale(code, quantity);

                System.out.println("\n ==> Vendido com sucesso");
                System.out.println("\n-> 0 - Retornar ao menu");

                scanner.next();
            }else{
                System.out.println("Erro: quantidade de ativo inexistente");
                scanner.next();
            }
        }
    }

    public static void space(){
        for(int i = 0; i < 10; i++){
            System.out.println();
        }
    }
}