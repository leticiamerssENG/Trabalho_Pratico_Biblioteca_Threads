from bson.objectid import ObjectId
from db.database import Database

class SensoresDAO:
    def __init__(self):
        self.db = Database(database='bancoiot', collection='sensores')
        self.collection = self.db.collection

    def create_sensor(self, nomeSensor: str, valorSensor: int, unidade: str, sensorAlarmado: str):
        res = self.collection.insert_one({"nomeSensor": nomeSensor , "valorSensor": valorSensor, "unidade": unidade, "sensorAlarmado": sensorAlarmado})
        return res.inserted_id
