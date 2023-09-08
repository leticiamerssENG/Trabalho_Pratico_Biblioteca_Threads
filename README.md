# Trabalho_Pratico_Biblioteca_Threads
Projeto apresentado para a Disciplina C012 - Sistemas Operacionais

Neste projeto foram criadas três Threads, cada uma responsável por simular a temperatura de um sensor em uma rede de Internet das Coisas (IoT); 
• Cada sensor de tempos em tempos gera uma temperatura aleatória, que varia entre 30 e 40 C°; 
• Estes valores de sensores, ao serem gerados, além de serem apresentados no terminal do Python, também são guardados no BD MongoDB (mais particularmente dentro de um database chamado bancoiot, que possui uma collection chamada sensores); 
• Cada sensor possui seu próprio documento na collection sensores, com o objetivo de não só guardar a última leitura de cada um deles, mas também informar se alguns deles estão ou não alarmados;
• O campo sensorAlarmado tem seu valor alterado no documento de um sensor para true quando a temperatura gerada pelo respectivo sensor for > 38 C°; 
• A partir do momento que um sensor tenha seu campo alarmado setado em true, dali em diante ele não gerará valores aleatórios de temperatura, e mostrará a seguinte mensagem no terminal do Python: “Atenção! Temperatura muito alta! Verificar Sensor X!”, em que X é o nome do sensor alarmado.
