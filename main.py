import threading
import time
import random
from db.sensores import SensoresDAO
from helper.WriteAJson import writeAJson

sensor = SensoresDAO()

def sensores(nome,intervalo):
    sensorAlarmado = False
    while sensorAlarmado == False:
        valor = random.randint(30, 40)
        if valor > 38:
            sensorAlarmado = True
            print(sensorAlarmado)
            print(valor)
            print(f'Atenção! Temperatura muito alta!Verificar {nome}')
            break
        else:
            unidade = '°C'
            print(nome, 'Temperatura:', valor, unidade)
            sensoress = sensor.create_sensor(nome, valor, unidade, sensorAlarmado)
            time.sleep(intervalo)

        writeAJson(sensoress, "sensor")

#Abrir uma thread

sensor1 = threading.Thread(target = sensores, args= ('Temp 1',2)).start()
sensor2 = threading.Thread(target = sensores, args= ('Temp 2',3)).start()
sensor3 = threading.Thread(target = sensores, args= ('Temp 3',4)).start()

