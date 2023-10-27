import java.util.concurrent.*;

public class BancoSemControle {

    static int saldo = 100;

    public static void main(String[] args) {
        int numThreads = 5;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numThreads; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        // Acesse a variável estática
                        int temp = saldo;
                        temp = temp - 10;
                        saldo = temp;
                    }
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Saldo final: " + saldo);
    }
}
