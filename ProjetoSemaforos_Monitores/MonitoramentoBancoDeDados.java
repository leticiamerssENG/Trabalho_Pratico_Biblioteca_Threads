import java.util.concurrent.Semaphore;

public class MonitoramentoBancoDeDados {

    private static Semaphore semaforo = new Semaphore(1);

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(new UsuarioDoBancoDedados(i));
            thread.start();
        }
    }

    static class UsuarioDoBancoDedados implements Runnable {
        private int id;

        public UsuarioDoBancoDedados(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                System.out.println("Usuário " + id + " está esperando para acessar o Banco de Dados.");

                semaforo.acquire(); // Obtém permissão para acessar o banco de dados

                System.out.println("Usuário " + id + " está utilizando o banco de dados.");

                // Simula o uso do BD
                Thread.sleep(2000);

                System.out.println("Usuário " + id + " liberou o acesso do Banco de Dados.");

                semaforo.release(); // Libera para outro usuário utilizar
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}